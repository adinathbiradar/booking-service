# Use official Java 17 JDK image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the pre-built JAR from your repo
COPY target/springcrud-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your service will run on
EXPOSE 8083

# Run the app, use Render's PORT env variable if set
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8083}"]
