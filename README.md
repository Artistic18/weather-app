# Weather App

The Weather App is a simple yet powerful web application that allows users to input a city and receive real-time weather data for that location. The app provides the current weather as well as the weather forecast for the next three days, offering a comprehensive view of the weather conditions.

Built with modern web technologies, the app integrates with a weather API to fetch accurate weather information and display it in an easy-to-understand format. The app is divided into two key services: weather-service and weather-cache-service, which work together to provide an efficient and reliable weather experience.

You can try out the app here: [Weather App](https://release.d3i2l7qmc2yjab.amplifyapp.com).

## Table of Contents

- [Weather App](#weather-app)
- [Features](#features)
- [Architecture](#architecture)
  - [1. weather-service](#1-weather-service)
  - [2. weather-cache-service](#2-weather-cache-service)
- [Technologies Used](#technologies-used)
- [Deployment & Infrastructure Strategy](#deployment--infrastructure-strategy)
  - [Deployment](#deployment)
  - [Pipeline Setup](#pipeline-setup)
  - [Cloud Infrastructure](#cloud-infrastructure)
  - [Setup Instructions](#setup-instructions)

## Features

- **City Input**: Allows users to enter a city name and retrieve weather data.
- **Current Weather**: Displays temperature, weather conditions (sunny, rainy, etc.), humidity, wind speed, and other relevant details for the specified city.
- **3-Day Forecast**: Shows the weather for the next three days, helping users plan ahead.
- **Responsive Design**: The app is designed to work on both desktop and mobile devices, ensuring usability across different screen sizes.
- **Real-time Data**: Fetches up-to-date weather information directly from the OpenWeatherMap API.

## Architecture

The Weather App is built with two core services:

### 1. weather-service

The weather-service acts as the intermediary between the frontend and the weather-cache-service.

**Endpoints**:

- Fetches data from `/data/cache/weather?city={city}` exposed by the weather-cache-service.
- Serves processed data to the frontend via its own endpoint `/data/forecast?city={city}`.

**Swagger Documentation**: [View Swagger Documentation](http://54.175.96.105:8082/swagger-ui/index.html)

**Key Responsibilities**:

- **Abstraction Layer**: Protects the public-facing API by ensuring requests are filtered through its business logic. Decouples the frontend from direct interaction with the weather-cache-service or the OpenWeatherMap API.
- **Business Logic**: Applies transformations to the raw data received from the weather-cache-service, formats and optimizes data for frontend consumption.
- **Error Management**: Handles errors from the weather-cache-service or external API with fallback mechanisms to ensure a seamless user experience.

**Best Practices Applied**:

- **SOLID Principles**: Clear separation of concerns between data retrieval, business logic, and data presentation. Modular and testable design through dependency inversion.
- **12-Factor App Principles**: Externalized configurations for easy deployment across environments. Stateless services enabling scalability.

**Design Patterns**:

- **Adapter Pattern**: Bridges the weather-cache-service and the frontend for compatibility.
- **Decorator Pattern**: Enhances response objects with additional computed fields.

### 2. weather-cache-service

The weather-cache-service is the backbone of the application’s performance, ensuring optimized and cost-effective data retrieval. It leverages Redis for caching weather data and employs intelligent invalidation strategies to maintain fresh and relevant data while minimizing the load on external APIs.

**Swagger Documentation**: [View Swagger Documentation](http://54.175.96.105:8083/swagger-ui/index.html)

**Key Responsibilities**:

- **Data Fetching**:
  - Calls the OpenWeatherMap API to fetch weather data for requested cities.
  - Handles edge cases such as unavailable data or API outages gracefully.
- **Caching Strategy**:
  - Stores weather data in Redis for cities that are requested frequently, improving response times and reducing the number of calls to the external weather API.
  - The cache is designed to be efficient, only storing the most accessed cities' weather data.
  - Every 15 minutes, the service fetches and updates weather data for the top 50 most-accessed cities stored in Redis, ensuring the cache is always up-to-date with the most relevant information.
  - Cities that are no longer in the top 50 most-accessed cities are invalidated and removed from the cache, ensuring that outdated data is not retained in the system.
- **Cache Invalidation**:
  - TTL (Time-to-Live) logic is applied to ensure cached weather data does not stay stale. Each cache entry is assigned a TTL, which is refreshed each time the data is accessed.
  - The TTL ensures that cached data expires after a set time (e.g., 24 hours), and the cache is periodically refreshed to ensure the data is current.
  - The `fetchAndCacheWeatherData` method identifies cities no longer in the top 50 most-accessed cities and deletes their outdated cache entries, ensuring the cache remains clean and efficient.
- **Rate Limiting**:
  - Implements a rate limiter to comply with the OpenWeatherMap API’s limit of 60 calls per minute.
  - Additional requests beyond the limit are queued and executed asynchronously when threads become available.
  - If the rate limit is reached, the service pauses for 1 minute before continuing the API calls, ensuring compliance with the usage policy.
- **Optimized Data Handling**:
  - Prioritizes updating high-demand city data in Redis while purging less-accessed entries. This ensures that only the most requested cities' data is kept up-to-date in the cache.

**Best Practices Applied**:

- **Performance Optimization**:
  - Asynchronous data fetching for non-blocking I/O operations. This ensures that fetching data for cities does not block other operations and improves throughput.
  - Proactive caching of high-demand cities reduces the number of direct API calls to the OpenWeatherMap API, which is critical in keeping the application performant and within API rate limits.
  - The cache is updated at regular intervals, ensuring that users always get fresh data without causing unnecessary load on the external API.
- **Security**:
  - API keys for the OpenWeatherMap API are stored securely in environment variables, ensuring that sensitive information is not exposed.
  - Input validation ensures that user inputs are sanitized, protecting the system from injection attacks.
- **Resilience and Reliability**:
  - Circuit breakers prevent cascading failures if the OpenWeatherMap API or Redis experiences downtime, allowing the service to continue functioning by serving stale data until the issue is resolved.
  - Graceful degradation ensures that even if the weather data for a city is unavailable, the system can still respond with a message indicating that the data could not be retrieved, providing a better user experience.

**Design Principles**:

- **SOLID**: Each component (data fetching, caching, rate limiting) follows the Single Responsibility Principle, making the code easier to test, extend, and maintain.
- **12-Factor App**: Externalized configurations make it easy to deploy and configure the service in various environments. Stateless services enable the application to scale horizontally and handle increasing traffic effectively.

**Design Patterns**:

- **Rate Limiting Pattern**: Ensures that API calls to OpenWeatherMap are made within the acceptable limits, preventing overuse of the service and avoiding potential throttling or penalties.
- **Cache-Aside Pattern**: This pattern allows the service to load data into the cache as needed. It ensures that fresh weather data is fetched from the API when necessary and cached for future use. When a city’s data is requested, the system first checks the cache before making an external API call.

## Technologies Used

- **Frontend**: Next.js for building a dynamic and SEO-friendly user interface.
- **Backend**: Java with Spring Boot for both weather-service and weather-cache-service, handling API requests and data processing.
- **Styling**: SCSS for advanced styling and Tailwind CSS for utility-first design.
- **Caching**: Redis for storing and managing weather data efficiently.
- **Weather API**: OpenWeatherMap API for fetching current weather and forecast data.

## Deployment & Infrastructure Strategy

### Deployment:

- **Frontend Deployment**: The frontend is deployed using **AWS Amplify**, which serves the app and acts as a Content Delivery Network (CDN). The app is hosted as a static site with optimized asset delivery across the globe.
- **Backend Deployment**:
  - **weather-service** and **weather-cache-service** are deployed in **AWS EC2** instances within a Virtual Private Cloud (VPC).
  - The services run in **Docker containers**, providing consistency and scalability across environments.
  - **AWS ECR (Elastic Container Registry)** is used to store Docker images, which are then pulled into EC2 instances for execution via a Jenkins pipeline.

### Pipeline Setup:

- **Jenkins**: Continuous Integration and Continuous Deployment (CI/CD) pipeline set up on Jenkins (accessible at http://54.172.32.102:8080/) to automate the build, test, and deployment processes.
- **Docker**: Docker containers ensure that both the frontend and backend services are packaged and deployed consistently across different environments.
- **Auto Scaling**: EC2 instances are set up with auto-scaling policies to handle varying loads efficiently. This ensures that the app can scale to meet high demand and scale down during idle periods.

### Cloud Infrastructure:

- **AWS EC2**: Hosts the backend services in a secure VPC, ensuring separation from other resources and controlling access.
- **AWS Amplify**: Used for hosting the frontend application with a global CDN, enabling fast and reliable delivery of assets.
- **AWS ECR**: Stores Docker images securely and is integrated into the CI/CD pipeline to fetch and deploy updated container images.
- **Redis**: Used for caching weather data, ensuring quick access to frequently requested data and reducing the load on the OpenWeatherMap API.

## Setup Instructions

Follow the steps below to set up and run the Weather App locally.

### Prerequisites

- **Java 21** or later installed (for backend services)
- **Node.js** and **npm** (for frontend development with Next.js)
- **Docker** (for containerizing services)
- **Redis** (for caching in the weather-cache-service)

### Step 1: Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/your-repo/weather-app.git
cd weather-app
```

### Step 2: Set Up the Backend

Navigate to the server folder and install dependencies and run it:

```bash
cd server/weather-cache-service || cd server/weather-svc
./mvnw clean install
./mvnw spring-boot:run
```

### Step 3: Set Up the Frontend

Navigate to the client folder and install dependencies and run it:

```bash
cd client
npm install
npm run dev
```

## Conclusion

The Weather App provides a smooth, efficient, and modern user experience for checking weather conditions in cities worldwide. Its backend services leverage powerful caching and rate-limiting strategies to optimize performance, while the frontend offers a responsive design for users on any device. With a cloud-based deployment infrastructure, the app is designed to scale and handle a large number of users.
