FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/aprendeya-api-0.0.1.jar
COPY ${JAR_FILE} aprendeya-api.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "aprendeya-api-0.0.1.jar"]