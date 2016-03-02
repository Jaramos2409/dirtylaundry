/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webappbeans.User;
import webapputils.UserUtils;
import webapputils.AuthUtils;

/**
 *
 * @author nk5946
 */
@WebServlet(name = "SaveServlet", urlPatterns = {"/SaveServlet"})
public class SaveServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        User mainuser = new User();
        mainuser.setEmail(request.getParameter("email"));
        mainuser.setFirstname(request.getParameter("firstname"));
        mainuser.setLastname(request.getParameter("lastname"));
        mainuser.setPassword(request.getParameter("password"));
        mainuser.setId(Integer.parseInt(request.getParameter("id")));
        mainuser.setCity(request.getParameter("city"));
        mainuser.setBirthday(request.getParameter("birthday"));
        mainuser.setEthnicity(request.getParameter("ethnicity"));
        mainuser.setEducation(request.getParameter("education"));
        mainuser.setOccupation(request.getParameter("occupation"));
        mainuser.setRelationship(request.getParameter("relationship"));
        mainuser.setPhone(request.getParameter("phone"));
        mainuser.setGender(request.getParameter("gender"));
        mainuser.setState(request.getParameter("state"));
        mainuser.setAbout(request.getParameter("about"));
        
        UserUtils.updateUser(mainuser);
        
        mainuser = UserUtils.validateUser(request.getParameter("email"), request.getParameter("password"));
        
        String url ="";
        
        HttpSession session = request.getSession();
        session.setAttribute("user", mainuser);
        
        url = "/details.jsp";
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SaveServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SaveServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
