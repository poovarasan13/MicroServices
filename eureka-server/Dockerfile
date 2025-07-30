# Multi-stage build for Spring Boot application
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /eureka-server

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

RUN addgroup -g 1001 -S appgroup && \
    adduser -u 1001 -S appuser -G appgroup

WORKDIR /eureka-server

COPY --from=build /eureka-server/target/*.jar ./

RUN chown -R appuser:appgroup /eureka-server

USER appuser

EXPOSE 8088

ENTRYPOINT ["java", "-jar", "icecream-service.jar"] 