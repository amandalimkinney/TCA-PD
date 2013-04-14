/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Objects;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erik
 */
    public class GetCourseServlet extends HttpServlet {


        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, java.io.IOException {
            
            PrintWriter pw = response.getWriter();
            response.setContentType("text/html");

            try
            {	 
                
                 CourseBean aClass = new CourseBean();
                 aClass.setType(request.getParameter("grandType"));

                 String[] output = CourseDAO.fetchFromType(aClass);

                 for (int i = 0; i < output.length; i++){
                     pw.println(output[i]);
                 }

            }
            
            catch (Throwable theException) 	    
            {
                 System.out.println(theException); 
            }
        }
    } 
