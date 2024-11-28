package com.hrishit.weather_svc.constants;

public class SwaggerExamples {
    public static final String WEATHER_EXAMPLE = """
        {
  "city": {
    "name": "California",
    "country": "US",
    "sunrise": 1732708847,
    "sunset": 1732744037
  },
  "list": [
    {
      "dt": 1732752000,
      "dt_text": null,
      "main": {
        "temp": 10.2,
        "feels_like": 8.69,
        "temp_min": 8.35,
        "temp_max": 10.2,
        "pressure": 1016,
        "humidity": 54
      },
      "weather": [
        {
          "description": "overcast clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 2.46,
        "deg": 138,
        "gust": 5.1
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732762800,
      "dt_text": null,
      "main": {
        "temp": 10.51,
        "feels_like": 9.26,
        "temp_min": 10.2,
        "temp_max": 10.51,
        "pressure": 1014,
        "humidity": 63
      },
      "weather": [
        {
          "description": "overcast clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 4.05,
        "deg": 144,
        "gust": 9.84
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732773600,
      "dt_text": null,
      "main": {
        "temp": 11.32,
        "feels_like": 10.57,
        "temp_min": 11.32,
        "temp_max": 11.32,
        "pressure": 1010,
        "humidity": 79
      },
      "weather": [
        {
          "description": "overcast clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 4.15,
        "deg": 145,
        "gust": 11.6
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732784400,
      "dt_text": null,
      "main": {
        "temp": 12.1,
        "feels_like": 11.61,
        "temp_min": 12.1,
        "temp_max": 12.1,
        "pressure": 1006,
        "humidity": 86
      },
      "weather": [
        {
          "description": "light rain",
          "main": "Rain"
        }
      ],
      "wind": {
        "speed": 4.56,
        "deg": 164,
        "gust": 13.69
      },
      "visibility": 10000,
      "pop": 0.62,
      "advice": []
    },
    {
      "dt": 1732795200,
      "dt_text": null,
      "main": {
        "temp": 12.08,
        "feels_like": 11.72,
        "temp_min": 12.08,
        "temp_max": 12.08,
        "pressure": 1003,
        "humidity": 91
      },
      "weather": [
        {
          "description": "light rain",
          "main": "Rain"
        }
      ],
      "wind": {
        "speed": 3.94,
        "deg": 202,
        "gust": 13.88
      },
      "visibility": 10000,
      "pop": 0.49,
      "advice": []
    },
    {
      "dt": 1732806000,
      "dt_text": null,
      "main": {
        "temp": 13.21,
        "feels_like": 13.04,
        "temp_min": 13.21,
        "temp_max": 13.21,
        "pressure": 1001,
        "humidity": 94
      },
      "weather": [
        {
          "description": "moderate rain",
          "main": "Rain"
        }
      ],
      "wind": {
        "speed": 5.15,
        "deg": 220,
        "gust": 17.62
      },
      "visibility": 10000,
      "pop": 1,
      "advice": [
        "There's chance of rain, carry an umbrella!"
      ]
    },
    {
      "dt": 1732816800,
      "dt_text": null,
      "main": {
        "temp": 15.36,
        "feels_like": 14.94,
        "temp_min": 15.36,
        "temp_max": 15.36,
        "pressure": 1001,
        "humidity": 76
      },
      "weather": [
        {
          "description": "light rain",
          "main": "Rain"
        }
      ],
      "wind": {
        "speed": 7.26,
        "deg": 271,
        "gust": 14.29
      },
      "visibility": 10000,
      "pop": 1,
      "advice": [
        "There's chance of rain, carry an umbrella!"
      ]
    },
    {
      "dt": 1732827600,
      "dt_text": null,
      "main": {
        "temp": 9.49,
        "feels_like": 6.24,
        "temp_min": 9.49,
        "temp_max": 9.49,
        "pressure": 1006,
        "humidity": 70
      },
      "weather": [
        {
          "description": "light rain",
          "main": "Rain"
        }
      ],
      "wind": {
        "speed": 7.15,
        "deg": 298,
        "gust": 13.88
      },
      "visibility": 10000,
      "pop": 0.2,
      "advice": []
    },
    {
      "dt": 1732838400,
      "dt_text": null,
      "main": {
        "temp": 6.94,
        "feels_like": 2.98,
        "temp_min": 6.94,
        "temp_max": 6.94,
        "pressure": 1011,
        "humidity": 68
      },
      "weather": [
        {
          "description": "scattered clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 7.07,
        "deg": 309,
        "gust": 12.85
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732849200,
      "dt_text": null,
      "main": {
        "temp": 5.92,
        "feels_like": 2.74,
        "temp_min": 5.92,
        "temp_max": 5.92,
        "pressure": 1013,
        "humidity": 65
      },
      "weather": [
        {
          "description": "broken clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 4.47,
        "deg": 312,
        "gust": 10.61
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732860000,
      "dt_text": null,
      "main": {
        "temp": 3.98,
        "feels_like": 1.03,
        "temp_min": 3.98,
        "temp_max": 3.98,
        "pressure": 1014,
        "humidity": 83
      },
      "weather": [
        {
          "description": "scattered clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 3.34,
        "deg": 295,
        "gust": 9.51
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732870800,
      "dt_text": null,
      "main": {
        "temp": 2.63,
        "feels_like": 0.01,
        "temp_min": 2.63,
        "temp_max": 2.63,
        "pressure": 1015,
        "humidity": 88
      },
      "weather": [
        {
          "description": "clear sky",
          "main": "Clear"
        }
      ],
      "wind": {
        "speed": 2.59,
        "deg": 295,
        "gust": 8.02
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732881600,
      "dt_text": null,
      "main": {
        "temp": 1.64,
        "feels_like": -0.79,
        "temp_min": 1.64,
        "temp_max": 1.64,
        "pressure": 1016,
        "humidity": 91
      },
      "weather": [
        {
          "description": "clear sky",
          "main": "Clear"
        }
      ],
      "wind": {
        "speed": 2.22,
        "deg": 280,
        "gust": 4.88
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732892400,
      "dt_text": null,
      "main": {
        "temp": 7.45,
        "feels_like": 5.09,
        "temp_min": 7.45,
        "temp_max": 7.45,
        "pressure": 1017,
        "humidity": 53
      },
      "weather": [
        {
          "description": "clear sky",
          "main": "Clear"
        }
      ],
      "wind": {
        "speed": 3.59,
        "deg": 242,
        "gust": 6.23
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732903200,
      "dt_text": null,
      "main": {
        "temp": 9.45,
        "feels_like": 6.7,
        "temp_min": 9.45,
        "temp_max": 9.45,
        "pressure": 1015,
        "humidity": 41
      },
      "weather": [
        {
          "description": "few clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 5.55,
        "deg": 268,
        "gust": 8.8
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732914000,
      "dt_text": null,
      "main": {
        "temp": 8.07,
        "feels_like": 5.11,
        "temp_min": 8.07,
        "temp_max": 8.07,
        "pressure": 1016,
        "humidity": 40
      },
      "weather": [
        {
          "description": "scattered clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 5.17,
        "deg": 288,
        "gust": 8.28
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732924800,
      "dt_text": null,
      "main": {
        "temp": 3.5,
        "feels_like": 0.2,
        "temp_min": 3.5,
        "temp_max": 3.5,
        "pressure": 1018,
        "humidity": 51
      },
      "weather": [
        {
          "description": "scattered clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 3.71,
        "deg": 303,
        "gust": 10.34
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732935600,
      "dt_text": null,
      "main": {
        "temp": 1.45,
        "feels_like": -2.22,
        "temp_min": 1.45,
        "temp_max": 1.45,
        "pressure": 1020,
        "humidity": 59
      },
      "weather": [
        {
          "description": "clear sky",
          "main": "Clear"
        }
      ],
      "wind": {
        "speed": 3.59,
        "deg": 297,
        "gust": 9.65
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732946400,
      "dt_text": null,
      "main": {
        "temp": 0.15,
        "feels_like": -3.4,
        "temp_min": 0.15,
        "temp_max": 0.15,
        "pressure": 1020,
        "humidity": 69
      },
      "weather": [
        {
          "description": "clear sky",
          "main": "Clear"
        }
      ],
      "wind": {
        "speed": 3.09,
        "deg": 283,
        "gust": 8
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732957200,
      "dt_text": null,
      "main": {
        "temp": -0.67,
        "feels_like": -4.76,
        "temp_min": -0.67,
        "temp_max": -0.67,
        "pressure": 1021,
        "humidity": 70
      },
      "weather": [
        {
          "description": "clear sky",
          "main": "Clear"
        }
      ],
      "wind": {
        "speed": 3.54,
        "deg": 293,
        "gust": 8.73
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732968000,
      "dt_text": null,
      "main": {
        "temp": -2.25,
        "feels_like": -7.12,
        "temp_min": -2.25,
        "temp_max": -2.25,
        "pressure": 1023,
        "humidity": 64
      },
      "weather": [
        {
          "description": "clear sky",
          "main": "Clear"
        }
      ],
      "wind": {
        "speed": 4.1,
        "deg": 296,
        "gust": 10.32
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732978800,
      "dt_text": null,
      "main": {
        "temp": 1.17,
        "feels_like": -4.01,
        "temp_min": 1.17,
        "temp_max": 1.17,
        "pressure": 1024,
        "humidity": 37
      },
      "weather": [
        {
          "description": "clear sky",
          "main": "Clear"
        }
      ],
      "wind": {
        "speed": 6.1,
        "deg": 297,
        "gust": 9.4
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1732989600,
      "dt_text": null,
      "main": {
        "temp": 3.6,
        "feels_like": -0.35,
        "temp_min": 3.6,
        "temp_max": 3.6,
        "pressure": 1022,
        "humidity": 31
      },
      "weather": [
        {
          "description": "scattered clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 4.87,
        "deg": 289,
        "gust": 7.12
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    },
    {
      "dt": 1733000400,
      "dt_text": null,
      "main": {
        "temp": 3.31,
        "feels_like": 0.69,
        "temp_min": 3.31,
        "temp_max": 3.31,
        "pressure": 1022,
        "humidity": 37
      },
      "weather": [
        {
          "description": "overcast clouds",
          "main": "Clouds"
        }
      ],
      "wind": {
        "speed": 2.74,
        "deg": 278,
        "gust": 5.35
      },
      "visibility": 10000,
      "pop": 0,
      "advice": []
    }
  ],
  "cnt": 32
}
    """;
}
