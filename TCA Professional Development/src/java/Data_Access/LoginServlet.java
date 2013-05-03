/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;

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

            
        }
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, java.io.IOException {

        }
        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, java.io.IOException {
            try
            {
                request.getSession().removeAttribute("currentSessionUser");
                request.getSession().invalidate();
                
                request.logout();
                
                String username;
                String password;
                username = request.getParameter("j_username").toString();
                password = request.getParameter("j_password").toString();
                request.login(username, password);
                String[] groups = AccountManagement.getAccountGroups(username);
                String groupString = "";
                for(int i = 0; i < groups.length;i++ )
                {
                    groupString+=groups[i]+":";
                }
                request.getSession().setAttribute("Groups", groupString);
                response.sendRedirect("/TCA_Professional_Development/home/index.jsp");
            } 
            catch (Exception e) 
            {
                response.sendRedirect("/TCA_Professional_Development/home/login.jsp?ERROR=Log-in Failed");
            }    
                
        }
    } 
