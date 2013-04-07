/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import Data_Objects.*;
import java.util.*;

/**
 *
 * @author Erik
 */
public class Scheduler {
    
    private int reminderID;
    private Course theCourse;
    
    public Scheduler(){
        
    }
    
    public Scheduler(int reminder, Course aCourse) throws Exception{
        
        setReminderID(reminder);
        setCourse(aCourse);
        setReminder();
        getTodayReminders();
        get3DayReminders();
        sendTodayReminders();
        send3DayReminders();
        sendSignUpExpires();
        
    }
    
    public void setReminderID(int reminder) throws Exception{
        this.reminderID = reminder;
    }
    
    public void setCourse(Course aCourse) throws Exception{
        this.theCourse = aCourse;
    }
    
    public void setReminder(){
        // todo
    }
    
    public void getTodayReminders(){
        // todo
    }
    
    public void get3DayReminders(){
        // todo
    }
    
    public void sendTodayReminders(){
        // todo
    }
    
    public void send3DayReminders(){
        // todo
    }
    
    public void sendSignUpExpires(){
        // todo
    }
    
}
