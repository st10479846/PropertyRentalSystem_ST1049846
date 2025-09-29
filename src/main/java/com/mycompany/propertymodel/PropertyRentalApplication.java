/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.propertymodel;

/**
 * References:
 * -----------
 * Author Information:
 * - Makhukhule, E. (2025). Java Property Rental Management System Code. 
 *   Student Number: ST10479846.
 *
 * Technical Documentation & Learning Resources:
 * - Oracle (2024). *Java SE Development Kit 22 Documentation*. 
 *   Available at: https://docs.oracle.com/en/java/javase/22/ (Accessed: 29 September 2025).
 * - Bro Code (2024). *Java Full Course for Beginners* [YouTube tutorial]. 
 *   Available at: https://www.youtube.com/watch?v=xk4_1vDrzzo (Accessed: 29 September 2025).
 * - Programming with Mosh (2024). *Java Tutorial for Beginners* [YouTube series]. 
 *   Available at: https://www.youtube.com/watch?v=eIrMbAQSU34 (Accessed: 29 September 2025).
 * - Amigoscode (2024). *Java Full Course* [YouTube tutorial]. 
 *   Available at: https://www.youtube.com/watch?v=Qgl81fPcLc8 (Accessed: 29 September 2025).
 *
 * Testing & Development Resources:
 * - JUnit 5 Team (2024). *JUnit Jupiter API Documentation*. 
 *   Available at: https://docs.junit.org/current/user-guide/ (Accessed: 29 September 2025).
 * - Java Design Patterns (2024). *Object-Oriented Design Patterns*. 
 *   Available at: https://javadesignpatterns.com/blog/archive/2024/ (Accessed: 29 September 2025).
 * - Apache NetBeans (2024). *NetBeans IDE Documentation*. 
 *   Available at: https://netbeans.apache.org/kb/docs/ (Accessed: 29 September 2025).
 *
 * Educational Resources:
 * - W3Schools (2024). *Java Tutorial: Java Programming Concepts and Syntax*. 
 *   Available at: https://www.w3schools.com/java/ (Accessed: 29 September 2025).
 * - GeeksforGeeks (2024). *Java Programming Language Articles*. 
 *   Available at: https://www.geeksforgeeks.org/java/ (Accessed: 29 September 2025).
 * - Stack Overflow (2024). *Programming Community Problem Solutions*. 
 *   Available at: https://stackoverflow.com/ (Accessed: 29 September 2025).
 *
 * Note:
 * This application was developed as part of an academic project to demonstrate
 * object-oriented principles and software engineering best practices.
 * 
 * 
 */

import java.util.Scanner;

/**
 * PropertyRentalApplication class serves as the main entry point
 * for running the Property Rental Management System.
 * It interacts with the user via the console and delegates
 * property operations to the Property class.
 */
public class PropertyRentalApplication {

    /**
     * Main method - starts the Property Rental Management System.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Create an instance of Property to manage rental properties
        Property propertyManager = new Property();

        // Retrieve the Scanner object from Property for user input
        Scanner scanner = propertyManager.getScanner();

        // Display welcome message to the user
        System.out.println("Welcome to Property Rental Management System!");

        // Flag to control the main application loop
        boolean running = true;

        // Main application loop - continues until the user chooses to exit
        while (running) {
            try {
                // Display the main menu
                propertyManager.displayMenu();

                // Read user's menu choice
                String choice = scanner.nextLine();

                // Execute the selected option
                switch (choice) {
                    case "1" -> // Add a new property
                        propertyManager.EnterProperty();
                    case "2" -> // Search for an existing property
                        propertyManager.SearchProperty();
                    case "3" -> // Update property details
                        propertyManager.UpdateProperty();
                    case "4" -> // Delete a property
                        propertyManager.DeleteProperty();
                    case "5" -> // Display a report of all properties
                        propertyManager.PropertyRentalReport();
                    case "6" -> {
                        // Exit the application gracefully
                        propertyManager.ExitPropertyApplication();
                        running = false;
                    }
                    default -> // Handle invalid input
                        System.out.println("Invalid option! Please enter a number between 1-6.");
                }

                // Pause before showing the menu again if still running
                if (running) {
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }

            } catch (Exception e) {
                // Handle unexpected errors and allow user to try again
                System.out.println("An error occurred: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }
}
