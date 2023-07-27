FROM eclipse-temurin:17 as builder


WORKDIR /app

COPY src src
COPY .mvn .mvn
COPY mvnw mvnw
COPY pom.xml pom.xml

RUN ./mvnw clean package

FROM eclipse-temurin:17

COPY --from=builder /app/target/quarkus-app /app

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "/app/quarkus-run.jar"]
