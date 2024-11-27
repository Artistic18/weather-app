package com.hrishit.weather_cache_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
public class WeatherCacheServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCacheServiceApplication.class, args);
	}

}
