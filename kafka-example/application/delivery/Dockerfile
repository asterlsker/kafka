FROM gradle:jdk17

WORKDIR /app
COPY build/libs/delivery-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
