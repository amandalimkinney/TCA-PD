/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;

import Data_Objects.*;
import java.util.*;

/**
 *
 * @author Jeff
 */
public class DataAccess 
{
    public DataAccess()
    {
        
    }
    
    public static Account getAccount(String accountID)
    {
        if(accountID.equals("fer10293"))
        {
            return new Account(accountID,"Fred","Richards","Middle School","7","Science",new Date(2000,8,12));
        }
        if(accountID.equals("gef39482"))
        {
            return new Account(accountID,"Gretta","Fernando","Lower School","3","K - 4",new Date(2010,8,1));
        }
        if(accountID.equals("tud30495"))
        {
            return new Account(accountID,"Ted","Dabenport","High School","11","Math",new Date(2003,7,25));
        }
        if(accountID.equals("pqr03952"))
        {
            return new Account(accountID,"Pam","Rodriguez","High School","7","Science",new Date(1995,8,3));
        }
        if(accountID.equals("voh00947"))
        {
            return new Account(accountID,"Vicki","Hothstadder","Lower School","1","K - 4",new Date(2008,6,30));
        }
        if(accountID.equals("ali33024"))
        {
            return new Account(accountID,"Anderson","Ivanavich","Middle School","8","Science",new Date(1992,12,8));
        }
        if(accountID.equals("wkj86845"))
        {
            return new Account(accountID,"Wendy","Jacobs","High School","12","English",new Date(2000,8,12));
        }
        
        return null;
    }
    
    public static void addDevHours(DevelopmentHours devHours)
    {
        
    }
}
