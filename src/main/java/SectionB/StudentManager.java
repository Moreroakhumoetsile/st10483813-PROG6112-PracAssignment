/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SectionB;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;



public class StudentManager {
    private Student[] students;
    private int studentCount;
    private Scanner scanner;
    private final int MAX_STUDENTS = 100;
    private final int MAX_GRADES = 10;
    
    public StudentManager() {
        students = new Student[MAX_STUDENTS];
        studentCount = 0;
        scanner = new Scanner(System.in);
    }
    
    public void startApplication() {
        System.out.println("STUDENT MANAGEMENT SYSTEM - 2025");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = scanner.nextLine();
        if ("1".equals(input)) {
            displayMenu();
        } else {
            exitApplication();
        }
    }
    
    private void displayMenu() {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Add a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Update student details.");
            System.out.println("(4) Add grades to student.");
            System.out.println("(5) Delete a student.");
            System.out.println("(6) Generate student report.");
            System.out.println("(7) Exit Application.");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    searchStudent();
                    break;
                case "3":
                    updateStudent();
                    break;
                case "4":
                    addGrades();
                    break;
                case "5":
                    deleteStudent();
                    break;
                case "6":
                    generateReport();
                    break;
                case "7":
                    exitApplication();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Maximum number of students reached!");
            returnToMenu();
            return;
        }
        
        System.out.println("\nADD A NEW STUDENT");
        System.out.println("***************");
        
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        // Check if ID already exists
        if (findStudentById(id) != null) {
            System.out.println("Student with this ID already exists!");
            returnToMenu();
            return;
        }
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        int age;
        while (true) {
            System.out.print("Enter student age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 16 && age <= 100) {
                    break;
                } else {
                    System.out.println("Age must be between 16 and 100!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for age!");
            }
        }
        
        System.out.print("Enter student course: ");
        String course = scanner.nextLine();
        
        Student newStudent = new Student(id, name, age, course, MAX_GRADES);
        students[studentCount] = newStudent;
        studentCount++;
        
        System.out.println("Student added successfully!");
        returnToMenu();
    }
    
    private void searchStudent() {
        System.out.print("\nEnter student ID to search: ");
        String searchId = scanner.nextLine();
        
        Student student = findStudentById(searchId);
        if (student != null) {
            student.displayDetails();
        } else {
            System.out.println("Student with ID " + searchId + " was not found!");
        }
        
        returnToMenu();
    }
    
    private void updateStudent() {
        System.out.print("\nEnter student ID to update: ");
        String updateId = scanner.nextLine();
        
        Student student = findStudentById(updateId);
        if (student == null) {
            System.out.println("Student with ID " + updateId + " was not found!");
            returnToMenu();
            return;
        }
        
        System.out.print("Enter new name (current: " + student.getName() + "): ");
        String newName = scanner.nextLine();
        if (!newName.trim().isEmpty()) {
            student.setName(newName);
        }
        
        System.out.print("Enter new age (current: " + student.getAge() + "): ");
        String ageInput = scanner.nextLine();
        if (!ageInput.trim().isEmpty()) {
            try {
                int newAge = Integer.parseInt(ageInput);
                if (newAge >= 16 && newAge <= 100) {
                    student.setAge(newAge);
                } else {
                    System.out.println("Age must be between 16 and 100. Age not updated.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format. Age not updated.");
            }
        }
        
        System.out.print("Enter new course (current: " + student.getCourse() + "): ");
        String newCourse = scanner.nextLine();
        if (!newCourse.trim().isEmpty()) {
            student.setCourse(newCourse);
        }
        
        System.out.println("Student details updated successfully!");
        returnToMenu();
    }
    
    private void addGrades() {
        System.out.print("\nEnter student ID to add grades: ");
        String studentId = scanner.nextLine();
        
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student with ID " + studentId + " was not found!");
            returnToMenu();
            return;
        }
        
        if (student.getGradeCount() >= MAX_GRADES) {
            System.out.println("Maximum number of grades reached for this student!");
            returnToMenu();
            return;
        }
        
        System.out.println("Adding grades for student: " + student.getName());
        
        while (student.getGradeCount() < MAX_GRADES) {
            System.out.print("Enter grade (0-100) or 'stop' to finish: ");
            String input = scanner.nextLine();
            
            if ("stop".equalsIgnoreCase(input)) {
                break;
            }
            
            try {
                double grade = Double.parseDouble(input);
                if (grade >= 0 && grade <= 100) {
                    if (student.addGrade(grade)) {
                        System.out.println("Grade added successfully!");
                    } else {
                        System.out.println("Failed to add grade!");
                    }
                } else {
                    System.out.println("Grade must be between 0 and 100!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
        
        System.out.println("Grades processing completed!");
        returnToMenu();
    }
    
    private void deleteStudent() {
        System.out.print("\nEnter student ID to delete: ");
        String deleteId = scanner.nextLine();
        
        int index = -1;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(deleteId)) {
                index = i;
                break;
            }
        }
        
        if (index == -1) {
            System.out.println("Student with ID " + deleteId + " was not found!");
            returnToMenu();
            return;
        }
        
        System.out.print("Are you sure you want to delete student " + deleteId + "? (yes/no): ");
        String confirmation = scanner.nextLine();
        
        if ("yes".equalsIgnoreCase(confirmation)) {
            // Shift elements to remove the student
            for (int i = index; i < studentCount - 1; i++) {
                students[i] = students[i + 1];
            }
            students[studentCount - 1] = null;
            studentCount--;
            
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
        
        returnToMenu();
    }
    
    private void generateReport() {
        System.out.println("\nSTUDENT REPORT - 2025");
        System.out.println("====================");
        
        if (studentCount == 0) {
            System.out.println("No students registered.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println("Student " + (i + 1));
                students[i].displayDetails();
                System.out.println();
            }
            
            // Display statistics
            displayStatistics();
        }
        
        returnToMenu();
    }
    
    private void displayStatistics() {
        if (studentCount == 0) return;
        
        double totalAverage = 0;
        int studentsWithGrades = 0;
        
        for (int i = 0; i < studentCount; i++) {
            double avg = students[i].calculateAverage();
            if (students[i].getGradeCount() > 0) {
                totalAverage += avg;
                studentsWithGrades++;
            }
        }
        
        System.out.println("=== STATISTICS ===");
        System.out.println("Total students: " + studentCount);
        System.out.println("Students with grades: " + studentsWithGrades);
        
        if (studentsWithGrades > 0) {
            System.out.println("Overall average: " + String.format("%.2f", totalAverage / studentsWithGrades));
        }
    }
    
    private Student findStudentById(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }
    
    private void returnToMenu() {
        System.out.println("\nEnter (1) to return to menu or any other key to exit");
        
        String input = scanner.nextLine();
        if (!"1".equals(input)) {
            exitApplication();
        }
    }
    
    private void exitApplication() {
        System.out.println("Exiting Student Management System. Goodbye!");
        scanner.close();
        System.exit(0);
    }
}
