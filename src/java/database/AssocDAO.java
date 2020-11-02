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

/**
 *
 * @author kalli
 */
public class AssocDAO {
    
    public static Vector<Assoc> getAllAssoc() throws SQLException, ClassNotFoundException{
        Vector<Assoc> vec = new Vector<Assoc>();
        Assoc assoc;
        Connection con = Connector.getConnection();
        String sql = "SELECT * FROM A_PHENOGENEASSOC";
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
    public static Vector<Assoc> getAllAssocByGeneName(String name) throws SQLException, ClassNotFoundException{
        Vector<Assoc> vec = new Vector<Assoc>();
        Assoc assoc;
        Connection con = Connector.getConnection();
        String sql = "SELECT * FROM A_PHENOGENEASSOC WHERE GENE=?";
        if(con != null){
            try{
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,name);                
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
    
      public static Vector<Assoc> getAllAssocByPhenotypeName(String name) throws SQLException, ClassNotFoundException{
        Vector<Assoc> vec = new Vector<Assoc>();
        Assoc assoc;
        Connection con = Connector.getConnection();
        String sql = "SELECT * FROM A_PHENOGENEASSOC WHERE PHENO=?";
        if(con != null){
            try{
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,name);                
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
      
    public static Assoc getAssoc(String pid, String gid, String title) throws SQLException, ClassNotFoundException{
        Assoc assoc = null;
        Connection con = Connector.getConnection();
        System.out.println("mphka dao me "+pid+" "+gid+" "+title);
        String sql = "SELECT * FROM A_PHENOGENEASSOC WHERE PHENO=? AND GENE=? AND PHENOTITLE=?";
        if(con != null){
            try{
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,pid);   
                statement.setString(2,gid);  
                statement.setString(3,title);
                ResultSet set = statement.executeQuery();
                while (set.next()){
                    assoc = new Assoc();
                    assoc.setGeneID(set.getString("GENE"));
                    assoc.setPhenoID(set.getString("PHENO"));
                    assoc.setPhenoTitle(set.getString("PHENOTITLE"));
                    assoc.setInheritance(set.getString("INHERITANCE"));
                    assoc.setMappingKey(set.getInt("PHENOTYPEMAPPINGKEY"));  
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
                System.out.println("before returnwaghrs: "+assoc);
                if (assoc !=null)
                    return assoc;
                else 
                    return null;
            }
        }     
        System.out.println("before return: "+assoc);
        return null;
    } 
}
