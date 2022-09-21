FROM azul/zulu-openjdk:17.0.2
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} order-app.jar
ENTRYPOINT ["java", "-jar", "order-app.jar"]