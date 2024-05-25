# Library Management System

The Library Management System is a web application built using Spring Boot 3.3.0, Java 17, and MySQL database. It is designed to handle the management of a library's books and users efficiently. This application provides distinct functionalities for two types of users: the Admin and the User.

## Features

### User
- **Signup/Login:** Users can register and log in to the system.
![Signup](https://drive.google.com/file/d/1Jg3HYahlrszzhDeE8KzwgZq69C6HJzW7/view?usp=sharing)
![Login](https://drive.google.com/file/d/1mhzHpQw8Scuzs9yReOLojX4geM5qGrRM/view?usp=sharing)

### Admin
- **Add Book:** Admin can add new books to the library.
![AddBook](https://drive.google.com/file/d/1Yu4Y2AIGSSsnel0jbGzdClTqI4CW1v1E/view?usp=sharing)

- **Update Book:** Admin can update details of existing books.
![UpdateBook](https://drive.google.com/file/d/1s1MsecH0Bu1xwWbagi4nMvww75rybP2I/view?usp=sharing)

- **Get Books:** Admin can view all books in the library.
![GetBook](https://drive.google.com/file/d/1o3CI2w2i4RBDC12hvblbpXBQShautA_7/view?usp=sharing)

- **Delete Book:** Admin can remove books from the library.
![DeleteBook](https://drive.google.com/file/d/1RPjAS4UOAkScs5OvCXFzqhYUGdqjUcBR/view?usp=sharing)

- **Issue Book:** Books can be issued to users by the admin based on the book ID and admission number.
![IssueBook](https://drive.google.com/file/d/18WruQgQ6mhgvHYGZs7U3--Lww69xmXdM/view?usp=sharing)

- **Return Book:** Admin can update the database with the return details based on the book ID and admission number.
![ReturnBook](https://drive.google.com/file/d/1jP_Xteuovi_uw88xGUe5ynaLvWhfnOHo/view?usp=sharing)

- **MySQL Database Transactions:** This screenshot displays MySQL transactions related to returning books, including details such as user information, book details, withdrawal date, and return date. Admin updates the database with the return details based on the book ID and admission number.
![MySQL Transactions](https://drive.google.com/file/d/1myIuN5RnxYV8LQAwz5DFEYyn110l8Ppr/view?usp=sharing)



## Technologies Used
- **Spring Boot 3.3.0:** Framework used to build the application.
- **Java 17:** Programming language used.
- **MySQL:** Database used for storing all user and book information.
- **PasswordEncoder:** Used to hash passwords before storing them in the database.
- **Postman:** Used for testing the API endpoints.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

```bash
Java 17
MySQL
Maven


Installing
A step by step series of examples that tell you how to get a development environment running:

1: Clone the repository:
    git clone https://Bala1703/Library-Management-System.git

2: Navigate to the project directory:
    cd library-management-system

3: Install dependencies:
    mvn install

4: Configure MySQL database:
    Ensure MySQL is running on your system.
    Create a database named library.
    Update the application.properties file with your MySQL username and password.

5: Run the application:
    mvn spring-boot:run

The server will start at http://localhost:8080.

Testing:

To test the API endpoints, you can use Postman:
    Ensure the server is running and send requests through Postman to test different functionalities.



