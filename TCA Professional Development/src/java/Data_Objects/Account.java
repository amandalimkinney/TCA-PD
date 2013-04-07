
package Data_Objects;

import java.util.*;
import Data_Access.*;
import Access_control.*;

public class Account 
{
    private String 
        accountID,
        firstName,
        lastName,
        division,
        grade,
        subject,
        email;
    private Calendar hiredDate;
    private LinkedList<DevelopmentHours> devHours;
    
    public Account()
    {
        devHours = new LinkedList<DevelopmentHours>();
    }
    
    public Account(String accountID,String email,String firstName,String lastName,String division,String grade,String subject,Calendar hiredDate)
    {
        super();
        setAccountID(accountID);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setDivision(division);
        setGrade(grade);
        setSubject(subject);
        setHiredDate(hiredDate);
    }
    
    public static Account getAccount(String accountID)
    {
        //if(AccessControl.hasPower("readAccount:" + accountID))
        //{
            //return DataAccess.getAccount(accountID);
        //}
        return null;
    }
    
    public static Account[] getAccounts(String[] accountIDs)
    {
        int maxIndex = 0;
        String[] tempIDs = new String[accountIDs.length];
        for(int i=0;i<accountIDs.length;i++)
        {
            if(AccessControl.hasPower("readAccount:"+accountIDs[i]))
            {
                tempIDs[maxIndex] = accountIDs[i];
                maxIndex++;
            }
        }
        
        Account[] accounts = new Account[maxIndex];
        for(int i=0;i<maxIndex;i++)
        {
            accounts[i] = DataAccess.getAccount(tempIDs[i]);
        }
        return accounts;
    }
    
    public void addDevHours(String date,String numHours,String method,String location,String type,String hostOrginization,String topic) throws Exception
    {
        //if(AccessControl.hasPower("addDevHours:" + accountID))
        //{
            DevelopmentHours tempDevHours = new DevelopmentHours(date,numHours,method,location,type,hostOrginization,topic);
            //DataAccess.addDevHours(tempDevHours,accountID);
            devHours.add(tempDevHours);
        //}
    }
    
    public LinkedList<DevelopmentHours> getDevHours()
    {
        return devHours;
    }
    
    public void setAccountID(String accountID){this.accountID = accountID;}
    public void setEmail(String email){this.email = email;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setDivision(String division){this.division = division;}
    public void setGrade(String grade){this.grade = grade;}
    public void setSubject(String subject){this.subject = subject;}
    public void setHiredDate(Calendar hiredDate){this.hiredDate = hiredDate;}
    
    
    public String getAccountID(){return accountID;}
    public String getEmail(){return email;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getDivision(){return division;}
    public String getGrade(){return grade;}
    public String getSubject(){return subject;}
    public Calendar getHiredDate(){return hiredDate;}
            
}
