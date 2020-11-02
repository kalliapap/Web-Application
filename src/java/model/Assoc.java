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
public class Assoc {
    
    private String phenoID;
    private String geneID;
    private String phenoTitle;
    private String inheritance;
    private int mappingKey;

    public Assoc() {
    }

    public String getPhenoID() {
        return phenoID;
    }

    public void setPhenoID(String phenoID) {
        this.phenoID = phenoID;
    }

    public String getGeneID() {
        return geneID;
    }

    public void setGeneID(String geneID) {
        this.geneID = geneID;
    }

    public String getPhenoTitle() {
        return phenoTitle;
    }

    public void setPhenoTitle(String phenoTitle) {
        this.phenoTitle = phenoTitle;
    }

    public String getInheritance() {
        return inheritance;
    }

    public void setInheritance(String inheritance) {
        this.inheritance = inheritance;
    }

    public int getMappingKey() {
        return mappingKey;
    }

    public void setMappingKey(int mappingKey) {
        this.mappingKey = mappingKey;
    }
    
    
}
