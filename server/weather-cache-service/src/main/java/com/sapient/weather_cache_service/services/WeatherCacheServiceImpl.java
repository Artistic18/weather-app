package com.sapient.weather_cache_service.services;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sapient.weather_cache_service.config.ApiConfig;
import com.sapient.weather_cache_service.exceptions.CacheServiceException;
import com.sapient.weather_cache_service.exceptions.WeatherDataFetchException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WeatherCacheServiceImpl implements WeatherCacheService {
    
    private final StringRedisTemplate redisTemplate;
    private final RestTemplate restTemplate;
    private final ApiConfig apiConfig;

    private static final long cacheTTL = 15;
    private static final long max_cities_to_cache = 50;

    public WeatherCacheServiceImpl(StringRedisTemplate redisTemplate, RestTemplate restTemplate, ApiConfig apiConfig) {
        this.redisTemplate = redisTemplate;
        this.restTemplate = restTemplate;
        this.apiConfig = apiConfig;
    }

    @Override
    @Scheduled(fixedRate = 15 * 60 * 1000)
    @CircuitBreaker(name = "weather-api", fallbackMethod = "fetchWeatherDataFallback")
    public void fetchAndCacheWeatherData() {
        Set<String> topCities = getTopAccessedCities();
    
        int apiCallCount = 0;
        final int MAX_CALLS_PER_MINUTE = 60;
    
        for (String city : topCities) {
            if (apiCallCount >= MAX_CALLS_PER_MINUTE) {
                try {
                    log.info("API call limit reached. Pausing for 1 minute...");
                    Thread.sleep(60L * 1000);
                    apiCallCount = 0;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new CacheServiceException("Rate limiter sleep interrupted", e);
                }
            }
    
            String url = String.format("%s?q=%s&appid=%s&cnt=24", apiConfig.getUrl(), city, apiConfig.getKey());
    
            try {
                String weatherData = restTemplate.getForObject(url, String.class);
    
                if (weatherData != null) {
                    redisTemplate.opsForValue().set("weatherData:" + city, weatherData, cacheTTL, TimeUnit.MINUTES);
                    log.info("Weather data cached successfully for " + city);
                } else {
                    throw new WeatherDataFetchException("Received null response from OpenWeather API for city: " + city);
                }
    
                apiCallCount++;
    
            } catch (RestClientException e) {
                log.error("Failed to fetch data for city: " + city, e);
                throw new WeatherDataFetchException("Failed to fetch data from OpenWeather API for city: " + city, e);
    
            } catch (CacheServiceException e) {
                log.error("Failed to cache data for city: " + city, e);
                throw new CacheServiceException("Error while caching weather data for city: " + city, e);
    
            } catch (Exception e) {
                log.error("Unexpected error during fetch and cache for city: " + city, e);
                throw new CacheServiceException("Unexpected error during fetch and cache for city: " + city, e);
            }
        }
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
    public String getCachedWeatherData(String city) {
        log.info("Requested cached data from Redis for city: " + city);
        trackCityAccess(city);
        String cachedData = redisTemplate.opsForValue().get("weatherData:" + city);
        if (cachedData == null) {
            log.info("Cache miss for city: " + city + ". Fetching from OpenWeather API...");
            return fetchAndCacheSingleCityData(city);
        }
        return cachedData;
    }

    private String fetchAndCacheSingleCityData(String city) {
        String url = String.format("%s?q=%s&appid=%s&cnt=24", apiConfig.getUrl(), city, apiConfig.getKey());
        try {
            String weatherData = restTemplate.getForObject(url, String.class);

            if (weatherData != null) {
                redisTemplate.opsForValue().set("weatherData:" + city, weatherData, cacheTTL, TimeUnit.MINUTES);
                trackCityAccess(city);
                return weatherData;
            } else {
                throw new WeatherDataFetchException("Received null response for city: " + city);
            }
        } catch (RestClientException e) {
            throw new WeatherDataFetchException("Failed to fetch data for city: " + city, e);
        }
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
