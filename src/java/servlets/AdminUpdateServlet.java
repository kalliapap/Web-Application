/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.AssocDAO;
import database.Connector;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.GeneDAO;
import database.PhenotypeDAO;
import database.UserDAO;
import model.Assoc;
import model.Gene;
import model.Phenotype;
import model.User;

/**
 *
 * @author vasiliki
 */
public class AdminUpdateServlet extends HttpServlet {

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
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminUpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminUpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } */
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

        String item = (String) request.getParameter("it");
        Connection con = null;
        PreparedStatement statement = null;
        String message = null;
        if (item.equals("1")) {
            System.out.println("Update Gene!");
            String geneID = request.getParameter("gid");
            String symbol = request.getParameter("symbol");
            String title = request.getParameter("title");
            String location = request.getParameter("location");
            String description = request.getParameter("description");
            String coord = request.getParameter("coordinates");
            try {
                String sql = "UPDATE A_GENE SET GENESYMBOL = ?, GENETITLE = ? ,LOCATION = ?, DESCRIPTION = ?, COORDINATES = ? WHERE GENEID = ?";
                con = Connector.getConnection();
                statement = con.prepareStatement(sql);
                Gene g = GeneDAO.getGeneByName(geneID);
                if (g != null) {
                    if (!symbol.isEmpty()) {
                        statement.setString(1, symbol);
                    } else {
                        symbol = g.getGeneSymbol();
                        statement.setString(1, symbol);
                    }

                    if (!title.isEmpty()) {
                        statement.setString(2, title);
                    } else {
                        title = g.getGeneTitle();
                        statement.setString(2, title);
                    }

                    if (!location.isEmpty()) {
                        statement.setString(3, location);
                    } else {
                        location = g.getLocation();
                        statement.setString(3, location);
                    }

                    if (!description.isEmpty()) {
                        statement.setString(4, description);
                    } else {
                        description = g.getDescription();
                        statement.setString(4, description);
                    }

                    if (!coord.isEmpty()) {
                        statement.setString(5, coord);
                    } else {
                        coord = g.getCoordinates();
                        statement.setString(5, coord);
                    }

                    statement.setString(6, geneID);
                    statement.executeUpdate();
                    message = "Update of Gene '" + geneID + "' completed succesfully.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                } else {
                    System.out.println("den uparxei to gonidio");
                    message = "This Gene does not exist! Try Insert Gene instead.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (item.equals("2")) {
            System.out.println("Update Phenotype!");
            String pheno = request.getParameter("pid");
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String text = request.getParameter("text");
            try {
                String sql = "UPDATE A_PHENOTYPE SET PHENOTYPETITLE = ?, DESCRIPTION = ?, PHENTEXT = ? WHERE PHENOTYPEID = ?";
                con = Connector.getConnection();
                statement = con.prepareStatement(sql);
                Phenotype p = PhenotypeDAO.getPhenotypeByName(pheno);
                if (p != null) {
                    if (!title.isEmpty()) {
                        statement.setString(1, title);
                    } else {
                        title = p.getPhenotypeTitle();
                        statement.setString(1, title);
                    }
                    if (!description.isEmpty()) {
                        statement.setString(2, description);
                    } else {
                        description = p.getDescription();
                        statement.setString(2, description);
                    }
                    if (!text.isEmpty()) {
                        statement.setString(3, text);
                    } else {
                        text = p.getPhentext();
                        statement.setString(3, text);
                    }

                    statement.setString(4, pheno);
                    statement.executeUpdate();
                    System.out.println("ola kala");
                    message = "Update of Phenotype '" + pheno + "' completed succesfully.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                } else {
                    System.out.println("den yparxei to id");
                    message = "PhenotypeID does not exist! Try Insert Phenotype instead. ";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                }

            } catch (SQLException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (item.equals("3")) {
            System.out.println("Update Association!");
            String pheno = request.getParameter("pid");
            String gid = request.getParameter("gid");
            String phentitle = request.getParameter("title");
            String inheritance = request.getParameter("inheritance");
            String mappingKey = request.getParameter("mapKey");
            try {
                String sql = "UPDATE A_PHENOGENEASSOC SET INHERITANCE = ?, PHENOTYPEMAPPINGKEY = ? WHERE PHENO = ? AND GENE = ? AND PHENOTITLE = ?";
                con = Connector.getConnection();
                statement = con.prepareStatement(sql);
                Assoc a = AssocDAO.getAssoc(pheno, gid, phentitle);
                if (a != null) {
                    if (!inheritance.isEmpty()) {
                        statement.setString(1, inheritance);
                    } else {
                        inheritance = a.getInheritance();
                        statement.setString(1, inheritance);
                    }

                    if (!mappingKey.isEmpty()) {
                        statement.setString(2, mappingKey);
                    } else {
                        mappingKey = String.valueOf(a.getMappingKey());
                        statement.setString(2, mappingKey);
                    }

                    statement.setString(1, inheritance);
                    statement.setString(2, mappingKey);
                    statement.setString(3, pheno);
                    statement.setString(4, gid);
                    statement.setString(5, phentitle);
                    statement.executeUpdate();
                    System.out.println("ola kala");
                    message = "Update of Association '" + pheno + ", '" + gid + "' completed succesfully.";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                } else {
                    System.out.println(" den yparxei ");
                    message = "Association does not exist! Try Insert Association instead. ";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("MessagePage.jsp");
                }

            } catch (SQLException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (item.equals("4")) {
            System.out.println("Update User!");
            String email = request.getParameter("pid");
            String password = request.getParameter("psw1");
            String cpassword = request.getParameter("psw2");
            String role = request.getParameter("role");
            if (password.equals(cpassword)) {
                try {
                    String sql = "UPDATE USERS SET PASSWORD_ = ?, ROLE_ = ? WHERE EMAIL = ?";
                    con = Connector.getConnection();
                    statement = con.prepareStatement(sql);
                    User u = UserDAO.getUser(email);
                    if (u != null) {
                        if (!password.isEmpty()) {
                            statement.setString(1, password);
                        } else {
                            password = u.getPsw();
                            statement.setString(1, password);
                        }
                        if (!role.isEmpty()) {
                            statement.setString(2, role);
                        } else {
                            role = u.getRole();
                            statement.setString(2, role);
                        }
                        statement.setString(3, email);
                        message = "Update of User '" + email + "' completed succesfully.";
                        request.getSession().setAttribute("message", message);
                        response.sendRedirect("MessagePage.jsp");
                    } else {
                        System.out.println(" den yparxei ");
                        message = "User does not exist! Try Create User instead. ";
                        request.getSession().setAttribute("message", message);
                        response.sendRedirect("MessagePage.jsp");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                message = "Password do not match!";
                request.getSession().setAttribute("message", message);
                response.sendRedirect("MessagePage.jsp");
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
