import React from "react";
import "../../styles/style.scss";

const TemperatureDetails = ({ weatherData, cityData }) => {
  console.log("hrishit", weatherData, cityData);
  const { main, visibility, wind } = weatherData;
  const { sunrise, sunset } = cityData;

  return (
    <div className="weather-container__temperature flex flex-col justify-center">
      <div className="flex flex-row items-center gap-5">
        <span className="weather-container__temperature-value">
          {main.temp.toFixed(0)}°
        </span>
        <div className="flex flex-col">
          <span>Max: {main.temp_max.toFixed(0)}°</span>
          <span>Min: {main.temp_min.toFixed(0)}°</span>
        </div>
      </div>
      <div className="flex flex-row gap-12 ml-3">
        <div className="flex flex-col">
          <div className="flex flex-row items-center gap-1">
            <svg
              width="16px"
              height="16px"
              viewBox="0 0 24 24"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M21 3L15 3M21 7L15 7M21 11L15 11M5.5 13.7578V4.5C5.5 3.11929 6.61929 2 8 2C9.38071 2 10.5 3.11929 10.5 4.5V13.7578C11.706 14.565 12.5 15.9398 12.5 17.5C12.5 19.9853 10.4853 22 8 22C5.51472 22 3.5 19.9853 3.5 17.5C3.5 15.9398 4.29401 14.565 5.5 13.7578ZM9 17.5C9 18.0523 8.55228 18.5 8 18.5C7.44772 18.5 7 18.0523 7 17.5C7 16.9477 7.44772 16.5 8 16.5C8.55228 16.5 9 16.9477 9 17.5Z"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
              />
            </svg>
            <span>Feels Like</span>
          </div>
          <span className="text-3xl">{main.feels_like.toFixed(0)}°</span>
        </div>
        <div className="flex flex-col">
          <div className="flex flex-row items-center gap-1">
            <svg
              width="16px"
              height="16px"
              viewBox="0 0 24 24"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M21 18C21 18 19.8096 17.5305 19 17.3021C13.8797 15.8574 10.1203 20.1426 5 18.6979C4.19041 18.4695 3 18 3 18M21 12C21 12 19.8096 11.5305 19 11.3021C13.8797 9.85739 10.1203 14.1426 5 12.6979C4.19041 12.4695 3 12 3 12M21 6C21 6 19.8096 5.53048 19 5.30206C13.8797 3.85739 10.1203 8.14261 5 6.69794C4.19041 6.46952 3 6 3 6"
                stroke="currentColor"
                strokeWidth="2"
                strokeLinecap="round"
                strokeLinejoin="round"
              />
            </svg>
            <span>Humidity</span>
          </div>
          <span className="text-3xl">{main.humidity}%</span>
        </div>
      </div>
      <div className="flex flex-col ml-3 mt-3">
        <div className="flex flex-row items-center gap-1">
          <svg
            width="16px"
            height="16px"
            viewBox="0 0 24 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M5 12C5 8.13401 8.13401 5 12 5M16.4999 7.5L11.9999 12M22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12ZM13 12C13 12.5523 12.5523 13 12 13C11.4477 13 11 12.5523 11 12C11 11.4477 11.4477 11 12 11C12.5523 11 13 11.4477 13 12Z"
              stroke="currentColor"
              strokeWidth="2"
              strokeLinecap="round"
              strokeLinejoin="round"
            />
          </svg>
          <span>Pressure</span>
        </div>
        <span className="text-3xl">{main.pressure} hPa</span>
      </div>
      <div className="flex flex-col ml-3 mt-3">
        <div className="flex flex-row gap-1 items-center">
          <svg
            width="16px"
            height="16px"
            viewBox="0 0 24 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M9.50929 4.66667C9.8755 4.2575 10.4077 4 11 4C12.1046 4 13 4.89543 13 6C13 7.10457 12.1046 8 11 8H2.00002M12.5093 19.3333C12.8755 19.7425 13.4077 20 14 20C15.1046 20 16 19.1046 16 18C16 16.8954 15.1046 16 14 16H2.00002M16.7639 7C17.3132 6.38625 18.1115 6 19 6C20.6569 6 22 7.34315 22 9C22 10.6569 20.6569 12 19 12H2"
              stroke="currentColor"
              strokeWidth="2"
              strokeLinecap="round"
              strokeLinejoin="round"
            />
          </svg>
          <span>Wind</span>
        </div>
        <span className="text-3xl">
          {(wind.speed * 3.6).toFixed(0)} km/h{" "}
          <span className="text-sm">speed</span>
        </span>
        <span className="text-3xl">
          {(wind.gust * 3.6).toFixed(0)} km/h{" "}
          <span className="text-sm">gust</span>
        </span>
        <span className="text-3xl">
          {wind.deg}° <span className="text-sm">direction</span>
        </span>
      </div>
      <div className="flex flex-col mt-3 ml-3">
        <div className="flex flex-row gap-1 items-center">
          <svg
            width="16px"
            height="16px"
            viewBox="0 0 24 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M2.42012 12.7132C2.28394 12.4975 2.21584 12.3897 2.17772 12.2234C2.14909 12.0985 2.14909 11.9015 2.17772 11.7766C2.21584 11.6103 2.28394 11.5025 2.42012 11.2868C3.54553 9.50484 6.8954 5 12.0004 5C17.1054 5 20.4553 9.50484 21.5807 11.2868C21.7169 11.5025 21.785 11.6103 21.8231 11.7766C21.8517 11.9015 21.8517 12.0985 21.8231 12.2234C21.785 12.3897 21.7169 12.4975 21.5807 12.7132C20.4553 14.4952 17.1054 19 12.0004 19C6.8954 19 3.54553 14.4952 2.42012 12.7132Z"
              stroke="currentColor"
              strokeWidth="2"
              strokeLinecap="round"
              strokeLinejoin="round"
            />
            <path
              d="M12.0004 15C13.6573 15 15.0004 13.6569 15.0004 12C15.0004 10.3431 13.6573 9 12.0004 9C10.3435 9 9.0004 10.3431 9.0004 12C9.0004 13.6569 10.3435 15 12.0004 15Z"
              stroke="currentColor"
              strokeWidth="2"
              strokeLinecap="round"
              strokeLinejoin="round"
            />
          </svg>
          <span>Visibility</span>
        </div>
        <span className="text-3xl">{(visibility / 1000).toFixed(0)} Km</span>
      </div>
      <div className="flex flex-col mt-3 ml-3">
        <div className="flex flex-row gap-1">
          <svg
            width="16px"
            height="16px"
            viewBox="0 0 24 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M4 18H2M6.31412 12.3141L4.8999 10.8999M17.6858 12.3141L19.1 10.8999M22 18H20M7 18C7 15.2386 9.23858 13 12 13C14.7614 13 17 15.2386 17 18M22 22H2M16 6L12 2M12 2L8 6M12 2V9"
              stroke="currentColor"
              strokeWidth="2"
              strokeLinecap="round"
              strokeLinejoin="round"
            />
          </svg>
          <span>Sunrise</span>
        </div>
        <span className="text-2xl">
          {new Date(sunrise * 1000).toLocaleTimeString([], {
            hour: "2-digit",
            minute: "2-digit",
            hour12: true,
          })}
        </span>
      </div>
      <div className="flex flex-col mt-3 ml-3">
        <div className="flex flex-row gap-1">
          <svg
            width="16px"
            height="16px"
            viewBox="0 0 24 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M4 18H2M6.31412 12.3141L4.8999 10.8999M17.6858 12.3141L19.1 10.8999M22 18H20M7 18C7 15.2386 9.23858 13 12 13C14.7614 13 17 15.2386 17 18M22 22H2M16 5L12 9M12 9L8 5M12 9V2"
              stroke="currentColor"
              strokeWidth="2"
              strokeLinecap="round"
              strokeLinejoin="round"
            />
          </svg>
          <span>Sunset</span>
        </div>
        <span className="text-2xl">
          {new Date(sunset * 1000).toLocaleTimeString([], {
            hour: "2-digit",
            minute: "2-digit",
            hour12: true,
          })}
        </span>
      </div>
    </div>
  );
};

export default TemperatureDetails;
