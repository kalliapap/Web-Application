/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Connector;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kalli
 */
public class AdminInsertServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       /* response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminInsertServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminInsertServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
            String item = (String)request.getParameter("it");
            Connection con = null;
            PreparedStatement statement = null;
            String message = null;
            if(item.equals("1")){
                System.out.println("Insert Gene!");
                String geneID = request.getParameter("gid");
                String symbol = request.getParameter("symbol");
                String title = request.getParameter("title");
                String location = request.getParameter("location");
                String description = request.getParameter("description");
                String coord = request.getParameter("coordinates");
                try{
                    String sql = "INSERT INTO A_GENE(GENEID,GENESYMBOL,GENETITLE,LOCATION,DESCRIPTION,COORDINATES)VALUES(?,?,?,?,?,?)";
                    con = Connector.getConnection();
                    statement = con.prepareStatement(sql);
                    statement.setString(1,geneID);
                    statement.setString(2,symbol);
                    statement.setString(3,title);
                    statement.setString(4,location);
                    statement.setString(5,description);
                    statement.setString(6,coord);
                    statement.executeUpdate();
                    message = "Insertion of Gene '"+geneID+"' completed succesfully.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                    
                } catch (SQLException ex) {
                    System.out.println("yparxei hdh to id");
                    message = "GeneId is already exists!Try Update Gene instead.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminInsertServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(item.equals("2")){
                System.out.println("Insert Phenotype!");
                String pheno = request.getParameter("pid");
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                String text = request.getParameter("text");
                try{
                    String sql = "INSERT INTO A_PHENOTYPE(PHENOTYPEID,PHENOTYPETITLE,DESCRIPTION,PHENTEXT)"
                            + "VALUES(?,?,?,?)";
                    con = Connector.getConnection();
                    statement = con.prepareStatement(sql);
                    statement.setString(1,pheno);
                    statement.setString(2,title);
                    statement.setString(3,description);
                    statement.setString(4,text);
                    statement.executeUpdate();
                    System.out.println("ola kala");
                    message = "Insertion of Phenotype '"+pheno+"' completed succesfully.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                    
                } catch (SQLException ex) {
                    System.out.println("yparxei hdh to id");
                    message = "PhenotypeID is already exists!Try Update Phenotype instead."+ex.toString();
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminInsertServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(item.equals("3")){
                System.out.println("Insert Association!");
                String pheno = request.getParameter("pid");
                String gid = request.getParameter("gid");
                String phentitle = request.getParameter("title");
                String inheritance = request.getParameter("inheritance");
                String mappingKey = request.getParameter("mapKey");
                try{
                    String sql = "INSERT INTO A_PHENOGENEASSOC(PHENO,GENE,PHENOTITLE,INHERITANCE,PHENOTYPEMAPPINGKEY)"
                            + "VALUES(?,?,?,?,?)";
                    con = Connector.getConnection();
                    statement = con.prepareStatement(sql);
                    statement.setString(1,pheno);
                    statement.setString(2,gid);
                    statement.setString(3,phentitle);
                    statement.setString(4,inheritance);
                    statement.setString(5,mappingKey);
                    statement.executeUpdate();
                    System.out.println("ola kala");
                    message = "Insertion of Association '"+pheno+", '"+gid+"' completed succesfully.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                    
                } catch (SQLException ex) {
                    if(ex.getErrorCode() == -20001){
                        message = "Cannot insert association! Foreign key violation.";
                    }else{
                        message="Unexpected error! "+ex.getMessage();
                    }
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminInsertServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(item.equals("4")){
                System.out.println("Create User!");
                String email = request.getParameter("email");
                String psw1 = request.getParameter("psw1");
                String psw2 = request.getParameter("psw2");
                String role = request.getParameter("role");
                if(!psw1.equals(psw2)){
                    message = "Passwords don't match! Please, try again.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                }else{
                    try{
                        String sql = "INSERT INTO USERS(EMAIL,PASSWORD_,ROLE_)"
                                + "VALUES(?,?,?)";
                        con = Connector.getConnection();
                        statement = con.prepareStatement(sql);
                        statement.setString(1,email);
                        statement.setString(2,psw1);
                        statement.setString(3,role);
                        statement.executeUpdate();
                        System.out.println("ola kala");
                        message = "User created succesfully.";
                        request.getSession().setAttribute("message", message);
                        response.sendRedirect("MessagePage.jsp");

                    } catch (SQLException ex) {
                        message = "User already exists!"+ex.getMessage();
                        request.getSession().setAttribute("message", message);
                        response.sendRedirect("MessagePage.jsp");

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AdminInsertServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
