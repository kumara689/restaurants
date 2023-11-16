# Restaurants

This application is with the necessary API stack required by restaurant-picker, which supports to initiate user session, end the session, add/retrieve restaurants etc.

## Prerequisites

The following components are required to be installed on your PC prior to start this application:

- Java 17
- Maven 3.9.5
- Mongo DB 7.0

- Start the application by running ```org.gov.tech.restaurants.RestaurantsApplication.java```
- The application will be running on port 9292
- there are two APIs, one is an HTTP API, other one is WS API in order to provide the real time updates to the restaurants.
- The session details supposed to be persisted in MongoDB with this design
