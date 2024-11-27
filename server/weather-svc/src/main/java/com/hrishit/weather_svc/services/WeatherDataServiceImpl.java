package com.hrishit.weather_svc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.hrishit.weather_svc.config.WeatherAPIConfig;
import com.hrishit.weather_svc.dto.WeatherResponseDTO;
import com.hrishit.weather_svc.exceptions.WeatherDataNotFoundException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final RestTemplate restTemplate;
    private final WeatherAPIConfig weatherAPIConfig;

    public WeatherDataServiceImpl(RestTemplate restTemplate, WeatherAPIConfig weatherAPIConfig) {
        this.restTemplate = restTemplate;
        this.weatherAPIConfig = weatherAPIConfig;
    }

    @Override
    @Async
    @CircuitBreaker(name = "weatherApiCircuitBreaker", fallbackMethod = "fallbackForWeatherData")
    @Retry(name = "weatherApiRetry") 
    public CompletableFuture<WeatherResponseDTO> getForecastData(String city) {
        String reqURL = "http://54.175.96.105:8081/data/cache/weather?city=" + city;

        WeatherResponseDTO response = restTemplate.getForObject(reqURL, WeatherResponseDTO.class);
        log.info("Fetched weather data for city: {}", response);
        
        if (response == null) {
            log.error("No weather data found for city: {}", city);
            throw new WeatherDataNotFoundException("City not found");
        }

        addAdviceToForecast(response);

        return CompletableFuture.completedFuture(response);
    }

    @Override
    public void addAdviceToForecast(WeatherResponseDTO weatherResponseDTO) {
        weatherResponseDTO.getList().forEach(forecast -> {
            List<String> advice = new ArrayList<>();

            if (forecast.getPop() > 0.7) { 
                advice.add("There's chance of rain, carry an umbrella!");
            }

            if (forecast.getMain().getTemp_max() > 40) {
                advice.add("The temperature is above 40°C, use sunscreen lotion!");
            }

            if (forecast.getWind().getSpeed() > 10) {
                advice.add("It’s too windy (Wind speed: " + forecast.getWind().getSpeed() + " mph), watch out!");
            }

            if (forecast.getWeather().stream().anyMatch(w -> w.getMain().equalsIgnoreCase("Thunderstorm"))) {
                advice.add("Don’t step out! A storm is brewing!");
            }

            forecast.setAdvice(advice);
        });
    }

    public CompletableFuture<WeatherResponseDTO> fallbackForWeatherData(String city, Throwable t) {

        if (t instanceof HttpServerErrorException) {
            log.error("Error while fetching weather data for city: {}", city, t);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error while fetching weather data", t);
        }

        try {
            String openWeatherApiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + weatherAPIConfig.getKey() + "&cnt=" + weatherAPIConfig.getCount() + "&units=metric";
            WeatherResponseDTO fallbackResponse = restTemplate.getForObject(openWeatherApiUrl, WeatherResponseDTO.class);
            log.info("Fetched fallback weather data for city: {}", city);
            return CompletableFuture.completedFuture(fallbackResponse);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error while fetching fallback weather data", e);
        }
    }

}