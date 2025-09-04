/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package SectionB;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class PersonTest {
    
    public PersonTest() {
    }
    
    
    
    @Test
    public void testGetId() {
        System.out.println("getId");
        Person instance = new Person("P001", "John", 25);
        String expResult = "P001";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        Person instance = new Person("P001", "John", 25);
        instance.setId("P002");
        assertEquals("P002", instance.getId());
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Person instance = new Person("P001", "John", 25);
        String expResult = "John";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        Person instance = new Person("P001", "John", 25);
        instance.setName("Alice");
        assertEquals("Alice", instance.getName());
    }

    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Person instance = new Person("P001", "John", 25);
        int expResult = 25;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAge() {
        System.out.println("setAge");
        Person instance = new Person("P001", "John", 25);
        instance.setAge(30);
        assertEquals(30, instance.getAge());
    }

    @Test
    public void testDisplayDetails() {
        System.out.println("displayDetails");
        Person instance = new Person("P001", "John", 25);
        instance.displayDetails();
        // No assert needed unless you're capturing output
    }

    @Test
    public void testIsValidAge() {
        System.out.println("isValidAge");
        Person instance = new Person("P001", "John", 25);
        boolean expResult = true;
        boolean result = instance.isValidAge();
        assertEquals(expResult, result);
    }
}
