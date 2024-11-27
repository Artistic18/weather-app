package com.hrishit.weather_svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

import com.hrishit.weather_svc.config.WeatherAPIConfig;

@SpringBootApplication
@EnableConfigurationProperties(WeatherAPIConfig.class)
@EnableAsync
public class WeatherSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherSvcApplication.class, args);
	}

}
