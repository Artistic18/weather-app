"use client";
import { createContext, useState, useContext, useEffect } from "react";
import axios from "axios";

const WeatherContext = createContext();

export const WeatherProvider = ({ children }) => {
  const [city, setCity] = useState("Kolkata");
  const [weatherData, setWeatherData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [date, setDate] = useState(
    new Date().toLocaleString("en-US", {
      weekday: "short",
      month: "long",
      day: "numeric",
    })
  );
  const [selected, setSelected] = useState(0);

  const fetchWeatherData = async (city) => {
    try {
      setLoading(true);
      setError(null);

      const response = await axios.get(`/api/weather`, {
        params: { city: city.toLowerCase() },
      });

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
      value={{
        city,
        setCity,
        weatherData,
        loading,
        error,
        date,
        setDate,
        selected,
        setSelected,
      }}
    >
      {children}
    </WeatherContext.Provider>
  );
};

export const useWeather = () => useContext(WeatherContext);
