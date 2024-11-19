package com.sapient.weather_svc.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.weather_svc.dto.WeatherResponseDTO;
import com.sapient.weather_svc.services.WeatherDataService;

@RestController
public class WeatherDataController {

    private final WeatherDataService weatherDataService;

    @Autowired
    public WeatherDataController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @GetMapping("/data/forecast")
    public CompletableFuture<WeatherResponseDTO> getWeatherForecast(@RequestParam String city) {
        return weatherDataService.getForecastData(city);
    }
    
}
