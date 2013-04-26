/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Access_control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeff
 */
public class RegisterAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(true == true)
        {
            String temp = "";
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            String firstName = request.getParameter("firstName").toString();
            String lastName = request.getParameter("lastName").toString();
            String email = request.getParameter("email").toString();
            String password1 = request.getParameter("password1").toString();
            String password2 = request.getParameter("password2").toString();
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("email", email);
            request.setAttribute("password1", password1);
            request.setAttribute("password", password2);
            String errorMessage = AccountManagement.registerAccount(firstName, lastName, email, password1,password2);
            if(errorMessage!= "")
            {
                response.sendRedirect("/TCA_Professional_Development/home/RegisterAccount.jsp?ERROR=\"" + errorMessage + "\"");
            }
            else
            {
                response.sendRedirect("/TCA_Professional_Development/home/login.jsp?ERROR=Account Successfully Created");
            }
        }
        catch(Exception e)
        {
            String errorMessage = e.getMessage();
            response.sendRedirect("/TCA_Professional_Development/home/RegisterAccount.jsp?ERROR=\"" + errorMessage + "\"");
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
