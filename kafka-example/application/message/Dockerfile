FROM azul/zulu-openjdk:17.0.2
ARG JAR_FILE=./build/libs/message-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} message-app.jar
ENTRYPOINT ["java", "-jar", "message-app.jar"]