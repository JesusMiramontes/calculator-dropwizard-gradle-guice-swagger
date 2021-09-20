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

