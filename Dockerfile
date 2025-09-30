# Use official Java 17 JDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the port your service will run on
# Render will map its $PORT to this port
EXPOSE 8083

# Run the Spring Boot application using Render's $PORT environment variable
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8083}"]
