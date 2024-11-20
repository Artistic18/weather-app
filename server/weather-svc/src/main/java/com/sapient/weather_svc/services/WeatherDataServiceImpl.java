package com.sapient.weather_svc.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.weather_svc.config.WeatherAPIConfig;
import com.sapient.weather_svc.dto.WeatherResponseDTO;
import com.sapient.weather_svc.exceptions.WeatherDataNotFoundException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

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
        
        if (response == null) {
            throw new WeatherDataNotFoundException("Cache data not available");
        }

        return CompletableFuture.completedFuture(response);
    }

    public CompletableFuture<WeatherResponseDTO> fallbackForWeatherData(String city, Throwable t) {
        String openWeatherApiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + weatherAPIConfig.getKey() + "&cnt=" + weatherAPIConfig.getCount();
        
        WeatherResponseDTO fallbackResponse = restTemplate.getForObject(openWeatherApiUrl, WeatherResponseDTO.class);
        
        return CompletableFuture.completedFuture(fallbackResponse);
    }
}