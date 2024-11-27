package com.hrishit.weather_cache_service.constants;

public class SwaggerExamples {
    public static final String WEATHER_EXAMPLE = """
        {
  "cod": "200",
  "message": 0,
  "cnt": 24,
  "list": [
    {
      "dt": 1732730400,
      "main": {
        "temp": 9.45,
        "feels_like": 7.33,
        "temp_min": 9.45,
        "temp_max": 10.02,
        "pressure": 1017,
        "sea_level": 1017,
        "grnd_level": 1016,
        "humidity": 49,
        "temp_kf": -0.57
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01d"
        }
      ],
      "clouds": {
        "all": 8
      },
      "wind": {
        "speed": 4,
        "deg": 279,
        "gust": 5.91
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-27 18:00:00"
    },
    {
      "dt": 1732741200,
      "main": {
        "temp": 10.09,
        "feels_like": 8.3,
        "temp_min": 10.09,
        "temp_max": 10.55,
        "pressure": 1017,
        "sea_level": 1017,
        "grnd_level": 1015,
        "humidity": 44,
        "temp_kf": -0.46
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 59
      },
      "wind": {
        "speed": 3.16,
        "deg": 262,
        "gust": 4.84
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-27 21:00:00"
    },
    {
      "dt": 1732752000,
      "main": {
        "temp": 9.37,
        "feels_like": 8.54,
        "temp_min": 9.37,
        "temp_max": 9.37,
        "pressure": 1016,
        "sea_level": 1016,
        "grnd_level": 1016,
        "humidity": 45,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 94
      },
      "wind": {
        "speed": 1.91,
        "deg": 248,
        "gust": 4.11
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-28 00:00:00"
    },
    {
      "dt": 1732762800,
      "main": {
        "temp": 9.15,
        "feels_like": 9.15,
        "temp_min": 9.15,
        "temp_max": 9.15,
        "pressure": 1015,
        "sea_level": 1015,
        "grnd_level": 1014,
        "humidity": 47,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 1.29,
        "deg": 227,
        "gust": 2.43
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-28 03:00:00"
    },
    {
      "dt": 1732773600,
      "main": {
        "temp": 8.96,
        "feels_like": 8.96,
        "temp_min": 8.96,
        "temp_max": 8.96,
        "pressure": 1014,
        "sea_level": 1014,
        "grnd_level": 1013,
        "humidity": 48,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 1.19,
        "deg": 194,
        "gust": 2.2
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-28 06:00:00"
    },
    {
      "dt": 1732784400,
      "main": {
        "temp": 8.48,
        "feels_like": 8.48,
        "temp_min": 8.48,
        "temp_max": 8.48,
        "pressure": 1012,
        "sea_level": 1012,
        "grnd_level": 1012,
        "humidity": 58,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10n"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 0.66,
        "deg": 190,
        "gust": 2.37
      },
      "visibility": 10000,
      "pop": 0.59,
      "rain": {
        "3h": 0.31
      },
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-28 09:00:00"
    },
    {
      "dt": 1732795200,
      "main": {
        "temp": 7.58,
        "feels_like": 4.73,
        "temp_min": 7.58,
        "temp_max": 7.58,
        "pressure": 1007,
        "sea_level": 1007,
        "grnd_level": 1006,
        "humidity": 87,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 501,
          "main": "Rain",
          "description": "moderate rain",
          "icon": "10d"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 4.62,
        "deg": 83,
        "gust": 8.2
      },
      "visibility": 6232,
      "pop": 1,
      "rain": {
        "3h": 6.86
      },
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-28 12:00:00"
    },
    {
      "dt": 1732806000,
      "main": {
        "temp": 8.41,
        "feels_like": 5.41,
        "temp_min": 8.41,
        "temp_max": 8.41,
        "pressure": 1001,
        "sea_level": 1001,
        "grnd_level": 1001,
        "humidity": 92,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 501,
          "main": "Rain",
          "description": "moderate rain",
          "icon": "10d"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 5.49,
        "deg": 56,
        "gust": 10.86
      },
      "visibility": 10000,
      "pop": 1,
      "rain": {
        "3h": 8.21
      },
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-28 15:00:00"
    },
    {
      "dt": 1732816800,
      "main": {
        "temp": 8.35,
        "feels_like": 6.11,
        "temp_min": 8.35,
        "temp_max": 8.35,
        "pressure": 998,
        "sea_level": 998,
        "grnd_level": 997,
        "humidity": 90,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10d"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 3.74,
        "deg": 335,
        "gust": 5.77
      },
      "visibility": 10000,
      "pop": 1,
      "rain": {
        "3h": 2.37
      },
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-28 18:00:00"
    },
    {
      "dt": 1732827600,
      "main": {
        "temp": 5.86,
        "feels_like": 1.92,
        "temp_min": 5.86,
        "temp_max": 5.86,
        "pressure": 1001,
        "sea_level": 1001,
        "grnd_level": 1001,
        "humidity": 79,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10d"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 6.17,
        "deg": 318,
        "gust": 10.03
      },
      "visibility": 10000,
      "pop": 0.2,
      "rain": {
        "3h": 0.35
      },
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-28 21:00:00"
    },
    {
      "dt": 1732838400,
      "main": {
        "temp": 6.2,
        "feels_like": 2.02,
        "temp_min": 6.2,
        "temp_max": 6.2,
        "pressure": 1005,
        "sea_level": 1005,
        "grnd_level": 1005,
        "humidity": 73,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 804,
          "main": "Clouds",
          "description": "overcast clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 100
      },
      "wind": {
        "speed": 7.1,
        "deg": 298,
        "gust": 11.37
      },
      "visibility": 10000,
      "pop": 0.08,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-29 00:00:00"
    },
    {
      "dt": 1732849200,
      "main": {
        "temp": 5.21,
        "feels_like": 0.52,
        "temp_min": 5.21,
        "temp_max": 5.21,
        "pressure": 1008,
        "sea_level": 1008,
        "grnd_level": 1008,
        "humidity": 71,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 70
      },
      "wind": {
        "speed": 7.78,
        "deg": 310,
        "gust": 11.87
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-29 03:00:00"
    },
    {
      "dt": 1732860000,
      "main": {
        "temp": 5.81,
        "feels_like": 1.96,
        "temp_min": 5.81,
        "temp_max": 5.81,
        "pressure": 1010,
        "sea_level": 1010,
        "grnd_level": 1009,
        "humidity": 67,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04n"
        }
      ],
      "clouds": {
        "all": 84
      },
      "wind": {
        "speed": 5.92,
        "deg": 295,
        "gust": 10.57
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-29 06:00:00"
    },
    {
      "dt": 1732870800,
      "main": {
        "temp": 4.47,
        "feels_like": 0.8,
        "temp_min": 4.47,
        "temp_max": 4.47,
        "pressure": 1012,
        "sea_level": 1012,
        "grnd_level": 1011,
        "humidity": 62,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01n"
        }
      ],
      "clouds": {
        "all": 4
      },
      "wind": {
        "speed": 4.75,
        "deg": 293,
        "gust": 10.23
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-29 09:00:00"
    },
    {
      "dt": 1732881600,
      "main": {
        "temp": 3.8,
        "feels_like": 0.57,
        "temp_min": 3.8,
        "temp_max": 3.8,
        "pressure": 1013,
        "sea_level": 1013,
        "grnd_level": 1012,
        "humidity": 70,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01d"
        }
      ],
      "clouds": {
        "all": 4
      },
      "wind": {
        "speed": 3.7,
        "deg": 282,
        "gust": 8.01
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-29 12:00:00"
    },
    {
      "dt": 1732892400,
      "main": {
        "temp": 5.24,
        "feels_like": 1.91,
        "temp_min": 5.24,
        "temp_max": 5.24,
        "pressure": 1014,
        "sea_level": 1014,
        "grnd_level": 1014,
        "humidity": 60,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01d"
        }
      ],
      "clouds": {
        "all": 6
      },
      "wind": {
        "speed": 4.44,
        "deg": 257,
        "gust": 5.93
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-29 15:00:00"
    },
    {
      "dt": 1732903200,
      "main": {
        "temp": 7,
        "feels_like": 3.43,
        "temp_min": 7,
        "temp_max": 7,
        "pressure": 1013,
        "sea_level": 1013,
        "grnd_level": 1012,
        "humidity": 47,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 801,
          "main": "Clouds",
          "description": "few clouds",
          "icon": "02d"
        }
      ],
      "clouds": {
        "all": 12
      },
      "wind": {
        "speed": 6,
        "deg": 261,
        "gust": 7.94
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-29 18:00:00"
    },
    {
      "dt": 1732914000,
      "main": {
        "temp": 6.73,
        "feels_like": 3.18,
        "temp_min": 6.73,
        "temp_max": 6.73,
        "pressure": 1013,
        "sea_level": 1013,
        "grnd_level": 1013,
        "humidity": 42,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 803,
          "main": "Clouds",
          "description": "broken clouds",
          "icon": "04d"
        }
      ],
      "clouds": {
        "all": 84
      },
      "wind": {
        "speed": 5.77,
        "deg": 265,
        "gust": 9.5
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-29 21:00:00"
    },
    {
      "dt": 1732924800,
      "main": {
        "temp": 5.59,
        "feels_like": 1.8,
        "temp_min": 5.59,
        "temp_max": 5.59,
        "pressure": 1014,
        "sea_level": 1014,
        "grnd_level": 1014,
        "humidity": 49,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 802,
          "main": "Clouds",
          "description": "scattered clouds",
          "icon": "03n"
        }
      ],
      "clouds": {
        "all": 49
      },
      "wind": {
        "speed": 5.62,
        "deg": 262,
        "gust": 10.15
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-30 00:00:00"
    },
    {
      "dt": 1732935600,
      "main": {
        "temp": 3.75,
        "feels_like": -0.69,
        "temp_min": 3.75,
        "temp_max": 3.75,
        "pressure": 1015,
        "sea_level": 1015,
        "grnd_level": 1014,
        "humidity": 52,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01n"
        }
      ],
      "clouds": {
        "all": 3
      },
      "wind": {
        "speed": 6,
        "deg": 271,
        "gust": 9.57
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-30 03:00:00"
    },
    {
      "dt": 1732946400,
      "main": {
        "temp": 2.2,
        "feels_like": -2.45,
        "temp_min": 2.2,
        "temp_max": 2.2,
        "pressure": 1015,
        "sea_level": 1015,
        "grnd_level": 1014,
        "humidity": 58,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01n"
        }
      ],
      "clouds": {
        "all": 2
      },
      "wind": {
        "speed": 5.55,
        "deg": 274,
        "gust": 9.81
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-30 06:00:00"
    },
    {
      "dt": 1732957200,
      "main": {
        "temp": 1.23,
        "feels_like": -3.34,
        "temp_min": 1.23,
        "temp_max": 1.23,
        "pressure": 1015,
        "sea_level": 1015,
        "grnd_level": 1015,
        "humidity": 59,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01n"
        }
      ],
      "clouds": {
        "all": 3
      },
      "wind": {
        "speed": 4.93,
        "deg": 278,
        "gust": 8.7
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-30 09:00:00"
    },
    {
      "dt": 1732968000,
      "main": {
        "temp": 0.59,
        "feels_like": -4.08,
        "temp_min": 0.59,
        "temp_max": 0.59,
        "pressure": 1017,
        "sea_level": 1017,
        "grnd_level": 1016,
        "humidity": 60,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01n"
        }
      ],
      "clouds": {
        "all": 4
      },
      "wind": {
        "speed": 4.83,
        "deg": 274,
        "gust": 7.63
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "n"
      },
      "dt_txt": "2024-11-30 12:00:00"
    },
    {
      "dt": 1732978800,
      "main": {
        "temp": 2.09,
        "feels_like": -2.38,
        "temp_min": 2.09,
        "temp_max": 2.09,
        "pressure": 1017,
        "sea_level": 1017,
        "grnd_level": 1017,
        "humidity": 51,
        "temp_kf": 0
      },
      "weather": [
        {
          "id": 800,
          "main": "Clear",
          "description": "clear sky",
          "icon": "01d"
        }
      ],
      "clouds": {
        "all": 5
      },
      "wind": {
        "speed": 5.15,
        "deg": 274,
        "gust": 6.81
      },
      "visibility": 10000,
      "pop": 0,
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2024-11-30 15:00:00"
    }
  ],
  "city": {
    "id": 5128581,
    "name": "New York",
    "coord": {
      "lat": 40.7143,
      "lon": -74.006
    },
    "country": "US",
    "population": 8175133,
    "timezone": -18000,
    "sunrise": 1732708633,
    "sunset": 1732743050
  }
}
    """;
}
