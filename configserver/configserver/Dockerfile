# start with best image containing java runtime
FROM openjdk:17 as build

# Imformation of own or maintaner image
MAINTAINER makarabank

# Add the application's jar to container
COPY target/configserver-0.0.1-SNAPSHOT.jar configserver-0.0.1-SNAPSHOT.jar

# Execute the apllication
ENTRYPOINT ["java","-jar","/configserver-0.0.1-SNAPSHOT.jar"]