/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SectionB;

/**
 *
 * @author lab_services_student
 */


public class Student extends Person {
    private String course;
    private double[] grades; // Using array for grades
    private int gradeCount;
    
    // Constructor
    public Student(String id, String name, int age, String course, int maxGrades) {
        super(id, name, age);
        this.course = course;
        this.grades = new double[maxGrades];
        this.gradeCount = 0;
    }
    
    // Getters and setters
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public double[] getGrades() {
        return grades;
    }
    
    // Method to add grade
    public boolean addGrade(double grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;
            gradeCount++;
            return true;
        }
        return false;
    }
    
    // Method to calculate average grade
    public double calculateAverage() {
        if (gradeCount == 0) return 0;
        
        double sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return sum / gradeCount;
    }
    
    // Method to get grade count
    public int getGradeCount() {
        return gradeCount;
    }
    
    // Override displayDetails method
    @Override
    public void displayDetails() {
        System.out.println("--- ---");
        System.out.println("STUDENT ID: " + getId());
        System.out.println("STUDENT NAME: " + getName());
        System.out.println("AGE: " + getAge());
        System.out.println("COURSE: " + course);
        System.out.println("GRADES: " + getGradesString());
        System.out.println("AVERAGE: " + String.format("%.2f", calculateAverage()));
        System.out.println("--- ---");
    }
    
    // Helper method to get grades as string
    private String getGradesString() {
        if (gradeCount == 0) return "No grades";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gradeCount; i++) {
            if (i > 0) sb.append(", ");
            sb.append(grades[i]);
        }
        return sb.toString();
    }
}

