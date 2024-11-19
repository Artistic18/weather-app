package com.sapient.weather_svc.dto;

import java.util.List;

import lombok.Data;

@Data
public class WeatherResponseDTO {
    private CityDTO city;
    private List<ForecastDTO> list;
    private Integer cnt;
}

@Data
class CityDTO {
    private String name;
    private String country;
    private Integer sunrise;
    private Integer sunset;
}

@Data
class ForecastDTO {
    private long dt;
    private String dt_text; 
    private MainDTO main;
    private List<WeatherDetailsDTO> weather;
    private WindDetailsDTO wind;
    private Integer visibility;
    private double pop;
}

@Data
class MainDTO {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private Integer pressure;
    private Integer humidity;
}

@Data
class WeatherDetailsDTO {
    private String description;
    private String main;
}

@Data
class WindDetailsDTO {
    private double speed;
    private Integer deg;
    private double gust;
}

