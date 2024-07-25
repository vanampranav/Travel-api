# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle .
COPY settings.gradle .

# Copy the source code
COPY src/ src/

# Install dependencies and build the application
RUN ./gradlew build -x test

# Expose the port on which the app will run
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "build/libs/Travels-0.0.1-SNAPSHOT.jar"]
