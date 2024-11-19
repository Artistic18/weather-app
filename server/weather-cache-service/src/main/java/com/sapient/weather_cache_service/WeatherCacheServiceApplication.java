package com.sapient.weather_cache_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class WeatherCacheServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCacheServiceApplication.class, args);
	}

}
