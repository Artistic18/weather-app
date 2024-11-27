package com.hrishit.weather_svc.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrishit.weather_svc.constants.SwaggerExamples;
import com.hrishit.weather_svc.dto.WeatherResponseDTO;
import com.hrishit.weather_svc.services.WeatherDataService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class WeatherDataController {

    private final WeatherDataService weatherDataService;

    public WeatherDataController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @Operation(
        summary = "Get Weather Forecast Data", 
        description = "Fetch cached weather data for a given city.",
        parameters = {
            @Parameter(
                name = "city",
                description = "Name of the city to fetch weather data for",
                required = true,
                example = "California"
            )
        }
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Weather data fetched successfully",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    value = SwaggerExamples.WEATHER_EXAMPLE
                )
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "City not found or no cached data available",
            content = @Content(
                examples = @ExampleObject(
                    value = "{\"error\":\"City not found\"}"
                )
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content = @Content(
                examples = @ExampleObject(
                    value = "{\"error\":\"Internal server error. Failed to fetch data from API.\"}"
                )
            )
        )
    })
    @GetMapping("/data/forecast")
    public CompletableFuture<WeatherResponseDTO> getWeatherForecast(@RequestParam String city) {
        log.info("Fetching weather data for city: {}", city);
        return weatherDataService.getForecastData(city);
    }
    
}
