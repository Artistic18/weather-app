FROM openjdk:21-jdk-slim

ENV WEATHER_API_KEY=d2929e9483efc82c82c32ee7e02d563e

WORKDIR /app

COPY target/weather-cache-service-0.0.1-SNAPSHOT.jar /app/weather-cache-service-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "weather-cache-service-0.0.1-SNAPSHOT.jar"]