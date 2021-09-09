FROM openjdk:8-jdk-alpine

ADD build/libs/calculator-dropwizard-gradle-guice-swagger-1.0-SNAPSHOT-all.jar calculator.jar
ADD dev.yaml dev.yaml
ENTRYPOINT ["java", "-jar", "calculator.jar", "server", "../../dev.yaml"]
Expose 8080
