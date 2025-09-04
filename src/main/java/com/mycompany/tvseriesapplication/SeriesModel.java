/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesapplication;

/**
 *
 * @author lab_services_student
 */


public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private String seriesAge;
    private String seriesNumberOfEpisodes;
    
    public SeriesModel() {}
    
    public SeriesModel(String seriesId, String seriesName, String seriesAge, String seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
    
    // Getter methods
    public String getId() { 
        return seriesId; 
    }
    
    public String getName() { 
        return seriesName; 
    }
    
    public String getAgeRestriction() { 
        return seriesAge; 
    }
    
    public String getNumberOfEpisodes() { 
        return seriesNumberOfEpisodes; 
    }
    
    // Setter methods
    public void setId(String seriesId) { 
        this.seriesId = seriesId; 
    }
    
    public void setName(String seriesName) { 
        this.seriesName = seriesName; 
    }
    
    public void setAgeRestriction(String seriesAge) { 
        this.seriesAge = seriesAge; 
    }
    
    public void setNumberOfEpisodes(String seriesNumberOfEpisodes) { 
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes; 
    }
    
    public void displayDetails() {
        System.out.println("--- ---");
        System.out.println("SERIES ID: " + seriesId);
        System.out.println("SERIES NAME: " + seriesName);
        System.out.println("SERIES AGE RESTRICTION: " + seriesAge);
        System.out.println("NUMBER OF EPISODES: " + seriesNumberOfEpisodes);
        System.out.println("--- ---");
    }
}
    
