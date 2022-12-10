FROM maven:3.6.3-openjdk-17 AS build

RUN ./product_backend
WORKDIR /app
COPY src /app
RUN mvn -f path/to/pom.xml ./
RUN mvn clean package -DskipTests
FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=./target/product_backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /
ENTRYPOINT ["java","-jar","/product_backend-0.0.1-SNAPSHOT.jar"]


