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
public class Emailer {
    
    private String recipientName;
    private String recipientEmail;
    
    private Account recipientAccount;
    
    public Emailer(){

    }
    
    public Emailer(Account account, String name, String email) throws Exception{
        
        this.recipientAccount = account;
        this.recipientName = getRecipientName(account);
        this.recipientEmail = getRecipientEmail(account);
 
    }    
    
    public void getRecipientName(Account anAccount) throws Exception{
        
        String tempName = (anAccount.getFirstName() + " " + anAccount.getLastName());
        this.recipientName = tempName;
        
    }
    
    public void getRecipientEmail(Account anAccount) throws Exception{
        
        this.recipientEmail = anAccount.getEmail();
        
    }
    
    public void sendEmail(){
        
        // todo
        
    }
}


