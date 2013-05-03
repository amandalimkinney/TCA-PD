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
import java.security.*;

/**
 *
 * @author Erik
 */
    public class LoginServlet extends HttpServlet {

        
        
        
        public void processRequest(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, java.io.IOException {

            /*try
            {
                String username;
                String password;
                username = request.getParameter("j_username").toString();
                password = request.getParameter("j_password").toString();
                request.login(username, password);
                response.sendRedirect("/home/index.jsp");
            } 
            catch (Exception e) 
            {
                response.sendRedirect("loginerror.jsp");
            }    
                 /*UserBean user = new UserBean();
                 user.setUserName(request.getParameter("sUserName"));
                 user.setPassword(request.getParameter("sPwd"));
                 
                 HttpSession session = request.getSession(true);
                 
                 session.setAttribute("currentSessionUser",user); 
                 response.sendRedirect("index.jsp"); //logged-in page 
                 
                 /*user = UserDAO.login(user);

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
            }*/
        }
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, java.io.IOException {
/*
            try
            {
                String username;
                String password;
                username = request.getParameter("j_username").toString();
                password = request.getParameter("j_password").toString();
                request.setAttribute("Repost", "False"); 
                request.login(username, password);
                //response.sendRedirect("/SecureMessageWebInterface/");
            } 
            catch (Exception e) 
            {
                response.sendRedirect("loginerror.jsp");
            }    
                 /*UserBean user = new UserBean();
                 user.setUserName(request.getParameter("sUserName"));
                 user.setPassword(request.getParameter("sPwd"));
                 
                 HttpSession session = request.getSession(true);
                 
                 session.setAttribute("currentSessionUser",user); 
                 response.sendRedirect("index.jsp"); //logged-in page 
                 
                 /*user = UserDAO.login(user);

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
            }*/
        }
        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, java.io.IOException {
            try
            {
                String username;
                String password;
                username = request.getParameter("j_username").toString();
                password = request.getParameter("j_password").toString();
                request.login(username, password);
                response.sendRedirect("/TCA_Professional_Development/home/index.jsp");
            } 
            catch (Exception e) 
            {
                response.sendRedirect("/TCA_Professional_Development/home/login.jsp?ERROR=Log-in Failed");
            }    
                 /*UserBean user = new UserBean();
                 user.setUserName(request.getParameter("sUserName"));
                 user.setPassword(request.getParameter("sPwd"));
                 
                 HttpSession session = request.getSession(true);
                 
                 session.setAttribute("currentSessionUser",user); 
                 response.sendRedirect("index.jsp"); //logged-in page 
                 
                 /*user = UserDAO.login(user);

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
            }*/
        }
    } 
