package BusinessTierInterface;

import Data_Objects.Course;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public interface TeacherInterface {
    
    //adding hours
    
    //return "" if input is okay
    //return a string that contains all error messages if not okay
    public String checkAddHoursInput(HttpServletRequest request);
    
    //return bool whether the add was successful or not
    //TODO: what input is needed here? A PDHours class, or a request???
    //public boolean addHours(HttpServletRequest request);
    
    
    //TCA courses to sign up for
    //TODO: what input is needed? Account??
    public Collection<Course> getCurrentCourses();
    //return the teacher's past TCA courses
    public Collection<Course> getMyPastCourses();
    
    //return TRUE if successfully signed up for the course
    //return FALSE if class is full or there was an error
    //TODO: what input is needed? Course course or int courseid???
    public boolean signUp(int courseID);
    
    

    
    //TODO - make PDHours class
    //public Collection<PDHours> getMyPDHours();
    
}
