package com.hrishit.weather_svc.services;

import java.util.concurrent.CompletableFuture;

import com.hrishit.weather_svc.dto.WeatherResponseDTO;

public interface WeatherDataService {
      /**
     * Retrieves weather forecast for a given city.
     *
     * @param city the name of the city
     * @return the weather forecast as a JSON string
     */

     CompletableFuture<WeatherResponseDTO> getForecastData(String city);

     /**
     * Adds weather advice to the forecast data.
     *
     * @param weatherResponseDTO the weather response DTO to which advice will be added
     */
    void addAdviceToForecast(WeatherResponseDTO weatherResponseDTO);
}