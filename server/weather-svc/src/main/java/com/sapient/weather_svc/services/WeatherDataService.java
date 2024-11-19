package com.sapient.weather_svc.services;

import java.util.concurrent.CompletableFuture;

import com.sapient.weather_svc.dto.WeatherResponseDTO;

public interface WeatherDataService {
      /**
     * Retrieves weather forecast for a given city.
     *
     * @param city the name of the city
     * @return the weather forecast as a JSON string
     */

     CompletableFuture<WeatherResponseDTO> getForecastData(String city);
}