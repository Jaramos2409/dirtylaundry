/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webappbeans.User;
import webapputils.SearchUtils;

/**
 *
 * @author EVA Unit 02
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

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
        
        String action = request.getParameter("action");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String birthday = request.getParameter("birthday");
        String ethnicity = request.getParameter("ethnicity");
        String education = request.getParameter("education");
        String occupation = request.getParameter("occupation");
        String relationship = request.getParameter("relationship");
        String phone = request.getParameter("phone");
        String url = "";
        
        List<User> results = new ArrayList<>();
        
        
        if (null != action && action.equals("load"))
        {
            url = "/search.jsp";
        }
        else if (null!=action && action.equals("search"))
        {
            if(firstname.isEmpty() 
                    && lastname.isEmpty() 
                    && gender.isEmpty()
                    && email.isEmpty()
                    && city.isEmpty()
                    && state.isEmpty()
                    && birthday.isEmpty()
                    && ethnicity.isEmpty()
                    && education.isEmpty()
                    && occupation.isEmpty()
                    && relationship.isEmpty()
                    && phone.isEmpty())
            {
                url = "/sorrysearch.jsp";
            } 
            else
            {
                results = SearchUtils.getSearchResults(firstname, lastname, gender, email, city, state, birthday,
                        ethnicity, education, occupation, relationship, phone);
                if (results.isEmpty())
                {
                    url = "/nosearchresults.jsp";
                }
                else
                {
                    url = "/searchresult.jsp";
                }
            }
        }
        
        request.setAttribute("results", results);
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
