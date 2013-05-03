/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Access_control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
 
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
        try
        {
            Message msg = new MimeMessage(mailSession);
            msg.setSubject("Hello World!");
            msg.setRecipient(RecipientType.TO, new InternetAddress(
              "jiffall@gmail.com", "czetsuya 2"));
            msg.setFrom(new InternetAddress("jiffall@gmail.com", "jeff"));

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hello World!.");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            msg.setContent(multipart);

            Transport.send(msg);
            
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
                response.sendRedirect("/TCA_Professional_Development/home/RegisterAccount.jsp?ERROR=\"" + errorMessage + "\"");
            }
            else
            {
                response.sendRedirect("/TCA_Professional_Development/home/login.jsp?ERROR=Account Successfully Created");
            }
        }
        catch(Exception e)
        {
            String errorMessage = e.getMessage();
            response.sendRedirect("/TCA_Professional_Development/home/RegisterAccount.jsp?ERROR=\"" + errorMessage + "\"");
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
