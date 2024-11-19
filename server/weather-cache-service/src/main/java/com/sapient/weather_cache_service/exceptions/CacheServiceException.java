package com.sapient.weather_cache_service.exceptions;

public class CacheServiceException extends RuntimeException {
    public CacheServiceException(String message) {
        super(message);
    }

    public CacheServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
