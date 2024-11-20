import React from "react";
import "../../styles/style.scss";

const LocationDetails = ({ weatherData }) => {
  const { name, country } = weatherData.city;
  return (
    <div className="weather-container__location-box flex flex-col">
      <div className="flex flex-row items-center gap-2">
        <svg
          width="16px"
          height="16px"
          viewBox="0 0 24 24"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M12 13C13.6569 13 15 11.6569 15 10C15 8.34315 13.6569 7 12 7C10.3431 7 9 8.34315 9 10C9 11.6569 10.3431 13 12 13Z"
            stroke="currentColor"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
          />
          <path
            d="M12 22C16 18 20 14.4183 20 10C20 5.58172 16.4183 2 12 2C7.58172 2 4 5.58172 4 10C4 14.4183 8 18 12 22Z"
            stroke="currentColor"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
          />
        </svg>
        <span className="weather-container__location-name">
          {name}, {country}
        </span>
      </div>
      <span className="weather-container__location-date">
        {`(${new Date().toLocaleString("en-US", {
          weekday: "long",
          month: "long",
          day: "numeric",
        })})`}
      </span>
    </div>
  );
};

export default LocationDetails;
