/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesapplication;

/**
 *
 * @author lab_services_student
 */
public class Media {
   
    private String id;
    private String name;
    private String ageRestriction;

    // Constructor
    public Media(String id, String name, String ageRestriction) {
        this.id = id;
        this.name = name;
        this.ageRestriction = ageRestriction;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    // Display method
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age Restriction: " + ageRestriction);
    }
}