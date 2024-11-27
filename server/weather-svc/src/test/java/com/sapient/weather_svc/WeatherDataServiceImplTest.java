package com.sapient.weather_svc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import com.hrishit.weather_svc.WeatherSvcApplication;
import com.hrishit.weather_svc.config.WeatherAPIConfig;
import com.hrishit.weather_svc.dto.WeatherResponseDTO;
import com.hrishit.weather_svc.exceptions.WeatherDataNotFoundException;
import com.hrishit.weather_svc.services.WeatherDataServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.CompletableFuture;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = WeatherSvcApplication.class)
class WeatherDataServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private WeatherAPIConfig weatherAPIConfig;

    @InjectMocks
    private WeatherDataServiceImpl weatherDataService;

    private WeatherResponseDTO mockWeatherResponse;

    @BeforeEach
    void setUp() {
        mockWeatherResponse = new WeatherResponseDTO(); 
    }

    @Test
    void testGetForecastData_success() throws Exception {
        String city = "Bengaluru";
        when(restTemplate.getForObject(anyString(), eq(WeatherResponseDTO.class)))
                .thenReturn(mockWeatherResponse);

        CompletableFuture<WeatherResponseDTO> result = weatherDataService.getForecastData(city);

        verify(restTemplate, times(1)).getForObject(anyString(), eq(WeatherResponseDTO.class));
        assert result.isCompletedExceptionally() == false;
    }

    @Test
    void testGetForecastData_noDataFound() throws Exception {
        String city = "NonExistentCity";
        when(restTemplate.getForObject(anyString(), eq(WeatherResponseDTO.class)))
                .thenReturn(null);

        try {
            weatherDataService.getForecastData(city);
        } catch (WeatherDataNotFoundException e) {
            assert e.getMessage().equals("City not found");
        }

        verify(restTemplate, times(1)).getForObject(anyString(), eq(WeatherResponseDTO.class));
    }

    @Test
    void testFallbackForWeatherData_success() throws Exception {
        String city = "Bengaluru";
        String fallbackUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city;
        
        when(restTemplate.getForObject(eq(fallbackUrl), eq(WeatherResponseDTO.class)))
                .thenReturn(mockWeatherResponse);

        CompletableFuture<WeatherResponseDTO> result = weatherDataService.fallbackForWeatherData(city, new Exception());

        verify(restTemplate, times(1)).getForObject(eq(fallbackUrl), eq(WeatherResponseDTO.class));
        assert result.get() != null;
    }

    @SuppressWarnings("null")
    @Test
    void testFallbackForWeatherData_internalServerError() throws Exception {
        String city = "Bengaluru";
        String fallbackUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city;

        when(restTemplate.getForObject(eq(fallbackUrl), eq(WeatherResponseDTO.class)))
                .thenThrow(new RuntimeException("Fallback API failed"));

        try {
            weatherDataService.fallbackForWeatherData(city, new Exception());
        } catch (ResponseStatusException e) {
            assert e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR;
            assert e.getReason().equals("Internal server error while fetching fallback weather data");
            assert e.getCause() instanceof RuntimeException;  // Check the cause
            assert e.getCause().getMessage().equals("Fallback API failed");
        }

        verify(restTemplate, times(1)).getForObject(eq(fallbackUrl), eq(WeatherResponseDTO.class));
    }


    @Test
     void testAddAdviceToForecast() {
        WeatherResponseDTO responseDTO = mock(WeatherResponseDTO.class);

        weatherDataService.addAdviceToForecast(responseDTO);

        verify(responseDTO, times(1)).getList();
    }
}
