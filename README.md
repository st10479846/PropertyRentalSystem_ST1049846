Java Projects by Eugene Makhukhule

This repository contains two Java projects developed as part of academic and learning exercises, demonstrating object-oriented programming, console-based applications, and software engineering best practices.

1. Property Rental Management System

Description:
A console-based application for managing rental properties. Users can add, search, update, and delete properties, as well as generate reports of all properties.

Features:

Add new properties with details: ID, address, rental amount, agent name

Search properties by ID

Update property details

Delete properties

Generate property rental reports

User-friendly console interface

Input validation and error handling

Technologies:

Java SE 22

JUnit 5 (for testing)

Object-Oriented Programming principles

Apache NetBeans IDE

Usage:

Clone the repository

git clone https://github.com/st10479846/PropertyRentalSystem_ST1049846.git


Open the project in NetBeans

Run PropertyRentalApplication.java

Follow the console menu to manage properties

References:

Oracle, Java SE Development Kit 22 Documentation: https://docs.oracle.com/en/java/javase/22/

JUnit 5 User Guide: https://docs.junit.org/current/user-guide/

W3Schools Java Tutorial: https://www.w3schools.com/java/

2. Road Construction Report System

Description:
A simple Java console application that prints a road construction report for a city, demonstrating abstract classes, interfaces, and basic OOP concepts.

Features:

Stores city name and number of roads constructed

Uses abstract class RoadsConstructed and interface IRoadsConstructed

Concrete implementation RoadConstructionReport prints the report

Demonstrates inheritance and polymorphism

Technologies:

Java SE 22

Apache NetBeans IDE

Object-Oriented Programming principles

Usage:

Clone the repository

git clone https://github.com/st10479846/PropertyRentalSystem_ST1049846.git


Open the project in NetBeans

Run RunApplication.java

View the road construction report in the console

References:

Oracle, Java SE Development Kit 22 Documentation: https://docs.oracle.com/en/java/javase/22/

Java Design Patterns: https://javadesignpatterns.com/blog/archive/2024/

W3Schools Java Tutorial: https://www.w3schools.com/java/

Repository Structure
PropertyRentalSystem_ST1049846/
├── PropertyModel/               # Property Rental Management System
│   ├── src/main/java/com/mycompany/propertymodel/
│   │   ├── Property.java
│   │   ├── PropertyModel.java
│   │   ├── PropertyRentalApplication.java
│   └── src/test/java/
│       └── PropertyTest.java
└── RoadConstruction/
    ├── src/
    │   ├── RunApplication.java
    │   ├── RoadConstructionReport.java
    │   ├── RoadsConstructed.java
    │   └── IRoadsConstructed.java

License

This project is for educational purposes and academic reference only
