"use client";
import "../styles/style.scss";
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
      <div className="flex flex-col md:flex-row">
        <div className="weather-container__summary flex flex-col p-5 md:basis-1/6 w-full md:w-auto h-auto md:h-screen">
          <SearchBox />
          <LocationDetails weatherData={weatherData} />
          <TemperatureDetails
            weatherData={weatherData.list[0]}
            cityData={weatherData.city}
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
