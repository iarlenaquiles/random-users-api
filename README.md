# Random User Spring Boot RESTful API 

Welcome to the Random User Spring Boot RESTful API! This project is a RESTful APIs using Spring Boot 3, Spring Data JPA, and OpenAPI (Swagger) for API documentation. We have utilized the power of Java 17, the latest LTS version of Java, to build this project.

## Table of Contents

- [Key Features](#key-features)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Project Details](#project-details)
- [API Usage (Swagger UI Documentation)](#api-usage-swagger-ui-documentation)
- [Hosting on Railway.app](#hosting-on-railway)
- [Contribution](#contribution)
- [License](#license)
- [Authors](#authors)

## Key Features:

- **Java 17**: Leveraging the latest LTS version of Java, improving readability and efficiency.
- **Spring Boot 3**: An upgraded version of Spring Boot, enhancing developer productivity with its auto-configuration
  feature. Generated using [Spring Initializr](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.1.1&packaging=jar&jvmVersion=17&groupId=me.dio&artifactId=spring-boot-3-rest-api-template&name=spring-boot-3-rest-api-template&description=DIO%20Spring%20Boot%20RESTful%20API%20Template&packageName=me.dio&dependencies=web,data-jpa,h2,postgresql).
- **Spring Data JPA**: Simplifying the database access layer.
- **OpenAPI (Swagger)**: Integrated with OpenAPI 3, enabling seamless API documentation for better understanding and
  testing.

## Project Structure:

The project is organized into several packages, each serving a specific purpose:

- `controller`: This package contains our Rest Controllers. Here, we expose our endpoints, following the REST architectural style. DTOs are used in this layer to define the consumption interfaces appropriately, avoiding the exposure of unnecessary model attributes.

- `exception`: define our custom exceptions and a global exception handler for dealing with Spring's exceptions.

- `model`: where our entities are defined, using JPA (Jakarta) annotations for ORM with our SQL database.

- `repository`: In this package, we handle data access using interfaces provided by Spring Data JPA.

- `service`: where our business logic lives. Here we validate our data, handle business exceptions, and manage access to our SQL database through repositories.

- `Application.java`: This is the main class to run our project. It initializes our Spring application and connects all the components together.

Please note that this structure is a simple suggestion for educational purposes. Each developer is free to adapt and modify this structure according to their project needs and standards.

## Project strategy

The strategy was chosen to load user data when the application is started and from then on the user consumes data from the downloaded results.

## Setup

These instructions guide you through cloning the repository and starting the application in Unix or Windows environments, with the development profile enabled.

1. Clone the repository: git clone https://github.com/iarlenaquiles/random-users-api.git
2. Start the application in the Unix environment: `./gradlew bootrun --args='--spring.profiles.active=dev'`
3. Start the application in the Windows environment: `gradle.bat bootrun --args='--spring.profiles.active=dev'`
4. Run redis on docker
  ```docker run --name random-user-api-redis -p 6379:6379 -d redis``` 
## Project Details:

The project focuses on a Random User API as an example, which includes basic CRUD operations and statistics system. It adheres to the best practices of RESTful principles, such as idempotent operations and the use of appropriate HTTP status codes.

Exception handling is globally managed with a `@RestControllerAdvice` to ensure consistent handling of exceptions throughout the entire application.

The project also includes the setup for an H2 database (an in-memory database) for testing purposes and development environment. For the production environment on Railway, PostgreSQL database is used.

## API Usage (Swagger UI Documentation)

The API documentation can be found on Swagger UI. To view it, please visit: [Swagger UI](http://localhost:8080/swagger-ui.html).

## Hosting on Railway

Both this project and your PostgreSQL database are hosted on [Railway.app](https://railway.app/). To access our demo application, visit:
- Development Environment: [https://[your-public-domain]-dev.up.railway.app/swagger-ui.html](https://-dev.up.railway.app/swagger-ui.html)
- Production Environment: [https://[your-public-domain]-prd.up.railway.app/swagger-ui.html](https://-prd.up.railway.app/swagger-ui.html)

## Contribution

We welcome contributions! If you encounter any issues or have suggestions for improvements, don't hesitate to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. Please refer to the <a href="https://github.com/digitalinnovationone/spring-boot-3-rest-api-template/blob/main/LICENSE.md">(LICENSE)</a> file for details.

## Authors

<table>
  <tr>
    <td align="center"><a href="https://github.com/iarlenaquiles"><img src="https://avatars.githubusercontent.com/u/3675462?v=4&s=100" width="100px;" alt=""/><br/><strong>Iarlen Aquiles</strong></a><br/><a href="https://www.linkedin.com/in/iarlenaquiles/">LinkedIn</a></td>
  </tr>
</table>
