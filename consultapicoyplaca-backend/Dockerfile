FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

RUN ./mvnw clean package

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/target/consultapicoyplaca-backend-Release-1.0.0.jar"]