/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Objects;

import ToolBox.*;
import java.util.*;
/**
 *
 * @author Jeff
 */
public class DevelopmentHours 
{
    private Calendar date;
    private int numHours;
    private String method,location,type,additionalComments,hostOrganization,topic;
    public DevelopmentHours()
    {
    }
    
    public DevelopmentHours(String date,String numHours,String method,String location,String type,String hostOrganization,String topic) throws Exception
    {
        setDate(date);
        setNumHours(numHours);
        setMethod(method);
        setLocation(location);
        setType(type);
        //setAdditionalComments(additionalComments);
        setHostOrganization(hostOrganization);
        setTopic(topic);
    }
    
    //set Methods
    public void setDate(String date) throws Exception{this.date = ToolBox.ConvertStringToDate(date);}
    
    public void setNumHours(String numHours) throws Exception{this.numHours = Integer.parseInt(numHours);}
    
    public void setMethod(String method) throws Exception
    {
        if(method.equals(""))
        {
            throw new Exception("Must Enter a Method");
        }
        this.method = method;
    }
    
    public void setLocation(String location) throws Exception
    {
        if(method.equals(""))
        {
            throw new Exception("Must Enter Location");
        }
        this.location = location;
    }
    
    public void setType(String type) throws Exception
    {
        if(method.equals(""))
        {
            throw new Exception("Must Enter a Type");
        }
        this.type = type;
    }
    
    public void setAdditionalComments(String additionalComments)
    {
        this.additionalComments = additionalComments;
    }
    
    public void setHostOrganization(String hostOrganization)
    {
        this.hostOrganization = hostOrganization;
    }
    
    public void setTopic(String topic)
    {
        this.topic = topic;
    }
    
    //get Methods
    public Calendar getDate()
    {
        return date;
    }
    
    public int getNumHours()
    {
        return numHours;
    }
    
    public String getMethod()
    {
        return method;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getAdditionalComments()
    {
        return additionalComments;
    }
    
    public String getHostOrganization()
    {
        return hostOrganization;
    }
    
    public String getTopic()
    {
        return topic;
    }
}
