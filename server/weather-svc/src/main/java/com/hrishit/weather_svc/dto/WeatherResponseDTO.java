package com.hrishit.weather_svc.dto;

import java.util.List;

import lombok.Data;

@Data
public class WeatherResponseDTO {
    private CityDTO city;
    private List<ForecastDTO> list;
    private Integer cnt;
}


