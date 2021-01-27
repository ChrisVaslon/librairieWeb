/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entites.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import outils.CustomedException;
import traitements.GestionClient;

/**
 *
 * @author Win 7
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
         response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        
          String urlJSP = "/WEB-INF/home.jsp";
        
          String email = request.getParameter("email");
          String password = request.getParameter("password");
          
        if (getServletContext().getAttribute("gestionClient") == null) {
        getServletContext().setAttribute("gestionClient", new GestionClient()); // " new GestionClient()" => GestionClient GC = new GestionClient()"
        }
        GestionClient gtClient = (GestionClient) getServletContext().getAttribute("gestionClient");
        
        try {
            Client user = gtClient.seConnecter(email, password);
            System.out.println(user);
            session.setAttribute("user", user);
            request.setAttribute("msgSuccess", "Bravo, vous êtes connecté " + user.getNom() + " !");
        } catch (CustomedException ex) {
           request.setAttribute("errLogin", ex.getMessage());
           HashMap<String, String> erreurs = ex.getErreurs();
           request.setAttribute("errMail", erreurs.get("errMail"));
           
           request.setAttribute("errPassword", erreurs.get("errPassword"));
           
           request.setAttribute("emailFourni", email);
           urlJSP = "/WEB-INF/login-form.jsp";
           
        } catch (SQLException ex) {
           System.out.println("erreur 02 sql :" + ex.getMessage());
        }
      getServletContext().getRequestDispatcher(urlJSP).include(request, response);
     
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
