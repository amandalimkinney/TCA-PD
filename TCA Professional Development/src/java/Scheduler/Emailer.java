/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import Data_Access.Account;
import Data_Objects.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

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
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Erik
 */
public class Emailer {
    
    
    public static void sendResetPassword(String to,String firstName,String lastName,String pw) throws Exception
    {
        try
        {
            InitialContext ic = new InitialContext();
            Session mailSession = (Session)ic.lookup("tca/mail");
            Message msg = new MimeMessage(mailSession);
            msg.setSubject("New Password");
            msg.setRecipient(RecipientType.TO, new InternetAddress(to, firstName + " " + lastName));
            msg.setFrom(new InternetAddress("jiffall@gmail.com", "Jeff"));

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(pw);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            msg.setContent(multipart);

            Transport.send(msg);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
    public static void sendResetCode(String to,String firstName,String lastName,String code) throws Exception
    {
        try
        {
            InitialContext ic = new InitialContext();
            Session mailSession = (Session)ic.lookup("tca/mail");
            Message msg = new MimeMessage(mailSession);
            msg.setSubject("Password Reset Request");
            msg.setRecipient(RecipientType.TO, new InternetAddress(to, firstName + " " + lastName));
            msg.setFrom(new InternetAddress("TCAUtility@gmail.com", "TCA System"));

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("We have recieved a request to reset your password. Please use the following code to reset your password\n"+code);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            msg.setContent(multipart);

            Transport.send(msg);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}