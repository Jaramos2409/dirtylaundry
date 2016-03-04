/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappservlets;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webappbeans.User;


/**
 *
 * @author nk5946
 */
@WebServlet(name = "ConnectServlet", urlPatterns = {"/ConnectServlet"})
public class ConnectServlet extends HttpServlet {

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
        User user = (User) request.getSession().getAttribute("user");
        
        String action = request.getParameter("action");
        int modelid = parseInt(request.getParameter("modelId"));
        String url ="";
        int m = MapUtils.getModelByUser(user.getId());
        int u = MapUtils.getUserByModel(modelid);
        if(null !=action && action.equals("reserve"))
        {
            if(m == 0 && u == 0)
            {
                
                MapUtils.reserveCar(modelid, user.getId());
                url = "/thankyoureserve.jsp";
            }
            else
            {
                url = "/sorryreserve.jsp";
            }
        }
        
        else if (null!=action && action.equals("return"))
        {
            if(user.getId() == u)
            {
                MapUtils.returnCar(user.getId(), modelid); 
                url = "/thankyoureturn.jsp";
            }
            else if(user.getId() != u)
            {
                url = "/sorryreturn.jsp";
            }
        }
        
        System.out.println(u);
        System.out.println(url);
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
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
