# Use a base image with Java 17
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/smart-clinic-0.0.1-SNAPSHOT.jar app.jar

# Set environment variable for port (Render uses $PORT)
ENV PORT=8080

# Expose the port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
