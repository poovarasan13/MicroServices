# ---------- STAGE 1: Build the application ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory inside the container
WORKDIR /gateway

# Copy Maven descriptor
COPY pom.xml .

# Download dependencies (cached layer)
RUN mvn dependency:go-offline -B

# Copy the rest of the project
COPY src ./src

# Build the Spring Boot application
RUN mvn clean package -DskipTests

# ---------- STAGE 2: Create minimal runtime image ----------
FROM eclipse-temurin:21-jre-alpine

# Create a non-root user for security
RUN addgroup -g 1001 -S appgroup && \
    adduser -u 1001 -S appuser -G appgroup

# Set working directory
WORKDIR /gateway

# Copy the built JAR from the build stage
COPY --from=build /gateway/target/*.jar gateway.jar

# Set permissions
RUN chown -R appuser:appgroup /gateway

# Use non-root user
USER appuser

# Expose port
EXPOSE 8088

# Command to run the application
ENTRYPOINT ["java", "-jar", "gateway.jar"]
