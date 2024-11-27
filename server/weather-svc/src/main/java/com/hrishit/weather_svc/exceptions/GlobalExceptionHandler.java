package com.hrishit.weather_svc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(WeatherDataNotFoundException.class)
    public ResponseEntity<String> handleWeatherDataNotFound(WeatherDataNotFoundException weatherDataNotFoundException) {
        return new ResponseEntity<>(weatherDataNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WeatherServiceException.class)
    public ResponseEntity<String> handleWeatherServiceException(WeatherServiceException weatherServiceException) {
        return new ResponseEntity<>(weatherServiceException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
