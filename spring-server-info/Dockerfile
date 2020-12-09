FROM maven:3.5-jdk-8-alpine AS appbuild

COPY spring-server-info /usr/src/spring-server-info
WORKDIR /usr/src/spring-server-info

RUN mvn -B package -DskipTests=true

FROM openjdk:8-jdk-alpine
WORKDIR /app

COPY --from=appbuild /usr/src/spring-server-info/target/spring-server-info-1.0.jar .

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/spring-server-info-1.0.jar"]