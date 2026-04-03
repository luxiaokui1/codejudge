FROM maven:3.8-eclipse-temurin-8 as builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B || true
COPY src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:8-jdk
WORKDIR /app
COPY --from=builder /app/target/codejudge-sandbox-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]

