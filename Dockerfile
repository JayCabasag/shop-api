FROM openjdk:17-jdk-alpine
COPY target/mobile-ecommerce-0.0.1-SNAPSHOT.jar  /app/app.jar
WORKDIR /app
CMD ["java", "-jar", "app.jar"]

