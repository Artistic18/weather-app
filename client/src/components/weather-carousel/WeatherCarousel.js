"use client";
import React, { useState, useEffect, useRef, useCallback } from "react";
import { getSVGElementByTitle } from "@/helper/helper";

const WeatherCarousel = ({ weatherData }) => {
  const { list } = weatherData;
  const visibleTemperatures = list.slice(0, 5 + 5);

  const parentRef = useRef(null);
  const scrollAmountRef = useRef(0);

  const [isMouseOver, setIsMouseOver] = useState(false);

  const handleWheel = useCallback(
    (e) => {
      if (!isMouseOver || !parentRef.current) return;

      e.preventDefault();

      const delta = e.deltaY;
      scrollAmountRef.current += delta > 0 ? 50 : -50;

      animateScroll(scrollAmountRef.current);
    },
    [isMouseOver]
  );

  const animateScroll = (scrollValue) => {
    const parent = parentRef.current;

    let currentScroll = parent.scrollLeft;

    const animate = () => {
      currentScroll += (scrollValue - currentScroll) * 0.1;
      parent.scrollLeft = currentScroll;

      if (Math.abs(scrollValue - currentScroll) > 1) {
        requestAnimationFrame(animate);
      } else {
        parent.scrollLeft = scrollValue;
      }
    };

    requestAnimationFrame(animate);
  };

  useEffect(() => {
    const handleMouseEnter = () => setIsMouseOver(true);
    const handleMouseLeave = () => setIsMouseOver(false);

    const parent = parentRef.current;
    if (parent) {
      parent.addEventListener("mouseenter", handleMouseEnter);
      parent.addEventListener("mouseleave", handleMouseLeave);
      parent.addEventListener("wheel", handleWheel, { passive: false });
    }

    return () => {
      if (parent) {
        parent.removeEventListener("mouseenter", handleMouseEnter);
        parent.removeEventListener("mouseleave", handleMouseLeave);
        parent.removeEventListener("wheel", handleWheel);
      }
    };
  }, [handleWheel]);

  return (
    <div className="weather-carousel w-full">
      <span className="text-xl ml-10">3-Hour Weather Updates</span>
      <div className="weather-carousel__scroll-container" ref={parentRef}>
        <div className="weather-carousel__timestamps flex gap-3 w-full overflow-x-auto whitespace-nowrap justify-around">
          {visibleTemperatures.map((temperature, idx) => {
            const { dt, main, weather } = temperature;
            const { temp_max, temp_min } = main;
            return (
              <div className="flex flex-row mt-4 gap-2 items-center" key={dt}>
                <div className="h-8 w-8">
                  {getSVGElementByTitle(weather[0].main)}
                </div>
                <div className="flex flex-col">
                  <span>
                    {new Date(dt * 1000).toLocaleTimeString("en-US", {
                      hour: "2-digit",
                      minute: "2-digit",
                      hour12: false,
                    })}
                  </span>
                  <span>H - {temp_max.toFixed(0)}°</span>
                  <span>L - {temp_min.toFixed(0)}°</span>
                </div>
              </div>
            );
          })}
        </div>
        <svg
          viewBox="0 0 1000 100"
          preserveAspectRatio="none"
          style={{
            width: "180%",
            height: "100px",
          }}
          className="mt-1"
        >
          <path
            id="wavePath"
            d="M0,50 C75,10 125,90 200,50 C275,10 325,90 400,50 C475,10 525,90 600,50 C675,10 725,90 800,50 C875,10 925,90 1000,50 C1075,10 1125,90 1200,50"
            style={{
              stroke: "#FFFFFF",
              fill: "none",
              strokeWidth: 2,
            }}
          />
        </svg>
      </div>
    </div>
  );
};

export default WeatherCarousel;
