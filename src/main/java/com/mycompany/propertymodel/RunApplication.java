/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.runapplication;

/**
 * Road Construction Reporting Application
 * ---------------------------------------
 * Author: Eugene Makhukhule
 * Student Number: ST10479846
 *
 * Description:
 * This Java program generates a simple road construction report for a specified city.
 * The program demonstrates the use of Object-Oriented Programming principles
 * including abstraction, inheritance, encapsulation, and interface implementation.
 * It is designed to show a basic console output report of the total number of roads
 * constructed in a city.
 *
 * Program Features:
 * 1. Abstract class 'RoadsConstructed' stores common attributes (city, total roads)
 *    and defines an abstract method for printing reports.
 * 2. Interface 'IRoadsConstructed' provides a contract for getters: getCity() and getTotalRoadsConstructed().
 * 3. Concrete class 'RoadConstructionReport' extends 'RoadsConstructed' and implements the report printing functionality.
 * 4. 'RunApplication' class contains the main method, creates an instance of RoadConstructionReport, and prints the report.
 *
 * Classes:
 * - IRoadsConstructed
 *      Interface defining the getters for city and total roads.
 *      Methods:
 *          String getCity() - Returns the name of the city.
 *          int getTotalRoadsConstructed() - Returns the total number of roads constructed.
 *
 * - RoadsConstructed
 *      Abstract class implementing IRoadsConstructed.
 *      Fields:
 *          private String city - Stores the city name.
 *          private int totalRoadsConstructed - Stores the total roads constructed.
 *      Constructor:
 *          RoadsConstructed(String city, int totalRoadsConstructed)
 *      Methods:
 *          String getCity() - Getter for city.
 *          int getTotalRoadsConstructed() - Getter for total roads.
 *          abstract void printRoadsConstructedReport() - Abstract method to print report.
 *
 * - RoadConstructionReport
 *      Concrete class extending RoadsConstructed.
 *      Constructor:
 *          RoadConstructionReport(String city, int totalRoadsConstructed)
 *      Methods:
 *          void printRoadsConstructedReport() - Prints a formatted report of the city and total roads.
 *
 * - RunApplication
 *      Contains the main method to execute the program.
 *      Main Method:
 *          public static void main(String[] args) - Entry point. Creates a RoadConstructionReport object and prints the report.
 *
 * Example Console Output:
 * ---------------------------------------
 * ===== Road Construction Report =====
 * City: Pretoria
 * Total Roads Constructed: 120
 * ===================================
 *
 * References:
 * -----------
 * Technical Documentation & Learning Resources:
 * - Oracle. (2024). Java SE Development Kit 22 Documentation. Available at: https://docs.oracle.com/en/java/javase/22/
 * - Bro Code. (2024). Java Full Course for Beginners [YouTube Tutorial]. Available at: https://www.youtube.com/watch?v=xk4_1vDrzzo
 * - Programming with Mosh. (2024). Java Tutorial for Beginners [YouTube Series]. Available at: https://www.youtube.com/watch?v=eIrMbAQSU34
 * - Amigoscode. (2024). Java Full Course [YouTube Tutorial]. Available at: https://www.youtube.com/watch?v=Qgl81fPcLc8
 *
 * Testing & Development Resources:
 * - JUnit 5 User Guide. (2024). JUnit Jupiter API Documentation. Available at: https://docs.junit.org/current/user-guide/
 * - Java Programming Guides. (2024). Object-Oriented Design Patterns. Available at: https://javadesignpatterns.com/blog/archive/2024/
 * - NetBeans IDE Documentation. (2024). Integrated Development Environment Guide. Available at: https://netbeans.apache.org/kb/docs/
 *
 * Educational Resources:
 * - W3Schools. (2024). Java Programming Concepts and Syntax. Available at: https://www.w3schools.com/java/
 * - GeeksforGeeks. (2024). Java Programming Language Articles. Available at: https://www.geeksforgeeks.org/java/
 * - Stack Overflow. (2024). Programming Community Problem Solutions. Available at: https://stackoverflow.com/
 */



/**
 * RunApplication class serves as the entry point for the Road Construction Report program.
 * It demonstrates creating an instance of RoadConstructionReport and printing the report.
 */
public class RunApplication {

    /**
     * Main method - the starting point of the application.
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args) {

        // Create an instance of RoadConstructionReport for the city of Pretoria
        // and with 120 roads constructed
        RoadConstructionReport report = new RoadConstructionReport("Pretoria", 120);

        // Call the method to print the road construction report to the console
        report.printRoadsConstructedReport();
    }
}


