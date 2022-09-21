FROM gradle:jdk17

WORKDIR /app
COPY build/libs/logging-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
