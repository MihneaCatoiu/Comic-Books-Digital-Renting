# Comic Books Digital Renting

This "Comic Books Digital Renting" application provides an efficient platform for users to manage comic book rentals. 
It offers a seamless experience for customers to browse, rent, and return comic books 
while maintaining an organized record of transactions.


## Table of Contents

<!-- TOC -->
* [Comic Books Digital Renting](#comic-books-digital-renting)
  * [Table of Contents](#table-of-contents)
  * [Tech Stack](#tech-stack)
  * [Core Functionalities](#core-functionalities)
  * [Project Structure](#project-structure)
  * [Getting Started](#getting-started)
  * [API Endpoints](#api-endpoints)
    * [Comic Book Endpoints](#comic-book-endpoints)
    * [Customer Endpoints](#customer-endpoints)
    * [Rent Procedure Endpoints](#rent-procedure-endpoints)
  * [Testing](#testing)
  * [Error Handling](#error-handling)
  * [Contributing](#contributing)
<!-- TOC -->

## Tech Stack

1. Spring Boot
2. Java 17
3. Maven
4. PostgreSQL
5. H2 In-Memory
6. MockMVC
7. JUnit
8. Mockito
9. Hibernate

## Core Functionalities

The application offers the following features:

1. Customer Management:

- Create Customer: Register a new customer.
- Retrieve Customer: Get customer details by their ID.
- Update Customer: Modify existing customer information.
- Delete Customer: Remove a customer from the system.

2. Comic Book Rentals:

- Create Rental Record: Initiate a comic book rental for a customer.
- Retrieve Rental Records: View rental history for a customer or specific comic books.
- Update Rental Details: Modify existing rental records.
- Delete Rental Record: Remove a rental record from the system.

3. Comic Book Management:
- Create Comic Book: Save a new comic book in the library.
- Retrieve Comic Book: Get a comic book by their superhero.
- Update Comic Book: Modify existing number of copies.
- Delete Comic Book: Remove a comic book from the library.

## Project Structure

- The project follows a standard structure for Spring Boot applications. Below is 
an overview of the key directories and files:

- `Comic-Books-Digital-Renting/`
    - `src/`
        - `main/`
            - `java/`
                - `com/ComicBooksDigitalRenting/`
                    - `controllers/`
                    - `exceptions/`
                    - `models/`
                        - `dtos/`
                        - `entities/`
                    - `repositories/`
                    - `services/`
            - `resources/`
              - `application.properties/`
        - `test/`

## Getting Started

- In order to use te app, you need to complete a few steps, those being:

1. Clone the github repository - https://github.com/yourusername/Comic-Books-Digital-Renting,
2. Configure PostgreSQL:
- Set up the PostgreSQL database
- Update the credentials in application.properties to match the setup
- Replace the username and password with your own

3. Run the application using Maven - mvn spring-boot:run
4. Access the APIs using Postman


## API Endpoints

### Comic Book Endpoints
1. POST /api/comic-books - Create a new comic book,
2. GET /api/comic-books/{title} - Search a comic book by title,
3. PATCH /api/comic-books/{id} - Update the number of copies for a comic book,
4. DELETE /api/comic-books/{id} - Delete a specific comic book.

### Customer Endpoints
1. POST /api/customers - Create a new customer,
2. GET /api/customers/{firstName} - Search a customer by their first name,
3. PATCH /api/customers/{id} - Update a customer email address, by their id,
4. DELETE /api/customers/{id} - Delete a customer from the database.

### Rent Procedure Endpoints
1. POST /api/rent-records - Create a new renting instance,
2. GET /api/rent-records/{customerId} - Search what a specific customer rented,
3. PATCH /api/rent-records/{id} - Update the returning date of the comic book,
4. DELETE /api/rent-records/{id} - Delete the renting history of a customer.

## Testing

- Run unit and integration tests, using the "mvn test" command.
It is advised to use MockMVC for REST API tests, JUnit 5 for unit tests and Mockito for mocking services.

## Error Handling

- Customs exceptions were created in order to handle different situations, returning certain messages to the user.

## Contributing

- Fork the repository and submit a pull request.
 
