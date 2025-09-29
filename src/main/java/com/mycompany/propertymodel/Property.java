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
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Property class is responsible for managing a collection of rental properties.
 * It provides functionality to:
 * - Add new properties
 * - Search for properties
 * - Update property details
 * - Delete properties
 * - Generate reports
 * - Validate rental amounts
 * 
 * This class works together with the PropertyModel class and implements a 
 * console-based Property Rental Management System.
 */
public class Property {

    /** A list that stores all the properties currently managed by the system. */
    private ArrayList<PropertyModel> properties;

    /** Scanner object for user input through the console. */
    private Scanner scanner;

    // ------------------------
    // Constructors
    // ------------------------

    /**
     * Default constructor.
     * Initializes the properties list and the scanner.
     */
    public Property() {
        properties = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Parameterized constructor.
     * Initializes the properties list with given initial properties and sets up the scanner.
     * 
     * @param initialProperties Initial list of properties to populate the system.
     */
    public Property(ArrayList<PropertyModel> initialProperties) {
        this.properties = new ArrayList<>(initialProperties);
        this.scanner = new Scanner(System.in);
    }

    // ------------------------
    // Getter and Setter Methods
    // ------------------------

    /**
     * Returns a copy of the current list of properties.
     * 
     * @return A new ArrayList containing all property records.
     */
    public ArrayList<PropertyModel> getProperties() {
        return new ArrayList<>(properties);
    }

    /**
     * Sets a custom scanner object for this class.
     * 
     * @param scanner Scanner object for reading input.
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    // ------------------------
    // Menu Display
    // ------------------------

    /**
     * Displays the main menu for the Property Rental Management System.
     */
    public void displayMenu() {
        System.out.println("\n=== PROPERTY RENTAL MANAGEMENT SYSTEM ===");
        System.out.println("1. Enter New Property for Rent");
        System.out.println("2. Search for Rental Property");
        System.out.println("3. Update Property Details");
        System.out.println("4. Delete Property");
        System.out.println("5. View Property Rental Report");
        System.out.println("6. Exit Application");
        System.out.print("Please select an option (1-6): ");
    }

    // ------------------------
    // Add New Property
    // ------------------------

    /**
     * Adds a new property to the list with the provided details.
     * Validates duplicate property IDs and rental amount.
     * 
     * @param propertyId Unique identifier for the property.
     * @param address Address of the property.
     * @param rentalAmount Monthly rental amount.
     * @param agentName Name of the agent managing the property.
     * @return true if property is added successfully, false otherwise.
     */
    public boolean EnterProperty(String propertyId, String address, double rentalAmount, String agentName) {
        if (findPropertyById(propertyId) != null) {
            System.out.println("Error: Property ID already exists!");
            return false;
        }

        if (!validateRentalAmount(rentalAmount)) {
            return false;
        }

        PropertyModel newProperty = new PropertyModel(propertyId, address, rentalAmount, agentName);
        properties.add(newProperty);
        System.out.println("\n✓ Property rental details have been successfully processed!");
        return true;
    }

    /**
     * Handles user input for adding a new property through the console.
     */
    public void EnterProperty() {
        System.out.println("\n=== ENTER NEW PROPERTY FOR RENT ===");
        System.out.print("Enter Property ID: ");
        String propertyId = scanner.nextLine();
        System.out.print("Enter Property Address: ");
        String address = scanner.nextLine();

        double rentalAmount = PropertyAmountValidation();
        if (rentalAmount == -1) return;

        System.out.print("Enter Agent Name: ");
        String agentName = scanner.nextLine();
        EnterProperty(propertyId, address, rentalAmount, agentName);
    }

    // ------------------------
    // Search Property
    // ------------------------

    /**
     * Searches for a property by its ID.
     * 
     * @param propertyId The ID of the property to search for.
     * @return PropertyModel object if found, null otherwise.
     */
    public PropertyModel SearchProperty(String propertyId) {
        return findPropertyById(propertyId);
    }

    /**
     * Handles user input for searching for a property through the console.
     */
    public void SearchProperty() {
        System.out.println("\n=== SEARCH FOR RENTAL PROPERTY ===");
        System.out.print("Enter Property ID to search: ");
        String searchId = scanner.nextLine();
        PropertyModel foundProperty = SearchProperty(searchId);

        if (foundProperty != null) {
            System.out.println("\n✓ Property Found!");
            System.out.println("----------------------------");
            foundProperty.displayProperty();
        } else {
            System.out.println("Error: No property data could be found for ID: " + searchId);
        }
    }

    // ------------------------
    // Update Property
    // ------------------------

    /**
     * Updates the details of an existing property.
     * 
     * @param propertyId The ID of the property to update.
     * @param newAddress The new address, or null to keep the current one.
     * @param newRentalAmount The new rental amount, or null to keep the current one.
     * @param newAgentName The new agent name, or null to keep the current one.
     * @return true if update was successful, false if the property was not found.
     */
    public boolean UpdateProperty(String propertyId, String newAddress, Double newRentalAmount, String newAgentName) {
        PropertyModel propertyToUpdate = findPropertyById(propertyId);
        if (propertyToUpdate == null) return false;

        if (newAddress != null && !newAddress.trim().isEmpty()) {
            propertyToUpdate.PropertyAddress = newAddress;
        }

        if (newRentalAmount != null && validateRentalAmount(newRentalAmount)) {
            propertyToUpdate.PropertyRentalAmount = newRentalAmount;
        }

        if (newAgentName != null && !newAgentName.trim().isEmpty()) {
            propertyToUpdate.AgentName = newAgentName;
        }

        return true;
    }

    /**
     * Handles user input for updating a property through the console.
     */
    public void UpdateProperty() {
        System.out.println("\n=== UPDATE PROPERTY DETAILS ===");
        System.out.print("Enter Property ID to update: ");
        String updateId = scanner.nextLine();
        PropertyModel propertyToUpdate = findPropertyById(updateId);

        if (propertyToUpdate == null) {
            System.out.println("Error: No property found with ID: " + updateId);
            return;
        }

        System.out.println("\nCurrent Property Details:");
        propertyToUpdate.displayProperty();
        System.out.println("----------------------------");

        System.out.print("Enter new Property Address (press enter to keep current): ");
        String newAddress = scanner.nextLine();

        System.out.print("Update rental amount? (y/n): ");
        String updateRental = scanner.nextLine();
        Double newRentalAmount = null;
        if (updateRental.equalsIgnoreCase("y")) {
            newRentalAmount = PropertyAmountValidation();
            if (newRentalAmount == -1) return;
        }

        System.out.print("Enter new Agent Name (press enter to keep current): ");
        String newAgent = scanner.nextLine();

        if (UpdateProperty(updateId, newAddress, newRentalAmount, newAgent)) {
            System.out.println("✓ Property details updated successfully!");
        } else {
            System.out.println("Error updating property!");
        }
    }

    // ------------------------
    // Delete Property
    // ------------------------

    /**
     * Deletes a property from the list using its ID.
     * 
     * @param propertyId The ID of the property to delete.
     * @return true if deletion was successful, false otherwise.
     */
    public boolean DeleteProperty(String propertyId) {
        PropertyModel propertyToDelete = findPropertyById(propertyId);
        return propertyToDelete != null && properties.remove(propertyToDelete);
    }

    /**
     * Handles user input for deleting a property through the console.
     */
    public void DeleteProperty() {
        System.out.println("\n=== DELETE PROPERTY ===");
        System.out.print("Enter Property ID to delete: ");
        String deleteId = scanner.nextLine();
        PropertyModel propertyToDelete = findPropertyById(deleteId);

        if (propertyToDelete == null) {
            System.out.println("Error: No property found with ID: " + deleteId);
            return;
        }

        System.out.println("\nProperty to be deleted:");
        propertyToDelete.displayProperty();
        System.out.print("\nAre you sure you want to delete this property? (y/n): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("y") && DeleteProperty(deleteId)) {
            System.out.println("✓ Property deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    // ------------------------
    // Rental Amount Validation
    // ------------------------

    /**
     * Prompts user to enter a valid rental amount and validates the input.
     * Repeats until a valid amount is provided.
     * 
     * @return A valid rental amount entered by the user.
     */
    public double PropertyAmountValidation() {
        while (true) {
            try {
                System.out.print("Enter Monthly Rental Amount: R ");
                String rentalInput = scanner.nextLine();
                double rentalAmount = Double.parseDouble(rentalInput);

                if (validateRentalAmount(rentalAmount)) {
                    return rentalAmount;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input! Only numbers are allowed.");
            }
        }
    }

    /**
     * Validates that the rental amount meets minimum requirements.
     * 
     * @param rentalAmount The rental amount to validate.
     * @return true if the amount is valid, false otherwise.
     */
    private boolean validateRentalAmount(double rentalAmount) {
        if (rentalAmount < 1500) {
            System.out.println("Error: Rental amount must be ≥ R 1,500.00");
            return false;
        }
        return true;
    }

    /**
     * Validates the rental amount when provided directly.
     */
    public boolean PropertyAmountValidation(double rentalAmount) {
        return validateRentalAmount(rentalAmount);
    }

    // ------------------------
    // Reports
    // ------------------------

    /**
     * Generates and displays a formatted report of all properties,
     * including their total monthly rental.
     */
    public void PropertyRentalReport() {
        System.out.println("\n=== PROPERTY RENTAL REPORT ===");
        if (properties.isEmpty()) {
            System.out.println("No properties available for rent.");
            return;
        }

        double totalRental = 0;
        System.out.printf("%-12s %-25s %-15s %-20s%n", "Property ID", "Address", "Rental Amount", "Agent Name");
        System.out.println("----------------------------------------------------------------");

        for (PropertyModel property : properties) {
            // Truncate address if it's too long
            String shortAddress = property.PropertyAddress.length() > 24 ? 
                property.PropertyAddress.substring(0, 24) : property.PropertyAddress;

            System.out.printf("%-12s %-25s R%-14.2f %-20s%n", 
                property.PropertyId, shortAddress, property.PropertyRentalAmount, property.AgentName);
            totalRental += property.PropertyRentalAmount;
        }

        System.out.println("----------------------------------------------------------------");
        System.out.printf("Total Properties: %d | Total Monthly Rental: R %,.2f%n", properties.size(), totalRental);
    }

    // ------------------------
    // Exit Application
    // ------------------------

    /**
     * Exits the application gracefully by closing resources.
     */
    public void ExitPropertyApplication() {
        System.out.println("\nThank you for using Property Rental Management System!");
        System.out.println("Goodbye!");
        if (scanner != null) scanner.close();
    }

    // ------------------------
    // Helper Method
    // ------------------------

    /**
     * Finds a property by its ID.
     * 
     * @param propertyId The ID of the property to search for.
     * @return PropertyModel object if found, null otherwise.
     */
    private PropertyModel findPropertyById(String propertyId) {
        for (PropertyModel property : properties) {
            if (property.PropertyId.equals(propertyId)) { // Changed from equalsIgnoreCase to equals
                return property;
            }
        }
        return null;
    }

    /**
     * Returns the Scanner object used for user input.
     * 
     * @return Scanner object.
     */
    public Scanner getScanner() {
        return scanner;
    }
}
