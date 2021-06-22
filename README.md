# Spring Boot Microservices

## Overview
* The application has been developed using microservice approach. 
* Each microservice `product-service` and `review-service` can run independently.
* You should be able to check out, build and run the app locally with Java and Gradle.

## Product-Service
* You should be able to run product-service at port `8081`
* You should be able to access API doc at url `http://localhost:8081` after successful application startup

## Review-Service
* You should be able to run product-service at port `8082`
* You should be able to access API doc at url `http://localhost:8082` after successful application startup
* You can perform `GET` operation without any authentication.
* You need to pass JWT access token in `Authorization` header in order to perform `POST`, `PUT` and `DELETE` operation.
  ```
  Authorization: Bearer jwt_access_token
  ```
* You should authenticate first using `/login` api to get the JWT access token. Any username and password will be authenticated successfully for demo purpose.

## Common-Library
* Common library has been created for re-usability purpose.
* It provides configuration for API logging, security and documentation.
* It provides exception handler for API
* Common library is used by both `product-service` and `review-service`


## Dockerize your microservices
It is essential in microservice environment to containerize the build using Docker.

Each microservice `product-service` and `review-service` has their own `Dockerfile` at the root of the project, which is used to build docker image.

### Docker

Docker can be installed on Mac using Brew:-
```
brew install --cask docker
```

To build a docker image for `product-service`, go to the project root location, where you have `Dockerfile` and run command:-
```
docker build -t product-service .
```

To run `product-service` application from docker image, run following command:-
```
docker run -d -p 8081:8081 -e "SPRING_PROFILES_ACTIVE=dev" product-service:latest
```

`docker` commands are used when you have to build a docker image and run that docker image for an individual microservice. You should use `docker-compose` commands if you want to build and run docker images for multiple microservices at once.

### Docker-Compose
Docker compose configuration file `docker-compose.yaml` is at the root folder of repo directory i.e. `springboot-microservices/docker-compose.yaml` which provides all the configuration required to build and run docker image of `product-service` and `review-service`

Go to the repo root directory `springboot-microservices` and execute following command to build and run docker images for both the services at port `8081` and `8082` respectively

```
docker-compose up
```
