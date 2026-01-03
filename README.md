# Cricketers-Stats

This repo serives provides cricketers' Test, ODI, and T20I statistics using AI technology.

This contains 5 microservices with Spring Boot to get cricketers' stats with AI by means of Gemini.

## Player Microservice

MySQL is used to save player details. Docker is used to run MySQL, and Flyway has been used for scripts. The Docker Compose file is in the docker-config directory.

## AI-Stat Microservice

Gemini is used to get players' stats.

## Gateway Microservice

Gateway is configured to the resource server, and Keycloak has been used to authorize gateway requests.

## Config-Server Microservice

All configurations of microservices are retrieved from the configuration directory in the Github repo.

## Eureka-Server Microservice

All microservices are registered in the Eureka server, and other microservices use the Eureka server for service discovery.

## Angular App

A simple Angular app is used to display players' stats. Keycloak is used to authenticate users and get access tokens with ID tokens. Nginx is used to run the Angular app, and a reverse proxy is used for gateway requests by means of Nginx.

## Keycloak

Keycloak is used as the IAM to authenticate and authorize users. The Authorization Code Flow with PKCE method has been used for OIDC.
