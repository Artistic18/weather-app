package com.sapient.weather_cache_service.services;

public interface WeatherCacheService {
    /**
     * Fetches and caches weather data from the OpenWeather API.
     */
    void fetchAndCacheWeatherData();

    /**
     * Retrieves cached weather data for the given city.
     *
     * @param city the name of the city
     * @return the cached weather data as a JSON string, or null if not found
     */
    String getCachedWeatherData(String city);
}
