"use client";
import "../styles/style.scss";
import SearchBox from "@/components/search-box/SearchBox";
import LocationDetails from "@/components/location-details/LocationDetails";
import TemperatureDetails from "@/components/temperature-details/TemperatureDetails";
import WeatherDescription from "@/components/weather-description/WeatherDescription";
import WeatherCarousel from "@/components/weather-carousel/WeatherCarousel";
import { useWeather } from "@/contexts/WeatherContext";
import { useEffect } from "react";

export default function Home() {
  const { city, weatherData, loading, error } = useWeather();
  const currentHour = new Date().getHours();
  const timeOfDay = currentHour >= 6 && currentHour < 18 ? "day" : "night";

  const weatherCondition = weatherData?.list[0]?.weather[0]?.main || "Clouds";

  const timeAndWeatherClass = `${timeOfDay}-${weatherCondition.toLowerCase()}`;

  useEffect(() => {
    if (error) {
      const timer = setTimeout(() => {
        window.location.reload();
      }, 5000);

      return () => clearTimeout(timer);
    }
  }, [error]);

  if (loading) {
    return <div className="loading">Loading...</div>;
  }

  if (error) {
    return (
      <div className="error-container">
        <div className="error">{error}</div>
        <p>Page will refresh in 5 seconds...</p>
      </div>
    );
  }

  return (
    <div className={`weather-container min-h-screen ${timeAndWeatherClass}`}>
      <div className="flex flex-col md:flex-row">
        <div className="weather-container__summary flex flex-col p-5 md:basis-1/6 w-full md:w-auto h-auto md:h-screen">
          <SearchBox />
          <LocationDetails weatherData={weatherData} />
          <TemperatureDetails
            weatherDataList={weatherData.list[0]}
            cityData={weatherData.city}
            weatherData={weatherData}
          />
        </div>
        <div className="weather-container__details md:basis-5/6 w-full md:w-auto">
          <WeatherDescription weatherData={weatherData} />
          <WeatherCarousel weatherData={weatherData} />
        </div>
      </div>
    </div>
  );
}
