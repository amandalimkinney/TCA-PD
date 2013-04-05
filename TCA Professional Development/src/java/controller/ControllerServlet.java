package controller;

import java.io.IOException;
import java.lang.String;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequestWrapper;
import Access_Control.*;
import Data_Objects.*;

/**
 *
 * @author Panda
 */
//@WebServlet(name = "ControllerServlet", 
//        loadOnStartup = 1,
//        urlPatterns = {"/courselist, /addhours"})
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
        if (userPath.equals("/courselist")) {
            // TODO: Implement category request

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
        String url = "/WEB-INF/view" + userPath + ".jsp";

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
        // if addToCart action is called
        if (userPath.equals("/teacher/addhours.jsp/submit")) {
            
            try
            {
            currentAccount.addDevHours(request.getParameter("date"),
                request.getParameter("numHours"),
                request.getParameter("method"),
                request.getParameter("location"),
                request.getParameter("type"),
                request.getParameter("TEXT"));
            
            }
            catch(Exception e)
            {   
                
                //request.setAttribute("ERROR", "Unable to add Hours");
            }
            response.sendRedirect("/TCA_Professional_Development/teacher/addhours.jsp?ERROR=Unable To Add Hours");
             //request.getRequestDispatcher("/teacher/addhours.jsp").forward(request, response);
            // TODO: addhours button - check input, if false then say it is wrong / give error message; 
            //else send to database and give confirmation page
            
            //check input
            
            //return error (bad input)
            
            //return confirmation (successfully added)
            
            //userPath = "teacher/addhoursconfirmation.jsp";

        // if updateCart action is called
        } else if (userPath.equals("/updateCart")) {
            // TODO: Implement update cart action

        // if purchase action is called
        } else if (userPath.equals("/purchase")) {
            // TODO: Implement purchase action

            userPath = "/confirmation";
        } else if (userPath.equals("/purchase"))
        {
            
        }

        // use RequestDispatcher to forward request internally
        //String url = "/WEB-INF/view" + userPath + ".jsp";
        String url = userPath;
        try {
            //request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}