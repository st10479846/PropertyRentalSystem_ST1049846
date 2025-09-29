/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.propertymodel.Property;
import com.mycompany.propertymodel.PropertyModel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
  Author Information:
 * - Makhukhule, E. (2025). Java Property Rental Management System Code. 
 *   Student Number: ST10479846.
 * */

/**
 * PropertyTest class contains unit tests for the Property and PropertyModel classes.
 * It verifies that property management operations (add, search, update, delete) and
 * rental amount validations function correctly.
 */
public class PropertyTest {

    // Property manager instance to perform operations
    private Property propertyManager;

    // Test properties used in unit tests
    private PropertyModel testProperty1;
    private PropertyModel testProperty2;

    /**
     * Setup method runs before each test to initialize test data
     * and the Property manager with pre-defined properties.
     */
    @BeforeEach
    void setUp() {
        // Create test properties
        testProperty1 = new PropertyModel("PROP001", "123 Main Street, Cape Town", 2000.0, "John Smith");
        testProperty2 = new PropertyModel("PROP002", "456 Oak Avenue, Johannesburg", 3000.0, "Sarah Johnson");

        // Initialize property manager with test data
        ArrayList<PropertyModel> initialProperties = new ArrayList<>();
        initialProperties.add(testProperty1);
        initialProperties.add(testProperty2);

        propertyManager = new Property(initialProperties);
    }

    /**
     * Test that searching for an existing property returns the correct property.
     */
    @Test
    @DisplayName("SearchProperty_ReturnProperty - Should return property when found")
    void SearchProperty_ReturnProperty() {
        String existingPropertyId = "PROP001";

        // Perform search
        PropertyModel result = propertyManager.SearchProperty(existingPropertyId);

        // Verify property details
        assertNotNull(result, "Property should be found when searching with valid ID");
        assertEquals(existingPropertyId, result.PropertyId, "Property ID should match the search criteria");
        assertEquals("123 Main Street, Cape Town", result.PropertyAddress, "Property address should match");
        assertEquals(2000.0, result.PropertyRentalAmount, 0.01, "Rental amount should match exactly");
        assertEquals("John Smith", result.AgentName, "Agent name should match");
    }

    /**
     * Test that searching for non-existent, empty, or null IDs returns null.
     * Also verifies case-sensitivity in property searches.
     */
    @Test
    @DisplayName("SearchProperty_NotFound - Should return null when property not found")
    void SearchProperty_NotFound() {
        String nonExistingPropertyId = "NONEXISTENT123";
        String emptyPropertyId = "";
        String nullPropertyId = null;

        // Test search for non-existent ID
        PropertyModel result1 = propertyManager.SearchProperty(nonExistingPropertyId);
        assertNull(result1, "Should return null when property ID does not exist");

        // Test search for empty ID
        PropertyModel result2 = propertyManager.SearchProperty(emptyPropertyId);
        assertNull(result2, "Should return null when property ID is empty");

        // Test search for null ID
        PropertyModel result3 = propertyManager.SearchProperty(nullPropertyId);
        assertNull(result3, "Should return null when property ID is null");

        // Test case-sensitivity (should not find lowercase or mixed case)
        PropertyModel result4 = propertyManager.SearchProperty("prop001"); 
        assertNull(result4, "Search should be case-sensitive and not find lowercase ID");

        PropertyModel result5 = propertyManager.SearchProperty("Prop001"); 
        assertNull(result5, "Search should be case-sensitive and not find mixed case ID");
    }

    /**
     * Test updating an existing property successfully.
     */
    @Test
    @DisplayName("UpdateProperty_ReturnSuccess - Should successfully update property details")
    void UpdateProperty_ReturnSuccess() {
        String propertyId = "PROP001";
        String newAddress = "789 Updated Street, Durban";
        Double newRentalAmount = 2500.0;
        String newAgentName = "Michael Brown";

        // Verify property exists before update
        PropertyModel originalProperty = propertyManager.SearchProperty(propertyId);
        assertNotNull(originalProperty, "Property should exist before update");

        // Perform update
        boolean result = propertyManager.UpdateProperty(propertyId, newAddress, newRentalAmount, newAgentName);

        // Verify update success
        assertTrue(result, "Property update should return true on success");

        // Verify all fields updated
        PropertyModel updatedProperty = propertyManager.SearchProperty(propertyId);
        assertNotNull(updatedProperty, "Property should still exist after update");
        assertEquals(newAddress, updatedProperty.PropertyAddress, "Address should be updated");
        assertEquals(newRentalAmount, updatedProperty.PropertyRentalAmount, 0.01, "Rental amount should be updated");
        assertEquals(newAgentName, updatedProperty.AgentName, "Agent name should be updated");
    }

