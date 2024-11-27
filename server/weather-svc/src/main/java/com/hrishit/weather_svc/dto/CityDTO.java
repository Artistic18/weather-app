package com.hrishit.weather_svc.dto;

import lombok.Data;

@Data
public class CityDTO {
    private String name;
    private String country;
    private Integer sunrise;
    private Integer sunset;
}
