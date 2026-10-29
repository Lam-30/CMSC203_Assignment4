# CMSC203_Assignment4

Property Management System
Project information
Course: CMSC203 - Computer Science
Assignment: #4
Instructor: Ahmed Tarek
Programmer: Luis Aguero
Due Date: 10/29/2026
Programming Language: Java
GUI Framework: JavaFX

Description:
This program simulates a property management system using Java and JavaFX. It allows users to create a management company, add and manage rental properties, verify property plot boundaries and overlaps, calculate total rental income and management fees, and display property information through a graphical user interface.

Main Classes:
- Plot.java: Represents a rectangular plot and provides methods to determine whether plots overlap or one plot encompasses another
- Property.java: Represents a rental property, including its name, city, rent, owner, and plot location.
- ManagementCompany.java: Represents a management company that manages rental properties. Stores company information, manages property plots, calculates total rent, and calculates management fees.
- MgmCompanyGui.java: This class provides the graphical user interface for the property management application. It allows the user to create a management company, add properties, and view rental information.

Testing
The project includes student-written JUnit test classes to verify the functionality of the main classes.
- PlotTestStudent.java
- PropertyTestStudent.java
- ManagementCompanyTestStudent.java
The tests cover constructors, getters, setters, plot boundaries, overlapping properties, property management, rental calculations, and management fee validation.

How to Run
1. Open the project in Eclipse
2. Ensure that Java 21 and the required JavaFX SDK are configured.
3. Verify that the JavaFX library is added to the project's build path.
4. Configure the JavaFX VM arguments if required by your Eclipse setup.
5. Run MgmCompanyGui.java as a Java application.
6. Enter the management company information and click New Management Company.
7. Enter property information and use the application buttons to add properties, view total rents, find the highest-rent property, and list properties.

Technologies Used
- Java 21
- JavaFX
- JUnit 5

Project Requirement
This assignment demonstrates object-oriented programming, constructors, encapsulation, arrays, object interaction, validation, unit testing, and graphical user interface development.

Author
Luis Aguero
CMSC203-Assignment 4
   
