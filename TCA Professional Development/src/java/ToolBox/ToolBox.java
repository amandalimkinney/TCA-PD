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
    
    public static Date ConvertStringToDate(String dateToConvert) throws Exception
    {
        String[] splitDate = dateToConvert.split("-");
        try
        {
            return new Date(Integer.parseInt(splitDate[0]),Integer.parseInt(splitDate[2]),Integer.parseInt(splitDate[1]));
        }
        catch(Exception e)
        {
            throw new Exception("Invalid Date Format");
        }
    }
}
