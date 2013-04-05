
package Data_Objects;

import java.util.*;
import Data_Access.*;

public class Account 
{
    private String 
        accountID,
        firstName,
        lastName,
        division,
        grade,
        subject;
    private Date hiredDate;
    private LinkedList<DevelopmentHours> devHours;
    
    public Account()
    {
        devHours = new LinkedList<DevelopmentHours>();
    }
    
    public Account(String accountID,String firstName,String lastName,String division,String grade,String subject,Date hiredDate)
    {
        super();
        setAccountID(accountID);
        setFirstName(firstName);
        setLastName(lastName);
        setDivision(division);
        setGrade(grade);
        setSubject(subject);
        setHiredDate(hiredDate);
    }
    
    public static Account getAccount(String accountID)
    {
        return DataAccess.getAccount(accountID);
    }
    
    public static Account[] getAccounts(String[] accountIDs)
    {
        Account[] accounts = new Account[accountIDs.length];
        for(int i=0;i<accountIDs.length;i++)
        {
            accounts[i] = DataAccess.getAccount(accountIDs[i]);
        }
        return accounts;
    }
    
    public void addDevHours(String date,String numHours,String method,String location,String type,String additionalComments) throws Exception
    {
        DevelopmentHours tempDevHours = new DevelopmentHours(date,numHours,method,location,type,additionalComments);
        DataAccess.addDevHours(tempDevHours);
        devHours.add(tempDevHours);
    }
    
    public LinkedList<DevelopmentHours> getDevHours()
    {
        return devHours;
    }
    
    public void setAccountID(String accountID){this.accountID = accountID;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setDivision(String division){this.division = division;}
    public void setGrade(String grade){this.grade = grade;}
    public void setSubject(String subject){this.subject = subject;}
    public void setHiredDate(Date hiredDate){this.hiredDate = hiredDate;}
    
    public String getAccountID(){return accountID;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getDivision(){return division;}
    public String getGrade(){return grade;}
    public String getSubject(){return subject;}
    public Date getHiredDate(){return hiredDate;}
            
}