    /**
     * Test deleting an existing property successfully.
     */
    @Test
    @DisplayName("DeleteProperty_ReturnSuccess - Should successfully delete property")
    void DeleteProperty_ReturnSuccess() {
        String propertyId = "PROP001";
        int initialSize = propertyManager.getProperties().size();

        // Verify property exists
        PropertyModel propertyToDelete = propertyManager.SearchProperty(propertyId);
        assertNotNull(propertyToDelete, "Property should exist before deletion");

        // Perform deletion
        boolean result = propertyManager.DeleteProperty(propertyId);

        // Verify deletion success
        assertTrue(result, "Property deletion should return true on success");

        // Verify property no longer exists
        PropertyModel deletedProperty = propertyManager.SearchProperty(propertyId);
        assertNull(deletedProperty, "Property should not exist after deletion");

        // Verify properties list size decreased
        int finalSize = propertyManager.getProperties().size();
        assertEquals(initialSize - 1, finalSize, "Properties list size should decrease by 1 after deletion");
    }

    /**
     * Test that valid rental amounts are accepted.
     */
    @Test
    @DisplayName("PropertyAmountValidation_AmountIsValid - Should return true for valid rental amounts")
    void PropertyAmountValidation_AmountIsValid() {
        assertTrue(propertyManager.PropertyAmountValidation(1500.0), "Minimum amount (R1500.00) should be valid");
        assertTrue(propertyManager.PropertyAmountValidation(2000.0), "R2000.00 should be valid");
        assertTrue(propertyManager.PropertyAmountValidation(5000.0), "R5000.00 should be valid");
        assertTrue(propertyManager.PropertyAmountValidation(1500.50), "Decimal amount (R1500.50) should be valid");
    }

    /**
     * Test that invalid rental amounts are rejected.
     */
    @Test
    @DisplayName("PropertyAmountValidation_AmountInValid - Should return false for invalid rental amounts")
    void PropertyAmountValidation_AmountInValid() {
        assertFalse(propertyManager.PropertyAmountValidation(1499.99), "Amount just below minimum (R1499.99) should be invalid");
        assertFalse(propertyManager.PropertyAmountValidation(1000.0), "R1000.00 should be invalid");
        assertFalse(propertyManager.PropertyAmountValidation(0.0), "Zero amount should be invalid");
        assertFalse(propertyManager.PropertyAmountValidation(-500.0), "Negative amount should be invalid");
    }

    /**
     * Test adding a new property successfully.
     */
    @Test
    @DisplayName("EnterProperty_ReturnSuccess - Should successfully add new property")
    void EnterProperty_ReturnSuccess() {
        String newPropertyId = "PROP003";
        String newAddress = "999 New Street, Pretoria";
        double newRentalAmount = 3500.0;
        String newAgentName = "New Agent";
        int initialSize = propertyManager.getProperties().size();

        // Perform property entry
        boolean result = propertyManager.EnterProperty(newPropertyId, newAddress, newRentalAmount, newAgentName);

        // Verify entry success
        assertTrue(result, "Property entry should be successful");

        // Verify property exists
        PropertyModel newProperty = propertyManager.SearchProperty(newPropertyId);
        assertNotNull(newProperty, "New property should exist in the system");
        assertEquals(newPropertyId, newProperty.PropertyId, "Property ID should match");
    }

    /**
     * Test that adding a property with duplicate ID fails.
     */
    @Test
    @DisplayName("EnterProperty_ReturnFailure_DuplicateId - Should fail when adding duplicate property")
    void EnterProperty_ReturnFailure_DuplicateId() {
        String duplicatePropertyId = "PROP001"; // Already exists
        String newAddress = "999 New Street";
        double newRentalAmount = 3500.0;
        String newAgentName = "New Agent";
        int initialSize = propertyManager.getProperties().size();

        // Attempt to add duplicate property
        boolean result = propertyManager.EnterProperty(duplicatePropertyId, newAddress, newRentalAmount, newAgentName);

        // Verify failure
        assertFalse(result, "Property entry should fail for duplicate ID");

        // Verify properties list size unchanged
        int finalSize = propertyManager.getProperties().size();
        assertEquals(initialSize, finalSize, "Properties list size should remain unchanged");
    }

    /**
     * Test that searching with exact case ID finds the property.
     */
    @Test
    @DisplayName("SearchProperty_FoundWithExactCase - Should find property with exact case match")
    void SearchProperty_FoundWithExactCase() {
        String exactCasePropertyId = "PROP001"; // Exact case match

        // Perform search
        PropertyModel result = propertyManager.SearchProperty(exactCasePropertyId);

        // Verify search success
        assertNotNull(result, "Property should be found with exact case match");
        assertEquals(exactCasePropertyId, result.PropertyId, "Property ID should match exactly");
    }
}
