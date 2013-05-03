/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;

import java.sql.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.security.*;

import java.util.Random;
import javax.annotation.Resource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Jeff
 */
public class AccountManagement 
{
    private static String[] resetAttempt;
    private static String hashPassword(String password) throws Exception
    {
        char[] HEX = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        MessageDigest MD = MessageDigest.getInstance("SHA-256");
        MD.reset();
        byte[] bytes = password.getBytes();
        byte[] digested =MD.digest(bytes);
        StringBuilder sb = new StringBuilder( 2 * digested.length );
        for(int i = 0;i < digested.length;i++)
        {
            int low = (int)(digested[i] & 0x0f);
            int high = (int)((digested[i] & 0xf0) >> 4);
            sb.append(HEX[high]);
            sb.append(HEX[low]);
        }
        return sb.toString();
    }
    
    public static String generatePassword()
    {
        Random rand = new Random();
        int length = rand.nextInt(4) + 8;
        String password = "";
        for(int i = 0; i < length; i ++)
        {
            int current = rand.nextInt(62);
            if(current < 10)
            {
                password += "" + current;
            }
            else if(current < 36)
            {
                password += (char)(current + 55);
            }
            else
            {
                password += (char)(current + 61);
            }     
        }
        return password;
                
    }
    
    public static String resetPasswordStep1(String username)  throws Exception
    {
        if(!username.equalsIgnoreCase("root"))
        {
        resetAttempt = new String[2];
        resetAttempt[0] = username;
        resetAttempt[1] = generatePassword();
        
        String[] temp = getAccount(username);
        
        if(temp != null)
        {
            if(temp[2].equals(username))
            {
                Scheduler.Emailer.sendResetCode(username, temp[0], temp[1], resetAttempt[1]);
                return username;
            }
            else
            {
                resetAttempt = null;
                throw new Exception("Invalid Account");
            }
        }
        }
        else
        {
            throw new Exception("Invalid Account");
        }
        return "";
    }
    
    public static String resetPasswordStep2(String username,String code) throws Exception
    {
        String errorMessage="";
        if(resetAttempt != null)
        {
        if(resetAttempt[0].equals(username) && resetAttempt[1].equals(code))
        {
            String newPassword = generatePassword();
            String[] temp = getAccount(username);
            Scheduler.Emailer.sendResetPassword(username, temp[0], temp[1], newPassword);
            String query = "";
            Connection conn = null;
            Statement stmt = null;
            try
            {
                query = "update account SET password='"+hashPassword(newPassword)+"' where username='"+username+"';";
                InitialContext ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup("jdbc/TCADB");
                conn = ds.getConnection();
                stmt = conn.createStatement();
                stmt.execute(query);
            }
            catch(Exception e)
            {
                errorMessage += e.getMessage() + "\n";
                resetAttempt = null;
                throw new Exception("Unable to Reset Password");
            }
            finally
            {
                try{conn.close();}catch(Exception e){errorMessage += e.getMessage() + "\n";}
                try{stmt.close();}catch(Exception e){errorMessage += e.getMessage() + "\n";}
                conn = null;
                stmt = null;
            }
        }
        else
        {
            resetAttempt = null;
            throw new Exception("Invalid Username and/or Code");
        }
        }
        else
        {
            resetAttempt = null;
            throw new Exception("Invalid Username and/or Code");
        }
        
        
        resetAttempt = null;
        return "Your New Password Has Been Sent to Your E-Mail";
    }
    
