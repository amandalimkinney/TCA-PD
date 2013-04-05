
package Data_Objects;

import java.util.*;
import Data_Access.*;
import ToolBox.*;

public class Course 
{
    private List<String> 
        attendees,
        waitList,
        assistantInstructors,
        materials,
        attendance;
    
    
    
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
    
    public Course(String[] attendees,String[] waitList,String[] assistantInstructors,String[] materials,String courseID,String courseName,String type,String room,String instructorID,String details,String date,int hours,int totalSeats) throws Exception
    {
        super();
        setAttendees(attendees);
        setWaitList(waitList);
        setAssistantInstructors(assistantInstructors);
        setMaterials(materials);
        setCourseName(courseName);
        setType(type);
        setDate(ToolBox.ConvertStringToDate(date));
        setDeatails(details);
        setHours(hours);
        setInstructorID(instructorID);
        setRoom(room);
        setTotalSeats(totalSeats);
    }
    
    
    
    public static void addCourse(String courseName,String Type,String Room,String InstructorID,String[] assistantInstructors,String[] materials,String details,String Date, int hours,int seats) throws Exception
    {
        //if(AccessControl.hasPower("addCourse"))
        //{
            Course toAdd = new Course();
            toAdd.setAssistantInstructors(assistantInstructors);
            toAdd.setCourseName(courseName);
            toAdd.setType(Type);
            toAdd.setDate(ToolBox.ConvertStringToDate(Date));
            toAdd.setDeatails(details);
            toAdd.setHours(hours);
            toAdd.setInstructorID(InstructorID);
            toAdd.setMaterials(materials);
            toAdd.setRoom(Room);
            toAdd.setTotalSeats(seats);
            //toAdd.setCourseID(DataAccess.getNextCourseID());
            //DataAccess.addCourse(toAdd);
        //}
        
    }
    
    public static void modifyCourse(String courseID,String courseName,String Type,String Room,String InstructorID,String[] assistantInstructors,String[] materials,String details,String Date, int hours,int seats) throws Exception
    {
        //if(AccessControl.hasPower("modifyCourse:" + courseID))
        //{
            Course toModify = new Course();//Remove This when Data Acces is complete
            //Course toModify = DataAccess.getCourse(courseID);
            toModify.setAssistantInstructors(assistantInstructors);
            toModify.setCourseName(courseName);
            toModify.setType(Type);
            toModify.setDate(ToolBox.ConvertStringToDate(Date));
            toModify.setDeatails(details);
            toModify.setHours(hours);
            toModify.setInstructorID(InstructorID);
            toModify.setMaterials(materials);
            toModify.setRoom(Room);
            toModify.setTotalSeats(seats);
            //DataAccess.saveCourse(toModify);
        //}
        
    }
    
    public static void deleteCourse(String CourseID)
    {
        //if(AccessControl.hasPower("modifyCourse:" + courseID))
        //{
            //DataAccess.deleteCourse(courseID);
        //}
    }
    
    public static Course[] searchCourses(Course min,Course max)
    {
        Course[] toReturn = null;
        //toReturn = DataAccess.searchCourses(min,max)
        //toReturn = AccessControl.cleanCourses(toReturn)
        return null;
    }
    
    public static void updateAttendance(String courseID,String[] attendance)
    {
        //if(AccessControl.hasPower("updateAttendance:" + courseID))
        //DataAccess.updateAttendance(courseID,attendance);
    }
    
    public static void addAttendee(String courseID,String attendeeID)
    {
        //Course toModify = DataAccess.getCourse(courseID);
        //if(toModify.addAttendee(attendeeID))
        //DataAccess.saveCourse(toModify);
    }
    
    public static void addToWaitList(String courseID,String waitListedID)
    {
        //Course toModify = DataAccess.getCourse(courseID);
        //if(toModify.addWaitList(attendeeID))
        //DataAccess.saveCourse(toModify);
    }
    
    public boolean addAttendee(String attendeeID)throws Exception
    {
        //if(AccessControl.hasPower("addAttendee:" + courseID + ":" + attendeeID))
        //{
            if(attendees.size() >= totalSeats)
            {
                //if(DataAccess.isValidID(attendeeID))
                //{
                    attendees.add(attendeeID);
                    return true;
                //}
                //else
                //{
                    //throw new Exception("Invalid ID");
                //}
            }
            else
            {
                throw new Exception("No Seats Left, Would You Like To Be Placed On the Waitlist?");
            }
        //}
        //return false;
    }
    
    public boolean addToWaitList(String attendeeID)throws Exception
    {
        //if(AccessControl.hasPower("addAttendee:" + courseID + ":" + attendeeID))
        //{
            //if(DataAccess.isValidID(attendeeID))
            //{
                waitList.add(attendeeID);
                return true;
            //}
            //else
            //{
                //throw new Exception("Invalid ID");
            //}
        //}
        //return false;
    }
    
    public void setAttendees(String[] attendees)
    {
        for(int i=0;i<attendees.length;i++)
        {
            if(attendees[i] != null)
            this.attendees.add(attendees[i]);
        }
    }
    public void setAttendance(String[] attendance)
    {
        for(int i=0;i<attendance.length;i++)
        {
            if(attendance[i] != null)
            this.attendance.add(attendance[i]);
        }
    }
    public void setWaitList(String[] waitList)
    {
        for(int i=0;i<waitList.length;i++)
        {
            if(waitList[i] != null)
            this.waitList.add(waitList[i]);
        }
    }
    public void setAssistantInstructors(String[] assistantInstructors)
    {
        for(int i=0;i<assistantInstructors.length;i++)
        {
            if(assistantInstructors[i] != null)
            this.assistantInstructors.add(assistantInstructors[i]);
        }
    }
    public void setMaterials(String[] materials)
    {
        for(int i=0;i<materials.length;i++)
        {
            if(materials[i] != null)
            this.materials.add(materials[i]);
        }
    }
    
    public void setCourseID(String courseID){if(courseID != null)this.courseID = courseID;}
    public void setCourseName(String courseName){if(courseName != null)this.courseName = courseName;}
    public void setType(String type){if(type != null)this.type = type;}
    public void setRoom(String room){if(room != null)this.room = room;}
    public void setInstructorID(String instructorID){if(instructorID != null)this.instructorID = instructorID;}
    public void setDeatails(String details){if(details != null)this.details = details;}
    public void setDate(Date date){if(date != null)this.date = date;}
    public void setHours(int hours){if(hours > 0)this.hours = hours;}
    public void setTotalSeats(int totalSeats){if(totalSeats > 0)this.totalSeats = totalSeats;}
    
    public String[] getAttendees()
    {
        return (String[])attendees.toArray();
    }
    public String[] getAttendance()
    {
        return (String[])attendance.toArray();
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
