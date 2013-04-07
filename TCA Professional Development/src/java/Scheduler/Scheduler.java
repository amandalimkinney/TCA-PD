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
public final class Scheduler {
    
    private int reminderID;
    private Course theCourse;
    private Account[] relevantAccounts;
    
    public Scheduler(){
        
    }
    
    public Scheduler(int reminder, Course aCourse) throws Exception{
        
        setReminderID(reminder);
        setCourse(aCourse);
        setAccounts(aCourse);

        setTodayReminder();
        set3DayReminder();
        sendReminder();
        sendSignUpExpires();
        send3DaySignUpExpires();
        
    }
    
    public void setReminderID(int reminder) throws Exception{
        this.reminderID = reminder;
    }
    
    public void setCourse(Course aCourse) throws Exception{
        this.theCourse = aCourse;
    }
    
    public void setAccounts(Course aCourse) throws Exception{
        this.relevantAccounts = Account.getAccounts(theCourse.getAttendees());
    }
    
    public void setTodayReminder() throws Exception{
        Calendar courseDate = theCourse.getDate();
        Calendar todayCal = new GregorianCalendar();
        todayCal.setTime(new Date());

        // Set parameters based on course date and today's date
        int theCourseYear = (courseDate.get(Calendar.YEAR));
        int todayYear = (todayCal.get(Calendar.YEAR));
        int theCourseMonth = (courseDate.get(Calendar.MONTH));
        int todayMonth = (todayCal.get(Calendar.MONTH));
        int theCourseDay = (courseDate.get(Calendar.DAY_OF_MONTH));
        int todayDay = (todayCal.get(Calendar.DAY_OF_MONTH));        

        
        // If the course year matches the current year
        if (theCourseYear - todayYear == 0){
            // ... And course month matches current month
            if (theCourseMonth - todayMonth == 0){
                // ... And course day matches today then send reminder
                if (theCourseDay - todayDay == 0){
                    sendReminder();
                } else {
                    // do nothing
                } 
            } else {
                // do nothing
            }
        } else {
        }        
        
    }
    
    public void set3DayReminder() throws Exception{
        Calendar courseDate = theCourse.getDate();
        Calendar todayCal = new GregorianCalendar();
        todayCal.setTime(new Date());

        // Set parameters based on course date and today's date
        int theCourseYear = (courseDate.get(Calendar.YEAR));
        int todayYear = (todayCal.get(Calendar.YEAR));
        int theCourseMonth = (courseDate.get(Calendar.MONTH));
        int todayMonth = (todayCal.get(Calendar.MONTH));
        int theCourseDay = (courseDate.get(Calendar.DAY_OF_MONTH));
        int todayDay = (todayCal.get(Calendar.DAY_OF_MONTH));        

        
        // If the course year matches the current year
        if (theCourseYear - todayYear == 0){
            // ... And course month matches current month
            if (theCourseMonth - todayMonth == 0){
                // ... And course day matches today then send reminder
                if (theCourseDay - todayDay == 3){
                      sendReminder();
                } else {
                    // do nothing
                } 
            } else {
                // do nothing
            }
        } else {
        } 
    }
    
    public void sendReminder() throws Exception{
        
        Emailer sendMailer = new Emailer(relevantAccounts);
        String subjectLine = ("REMINDER: CLASS IN 3 DAYS -- " + theCourse.getCourseName());
        String messageBody = ("This is a reminder that a class you signed up for, "
                + theCourse.getCourseID() + ", is in 3 days. Here is further information: "
                + theCourse.getDetails());
        
        sendMailer.sendEmail (subjectLine, messageBody);
        
    }
    
    public void sendSignUpExpires(){
        // todo
    }
    
    public void send3DaySignUpExpires(){
        // todo
    }    
    
}
