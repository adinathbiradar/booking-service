# Use official Java 17 JDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Build the JAR inside the container
RUN ./mvnw clean package -DskipTests

# Copy the generated JAR to a standard name
RUN cp target/*.jar app.jar

# Expose port
EXPOSE 8083

# Run the application
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8083}"]
