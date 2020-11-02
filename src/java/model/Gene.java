/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kalli
 */
public class Gene {
    
    private String geneID;
    private String geneSymbol;
    private String geneTitle;
    private String location;
    private String description;
    private String coordinates;

    public Gene() {
    }

    
    public Gene(String geneID, String geneSymbol, String geneTitle, String location, String description, String coordinates) {
        this.geneID = geneID;
        this.geneSymbol = geneSymbol;
        this.geneTitle = geneTitle;
        this.location = location;
        this.description = description;
        this.coordinates = coordinates;
    }

    public String getGeneID() {
        return geneID;
    }

    public void setGeneID(String geneID) {
        this.geneID = geneID;
    }

    public String getGeneSymbol() {
        return geneSymbol;
    }

    public void setGeneSymbol(String geneSymbol) {
        this.geneSymbol = geneSymbol;
    }

    public String getGeneTitle() {
        return geneTitle;
    }

    public void setGeneTitle(String geneTitle) {
        this.geneTitle = geneTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
    
    
}
