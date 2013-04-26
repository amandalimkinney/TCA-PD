/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Access_control;

import java.sql.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Jeff
 */
public class AccountManagement 
{
    public static String registerAccount(String firstName,String lastName,String email,String password1,String password2)
    {
        String[] errors = new String[5];
        
        errors[0] = checkName(firstName);
        errors[1] = checkName(lastName);
        errors[2] = checkEmail(email);
        errors[3] = checkPassword(password1);
        errors[4] = checkPassword(password2);
        String errorMessage = "";
        if(errors[0] != "")
        {
            errorMessage += "First Name " + errors[0] + "\n";
        }
        if(errors[1] != "")
        {
            errorMessage += "Last Name " + errors[1] + "\n";
        }
        if(errors[2] != "")
        {
            errorMessage += "E-Mail " + errors[2] + "\n";
        }
        if(errors[3] != "")
        {
            errorMessage += "Password " + errors[3] + "\n";
        }
        if(errors[4] != "")
        {
            errorMessage += "Password " + errors[3] + "\n";
        }
        if(!password1.equals(password2))
        {
            errorMessage += "Passwords must match";
        }
        if(errorMessage.equals(""))
        {
            Connection conn = null;
            Statement stmt = null;
            try
            {
                InitialContext ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup("jdbc/TCADB");
                conn = ds.getConnection();
                stmt = conn.createStatement();
                ResultSet results = stmt.executeQuery("Select UN from Users where un = '" + email + "'");
                if(!results.first())
                {
                    stmt.execute("Insert into Users (UN,PW,G,FirstName,LastName,Email) "
                        + "Values('" + email
                        + "','" + password1
                        + "','" + "default"
                        + "','" + firstName
                        + "','" + lastName
                        + "','" + email
                        + "')");
                }
                else
                {
                    errorMessage += "E-mail Address all ready exists";
                }

            }
            catch(Exception e)
            {
                errorMessage += e.getMessage() + "\n";
            }
            finally
            {
                try{conn.close();}catch(Exception e){errorMessage += e.getMessage() + "\n";}
                try{stmt.close();}catch(Exception e){errorMessage += e.getMessage() + "\n";}
                conn = null;
                stmt = null;
            }
        }
        return errorMessage;
    }
    
    public static String checkName(String name)
    {
        if(name == null)
        {
            return " is blank";
        }
        else
        {
            for(int i=0;i<name.length();i++)
            {
                if((int)name.charAt(i)<65||(int)name.charAt(i)>122||((int)name.charAt(i)>90&&(int)name.charAt(i)<97))
                {
                    return " must only contain A-Z a-z";
                }
            }
        }
        return "";
    }
    
    public static String checkEmail(String email)
    {
        boolean foundAt = false;
        boolean foundDot = false;
        if(email == null)
        {
            return " is blank";
        }
        else
        {
            for(int i=0;i<email.length();i++)
            {
                if((int)email.charAt(i)<65||(int)email.charAt(i)>122||((int)email.charAt(i)>90&&(int)email.charAt(i)<97))
                {
                    if(email.charAt(i) != '@' && email.charAt(i) != '.')
                    {
                        return " must only contain A-Z,a-z,@ and .";
                    }
                }
                if(email.charAt(i) == '@')
                {
                    if(foundAt)
                    {
                        return "  must only contain one @";
                    }
                    else
                    {
                        foundAt = true;
                    }
                }
                if(email.charAt(i) == '.')
                {
                    
                    String[] tempSplit = email.split("^\\.$");
                    if(foundDot)
                    {
                        return " must only contain one .";
                    }
                    foundDot = true;
                }
            }
        }
        if(!foundAt)
        {
            return " must contain one @";
        }
        if(!foundDot)
        {
            return " must contain one .";
        }
        return "";
    }
    
    public static String checkPassword(String password)
    {
        if(password.length() < 8)
        {
            return " must be at least 8 characters";
        }
        return "";
    }
}
