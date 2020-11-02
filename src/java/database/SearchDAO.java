/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assoc;
import model.Gene;
import model.Phenotype;

/**
 *
 * @author vasiliki
 */
public class SearchDAO {
    
    public static Vector<Gene> searchGenes(String searchtext) throws SQLException, ClassNotFoundException{
        Vector<Gene> vec = new Vector<Gene>();
        Gene gene;
        Connection con = Connector.getConnection();
        String sql = "SELECT * FROM A_GENE WHERE GENEID LIKE '%"+ searchtext +"%' OR GENESYMBOL LIKE '%"+ searchtext +"%' OR GENETITLE LIKE '%"+ searchtext +"%' OR LOCATION LIKE '%"+ searchtext +"%' OR DESCRIPTION LIKE '%"+ searchtext +"%' OR COORDINATES LIKE '%"+ searchtext +"%'";

        if(con != null){
            try{
                PreparedStatement statement = con.prepareStatement(sql);               
                ResultSet set = statement.executeQuery();
                while (set.next()){
                    gene = new Gene();
                    gene.setGeneID(set.getString("GENEID"));
                    gene.setGeneSymbol(set.getString("GENESYMBOL"));
                    gene.setGeneTitle(set.getString("GENETITLE"));
                    gene.setLocation(set.getString("LOCATION"));
                    gene.setDescription(set.getString("DESCRIPTION"));
                    gene.setCoordinates(set.getString("COORDINATES"));   
                    vec.add(gene);
                }
                set.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GeneDAO.class.getName()).log(Level.SEVERE, null, ex);   
                }
                for(Gene g:vec){
                    System.out.println(g.getGeneID());
                }
                return vec;
            }
        }        
        return null;
    } 
    
    public static Vector<Phenotype> searchPhenotypes(String searchtext) throws SQLException, ClassNotFoundException {

        Vector<Phenotype> vec = new Vector<Phenotype>();
        Phenotype phenotype;
        Connection con = Connector.getConnection();
        String sql = "SELECT * FROM A_PHENOTYPE WHERE PHENOTYPEID LIKE '%"+ searchtext +"%' OR PHENOTYPETITLE LIKE '%"+ searchtext +"%' OR DESCRIPTION LIKE '%"+ searchtext +"%' OR PHENTEXT LIKE '%"+ searchtext +"%'";
        if (con != null) {

            try {
                PreparedStatement statement = con.prepareStatement(sql);
                ResultSet set = statement.executeQuery();
                while(set.next()){
                    phenotype = new Phenotype();
                    phenotype.setPhenotypeID(set.getString("PHENOTYPEID"));
                    phenotype.setPhenotypeTitle(set.getString("PHENOTYPETITLE"));
                    phenotype.setPhentext(set.getString("PHENTEXT"));
                    phenotype.setDescription(set.getString("DESCRIPTION"));
                    vec.add(phenotype);                   
                    
                }
                set.close();

            }catch(SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhenotypeDAO.class.getName()).log(Level.SEVERE, null, ex);   
                }
                for(Phenotype p:vec){
                    System.out.println(p.getPhenotypeID());
                }
                return vec; 
            }
            
            
        }
        return null;
    }
    
      public static Vector<Assoc> searchAsso(String searchtext) throws SQLException, ClassNotFoundException{
        Vector<Assoc> vec = new Vector<Assoc>();
        Assoc assoc;
        Connection con = Connector.getConnection();
        String sql = "SELECT * FROM A_PHENOGENEASSOC WHERE PHENO LIKE '%"+ searchtext +"%' OR GENE LIKE '%"+ searchtext +"%' OR PHENOTITLE LIKE '%"+ searchtext +"%' OR INHERITANCE LIKE '%"+ searchtext + "%'";
        if(con != null){
            try{
                PreparedStatement statement = con.prepareStatement(sql);               
                ResultSet set = statement.executeQuery();
                while (set.next()){
                    assoc = new Assoc();
                    assoc.setGeneID(set.getString("GENE"));
                    assoc.setPhenoID(set.getString("PHENO"));
                    assoc.setPhenoTitle(set.getString("PHENOTITLE"));
                    assoc.setInheritance(set.getString("INHERITANCE"));
                    assoc.setMappingKey(set.getInt("PHENOTYPEMAPPINGKEY"));  
                    vec.add(assoc);
                }
                set.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GeneDAO.class.getName()).log(Level.SEVERE, null, ex);   
                }
                for(Assoc a:vec){
                    System.out.println(a.getGeneID());
                }
                return vec;
            }
        }        
        return null;
    } 
    
    
    
    
    
    
}
