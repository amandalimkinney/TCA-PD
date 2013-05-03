/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.naming.NamingException;

/**
 *
 * @author Jeff
 */
public class RegisterAccountServlet extends HttpServlet {

    @Resource(name = "tca/mail")
 private Session mailSession;
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
        String userPath = request.getServletPath();
        if (userPath.equals("/home/RegisterAccount.jsp--submit")) 
        {
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
                response.sendRedirect("/TCA_Professional_Development/home/RegisterAccount.jsp?ERROR=" + errorMessage);
            }
            else
            {
                response.sendRedirect("/TCA_Professional_Development/home/login.jsp?ERROR=Account Successfully Created");
            }
        }
        catch(Exception e)
        {
            String errorMessage = e.getMessage();
            response.sendRedirect("/TCA_Professional_Development/home/RegisterAccount.jsp?ERROR=" + errorMessage);
        }
    }
        else if(userPath.equals("/admin/editaccount.jsp--submit"))
        {
            int i = 0;
            String[][] input;
            String[][] roles;
            while(request.getParameter("firstName" + i) != null)
            {
                i++;
            }
            roles = new String[i][];
            input = new String[i][5];
            for(int j = 0; j<i;j++)
            {
                input[j][0] = request.getParameter("firstName" + j);
                input[j][1] = request.getParameter("lastName" + j);
                input[j][2] = request.getParameter("email" + j);
                roles[j] = request.getParameterValues("Role" + j);
                input[j][3] = request.getParameter("delete" + j);
            }
            
            AccountManagement.updateAccounts(input,roles,request.getUserPrincipal().getName());
            
            response.sendRedirect("/TCA_Professional_Development/admin/editaccount.jsp");
        }
        else if(userPath.equals("/home/resetPassword.jsp--submit"))
        {
            
            
            try
            {
                AccountManagement.resetPasswordStep1(request.getParameter("j_username"));
                response.sendRedirect("/TCA_Professional_Development/home/resetPassword.jsp?USER=" + request.getParameter("j_username"));
            }
            catch(Exception e)
            {
                response.sendRedirect("/TCA_Professional_Development/home/resetPassword.jsp?ERROR=" + e.getMessage());
            }
        }
        else if(userPath.equals("/home/resetPassword.jsp--submit2"))
        {
            try
            {
                response.sendRedirect("/TCA_Professional_Development/home/login.jsp?ERROR="+AccountManagement.resetPasswordStep2(request.getParameter("username"),request.getParameter("code")));
            }
            catch(Exception e)
            {
                response.sendRedirect("/TCA_Professional_Development/home/login.jsp?ERROR=" + e.getMessage());
            }
        }
        else if(userPath.equals("/home/changepassword.jsp--submit"))
        {
            try
            {
                response.sendRedirect("/TCA_Professional_Development/home/changepassword.jsp?ERROR="+AccountManagement.changePassword(request.getUserPrincipal().toString(),request.getParameter("password"),request.getParameter("password1"),request.getParameter("password2")));
            }
            catch(Exception e)
            {
                response.sendRedirect("/TCA_Professional_Development/home/changepassword.jsp?ERROR=" + e.getMessage());
            }
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
