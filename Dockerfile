# Use official Java 17 JDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR into the container (rename to app.jar)
COPY target/springcrud-0.0.1-SNAPSHOT.jar app.jar

# Expose the default port (Render will override with $PORT if needed)
EXPOSE 8083

# Run the Spring Boot app
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8083}"]
