
# BackendProject 🌐

This backend project is designed to work seamlessly with the FrontendProject. It includes MySQL integration for data persistence.

## Tech Stack 🛠️

- **Spring Boot:** The project is built using the Spring Boot framework.
- **MySQL:** Data is stored and managed in a MySQL database.

## Setup Instructions 🚀

1. Clone this repository to your local machine.
2. Set up a MySQL database and update the configuration in `application.properties`.
3. Run the application using your preferred IDE or by using the command `./mvnw spring-boot:run`.

## API Endpoints 🚀


GET /api/data: Retrieve data from the backend.
POST /api/data: Add new data to the backend.
PUT /api/data/{id}: Update data with the specified ID.
DELETE /api/data/{id}: Delete data with the specified ID.


## Database Configuration 📊

Ensure that you have a MySQL database set up with the following details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

