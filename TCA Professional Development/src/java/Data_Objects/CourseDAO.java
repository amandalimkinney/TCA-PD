/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Objects;

/**
 *
 * @author Erik
 */
import java.text.*;
import java.util.*;
import java.sql.*;

public class CourseDAO 	
{
      static Connection currentCon = null;
      static ResultSet rs = null;  
	
      /**
     *
     * @param bean
     * @return
     */
    public static String[] fetchFromType(CourseBean bean) {
	
         String[] forOutput = new String[100];
         
         //preparing some objects for connection 
         Statement stmt = null;    
	
         String courseType = bean.getType();
	    
         String searchQuery;
         searchQuery = "select * from courses where type=\'"
                                 + courseType
                                 + "\'";
	    
      // "System.out.println" prints in the console; Normally used to trace the process
      System.out.println("Your course type is " + courseType);          
      System.out.println("Query: "+searchQuery);
	    
      try 
      {
         //connect to DB 
         currentCon = ConnectionManager.getConnection();
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);	
         int k = 0;

         while (rs.next() && !rs.isLast()){
             System.out.println("We pulled one row.");
             forOutput[k] = "stuff";
         }
      } 

      catch (Exception ex) 
      {
         System.out.println("Query DB failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
      }

return forOutput;
	
      }	
   }

