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
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Gene;
//import org.apache.catalina.connector.Connector;

/*
 * @author kalli
 */
public class GeneDAO {
    
    public static Gene getGeneByName(String name) throws SQLException, ClassNotFoundException{
        Gene gene = null;
        Connection con = Connector.getConnection();
        //String sql = "SELECT * FROM A_GENE";
        String sql = "SELECT * FROM A_GENE WHERE GENEID = ?";
        if(con != null){
            try{
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,name);                
                ResultSet set = statement.executeQuery();
                if(set.next()){                   
                    System.out.println("bika if oti exw");
                    gene = new Gene();
                    gene.setGeneID(set.getString("GENEID"));
                    gene.setGeneSymbol(set.getString("GENESYMBOL"));
                    gene.setGeneTitle(set.getString("GENETITLE"));
                    gene.setLocation(set.getString("LOCATION"));
                    gene.setDescription(set.getString("DESCRIPTION"));
                    gene.setCoordinates(set.getString("COORDINATES"));                    
                }
            }catch(SQLException ex){
                Logger.getLogger(GeneDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GeneDAO.class.getName()).log(Level.SEVERE, null, ex);   
                }
                if(gene!=null)
                    System.out.println("connected epistrefw not null gene me "+gene.getGeneTitle());
                if(gene==null)
                    System.out.println("connected epistrefw null gene");
                
                return gene;
            }
        }        
           if(gene!=null)
                    System.out.println("not connected epistrefw not null gene me "+gene.getGeneTitle());
                if(gene==null)
                    System.out.println("not connected  epistrefw null gene");
        return null;
    }       
    
    public static Vector<Gene> getAllGenes() throws SQLException, ClassNotFoundException{
        Vector<Gene> vec = new Vector<Gene>();
        Gene gene;
        Connection con = Connector.getConnection();
        String sql = "SELECT * FROM A_GENE";
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
    
    public static void insertGene(Gene gene) throws SQLException, ClassNotFoundException{
        String sql=null;
        Connection con = null;
        try {
            con = Connector.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gene check = GeneDAO.getGeneByName(gene.getGeneID());
        if(check == null){
            sql = "INSERT INTO A_GENE(GENEID,GENESYMBOL,GENETITLE,LOCATION,DESCRIPTION,COORDINATES) VALUES('"
                +gene.getGeneID()+"','"+gene.getGeneSymbol()+"','"+gene.getGeneTitle()+"','"+gene.getLocation()
                +"','"+gene.getDescription()+"','"+gene.getCoordinates()+"'";
        }else{
            System.out.println("Gene Already Exists!Try Update Gene.");
            System.exit(-1); // edw prepei na petaei mhnuma sto xrhsth
        }
        if(con != null){
            try{
                Statement statement = con.createStatement();               
                statement.executeUpdate(sql);
                
            }catch(SQLException ex){
                Logger.getLogger(GeneDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GeneDAO.class.getName()).log(Level.SEVERE, null, ex);   
                }
                if(gene!=null)
                    System.out.println("connected epistrefw not null gene me "+gene.getGeneTitle());
                if(gene==null)
                    System.out.println("connected epistrefw null gene");
                
               
            }
        }        
           if(gene!=null)
                    System.out.println("not connected epistrefw not null gene me "+gene.getGeneTitle());
                if(gene==null)
                    System.out.println("not connected  epistrefw null gene");
        
    }
}
