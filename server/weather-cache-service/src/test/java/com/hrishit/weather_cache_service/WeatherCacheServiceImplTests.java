package com.hrishit.weather_cache_service;

import com.hrishit.weather_cache_service.config.ApiConfig;
import com.hrishit.weather_cache_service.services.WeatherCacheServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.*;

import java.util.Set;

class WeatherCacheServiceImplTests {

    @Mock
    private StringRedisTemplate redisTemplate;

    @Mock
    private ApiConfig apiConfig;

    @InjectMocks
    private WeatherCacheServiceImpl weatherCacheService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchAndCacheWeatherData_Success() {
        // Arrange
        Set<String> topCities = Set.of("City1", "City2");
        when(redisTemplate.opsForZSet().reverseRange("cityAccessCount", 0, 49)).thenReturn(topCities);
        when(apiConfig.getKey()).thenReturn("mock-api-key");

        // Act
        Mono<Void> result = weatherCacheService.fetchAndCacheWeatherData();

        // Assert
        StepVerifier.create(result)
                .expectComplete()
                .verify();
    }

    @Test
    void testGetCachedWeatherData_CacheHit() {
        // Arrange
        String city = "City1";
        String cachedWeatherData = "{\"city\":\"City1\", \"temp\":\"30\"}";
        when(redisTemplate.opsForValue().get("weatherData:" + city)).thenReturn(cachedWeatherData);

        // Act
        Mono<String> result = weatherCacheService.getCachedWeatherData(city);

        // Assert
        StepVerifier.create(result)
                .expectNext(cachedWeatherData)
                .expectComplete()
                .verify();
    }

    @Test
    void testTrackCityAccess() {
        // Arrange
        String city = "City1";
        doNothing().when(redisTemplate).opsForZSet().incrementScore("cityAccessCount", city, 1);

        // Act
        weatherCacheService.trackCityAccess(city);

        // Assert
        verify(redisTemplate).opsForZSet().incrementScore("cityAccessCount", city, 1);
    }

    @Test
    void testFetchWeatherDataFallback_DataAvailable() {
        // Arrange
        String city = "City1";
        String cachedData = "{\"city\":\"City1\", \"temp\":\"30\"}";
        when(redisTemplate.opsForValue().get("weatherData:" + city)).thenReturn(cachedData);

        // Act
        String result = weatherCacheService.fetchWeatherDataFallback(city, new Throwable("Fallback triggered"));

        // Assert
        assert(result.equals(cachedData));
    }

    @Test
    void testFetchWeatherDataFallback_NoData() {
        // Arrange
        String city = "City1";
        when(redisTemplate.opsForValue().get("weatherData:" + city)).thenReturn(null);

        // Act
        String result = weatherCacheService.fetchWeatherDataFallback(city, new Throwable("Fallback triggered"));

        // Assert
        assert(result.equals("No weather data available and unable to fetch from API."));
    }
}