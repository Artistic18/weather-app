"use client";
import React, { useEffect, useState } from "react";
import {
  getSVGElementByTitle,
  segregateWeatherDataByDates,
  getHighestAndLowestTempForGroupedData,
} from "@/helper/helper";
import { useWeather } from "@/contexts/WeatherContext";

const WeatherDescription = ({ weatherData }) => {
  const { setDate, date, setSelected } = useWeather();
  const [description, setDescription] = useState("");
  const [segregatedData, setSegregatedData] = useState([]);
  const [temps, setTemps] = useState([]);

  useEffect(() => {
    setDescription(weatherData.list[0].weather[0].description);
    setSegregatedData(segregateWeatherDataByDates(weatherData.list));
    setTemps(getHighestAndLowestTempForGroupedData(weatherData.list));
  }, [weatherData]);

  useEffect(() => {
    if (segregatedData.length > 0) {
      const currentDateData = segregatedData.find((dayData) =>
        dayData.some((entry) => entry.date.includes(date))
      );
      if (currentDateData) {
        setDescription(currentDateData[0].weather[0].description);
      }
    }
  }, [date, segregatedData]);

  const onClickDay = (date, index) => {
    setDate(date);
    setSelected(index);
  };

  return (
    <div className="weather-description flex flex-col justify-center">
      <h1 className="weather-description__header">Weather Forecast</h1>
      <p className="weather-description__text text-7xl">
        {description.charAt(0).toUpperCase() + description.slice(1)}
      </p>
      <div className="flex flex-row mt-4 gap-2">
        {weatherData.list[0].advice[0] && (
          <div className="h-6 w-6">
            {getSVGElementByTitle(weatherData.list[0].weather[0].main)}
          </div>
        )}
        <p>{weatherData.list[0].advice}</p>
      </div>
      <div className="three-day-weather flex flex-col">
        <span className="text-lg">Upcoming Weather</span>
        {segregatedData.map((dayData, index) => (
          <div
            key={index}
            onClick={() => onClickDay(dayData[0].date, index)}
            className="flex flex-row mt-3 gap-2 items-center cursor-pointer weather-next__text"
          >
            <div className="h-7 w-7">
              {getSVGElementByTitle(dayData[0].weather[0].main)}
            </div>
            <div className="flex flex-col">
              <span>{dayData[0].date}</span>
              <span>
                H : {temps[index].highestTemp.toFixed(0)}° / L :{" "}
                {temps[index].lowestTemp.toFixed(0)}°
              </span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default WeatherDescription;
