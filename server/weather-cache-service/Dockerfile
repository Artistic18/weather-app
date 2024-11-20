FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/weather-cache-service.jar /app/weather-cache-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "weather-cache-service.jar"]