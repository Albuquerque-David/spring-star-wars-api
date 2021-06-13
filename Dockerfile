FROM openjdk:11-jre-slim
MAINTAINER "David Albuquerque <davidra_rj@hotmail.com>"
WORKDIR /app

COPY ./target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8080