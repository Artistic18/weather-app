"use client";
import React, { useState } from "react";
import "../../styles/style.scss";
import { useWeather } from "@/contexts/WeatherContext";

const SearchBox = () => {
  const { setCity } = useWeather();
  const [cityInput, setCityInput] = useState("");

  const handleInputChange = (event) => {
    setCityInput(event.target.value);
  };

  const handleSearch = () => {
    if (cityInput) {
      setCity(cityInput);
    }
  };

  return (
    <div className="weather-container__search-wrapper">
      <input
        className="weather-container__search"
        type="text"
        value={cityInput}
        onChange={handleInputChange}
        placeholder="Search a city"
      />
      <svg
        onClick={handleSearch}
        className="weather-container__search-icon"
        width="20px"
        height="20px"
        viewBox="0 0 24 24"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M21 21L17.5001 17.5M20 11.5C20 16.1944 16.1944 20 11.5 20C6.80558 20 3 16.1944 3 11.5C3 6.80558 6.80558 3 11.5 3C16.1944 3 20 6.80558 20 11.5Z"
          stroke="currentColor"
          strokeWidth="2"
          strokeLinecap="round"
          strokeLinejoin="round"
        />
      </svg>
    </div>
  );
};

export default SearchBox;
