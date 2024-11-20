import React from "react";
import { SVGMap } from "@/helper/helper";

const WeatherDescription = () => {
  return (
    <div className="weather-description flex flex-col justify-center">
      <h1 className="weather-description__header">Weather Forecast</h1>
      <p className="weather-description__text text-7xl">Cloudy Sky</p>
      <div className="flex flex-row mt-4 gap-2">
        <svg
          width="25px"
          height="25px"
          viewBox="0 0 24 24"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M16 18.5L15 21M8 18.5L7 21M12 18.5L11 21M7 15C4.23858 15 2 12.7614 2 10C2 7.23858 4.23858 5 7 5C7.03315 5 7.06622 5.00032 7.09922 5.00097C8.0094 3.2196 9.86227 2 12 2C14.5192 2 16.6429 3.69375 17.2943 6.00462C17.3625 6.00155 17.4311 6 17.5 6C19.9853 6 22 8.01472 22 10.5C22 12.9853 19.9853 15 17.5 15C13.7434 15 11.2352 15 7 15Z"
            stroke="currentColor"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
          />
        </svg>
        <p>
          There&apos;s a 91% chance of precipitation. Please carry an umbrella.
        </p>
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
