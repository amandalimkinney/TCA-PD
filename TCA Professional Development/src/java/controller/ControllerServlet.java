package controller;

import session.CourseFacade;
import BusinessTierInterface.*;
import Data_Objects.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Access_Control.*;
import Data_Objects.*;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;

public class ControllerServlet extends HttpServlet {

    //Account currentAccount = new Account();
    BusinessTierFunctions funcs = new BusinessTierFunctions();
    @EJB
    CourseFacade courseFacade;
//    @Override
//    public void init() throws ServletException {
//
//        //this is called only once when application is deployed
//
//    }
    
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
            List<Access_control.Course> courselist = courseFacade.findAll();
            //request.setAttribute("categoryProducts", categoryProducts);
            //Course[] courseList = Course.getCurrentCourses();
            getServletContext().setAttribute("courseList", courselist);
            //instantiate list of courses

            //set this to servlet/app level
            //getServletContext().setAttribute("categories", obj here);
            
            
            userPath = "/teacher/courselist.jsp";

        // if cart page is requested
        } else if (userPath.equals("/teacher/addhours")) {
            // TODO: Implement cart page request

            userPath = "/teacher/addhours.jsp";
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
/*
        if (userPath.equals("/teacher/addhours")) {
            // TODO: check input, if false then say it is wrong / give error message; 
            //else send to database and give confirmation page
            if(request.getParameter("submit") == "true")
            {
                userPath = "teacher/addhours.jsp";
            }
            else
            {
                userPath = "/home/addhours.jsp";
            }
            //request.setAttribute("errormsg", "ERROR");
                        //request.getRequestDispatcher("teacher/addhours.jsp").forward(request, response);
//            try{
//                //TODO: fix this input for all things
//            DevelopmentHours newHours = new DevelopmentHours(request.getParameter("date"), 
//                    request.getParameter("numHours"), 
//                    request.getParameter("method"),
//                    //request.getParameter("hostOrg"),
//                    request.getParameter("location"),
//                    request.getParameter("type"),
//                    "");
//            userPath = "teacher/addhoursconfirmation.jsp";
//            
//                    }
//            catch(Exception e)
//                    {
//                        request.setAttribute("errormsg", e.toString());
//                        request.getRequestDispatcher("/login.jsp").forward(request, response);
//                    }
//            
//            
//                //userPath = "teacher/addhoursconfirmation.jsp";
//            }
            
} else */
            if (userPath.equals("/teacher/addhours.jsp-submit")) {
               
                userPath = "/teacher/addhours.jsp";
                if(request.getParameter("date").isEmpty() || request.getParameter("date").length()<10) {
                    request.setAttribute("errormsg", "Incorrect date format (mm/dd/yyyy).");
                }
                else if(request.getParameter("numHours").isEmpty()) {
                    request.setAttribute("errormsg", "Number of hours cannot be empty.");
                }
                else if(request.getParameter("method")== null) {
                    request.setAttribute("errormsg", "Please choose a method.");
                }
                else if(request.getParameter("hostOrg")== null) {
                    request.setAttribute("errormsg", "Please choose a host organization.");
                }
                else if(request.getParameter("location")== null) {
                    request.setAttribute("errormsg", "Please choose a location.");
                }
                else if(request.getParameter("type")== null) {
                    request.setAttribute("errormsg", "Please choose a type.");
                }
                else if(request.getParameter("topicName").isEmpty()) {
                    request.setAttribute("errormsg", "Topic cannot be empty.");
                }
            //getServletContext().setAttribute("errormsg", "ERROR");
                else {try{
                //TODO: fix this input for all things
            DevelopmentHours newHours = new DevelopmentHours(request.getParameter("date"), 
                    request.getParameter("numHours"), 
                    request.getParameter("method"),
                    request.getParameter("location"),
                    request.getParameter("type"),
                    request.getParameter("hostOrg"),
                    request.getParameter("topicName"));
            userPath = "teacher/addhoursconfirmation.jsp";
            
                    }
            catch(Exception e)
                    {
//                        request.setAttribute("date", request.getParameter("date"));
//                        request.setAttribute("numHours", request.getParameter("numHours"));
//                        request.setAttribute("method", request.getParameter("method"));
//                        request.setAttribute("location", request.getParameter("location"));
//                        request.setAttribute("type", request.getParameter("type"));
//                        request.setAttribute("hostOrg", request.getParameter("hostOrg"));
//                        request.setAttribute("topicName", request.getParameter("topicName"));
                        request.setAttribute("errormsg", e);
                        userPath = "/teacher/addhours.jsp";
                    }
                }
                        request.setAttribute("date", request.getParameter("date"));
                        request.setAttribute("numHours", request.getParameter("numHours"));
                        request.setAttribute("method", request.getParameter("method"));
                        request.setAttribute("location", request.getParameter("location"));
                        request.setAttribute("type", request.getParameter("type"));
                        request.setAttribute("hostOrg", request.getParameter("hostOrg"));
                        request.setAttribute("topicName", request.getParameter("topicName"));
                //userPath = "/teacher/addhours.jsp";
        } else if (userPath.equals("/teacher/courselist.jsp/signup")) {
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
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
