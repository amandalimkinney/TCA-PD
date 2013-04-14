
package Data_Objects;

import java.util.Calendar;

public class CourseBean {
	
    private String[] attendees;
    private String[] waitList;
    private String[] assistantInstructors;
    private String[] materials;
    private String[] attendance;
    private String courseID;
    private String courseName;
    private String type;
    private String room;
    private String instructorID;
    private String details;
    private Calendar courseDate;
    private int hours;
    private int totalSeats;
	
    public void setAttendees(String[] attendees1)
    {
        for(int i=0; i<attendees1.length; i++)
        {
            if(attendees1[i] != null)
            this.attendees[i] = (attendees1[i]);
        }
    }
    
    public void setAttendance(String[] attendance1)
    {
        for(int i=0; i<attendance1.length; i++)
        {
            if(attendance1[i] != null)
            this.attendance[i] = (attendance1[i]);
        }
    }
    
    public void setWaitList(String[] waitList1)
    {
        for(int i=0; i<waitList1.length; i++)
        {
            if(waitList1[i] != null)
            this.waitList[i] = (waitList1[i]);
        }
    }
    
    public void setAssistantInstructors(String[] assistantInstructors1)
    {
        for(int i=0; i<assistantInstructors1.length; i++)
        {
            if(assistantInstructors1[i] != null)
            this.assistantInstructors[i] = (assistantInstructors1[i]);
        }
    }
    
    public void setMaterials(String[] materials1)
    {
        for(int i=0; i<materials1.length; i++)
        {
            if(materials1[i] != null)
            this.materials[i] = (materials1[i]);
        }
    }
    
    public void setCourseID(String courseID1)
    {
        if(courseID1 != null)
            this.courseID = courseID1;
    }
    
    public void setCourseName(String courseName1)
    {
        if(courseName1 != null)
            this.courseName = courseName1;
    }
    
    public void setType(String type1)
    {
        if(type1 != null)
            this.type = type1;
    }
    
    public void setRoom(String room1)
    {
        if(room1 != null)
            this.room = room1;
    }
    
    public void setInstructorID(String instructorID1)
    {
        if(instructorID1 != null)
            this.instructorID = instructorID1;
    }
    
    public void setDetails(String details1)
    {
        if(details1 != null)
            this.details = details1;
    }
    
    public void setDate(Calendar courseDate1)
    {
        if(courseDate1 != null)
            this.courseDate = courseDate1;
    }
    
    public void setHours(int hours1)
    {
        if(hours1 > 0)
            this.hours = hours1;
    }
    
    public void setTotalSeats(int totalSeats1)
    {
        if(totalSeats1 > 0)
            this.totalSeats = totalSeats1;
    }
    
    public String[] getAttendees()
    {
        return attendees;
    }
    
    public String[] getAttendance()
    {
        return attendance;
    }
    
    public String[] getWaitList()
    {
        return waitList;
    }
    
    public String[] getAssistantInstructors()
    {
        return assistantInstructors;
    }
    
    public String[] getMaterials()
    {
        return materials;
    }
    
    public String getCourseID()
    {
        return courseID;
    }
    
    public String getCourseName()
    {
        return courseName;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getRoom()
    {
        return room;
    }
    
    public String getInstructorID()
    {
        return instructorID;
    }
    
    public String getDetails()
    {
        return details;
    }
    
    public Calendar getDate()
    {
        return courseDate;
    }
    
    public int getHours()
    {
        return hours;
    }
    
    public int getTotalSeats()
    {
        return totalSeats;
    }
   
}
    
    