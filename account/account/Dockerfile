# start with best image containing java runtime
FROM openjdk:17 as build

# Imformation of own or maintaner image
MAINTAINER makarabank

# Add the application's jar to container
COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar

# Execute the apllication
ENTRYPOINT ["java","-jar","/account-0.0.1-SNAPSHOT.jar"]