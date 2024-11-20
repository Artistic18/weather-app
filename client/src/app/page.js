"use client";
import "../styles/style.scss";
import axios from "axios";
import SearchBox from "@/components/search-box/SearchBox";
import LocationDetails from "@/components/location-details/LocationDetails";
import TemperatureDetails from "@/components/temperature-details/TemperatureDetails";
import WeatherDescription from "@/components/weather-description/WeatherDescription";
import WeatherCarousel from "@/components/weather-carousel/WeatherCarousel";
import { useWeather } from "@/contexts/WeatherContext";

export default function Home() {
  const { city, weatherData, loading, error } = useWeather();
  const currentHour = new Date().getHours();
  const timeOfDay = currentHour >= 6 && currentHour < 18 ? "day" : "night";

  if (loading) {
    return <div className="loading">Loading...</div>;
  }

  if (error) {
    return <div className="error">{error}</div>;
  }

  return (
    <div className={`weather-container min-h-screen ${timeOfDay}`}>
      <div className="flex">
        <div className="weather-container__summary flex flex-col p-5 basis-1/6 h-screen">
          <SearchBox />
          <LocationDetails data={weatherData} />
          <TemperatureDetails data={weatherData.list[0]} />
        </div>
        <div className="weather-container__details basis-5/6">
          <WeatherDescription />
          <WeatherCarousel />
        </div>
      </div>
    </div>
  );
}
