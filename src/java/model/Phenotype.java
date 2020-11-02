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
public class Phenotype {

    private String phenotypeID;
    private String phenotypeTitle;
    private String description;
    private String phentext;

    public Phenotype(String phenotypeID, String phenotypeTitle, String description, String phentext) {
        this.phenotypeID = phenotypeID;
        this.phenotypeTitle = phenotypeTitle;
        this.description = description;
        this.phentext = phentext;
    }

    public Phenotype() {
    }

    public String getPhenotypeID() {
        return phenotypeID;
    }

    public void setPhenotypeID(String phenotypeID) {
        this.phenotypeID = phenotypeID;
    }

    public String getPhenotypeTitle() {
        return phenotypeTitle;
    }

    public void setPhenotypeTitle(String phenotypeTitle) {
        this.phenotypeTitle = phenotypeTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhentext() {
        return phentext;
    }

    public void setPhentext(String phentext) {
        this.phentext = phentext;
    }
    
    
}
