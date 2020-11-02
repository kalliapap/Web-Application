/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.AssocDAO;
import database.Connector;
import database.GeneDAO;
import database.PhenotypeDAO;
import database.UserDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Assoc;
import model.Gene;
import model.Phenotype;
import model.User;

/**
 *
 * @author kalli
 */
public class AdminDeleteServlet extends HttpServlet {

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
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminDeleteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminDeleteServlet at " + request.getContextPath() + "</h1>");
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
                System.out.println("Delete Gene!");
                String geneID = request.getParameter("gid");
            try {
                Gene gene = GeneDAO.getGeneByName(geneID);
                if(gene != null){
                    String sql = "DELETE FROM A_GENE WHERE GENEID=?";
                    con = Connector.getConnection();
                    statement = con.prepareStatement(sql);
                    statement.setString(1,geneID);
                    statement.executeUpdate();
                    message = "Deletion of '"+geneID+"' completed succesfully.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                }else{
                    message = "Deletion failed. GeneID doesn't exist!";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            }else if(item.equals("2")){
                System.out.println("Delete Phenotype!");
                String pid = request.getParameter("pid");
            try {
                Phenotype pheno = PhenotypeDAO.getPhenotypeByName(pid);
                if(pheno != null){
                    String sql = "DELETE FROM A_PHENOTYPE WHERE PHENOTYPEID=?";
                    con = Connector.getConnection();
                    statement = con.prepareStatement(sql);
                    statement.setString(1,pid);
                    statement.executeUpdate();
                    message = "Deletion of '"+pid+"' completed succesfully.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                    
                }else{
                    message = "Deletion failed. PhenotypeID doesn't exist!";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else if(item.equals("3")){
                    System.out.println("Delete Association!");
                    String pid = request.getParameter("pid");
                    String gid = request.getParameter("gid");
                    String title = request.getParameter("title");
                try {
                    System.out.println("tets");
                    Assoc assoc = AssocDAO.getAssoc(pid, gid, title);
                    if(assoc != null ){
                        System.out.println("mphka if");
                        String sql = "DELETE FROM A_PHENOGENEASSOC WHERE PHENO=? AND GENE=? AND PHENOTITLE=?";
                        con = Connector.getConnection();
                        statement = con.prepareStatement(sql);
                        statement.setString(1,pid);
                        statement.setString(2,gid);
                        statement.setString(3, title);
                        statement.executeUpdate();
                        message = "Deletion of association between phenotype '"+pid+"' and gene '"+gid+"' completed succesfully.";
                        request.getSession().setAttribute("message", message);
                        response.sendRedirect("MessagePage.jsp");
                    }else{
                        System.out.println("mphka else");
                        message = "Deletion failed. Association doesn't exist!";
                        request.getSession().setAttribute("message", message);
                        response.sendRedirect("MessagePage.jsp");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                    Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(item.equals("4")){
                System.out.println("Delete User!");
                String email = request.getParameter("email");
            try {
                User user = UserDAO.getUser(email);
                if(user != null){
                    String sql = "DELETE FROM USERS WHERE EMAIL=?";
                    con = Connector.getConnection();
                    statement = con.prepareStatement(sql);
                    statement.setString(1,email);
                    statement.executeUpdate();
                    System.out.println("exists");
                    message = "Deletion of user '"+email+"' completed succesfully.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                }else{
                    System.out.println("doesnt exist");
                    message = "Deletion failed. User doesn't exist!";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
