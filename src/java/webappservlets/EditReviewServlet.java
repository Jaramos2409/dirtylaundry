/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webappbeans.Review;
import webapputils.ReviewUtils;

/**
 *
 * @author EVA Unit 02
 */
public class EditReviewServlet extends HttpServlet {

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
        String url = "";
        
        if (null != action && action.equals("load"))
        {
            url = "/editreview.jsp";
            
            Review review = ReviewUtils.retrieveSingleReview(Integer.parseInt(request.getParameter("reviewid")));
            
            request.getSession().setAttribute("review", review);
            request.setAttribute("review", review);
        }
        else if (null != action && action.equals("edit"))
        {
            Review review =  (Review) request.getSession().getAttribute("review");
            request.getSession().removeAttribute("review");
            
            review.setAgree_count(0);
            review.setDisagree_count(0);
            review.setReviewtext(request.getParameter("reviewtext"));
            
            if (ReviewUtils.update(review))
            {
                url = "/ViewReviewsServlet?action=load";
            }
            else
            {
                url = "/sorryedit.jsp";
            }
        }
        
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
