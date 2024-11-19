package com.sapient.weather_cache_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.weather_cache_service.services.WeatherCacheService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RestController
public class WeatherCacheController {
    
    private final WeatherCacheService weatherCacheService;

    public WeatherCacheController(WeatherCacheService weatherCacheService) {
        this.weatherCacheService = weatherCacheService;
    }

    @GetMapping("/data/cache/weather")
    public ResponseEntity<String> getWeatherData(@RequestParam String city) {
        log.info("Requested /data/cache/weather with city: " + city);
        String cachedData = weatherCacheService.getCachedWeatherData(city);
        return ResponseEntity.ok(cachedData);
    }
    
}
