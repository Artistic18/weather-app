"use client";
import { createContext, useState, useContext, useEffect } from "react";
import axios from "axios";

const WeatherContext = createContext();

export const WeatherProvider = ({ children }) => {
  const [city, setCity] = useState("Kolkata");
  const [weatherData, setWeatherData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchWeatherData = async (city) => {
    try {
      setLoading(true);
      setError(null);
      console.log(`Fetching weather data for city: ${city}`);

      const response = await axios.get(`/api/weather`, {
        params: { city },
      });

      console.log("Weather data response:", response.data);
      setWeatherData(response.data);
    } catch (err) {
      console.error("Error fetching weather data:", err);
      setError(err.response?.data?.message || "Error fetching data");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchWeatherData(city);
  }, [city]);

  return (
    <WeatherContext.Provider
      value={{ city, setCity, weatherData, loading, error }}
    >
      {children}
    </WeatherContext.Provider>
  );
};

export const useWeather = () => useContext(WeatherContext);
