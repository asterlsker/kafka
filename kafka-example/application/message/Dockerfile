FROM gradle:jdk17

WORKDIR /app
COPY build/libs/message-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
