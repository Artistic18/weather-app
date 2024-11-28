import React from "react";
import { getSVGElementByTitle, SVGMap } from "@/helper/helper";

const WeatherDescription = ({ weatherData }) => {
  console.log("hris", weatherData);
  let description = weatherData.list[0].weather[0].description;
  description = description.charAt(0).toUpperCase() + description.slice(1);
  let advice = weatherData.list[0].advice[0];

  return (
    <div className="weather-description flex flex-col justify-center">
      <h1 className="weather-description__header">Weather Forecast</h1>
      <p className="weather-description__text text-7xl">{description}</p>
      <div className="flex flex-row mt-4 gap-2">
        {advice && (
          <div className="h-6 w-6">{getSVGElementByTitle("Rain")}</div>
        )}
        <p>{advice}</p>
      </div>
      <div className="three-day-weather flex flex-col">
        <span className="text-lg">Upcoming Weather</span>
        <div className="flex flex-row mt-5 gap-2 items-center">
          <div className="h-7 w-7">{SVGMap[0].element}</div>
          <div className="flex flex-col">
            <span>Sat, November 15</span>
            <span>H - 20° / L - 18°</span>
          </div>
        </div>
        <div className="flex flex-row mt-5 gap-2 items-center">
          <div className="h-7 w-7">{SVGMap[3].element}</div>
          <div className="flex flex-col">
            <span>Sun, November 16</span>
            <span>H - 21° / L - 18°</span>
          </div>
        </div>
        <div className="flex flex-row mt-5 gap-2 items-center">
          <div className="h-7 w-7">{SVGMap[2].element}</div>
          <div className="flex flex-col">
            <span>Mon, November 17</span>
            <span>H - 19° / L - 16°</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default WeatherDescription;
