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



// RoadConstructionReport.java
public class RoadConstructionReport extends RoadsConstructed {

    // Constructor
    public RoadConstructionReport(String city, int totalRoadsConstructed) {
        super(city, totalRoadsConstructed);
    }

    // Implementation of the abstract method
    @Override
    public void printRoadsConstructedReport() {
        System.out.println("===== Road Construction Report =====");
        System.out.println("City: " + getCity());
        System.out.println("Total Roads Constructed: " + getTotalRoadsConstructed());
        System.out.println("===================================");
    }
}
