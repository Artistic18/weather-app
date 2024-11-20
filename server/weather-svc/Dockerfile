FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/weather-svc-0.0.1-SNAPSHOT.jar /app/weather-svc-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "weather-svc-0.0.1-SNAPSHOT.jar"]