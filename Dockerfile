FROM openjdk:11-jre-slim
MAINTAINER "Docker App <docker@app.com>"
WORKDIR /app

COPY ./target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "/app/StarWarsJavaApi-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080