# 👋 PreciosApp Overview

This project is a Spring Boot REST microservice designed as a Maven project based on hexagonal architecture + DDD.

At application initialization an in-memory embedded database initializes with the info of multiple prices for an item at different moments. The goal of this application is ensure the access to this information via API REST with an endpoint to do so.

## ⚙️ Prerequisites

- At least JDK 21 or higher
- Maven 3.8.1 (Min)

## 🏃 Running the Project

Navigate to the project directory and execute the following command to compile and package the project:

```shell
mvn clean install
```

After compiling all now you have to run the project with this command:

```shell
mvn spring-boot:run -pl bootloader
```

As it finish loading the application will be successfully running on port 8080 and you'll be able to access the API via swagger:
- `http://localhost:8080/swagger-ui.html`.

The first and only endpoint running in the app is the 'prices' GET endpoint, witch will receive 3 parameters: date, productId and brandId. The endpoint will return the actual price for the item

- `http://localhost:8080/api/v1/prices`.

## 💻 Key Technologies

### Core Concepts

- **Hexagonal Architecture**: Implements a clean architecture by dividing the project into application, domain, and infrastructure layers. Interfaces are used as "ports" to minimize layer coupling.
- **Domain Driven Design**: Incorporates DDD patterns such as Entity, ValueObject, and RootAggregate. More information can be found [here](https://en.wikipedia.org/wiki/Domain-driven_design).
- **Lombok**: Simplifies code with builders, setters, getters, etc. Visit [Lombok](https://projectlombok.org/) for more details.
- **MapStruct**: Facilitates object mapping between layers. Learn more at [MapStruct](https://mapstruct.org/).
- **Spring Boot**: Aids in creating REST microservices efficiently. Check out [Spring Boot](https://quarkus.io/).

### H2 Database Integration

- **H2Database**: Fast, open-source JDBC API supporting embedded and server modes, with disk-based or in-memory databases. More info at [H2Database](https://www.h2database.com/html/main.html).
- **Spring Data JPA**: Implements JPA-based repositories. Visit [Spring Data JPA](https://spring.io/projects/spring-data-jpa) for more details.
- **Flyway**: Manages database migrations at startup. Learn more at [Flyway](https://flywaydb.org/).

### REST API Documentation

- **springdoc-openapi-ui**: Automates API documentation generation for Spring Boot projects. More information can be found [here](https://springdoc.org/).

You can check the auto-generated documentation via this path:
- `http://localhost:8080/v3/api-docs`.