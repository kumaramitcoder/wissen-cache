FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/wissen-memcache-cache-example-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} wissen-memcache-cache-example.jar

ENTRYPOINT ["java","-jar","/wissen-memcache-cache-example.jar"]