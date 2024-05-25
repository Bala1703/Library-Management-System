# Library Management System

The Library Management System is a web application built using Spring Boot 3.3.0, Java 17, and MySQL database. It is designed to handle the management of a library's books and users efficiently. This application provides distinct functionalities for two types of users: the Admin and the User.

## Features

### User
- **Signup/Login:** Users can register and log in to the system.
![Signup](https://github.com/Bala1703/Library-Management-System/assets/138019223/176a06e9-54cd-45f5-9e5b-001cf41ae63e)

![Login](https://github.com/Bala1703/Library-Management-System/assets/138019223/bd122a80-c998-4b68-ac22-b62c1944ebf2)


### Admin
- **Add Book:** Admin can add new books to the library.
![AddBook](https://github.com/Bala1703/Library-Management-System/assets/138019223/cf5d980c-fd68-4177-a116-96d1e5c43dc6)


- **Update Book:** Admin can update details of existing books.
![UpdateBook](https://github.com/Bala1703/Library-Management-System/assets/138019223/15a9cabc-35fa-462c-aeda-a252e601ca74)


- **Get Books:** Admin can view all books in the library.
![GetBook](https://github.com/Bala1703/Library-Management-System/assets/138019223/c4d8fb6d-ce4d-49c4-8168-38e8805dfb42)


- **Delete Book:** Admin can remove books from the library.
![DeleteBook](https://github.com/Bala1703/Library-Management-System/assets/138019223/6148a028-6d02-4e59-8ec5-24b2f263029c)


- **Issue Book:** Books can be issued to users by the admin based on the book ID and admission number.
![IssueBook](https://github.com/Bala1703/Library-Management-System/assets/138019223/a82583e5-7c5b-4f16-9019-b122bc4502f8)


- **Return Book:** Admin can update the database with the return details based on the book ID and admission number.
![ReturnBook](https://github.com/Bala1703/Library-Management-System/assets/138019223/8ddce3e3-b971-44d4-9fce-61b01cb36dcf)


- **MySQL Database Transactions:** This screenshot displays MySQL transactions related to returning books, including details such as user information, book details, withdrawal date, and return date. Admin updates the database with the return details based on the book ID and admission number.
![MySQL Transactions](https://github.com/Bala1703/Library-Management-System/assets/138019223/d1eb2776-e7ba-419f-ac79-1f17a47c3387)




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



