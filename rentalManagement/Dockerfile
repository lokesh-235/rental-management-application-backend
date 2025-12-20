# ---------- STAGE 1: BUILD THE JAR ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q dependency:go-offline
COPY src ./src
RUN mvn -q clean package -DskipTests

# ---------- STAGE 2: RUN THE JAR ----------
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/rentalManagement-0.0.1-SNAPSHOT.jar /app/rentalManagement-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/rentalManagement-0.0.1-SNAPSHOT.jar"]
