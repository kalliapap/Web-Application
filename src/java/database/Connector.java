/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author kalli
 */
public class Connector {
    
    private static final String url = "jdbc:derby://localhost";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String name = "database";
    private static final String username = null;
    private static final String password = null;
    private static final int port = 1527;
    private static DataSource dataSource = null;
    
   public static Connection getConnection() throws SQLException, ClassNotFoundException{
        //String info = url+":1527/database"+username+password;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url+":"+port+"/"+name,username,password);
    }
    
  /* static {
        try {
            Class.forName(DRIVER);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {

            Context context = new InitialContext();
            Context envctx = (Context)context.lookup("java:comp/env");
            dataSource = (DataSource) envctx.lookup("jdbc/database");
        }
        catch (NamingException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection()
    {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            return conn;
        }
    }
    public static Connection getConnectionFromPool()
    {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            return conn;
        }
    }*/
}
