FROM maven:3.6.3-jdk-11-openj9 AS appbuild

COPY spring-server-info /usr/src/spring-server-info
WORKDIR /usr/src/spring-server-info

RUN mvn -B package -DskipTests=true

FROM openjdk:11.0.9.1-jdk-buster
WORKDIR /app

COPY --from=appbuild /usr/src/spring-server-info/target/spring-server-info-1.0.jar .

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/spring-server-info-1.0.jar"]