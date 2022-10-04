FROM azul/zulu-openjdk:17.0.2
ARG JAR_FILE=./build/libs/delivery-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} delivery-app.jar
ENTRYPOINT ["java", "-jar", "delivery-app.jar"]
