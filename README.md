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
