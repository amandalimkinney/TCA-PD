
package Data_Objects;

import java.util.*;
import Data_Access.*;

public class Course 
{
    private List<String> 
        attendees,
        waitList,
        assistantInstructors,
        materials;
    
    private String 
        courseID,
        courseName,
        type,
        room,
        instructorID,
        details;
    
    private Date
        date;
    
    private int
        hours,
        totalSeats;
    
    public Course()
    {
        attendees = new ArrayList();
        waitList = new ArrayList();
        assistantInstructors = new ArrayList();
        materials = new ArrayList();
    }
    
    public Course(String[] attendees,String[] waitList,String[] assistantInstructors,String[] materials,String courseID,String courseName,String type,String room,String instructorID,String details,Date date,int hours,int totalSeats)
    {
        super();
        setAttendees(attendees);
        setWaitList(waitList);
        setAssistantInstructors(assistantInstructors);
        setMaterials(materials);
        
    }
    
    public void setAttendees(String[] attendees)
    {
        for(int i=0;i<attendees.length;i++)
        {
            this.attendees.add(attendees[i]);
        }
    }
    public void setWaitList(String[] waitList)
    {
        for(int i=0;i<waitList.length;i++)
        {
            this.waitList.add(waitList[i]);
        }
    }
    public void setAssistantInstructors(String[] assistantInstructors)
    {
        for(int i=0;i<assistantInstructors.length;i++)
        {
            this.assistantInstructors.add(assistantInstructors[i]);
        }
    }
    public void setMaterials(String[] materials)
    {
        for(int i=0;i<materials.length;i++)
        {
            this.materials.add(materials[i]);
        }
    }
    
    public void setCourseID(String courseID){this.courseID = courseID;}
    public void setCourseName(String courseName){this.courseName = courseName;}
    public void setType(String type){this.type = type;}
    public void setRoom(String room){this.room = room;}
    public void setInstructorID(String instructorID){this.instructorID = instructorID;}
    public void setDeatails(String details){this.details = details;}
    public void setDate(Date date){this.date = date;}
    public void setHours(int hours){this.hours = hours;}
    public void setTotalSeats(int totalSeats){this.totalSeats = totalSeats;}
    
    public String[] getAttendees()
    {
        return (String[])attendees.toArray();
    }
    public String[] getWaitList()
    {
        return (String[])waitList.toArray();
    }
    public String[] getAssistantInstructors()
    {
        return (String[])assistantInstructors.toArray();
    }
    public String[] getMaterials()
    {
        return (String[])materials.toArray();
    }
    
    public String getCourseID(){return courseID;}
    public String getCourseName(){return courseName;}
    public String getType(){return type;}
    public String getRoom(){return room;}
    public String getInstructorID(){return instructorID;}
    public String getDeatails(){return details;}
    public Date getDate(){return date;}
    public int getHours(){return hours;}
    public int getTotalSeats(){return totalSeats;}
   
}
