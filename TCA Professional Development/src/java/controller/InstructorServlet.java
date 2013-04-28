package controller;

import Data_Objects.Course;
import Data_Objects.CourseSignupQueue;
import Data_Objects.Teacher;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CourseFacade;
import session.CourseSignupQueueFacade;

/**
 *
 * @author Panda
 */
public class InstructorServlet extends HttpServlet {
 /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    CourseFacade coursefacade;
    @EJB
    CourseSignupQueueFacade signupqueue;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        if (userPath.equals("/instructor/attendance")) {
            List<Course> courses = coursefacade.findInstructorCourses();
            getServletContext().setAttribute("courses", courses);
            userPath = "attendanceFind.jsp";
        
        } else if (userPath.equals("/teacher/attendance2")) {
            String courseId = request.getParameter("courseId");
            int id = Integer.parseInt(courseId);
            
            List<Teacher> attendees = signupqueue.getAttendees(id);
            getServletContext().setAttribute("attendees", attendees);
            
            //find past attendance already recorded
            

            userPath = "/instructor/attendanceTake.jsp";
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

            if (userPath.equals("/teacher/addhours.jsp-submit")) {
        } else if (userPath.equals("/teacher/viewcourselist-signup")) {
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
