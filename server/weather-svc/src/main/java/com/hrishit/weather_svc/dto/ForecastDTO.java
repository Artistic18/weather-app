package com.hrishit.weather_svc.dto;

import java.util.List;

import lombok.Data;

@Data
public class ForecastDTO {
    private long dt;
    private String dt_text; 
    private MainDTO main;
    private List<WeatherDetailsDTO> weather;
    private WindDetailsDTO wind;
    private Integer visibility;
    private double pop;
    private List<String> advice;
}
