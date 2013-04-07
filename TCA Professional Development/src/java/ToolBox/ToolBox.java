/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox;
/**
 *
 * @author Jeff
 */
import java.util.*;

public class ToolBox 
{
    private ToolBox(){}
    
    public static Calendar ConvertStringToDate(String dateToConvert) throws Exception
    {
        // The String to split in the form "MM-DD-YYYY"
        String[] splitDate = dateToConvert.split("-");

        // Use this to set the correct time zone
        String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);        
        
        // And if it fails throw an exception
        if (ids.length == 0){
            throw new Exception("Could not parse Time Zone information from the server.");
        }

        // create a Central Standard Time time zone
        SimpleTimeZone cst = new SimpleTimeZone(-6 * 60 * 60 * 1000, ids[0]); 
        
         // set up rules for daylight savings time
        cst.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
        cst.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
        
        try
        {
        // create a GregorianCalendar with the Central Standard Time zone
        // and the date specified for the course. 

        Calendar courseDate = new GregorianCalendar(cst);
        courseDate.set(Integer.parseInt(splitDate[2]),(Integer.parseInt(splitDate[0])),Integer.parseInt(splitDate[1]));
        return courseDate;
        }
        catch(Exception e)
        {
            throw new Exception("Invalid Date Format");
        }
    }
}
