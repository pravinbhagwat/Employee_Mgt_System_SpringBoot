## Employee_Mgt_System_SpringBoot

### Objective:
The aim of this assignment is to create a simple Employee Management System using Spring Boot, demonstrating the integration of both PostgreSQL and MongoDB databases. The application should be able to perform basic CRUD (Create, Read, Update, Delete) operations on employee, department data.

### Requirements :

#### Entities:
#### I. Employee (Stored in PostgreSQL):
* id: Long (Primary Key)
* firstName: String
* lastName: String
* email: String
* departmentId: String (Foreign Key)
* createdAt: Timestamp
* updatedAt: Timestamp

#### II. Department (Stored in MongoDB) :
* departmentId: String (Primary Key)
* departmentName: String
* createdAt: Timestamp
* updatedAt: Timestamp

### Functionalities :
* Implemented the employee crud operations
* Implemented the department crud operations

### Teck-Stack Used : 
1. Spring-Boot
2. PostgreSQL Database
3. MongoDB Database
4. OOPs
5. Java
