FROM gradle:jdk17

WORKDIR /app
COPY build/libs/order-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8084
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
