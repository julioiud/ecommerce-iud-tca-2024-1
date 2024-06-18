FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/app-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8084

CMD ["java", "-jar", "app.jar"]