import "../styles/style.scss";
import SearchBox from "@/components/search-box/SearchBox";
import LocationDetails from "@/components/location-details/LocationDetails";
import TemperatureDetails from "@/components/temperature-details/TemperatureDetails";
import WeatherDescription from "@/components/weather-description/WeatherDescription";
import WeatherCarousel from "@/components/weather-carousel/WeatherCarousel";

export default function Home() {
  const currentHour = new Date().getHours();
  const timeOfDay = currentHour >= 6 && currentHour < 18 ? "day" : "night";

  return (
    <div className={`weather-container min-h-screen ${timeOfDay}`}>
      <div className="flex">
        <div className="weather-container__summary flex flex-col p-5 basis-1/6 h-screen">
          <SearchBox />
          <LocationDetails />
          <TemperatureDetails />
        </div>
        <div className="weather-container__details basis-5/6">
          <WeatherDescription />
          <WeatherCarousel />
        </div>
      </div>
    </div>
  );
}
