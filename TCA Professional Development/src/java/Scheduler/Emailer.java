/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import Data_Objects.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author Erik
 */
public final class Emailer {
    
    private String[] recipientName;
    private String[] recipientEmail;  
    private Account[] recipientAccount;
    
    public Emailer(){

    }
    
    public Emailer(Account[] account) throws Exception{
        this.recipientAccount = account;
    }    
    
    public void setRecipientNames() throws Exception{
        for (int i = 0; i < recipientAccount.length; i++){
            this.recipientName[i] = (recipientAccount[i].getFirstName() + " " + recipientAccount[i].getLastName());
        }
    }
    
    public void setRecipientEmails() throws Exception{
        for (int j = 0; j < recipientAccount.length; j++){
            this.recipientEmail[j] = (recipientAccount[j].getEmail());
        }
    }
    
    public String[] getRecipientNames() throws Exception{
        return recipientName;
    }
    
    public String[] getRecipientEmail() throws Exception{
        return recipientEmail;
    }
    
    public void sendEmail(String subject, String bodyText){
        
        // First recipient email address
        String to = ("\"" + recipientName[0] + "\" <" + recipientEmail[0] + ">");
        String from = "noreply@TCA.org";
        String host = "localhost";
        
        // Set up system
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.user", "myuser");
        properties.setProperty("mail.password", "mypwd");        
        Session session = Session.getDefaultInstance(properties);

        try{
           // Create a default MimeMessage object.
           MimeMessage message = new MimeMessage(session);

           // Set From: header field of the header.
           message.setFrom(new InternetAddress(from));

           // Set To: header field of the header.
           message.addRecipient(Message.RecipientType.TO,
                                    new InternetAddress(to));
           
           if (recipientAccount.length > 1){
               for (int l = 1; l < recipientAccount.length; l++){
                 message.addRecipient(Message.RecipientType.TO, new
                   InternetAddress(("\"" + recipientName[1] + "\" <" + recipientEmail[1] + ">")));                 
               }
           }

           // Set Subject: header field
           message.setSubject(subject);

           // Now set the actual message
           message.setText(bodyText);

           // Send message
           Transport.send(message);

        }  catch (MessagingException e) {
               System.out.println("Error - Message not sent; " + e);
        }
     }
}