FROM openjdk:23-jdk-slim-bullseye
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE ${SERVER_PORT}

ENTRYPOINT ["sh", "-c", "java -jar /app.jar --server.port=${SERVER_PORT}"]