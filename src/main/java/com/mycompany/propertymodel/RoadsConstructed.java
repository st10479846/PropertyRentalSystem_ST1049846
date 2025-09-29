/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.runapplication;

/**Road Construction Reporting Application
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
*/

// RoadsConstructed.java


public abstract class RoadsConstructed implements IRoadsConstructed {

    // Variables to store city and total roads
    private String city;
    private int totalRoadsConstructed;

    // Constructor
    public RoadsConstructed(String city, int totalRoadsConstructed) {
        this.city = city;
        this.totalRoadsConstructed = totalRoadsConstructed;
    }

    // Getters (methods from interface)
    @Override
    public String getCity() {
        return city;
    }

    @Override
    public int getTotalRoadsConstructed() {
        return totalRoadsConstructed;
    }

    // Abstract method to be implemented by subclasses
    public abstract void printRoadsConstructedReport();
}