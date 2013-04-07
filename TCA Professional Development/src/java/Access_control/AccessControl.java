/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Access_Control;

import Data_Objects.*;
import Data_Access.*;

/**
 *
 * @author Jeff
 */
public class AccessControl 
{
    private String accountID;
    private String[][] powers;
    
    
    private AccessControl()
    {
    }
    
    public boolean logIn(String userName,String password)
    {
        //if(ActiveDicrectory.validateCredentials(userName,password))
        //{
            //accountID = DataAccess.getAccountIDFromUN(userName);
            //powers = DataAccess.getPowers(accountID);
            return true;
        //}
        //return false;
    }
    
    public boolean hasPower(String requestedPower)
    {
        String[] splitRequest = requestedPower.split(":");
        
        int index = 0;
        
        for(index = 0;index < powers.length;index++)
        {
            if(splitRequest[0] == powers[index][0])
            {
                if(splitRequest.length > 1 )
                {
                    for(int i = 0;i < powers[index].length;i++)
                    {
                        if(splitRequest[1] == powers[index][i] || powers[index][i] == "ALL" ||(powers[index][i] == "SELF" && splitRequest[1] == accountID))
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    return true;
                }
                
            }
        }
        return false;
    }
}
