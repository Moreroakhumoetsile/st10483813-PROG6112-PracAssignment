package com.mycompany.tvseriesapplication;

import java.util.ArrayList;
import java.util.Scanner;

public class SeriesManagement extends SeriesModel{
    private ArrayList<SeriesModel> seriesList;
    private Scanner keyboard;
    
    public SeriesManagement() {
        seriesList = new ArrayList<>();
        keyboard = new Scanner(System.in);
    }
    
    public void startApplication() {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = keyboard.nextLine();
        if ("1".equals(input)) {
            displayMenu();
        } else {
            exitSeriesApplication();
        }
    }
    
    private void displayMenu() {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            
            String choice = keyboard.nextLine();
            
            switch (choice) {
                case "1":
                    captureSeries();
                    break;
                case "2":
                    searchSeries();
                    break;
                case "3":
                    updateSeries();
                    break;
                case "4":
                    deleteSeries();
                    break;
                case "5":
                    seriesReport();
                    break;
                case "6":
                    exitSeriesApplication();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    public void captureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES");
        System.out.println("***************");
        
        System.out.print("Enter the series id: ");
        String seriesId = keyboard.nextLine();
        
        System.out.print("Enter the series name: ");
        String seriesName = keyboard.nextLine();
        
        String seriesAge;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            seriesAge = keyboard.nextLine();
            
            try {
                int age = Integer.parseInt(seriesAge);
                if (age >= 2 && age <= 18) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            }
        }
        
        System.out.print("Enter the number of episodes for " + seriesName + ": ");
        String seriesNumberOfEpisodes = keyboard.nextLine();
        
        SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes);
        seriesList.add(newSeries);
        
        System.out.println("Series processed successfully!!!");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = keyboard.nextLine();
        if (!"1".equals(input)) {
            exitSeriesApplication();
        }
    }
    
    public void searchSeries() {
        System.out.print("\nEnter the series id to search: ");
        String searchId = keyboard.nextLine();
        
        boolean found = false;
        for (SeriesModel series : seriesList) {
            if (series.getId().equals(searchId)) {
                series.displayDetails();
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("---");
            System.out.println("Series with Series Id: " + searchId + " was not found!");
            System.out.println("---");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = keyboard.nextLine();
        if (!"1".equals(input)) {
            exitSeriesApplication();
        }
    }
    
    public void updateSeries() {
        System.out.print("\nEnter the series id to update: ");
        String updateId = keyboard.nextLine();
        
        boolean found = false;
        for (SeriesModel series : seriesList) {
            if (series.getId().equals(updateId)) {
                System.out.print("Enter the series name: ");
                String newName = keyboard.nextLine();
                series.setName(newName);
                
                String newAge;
                while (true) {
                    System.out.print("Enter the age restrictions: ");
                    newAge = keyboard.nextLine();
                    
                    try {
                        int age = Integer.parseInt(newAge);
                        if (age >= 2 && age <= 18) {
                            break;
                        } else {
                            System.out.println("You have entered an incorrect series age!!!");
                            System.out.print("Please re-enter the series age >> ");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("You have entered an incorrect series age!!!");
                        System.out.print("Please re-enter the series age >> ");
                    }
                }
                series.setAgeRestriction(newAge);
                
                System.out.print("Enter the number of episodes: ");
                String newEpisodes = keyboard.nextLine();
                series.setNumberOfEpisodes(newEpisodes);
                
                System.out.println("Series updated successfully!");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Series with ID " + updateId + " not found!");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = keyboard.nextLine();
        if (!"1".equals(input)) {
            exitSeriesApplication();
        }
    }
    
    public void deleteSeries() {
        System.out.print("\nEnter the series id to delete: ");
        String deleteId = keyboard.nextLine();
        
        boolean found = false;
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getId().equals(deleteId)) {
                System.out.print("Are you sure you want to delete series " + deleteId + " from the system? Yes (y) to delete: ");
                String confirm = keyboard.nextLine();
                
                if ("y".equalsIgnoreCase(confirm)) {
                    seriesList.remove(i);
                    System.out.println("---");
                    System.out.println("Series with Series Id: " + deleteId + " successfully deleted!");
                    System.out.println("---");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Series with ID " + deleteId + " not found!");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = keyboard.nextLine();
        if (!"1".equals(input)) {
            exitSeriesApplication();
        }
    }
    
    public void seriesReport() {
        System.out.println("\nSERIES REPORT - 2025");
        
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        } else {
            for (int i = 0; i < seriesList.size(); i++) {
                System.out.println("Series " + (i + 1));
                seriesList.get(i).displayDetails();
            }
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = keyboard.nextLine();
        if (!"1".equals(input)) {
            exitSeriesApplication();
        }
    }
    
    public void exitSeriesApplication() {
        System.out.println("Exiting application. Goodbye!");
        keyboard.close();
        System.exit(0);
    }
}