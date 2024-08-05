# swagger-api-spring-boot
This is a Java Spring Boot project for managing users, using MongoDB as the database. The project is built with Maven and follows the Open API 3.0.0 specification.

# Spring Boot Swagger Example

This project is a simple demonstration of a Spring Boot application that performs CRUD (Create, Read, Update, Delete) operations on a `User` entity using MongoDB as the database. It leverages OpenAPI (Swagger) for API documentation and Maven as the build tool. This example provides a solid foundation for building RESTful services with Spring Boot and MongoDB.

## Prerequisites

- Java 22
- Maven 3.8.8
- MongoDB (running locally or on a server)

## Project Setup

1. **Clone the Repository**

    ```sh
    git clone <repository-url>
    cd springboot-swagger
    ```

2. **Update MongoDB Configuration**

    Update the MongoDB connection details in `src/main/resources/application.properties`:

    ```properties
    spring.application.name=openai-gen-springBoot

    server.port=8091
    
    # MongoDB properties
    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.database=userproduct_db
    
    # server.ssl.key-store
    server.ssl.key-store=classpath:keystore.p12
    server.ssl.key-store-password=sharad
    server.ssl.key-store-type=PKCS12
    server.ssl.key-alias=myapp
    ```

3. **Build the Project**

    ```sh
    mvn clean install
    ```

4. **Run the Application**

    ```sh
    mvn spring-boot:run
    ```
    or you can run Spring boot application class namely as `OpenaiGenSpringBootApplication`.

## API Documentation

Once the application is running, you can access the Swagger UI to explore the API documentation:
    `https://localhost:8091/swagger-ui.html`


## API Endpoints

The following CRUD operations are available for the `User` entity:

- **Create a User**
    - **POST** `/users`
    - Request Body: 
    ```json
    {
        "name": "John Doe",
        "email": "john.doe@example.com"
    }
    ```

- **Get All Users**
    - **GET** `/users`

- **Get User by ID**
    - **GET** `/users/{id}`

- **Update User**
    - **PUT** `/users/{id}`
    - Request Body:
    ```json
    {
        "name": "John Doe",
        "email": "john.doe@example.com"
    }
    ```

- **Delete User**
    - **DELETE** `/users/{id}`

## Dependencies

The project uses the following dependencies:

- Spring Boot Starter Web
- Spring Boot Starter Data MongoDB
- Springdoc OpenAPI UI
- Lombok
- Spring Boot Starter Test

## Troubleshooting

### Common Issues

- **Port Already in Use:** If the default port `8080` is already in use, you can change the port by updating the `application.properties` file:

    ```properties
    server.port=8081
    ```

- **MongoDB Connection Errors:** Ensure MongoDB is running and the connection details in `application.properties` are correct.

## License

This project is licensed under the MIT License.

## Contact

For any issues or inquiries, please contact [sharadchavhan001@gmail.com].

