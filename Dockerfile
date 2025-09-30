FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/springcrud-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8083

ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8083}"]
