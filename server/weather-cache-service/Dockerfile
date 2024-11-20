FROM maven:3.9.0-openjdk-21-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/weather-cache-service.jar /app/weather-cache-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "weather-cache-service.jar"]