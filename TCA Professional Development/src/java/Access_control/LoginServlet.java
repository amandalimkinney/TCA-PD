/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Access_control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Erik
 */
    public class LoginServlet extends HttpServlet {


        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, java.io.IOException {

            try
            {	 
                
                 UserBean user = new UserBean();
                 user.setUserName(request.getParameter("sUserName"));
                 user.setPassword(request.getParameter("sPwd"));

                 user = UserDAO.login(user);

                 if (user.isValid())
                 {

                      HttpSession session = request.getSession(true);	    
                      session.setAttribute("currentSessionUser",user); 
                      response.sendRedirect("index.jsp"); //logged-in page      		
                 }

                 else 
                      response.sendRedirect("loginerror.jsp"); //error page 
            } 


            catch (Throwable theException) 	    
            {
                 System.out.println(theException); 
            }
        }
    } 
