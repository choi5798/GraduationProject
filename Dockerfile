# deprecated -> ./gradlew bootBuildImage
FROM openjdk:17-slim
COPY build/libs/spring-jvm-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