    public static String[] getAccount(String userName)  throws Exception
    {
        ResultSet results = null;
        Connection conn = null;
        Statement stmt = null;
        String[] toReturn = null;
        try
            {
                InitialContext ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup("jdbc/TCADB");
                conn = ds.getConnection();
                stmt = conn.createStatement();
                results = stmt.executeQuery("Select firstname,lastname,username from tca.account where username = '"+userName+"'");
                int i = 0;
                if(results.last())
                {
                    toReturn = new String[4];
                    results.first();
                    do
                    {
                        if(results.getObject(1) != null)
                        {
                            toReturn[0] = results.getObject(1).toString();
                        }
                        else
                        {
                            toReturn[0] = "";
                        }
                        if(results.getObject(2) != null)
                        {
                            toReturn[1] = results.getObject(2).toString();
                        }
                        else
                        {
                            toReturn[1] = "";
                        }
                        if(results.getObject(3) != null)
                        {
                            toReturn[2] = results.getObject(3).toString();
                        }
                        else
                        {
                            toReturn[2] = "";
                        }
                        i++;
                    }while(results.next() && i < 200);
                }
            }
            catch(Exception e)
            {
                throw e;
            }
            finally
            {
                try{conn.close();}catch(Exception e){}
                try{stmt.close();}catch(Exception e){}
                conn = null;
               
            }
        return toReturn;
    }
    
    
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
                String query = "Select UserName from tca.account where username = '" + email + "'";
                ResultSet results = stmt.executeQuery(query);
                if(!results.first())
                {
                    stmt.execute("Insert into account (UserName,PassWord,G,FirstName,LastName) "
                        + "Values('" + email
                        + "','" + hashPassword(password1)
                        + "','" + "default"
                        + "','" + firstName
                        + "','" + lastName
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
    
    public static String[][] getAccounts()
    {
        ResultSet results = null;
        Connection conn = null;
        Statement stmt = null;
        String[][] toReturn = null;
        try
            {
                InitialContext ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup("jdbc/TCADB");
                conn = ds.getConnection();
                stmt = conn.createStatement();
                results = stmt.executeQuery("Select firstname,lastname,username from tca.account where username != 'root' order by username");
                int i = 0;
                if(results.last())
                {
                    toReturn = new String[results.getRow()][4];
                    results.first();
                    do
                    {
                        if(results.getObject(1) != null)
                        {
                            toReturn[i][0] = results.getObject(1).toString();
                        }
                        else
                        {
                            toReturn[i][0] = "";
                        }
                        if(results.getObject(2) != null)
                        {
                            toReturn[i][1] = results.getObject(2).toString();
                        }
                        else
                        {
                            toReturn[i][1] = "";
                        }
                        if(results.getObject(3) != null)
                        {
                            toReturn[i][2] = results.getObject(3).toString();
                        }
                        else
                        {
                            toReturn[i][2] = "";
                        }
                        i++;
                    }while(results.next() && i < 200);
                }
            }
            catch(Exception e)
            {
                int i =0;
            }
            finally
            {
                try{conn.close();}catch(Exception e){}
                try{stmt.close();}catch(Exception e){}
                conn = null;
               
            }
        return toReturn;
    }
    
    public static String[] getAccountGroups(String username)
    {
        ResultSet results = null;
        Connection conn = null;
        Statement stmt = null;
        String[] toReturn = null;
        try
            {
                InitialContext ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup("jdbc/TCADB");
                conn = ds.getConnection();
                stmt = conn.createStatement();
                results = stmt.executeQuery("Select group from tca.groups where username = '"+username+"'");
                int i = 0;
                if(results.last())
                {
                    toReturn = new String[results.getRow()];
                    results.first();
                    do
                    {
                        if(results.getObject(1) != null)
                        {
                            toReturn[i] = results.getObject(1).toString();
                        }
                        else
                        {
                            toReturn[i] = "";
                        }
                        i++;
                    }while(results.next() && i < 200);
                }
            }
            catch(Exception e)
            {
                int i =0;
            }
            finally
            {
                try{conn.close();}catch(Exception e){}
                try{stmt.close();}catch(Exception e){}
                conn = null;
               
            }
        return toReturn;
    }
    
    public static String[][] getAccountsGroups()
    {
        ResultSet results = null;
        Connection conn = null;
        Statement stmt = null;
        String[][] toReturn = null;
        try
            {
                InitialContext ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup("jdbc/TCADB");
                conn = ds.getConnection();
                stmt = conn.createStatement();
                results = stmt.executeQuery("Select username,group from tca.groups where username != 'root' order by username");
                int i = 0;
                if(results.last())
                {
                    toReturn = new String[results.getRow()][4];
                    results.first();
                    do
                    {
                        if(results.getObject(1) != null)
                        {
                            toReturn[i][0] = results.getObject(1).toString();
                        }
                        else
                        {
                            toReturn[i][0] = "";
                        }
                        if(results.getObject(2) != null)
                        {
                            toReturn[i][1] = results.getObject(2).toString();
                        }
                        else
                        {
                            toReturn[i][1] = "";
                        }
                        i++;
                    }while(results.next() && i < 200);
                }
            }
            catch(Exception e)
            {
                int i =0;
            }
            finally
            {
                try{conn.close();}catch(Exception e){}
                try{stmt.close();}catch(Exception e){}
                conn = null;
               
            }
        return toReturn;
    }
    
    public static String changeAccount(String[] input,String username)
    {
        String errorMessage="";
        String query = "";
        if(username.equals(input[2]))
        {
            
            Connection conn = null;
            Statement stmt = null;
            try
            {
                query = "update account SET firstname='"+input[0]+"',lastname='"+input[1]+"', password='"+hashPassword(input[2])+"' where username='"+input[2]+"';";
                InitialContext ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup("jdbc/TCADB");
                conn = ds.getConnection();
                stmt = conn.createStatement();
                stmt.execute(query);
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
    
    public static String updateAccounts(String[][] input,String username)
    {
        String errorMessage="";
        String query = "";
        for(int i = 0 ; i<input.length;i++)
        {
            if(!username.equals(input[i][2]))
            {
                if(input[i][4] != null)
                {
                    query = "delete from account where username='"+input[i][2]+"';delete from groups where username='"+input[i][2]+"'";
                }
                else
                {
                    query = "update account SET firstname='"+input[i][0]+"',lastname='"+input[i][1]+"' where username='"+input[i][2]+"';";//need to add group table
                }
                Connection conn = null;
                Statement stmt = null;
                try
                {
                    InitialContext ctx = new InitialContext();
                    DataSource ds = (DataSource)ctx.lookup("jdbc/TCADB");
                    conn = ds.getConnection();
                    stmt = conn.createStatement();
                    stmt.execute(query);
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
