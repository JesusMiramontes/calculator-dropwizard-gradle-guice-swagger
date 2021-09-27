# Calculator app

###Single docker

**Create fat jar**
gradlew shadowJar

**Run docker**
docker run -p 8080:8080 calculator

###Docker compose

1. docker-compose up --build
1. stop it
1. from the gateway dir: docker build -t calculator-gateway.jar .
1. docker-compose up


### Urls
1. App: http://localhost:8080
1. Gateway: http://localhost:9000
1. Prometheus: http://localhost:9090
1. Grafana: http://localhost:3000
1. JMX exporter: http://localhost:3030/metrics
