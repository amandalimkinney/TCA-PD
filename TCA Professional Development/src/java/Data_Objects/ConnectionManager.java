/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Objects;

import Access_control.*;
import java.sql.*;
import java.util.*;


public class ConnectionManager {

      static Connection con;
      static String url;
            
      public static Connection getConnection()
      {
        
         try
         {
            String urlx; 
            // assuming "DataSource" is your DataSource name
            //urlx = "jdbc:mysql://174.122.149.251:3306/lucindig_tca?zeroDateTimeBehavior=convertToNull";
            urlx = "jdbc:mysql://localhost:3306/tca?zeroDateTimeBehavior=convertToNull";

            Class.forName("com.mysql.jdbc.Driver");
            
            try
            {            	
               //con = DriverManager.getConnection(urlx,"lucindig_tca3","August2012!"); 
               con = DriverManager.getConnection(urlx,"root","");
               
            // assuming your SQL Server's	username is "username"               
            // and password is "password"
                 
            }
            
            catch (SQLException ex)
            {
               ex.printStackTrace();
            }
         }

         catch(ClassNotFoundException e)
         {
            System.out.println(e);
         }

      return con;
    }
}    
    

