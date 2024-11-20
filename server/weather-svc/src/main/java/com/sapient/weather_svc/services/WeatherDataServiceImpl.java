package com.sapient.weather_svc.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.weather_svc.config.WeatherAPIConfig;
import com.sapient.weather_svc.dto.WeatherResponseDTO;

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
    public CompletableFuture<WeatherResponseDTO> getForecastData(String city) {
        String reqURL = "http://54.175.96.105:8081/data/cache/weather?city=" + city;

        WeatherResponseDTO response = restTemplate.getForObject(reqURL, WeatherResponseDTO.class);

        return CompletableFuture.completedFuture(response);
    }
}