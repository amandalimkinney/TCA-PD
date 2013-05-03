package Data_Access;

import java.sql.*;
import java.util.Scanner;
import Data_Objects.*;
import java.util.*;
import java.sql.Statement;
import java.sql.SQLException;
public class DataAccess 
{
        static Connection conn = null;

        
        public static void main (String[] args) throws SQLException
        {
                try
                {
                    addHours(new DevelopmentHours("5-1-97","9","te3","test4","test5","test6","test7"),"7");
                }
                catch(Exception e)
                {
                    System.out.println("AddDevelopmentHours");
                }
                
        }
        public static void addHours(DevelopmentHours toAdd,String accountID)
        {
            String url = "jdbc:mysql://localhost:3307/";
            String dbName = "tca";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "Waheguru011";
               
                
            try
            {
                Class.forName(driver).newInstance();
                conn = DriverManager.getConnection(url+dbName, userName, password);
                System.out.println("Database connection established");
                String sqlStatement = "insert into development_hours (id,date,num_hours,method,location,host_organization,topic,type,teacher_id) "
                + "values('4','" + toAdd.getDate().get(1) +"/" + toAdd.getDate().get(2) + "/" + toAdd.getDate().get(3) +"','" + toAdd.getNumHours() + "','" + toAdd.getMethod() + "','" + toAdd.getLocation() + "','" + toAdd.getHostOrganization() + "','" + toAdd.getTopic() + "','" + toAdd.getType() + "','" + accountID +"')";
                
                Statement toRun = conn.createStatement();
                
                toRun.execute(sqlStatement);
                
                //toRun.executeQuery(sqlStatement);
            }
                
            catch (Exception e)
            {
                System.err.println("Cannot connect to database server");
            }
                
               finally
                {
                        if(conn != null)
                        {
                                try
                                {
                                       conn.close();
                                        System.out.println("Database connection terminated");
                               }
                                catch (Exception e)
                                {
                                        
                                }
                        }
               }
        }        }


