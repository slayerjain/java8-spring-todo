# Todo Spring Application

This is a simple Todo application built with Spring Boot, PostgreSQL, and Redis. The application provides RESTful APIs to manage Todo items.

## Prerequisites

- Java 8
- Maven
- Docker

## Installation

### 1. Clone the Repository

```sh
git clone https://github.com/yourusername/todo-spring-app.git
cd todo-spring-app
```

### 2. Build the Application

```sh
mvn clean install
```

### 3. Set Up Docker Containers

#### PostgreSQL Container

1. Pull the PostgreSQL Docker Image:

    ```sh
    docker pull postgres:latest
    ```

2. Run the PostgreSQL Container:

    ```sh
    docker run --name postgres-todo -e POSTGRES_DB=todoapp -e POSTGRES_USER=yourusername -e POSTGRES_PASSWORD=yourpassword -p 5432:5432 -d postgres:latest
    ```

#### Redis Container

1. Pull the Redis Docker Image:

    ```sh
    docker pull redis:latest
    ```

2. Run the Redis Container:

    ```sh
    docker run --name redis-todo -p 6379:6379 -d redis:latest
    ```

### 4. Configure Application Properties

Update the `src/main/resources/application.properties` file with your PostgreSQL username and password:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todoapp
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update

spring.redis.host=localhost
spring.redis.port=6379
```

### 5. Run the Application

```sh
mvn spring-boot:run
```

## Database Setup

The necessary schema for the Todo application will be created automatically by Hibernate. However, you can manually create the table using the following SQL script:

```sql
CREATE TABLE todo (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    completed BOOLEAN NOT NULL DEFAULT FALSE
);
```

## Usage

### API Endpoints

#### Create a Todo Item

```sh
curl -X POST http://localhost:8080/api/todos \
    -H "Content-Type: application/json" \
    -d '{
        "title": "Learn Spring Boot",
        "description": "Read the Spring Boot documentation and write some sample code",
        "completed": false
    }'
```

#### Get All Todo Items

```sh
curl -X GET http://localhost:8080/api/todos
```

#### Get a Todo Item by ID

```sh
curl -X GET http://localhost:8080/api/todos/{id}
```
Replace `{id}` with the actual ID of the Todo item you want to retrieve.

#### Update a Todo Item

```sh
curl -X PUT http://localhost:8080/api/todos/{id} \
    -H "Content-Type: application/json" \
    -d '{
        "title": "Learn Spring Boot",
        "description": "Read the Spring Boot documentation and write a comprehensive project",
        "completed": true
    }'
```
Replace `{id}` with the actual ID of the Todo item you want to update.

#### Delete a Todo Item

```sh
curl -X DELETE http://localhost:8080/api/todos/{id}
```
Replace `{id}` with the actual ID of the Todo item you want to delete.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

