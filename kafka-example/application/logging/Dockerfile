FROM azul/zulu-openjdk:17.0.2
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} logging-app.jar
ENTRYPOINT ["java", "-jar", "logging-app.jar"]
