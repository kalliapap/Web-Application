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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assoc;
import model.User;

/**
 *
 * @author kalli
 */
public class UserDAO {
    static Connection con = null;
    static ResultSet set = null; 
    
    public static User login(User user) throws SQLException, ClassNotFoundException{
        
        PreparedStatement statement = null;
        String email = user.getEmail();
        String psw = user.getPsw();
        //Connection con = Connector.getConnection();
        String sql = "SELECT * FROM USERS WHERE EMAIL= ? AND PASSWORD_ = ?";
            try{
                System.out.println("im here!!!!!!!");
                con = Connector.getConnection();
                statement = con.prepareStatement(sql);
                statement.setString(1,email);
                statement.setString(2,psw);
                set = statement.executeQuery();
                System.out.println("edwwwww");
                if(!set.next()){
                    System.out.println("Sorry, you are not registered!");
                    user.setExists(false);
                }
                else{
                    System.out.println("dao mphka na parw values apo vash");
                    user.setEmail(set.getString("EMAIL"));
                    user.setPsw(set.getString("PASSWORD_"));
                    user.setRole(set.getString("ROLE_"));
                    user.setExists(true);
                    System.out.println("Welcome "+user.getEmail());
                }
                
                
            }catch(SQLException e){
                e.printStackTrace();
            }finally {
                if(set != null){
                    try {
                        set.close();
                    } catch (Exception ex) {
                        Logger.getLogger(GeneDAO.class.getName()).log(Level.SEVERE, null, ex);   
                    }
                    set =null;
                }
                if(statement != null){
                    try{
                        statement.close();
                    }catch (Exception e) {} statement = null;
                }
                if(con!=null){
                    try{
                        con.close();
                    }catch(Exception e){}
                    con = null;
                }
            }
        System.out.println("before return: "+user.getEmail()+","+user.getPsw()+"."+user.exists);
        return user; 
    } 
         
    public static User getUser(String email) throws SQLException, ClassNotFoundException{
        User user = null;
        Connection con = Connector.getConnection();
       // System.out.println("mphka dao me "+pid+" "+gid+" "+title);
        String sql = "SELECT * FROM USERS WHERE EMAIL=?";
        if(con != null){
            try{
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,email);   
                ResultSet set = statement.executeQuery();
                while (set.next()){
                    user = new User();
                    user.setEmail(set.getString("EMAIL"));
                    user.setPsw(set.getString("PASSWORD_"));
                    user.setRole(set.getString("ROLE_"));
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
                System.out.println("before returnwaghrs: "+user);
                if (user !=null)
                    return user;
                else 
                    return null;
            }
        }     
        System.out.println("before return: "+user);
        return null;
    } 
    
}


