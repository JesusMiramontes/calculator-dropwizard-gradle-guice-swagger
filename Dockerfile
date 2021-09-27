FROM openjdk:8-jdk-alpine

ADD build/libs/calculator-dropwizard-gradle-guice-swagger-1.0-SNAPSHOT-all.jar calculator.jar
ADD dev.yaml dev.yaml
ADD jmx-exporter-config.yml jmx-exporter-config.yml
ADD libs/jmx_prometheus_javaagent-0.16.1.jar jmx_prometheus_javaagent-0.16.1.jar
#ENTRYPOINT ["java", "-jar", "calculator.jar", "server", "../../dev.yaml"]
ENTRYPOINT ["java", "-javaagent:./jmx_prometheus_javaagent-0.16.1.jar=3030:jmx-exporter-config.yml", "-jar", "calculator.jar", "server", "../../dev.yaml"]
Expose 8080
Expose 3030
