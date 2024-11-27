package com.hrishit.weather_cache_service.services;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.hrishit.weather_cache_service.config.ApiConfig;
import com.hrishit.weather_cache_service.exceptions.WeatherDataFetchException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class WeatherCacheServiceImpl implements WeatherCacheService {

    private final StringRedisTemplate redisTemplate;
    private final WebClient webClient;
    private final ApiConfig apiConfig;

    private static final long cacheTTL = 15;
    private static final long max_cities_to_cache = 50;

    public WeatherCacheServiceImpl(StringRedisTemplate redisTemplate, WebClient webClient, ApiConfig apiConfig) {
        this.redisTemplate = redisTemplate;
        this.webClient = webClient;
        this.apiConfig = apiConfig;
    }

    @Override
    @Scheduled(fixedRate = 15 * 60 * 1000)
    @CircuitBreaker(name = "weather-api", fallbackMethod = "fetchWeatherDataFallback")
    public Mono<Void> fetchAndCacheWeatherData() {
        Set<String> topCities = getTopAccessedCities();
        final int MAX_CALLS_PER_MINUTE = 60;
        AtomicInteger apiCallCount = new AtomicInteger(0);

        List<Mono<Void>> cityFetchMonos = new ArrayList<>();

        for (String city : topCities) {
            if (apiCallCount.get() >= MAX_CALLS_PER_MINUTE) {
                log.info("API call limit reached. Pausing for 1 minute...");
                cityFetchMonos.add(Mono.delay(Duration.ofMinutes(1))
                        .then(Mono.fromRunnable(() -> fetchAndCacheCityData(city, apiCallCount))));
                apiCallCount.set(0);
            } else {
                cityFetchMonos.add(Mono.fromRunnable(() -> fetchAndCacheCityData(city, apiCallCount)));
            }
        }

        return Mono.when(cityFetchMonos);
    }

    private void fetchAndCacheCityData(String city, AtomicInteger apiCallCount) {
        fetchAndCacheSingleCityData(city)
                .doOnTerminate(() -> apiCallCount.incrementAndGet())  
                .onErrorResume(ex -> {
                    log.error("Error occurred while fetching and caching weather data for city: " + city, ex);
                    return Mono.empty();  
                })
                .subscribe(
                    data -> log.info("Successfully fetched and cached data for city: " + city),
                    error -> log.error("Error occurred during subscribe: ", error) 
                );
    }

    private Set<String> getTopAccessedCities() {
        log.info("Requested top accessed cities from redis");
        return redisTemplate.opsForZSet()
                .reverseRange("cityAccessCount", 0, max_cities_to_cache - 1);
    }

    public void trackCityAccess(String city) {
        log.info("Updated city tracking for city: " + city);
        redisTemplate.opsForZSet().incrementScore("cityAccessCount", city, 1);
    }

    @Override
    public Mono<String> getCachedWeatherData(String city) {
        log.info("Requested cached data from Redis for city: " + city);
        trackCityAccess(city);

        String cachedData = redisTemplate.opsForValue().get("weatherData:" + city);

        if (cachedData == null) {
            log.info("Cache miss for city: " + city + ". Fetching from OpenWeather API...");
            
            return fetchAndCacheSingleCityData(city)
                .onErrorResume(ex -> {
                    log.error("Error while fetching data for city: " + city);

                    return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found"));
                });
        }

        return Mono.just(cachedData);
    }

    Mono<String> fetchAndCacheSingleCityData(String city) {
        String url = String.format("/data/2.5/forecast?q=%s&appid=%s&cnt=24&units=metric", city, apiConfig.getKey());
    
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .doOnTerminate(() -> trackCityAccess(city))
                .flatMap(weatherData -> {
                    if (weatherData != null && !weatherData.isEmpty()) {
                        log.info("Setting city in redis: " + city);
                        redisTemplate.opsForValue().set("weatherData:" + city, weatherData, cacheTTL, TimeUnit.MINUTES);
                        return Mono.just(weatherData);
                    } else {
                        return Mono.error(new WeatherDataFetchException("Received null or empty response for city: " + city));
                    }
                })
                .onErrorMap(WebClientResponseException.NotFound.class, e -> {
                    log.error("OpenWeather API returned 404 Not Found for city: " + city);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found in OpenWeather API", e);
                })
                .onErrorMap(RestClientException.class, e -> new WeatherDataFetchException("Failed to fetch data for city: " + city, e));
    }
    

    public String fetchWeatherDataFallback(String city, Throwable throwable) {
        log.info("Fallback triggered due to: " + throwable.getMessage());
        String cachedData = redisTemplate.opsForValue().get("weatherData:" + city);
        if (cachedData != null) {
            return cachedData;
        } else {
            return "No weather data available and unable to fetch from API.";
        }
    }
}
