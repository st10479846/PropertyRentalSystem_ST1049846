/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.propertymodel;

/**
 * References:
 * -----------
 * Author Information:
 * - Makhukhule, E. (2025). Java Property Rental Management System Code. 
 *   Student Number: ST10479846.
 */


/**
 * The PropertyModel class represents a rental property.
 * It stores the property's unique ID, address, monthly rental amount,
 * and the name of the agent managing the property.
 *
 * This class is part of the Property Rental Management System
 * and follows Object-Oriented Programming principles.
 */
public class PropertyModel {

    // ------------------------
    // Instance Variables
    // ------------------------

    /** Unique identifier for the property (e.g., "P001"). */
    public String PropertyId;

    /** Physical address of the property being rented. */
    public String PropertyAddress;

    /** Monthly rental amount for the property. */
    public double PropertyRentalAmount;

    /** Name of the agent responsible for managing the property. */
    public String AgentName;


    // ------------------------
    // Constructors
    // ------------------------

    /**
     * Parameterized constructor to create a new PropertyModel object.
     *
     * @param propertyId          Unique ID for the property
     * @param propertyAddress     Address of the property
     * @param propertyRentalAmount Monthly rental amount
     * @param agentName           Name of the managing agent
     */
    public PropertyModel(String propertyId, String propertyAddress, double propertyRentalAmount, String agentName) {
        this.PropertyId = propertyId;
        this.PropertyAddress = propertyAddress;
        this.PropertyRentalAmount = propertyRentalAmount;
        this.AgentName = agentName;
    }

    /**
     * Default constructor.
     * Allows creation of a PropertyModel object without setting values immediately.
     */
    public PropertyModel() {}


    // ------------------------
    // Methods
    // ------------------------

    /**
     * Displays the property details in a user-friendly format.
     * Prints the ID, address, rental amount, and agent name to the console.
     */
    public void displayProperty() {
        System.out.println("Property ID: " + PropertyId);
        System.out.println("Address: " + PropertyAddress);
        System.out.println("Rental Amount: R " + String.format("%,.2f", PropertyRentalAmount));
        System.out.println("Agent Name: " + AgentName);
    }

    /**
     * Compares this PropertyModel object with another to check for equality.
     * Two properties are considered equal if:
     * - They have the same PropertyId,
     * - The same PropertyAddress,
     * - The same PropertyRentalAmount,
     * - And the same AgentName.
     *
     * @param obj The object to compare with this property
     * @return true if both objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // Check if both references point to the same object in memory
        if (this == obj) return true;

        // If the object is null or not of type PropertyModel, return false
        if (obj == null || getClass() != obj.getClass()) return false;

        // Typecast obj to PropertyModel for comparison
        PropertyModel that = (PropertyModel) obj;

        // Compare individual fields for equality
        return Double.compare(that.PropertyRentalAmount, PropertyRentalAmount) == 0 &&
               PropertyId.equals(that.PropertyId) &&
               PropertyAddress.equals(that.PropertyAddress) &&
               AgentName.equals(that.AgentName);
    }

    /**
     * Returns a string representation of the PropertyModel object.
     * Useful for debugging or logging property information.
     *
     * @return A formatted string containing all property details.
     */
    @Override
    public String toString() {
        return "PropertyModel{" +
               "PropertyId='" + PropertyId + '\'' +
               ", Address='" + PropertyAddress + '\'' +
               ", Rental=" + PropertyRentalAmount +
               ", Agent='" + AgentName + '\'' +
               '}';
    }
}
