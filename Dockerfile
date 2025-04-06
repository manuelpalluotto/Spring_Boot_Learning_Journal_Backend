FROM arm64v8/openjdk:17-jdk-slim
WORKDIR /app
COPY target/learning.journal-0.0.1-SNAPSHOT.jar app/learning-journal-backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","learning-journal-backend.jar"]