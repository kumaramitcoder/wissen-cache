FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/wissen-redis-cache-example-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} wissen-redis-cache-example.jar

ENTRYPOINT ["java","-jar","/wissen-redis-cache-example.jar"]