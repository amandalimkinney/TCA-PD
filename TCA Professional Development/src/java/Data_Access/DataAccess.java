/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;

import Data_Objects.*;
import java.util.*;
import ToolBox.*;

/**
 *
 * @author Jeff
 */
public class DataAccess 
{
    public DataAccess()
    {
        
    }
    
    public static Account getAccount(String accountID) throws Exception
    {
        if(accountID.equals("fer10293"))
        {
            return new Account(accountID,"Fred","Richards","Middle School","7",
                "Science","fred@email.com",ToolBox.ConvertStringToDate("08-12-2000"));
        }
        if(accountID.equals("gef39482"))
        {
            return new Account(accountID,"Gretta","Fernando","Lower School","3",
                "K - 4","gretta@email.com",ToolBox.ConvertStringToDate("08-01-2010"));
        }
        if(accountID.equals("tud30495"))
        {
            return new Account(accountID,"Ted","Dabenport","High School","11",
                "Math","ted@email.com",ToolBox.ConvertStringToDate("07-25-2003"));
        }
        if(accountID.equals("pqr03952"))
        {
            return new Account(accountID,"Pam","Rodriguez","High School","7",
                "Science","pam@email.com",ToolBox.ConvertStringToDate("08-03-1995"));
        }
        if(accountID.equals("voh00947"))
        {
            return new Account(accountID,"Vicki","Hothstadder","Lower School",
                "1","K - 4","vicki@email.com",ToolBox.ConvertStringToDate("06-30-2008"));
        }
        if(accountID.equals("ali33024"))
        {
            return new Account(accountID,"Anderson","Ivanavich","Middle School",
                "8","Science","anderson@email.com",ToolBox.ConvertStringToDate("12-08-1992"));
        }
        if(accountID.equals("wkj86845"))
        {
            return new Account(accountID,"Wendy","Jacobs","High School","12",
                "English","wendy@email.com",ToolBox.ConvertStringToDate("08-12-2000"));
        }
        
        return null;
    }
    
    public static void addDevHours(DevelopmentHours devHours)
    {
        
    }
}
