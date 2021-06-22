FROM adoptopenjdk/openjdk11:alpine-jre

ARG APP_NAME="product-service"
ARG APP_VERSION="0.0.1"

COPY /build/libs/${APP_NAME}-${APP_VERSION}.jar /opt/app/${APP_NAME}.jar
ENTRYPOINT ["java","-jar","/opt/app/product-service.jar"]
