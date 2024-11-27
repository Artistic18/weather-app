package com.hrishit.weather_svc.dto;

import lombok.Data;

@Data
public class WindDetailsDTO {
    private double speed;
    private Integer deg;
    private double gust;
}
