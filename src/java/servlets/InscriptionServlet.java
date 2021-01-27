/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription"})
public class InscriptionServlet extends HttpServlet {

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

        //todo algo
        String email = request.getParameter("email");
        email = email.trim();
        String nom = request.getParameter("nom");
        nom = nom.trim();
        String prenom = request.getParameter("prenom");
        prenom = prenom.trim();
        String pwd = request.getParameter("pwd");

        String pwd2 = request.getParameter("pwd2");

        if (getServletContext().getAttribute("gestionClient") == null) {
            getServletContext().setAttribute("gestionClient", new GestionClient()); // " new GestionClient()" => GestionClient GC = new GestionClient()"
        }
        GestionClient gtClient = (GestionClient) getServletContext().getAttribute("gestionClient");
        try {
            gtClient.creerNouveauClient(nom, prenom, email, pwd, pwd2);
            request.setAttribute("msgSuccess", "Inscription reussi");

        } catch (CustomedException ex) {
            //message erreur
            HashMap<String, String> erreurs = ex.getErreurs();
            String message = ex.getMessage();
            System.out.println(message);
            request.setAttribute("msg", message);
            //maladroit
            request.setAttribute("errPwd", erreurs.get("errPwd"));
            request.setAttribute("errMail", erreurs.get("errMail"));

            //recup de la saisie user
            request.setAttribute("nom", nom);
            request.setAttribute("prenom", prenom);
            request.setAttribute("email", email);

            urlJSP = "/WEB-INF/inscription-form.jsp";

        } catch (SQLException ex) {
            System.out.println(">>>>>>>>> erreur debug 01 : " + ex.getMessage());
        }

        System.out.println(">>>>>>>>>>>> URL JSP :" + urlJSP);
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
