package controller;

import Data_Objects.Course;
import Data_Objects.Teacher;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.AttendanceFacade;
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
    @EJB
    AttendanceFacade attendancefacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        if (userPath.equals("/instructor/attendance")) {
            List<Course> courses = coursefacade.findInstructorCourses();
            getServletContext().setAttribute("courses", courses);
            userPath = "/instructor/attendanceFind.jsp";
        
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
        if (userPath.equals("/instructor/attendance2")) {
            String courseId = request.getParameter("courseId");
            int id = Integer.parseInt(courseId);
            
            List<Teacher> attendees = signupqueue.getAttendees(id);
            getServletContext().setAttribute("attendees", attendees);
            getServletContext().setAttribute("courseId", id);
            
            //TODO find past attendance already recorded
            

            userPath = "/instructor/attendanceTake.jsp";
        }
        else if(userPath.equals("/instructor/attendanceSubmit")) 
        {
            //get course id first
            String id = request.getParameter("courseId");
            int courseId = Integer.parseInt(id);
            
            String[] attendees = request.getParameterValues("attendance");
            attendancefacade.takeAttendance(attendees, courseId);
            
            userPath = "/instructor/attendanceConfirm.jsp";
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
