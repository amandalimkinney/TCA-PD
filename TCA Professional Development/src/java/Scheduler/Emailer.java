/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import Data_Objects.*;
import java.util.*;

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
    
    public String getRecipientName(Account anAccount) throws Exception{
        String tempName = (anAccount.getFirstName() + " " + anAccount.getLastName());
        return tempName;
    }
    
    public String getRecipientEmail(Account anAccount) throws Exception{
        String tempEmail = anAccount.getEmail();  
        return tempEmail;
    }
    
    public void sendEmail(String message){
        for (int k = 0; k < recipientAccount.length; k++){
             //EMAIL: recipientEmail[k]
             //NAME: recipientName[k]
             //MESSAGE: message;
        }
        
    }
}


