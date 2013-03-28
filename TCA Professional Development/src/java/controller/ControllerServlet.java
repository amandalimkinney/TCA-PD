package controller;

import Data_Objects.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

    Account currentAccount = new Account();
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if category page is requested
        if (userPath.equals("/teacher/viewcourselist")) {
            // TODO: Implement category request
            
            //request.setAttribute("categoryProducts", categoryProducts);
            
            //instantiate list of courses

            //set this to servlet/app level
            //getServletContext().setAttribute("categories", obj here);
            
            
            userPath = "/teacher/courselist.jsp";

        // if cart page is requested
        } else if (userPath.equals("/viewCart")) {
            // TODO: Implement cart page request

            userPath = "/cart";

        // if checkout page is requested
        } else if (userPath.equals("/checkout")) {
            // TODO: Implement checkout page request

        // if user switches language
        } else if (userPath.equals("/chooseLanguage")) {
            // TODO: Implement language request

        }

        // use RequestDispatcher to forward request internally
        //String url = "/WEB-INF/view" + userPath + ".jsp";
        String url = userPath;
        
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        if (userPath.equals("/teacher/addhours.jsp/submit")) {
            // TODO: check input, if false then say it is wrong / give error message; 
            //else send to database and give confirmation page
            
            //check input
            String errMsg = currentAccount.checkDevHoursInput(request);
            //return error (bad input)
            if(errMsg != null)
            {
                //return error message
                //should display the same screen with same input
                //but display the error message at top, and show the field
                //userPath = 
            }
            
            //return confirmation (successfully added)
            else
            {
                currentAccount.addDevHours(new String[]{request.getParameter("date"),
                request.getParameter("numHours"),
                request.getParameter("method"),
                request.getParameter("location"),
                request.getParameter("type"),
                request.getParameter("TEXT")});
            
                //userPath = "teacher/addhoursconfirmation.jsp";
            }
            

        // if updateCart action is called
        } else if (userPath.equals("/teacher/courselist.jsp/signup")) {
            // TODO: Implement update cart action

        // if purchase action is called
        } else if (userPath.equals("/purchase")) {
            // TODO: Implement purchase action

            userPath = "/confirmation";
        }

        // use RequestDispatcher to forward request internally
        //String url = "/WEB-INF/view" + userPath + ".jsp";
        String url = userPath;

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}