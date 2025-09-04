/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.tvseriesapplication;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class MediaTest {
    
    public MediaTest() {
    }

    @Test
    public void testGetId() {
        Media instance = new Media("M001", "Avatar", "PG-13");
        String expected = "M001";
        assertEquals(expected, instance.getId());
    }

    @Test
    public void testGetName() {
        Media instance = new Media("M001", "Avatar", "PG-13");
        String expected = "Avatar";
        assertEquals(expected, instance.getName());
    }

    @Test
    public void testGetAgeRestriction() {
        Media instance = new Media("M001", "Avatar", "PG-13");
        String expected = "PG-13";
        assertEquals(expected, instance.getAgeRestriction());
    }

    @Test
    public void testSetId() {
        Media instance = new Media("M001", "Avatar", "PG-13");
        instance.setId("M002");
        assertEquals("M002", instance.getId());
    }

    @Test
    public void testSetName() {
        Media instance = new Media("M001", "Avatar", "PG-13");
        instance.setName("Titanic");
        assertEquals("Titanic", instance.getName());
    }

    @Test
    public void testSetAgeRestriction() {
        Media instance = new Media("M001", "Avatar", "PG-13");
        instance.setAgeRestriction("18+");
        assertEquals("18+", instance.getAgeRestriction());
    }

    @Test
    public void testDisplayDetails() {
        Media instance = new Media("M001", "Avatar", "PG-13");
        // This just ensures the method runs without error
        // You can visually verify output or use a logger / output capture tool for automated checking
        instance.displayDetails();
    }
}
