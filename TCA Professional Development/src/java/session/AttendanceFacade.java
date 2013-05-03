package session;

import Data_Objects.Attendance;
import Data_Objects.AttendancePK;
import Data_Objects.Course;
import Data_Objects.Teacher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Panda
 */
@Stateless
public class AttendanceFacade extends AbstractFacade<Attendance> {
    @PersistenceContext(unitName = "TCA_Professional_DevelopmentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AttendanceFacade() {
        super(Attendance.class);
    }
    
    public void takeAttendance(String[] teacherIds, int courseId)
    {
        
        ArrayList<String> newEntries = new ArrayList<String>();
        newEntries.addAll(Arrays.asList(teacherIds));
        
        List<Attendance> oldEntries = em.createNamedQuery("Attendance.findByCourseId", Attendance.class)
                .setParameter("courseId", courseId)
                .getResultList();
        
        
        for(int j = 0; j < oldEntries.size(); j++) //check ALL old entries first
        {
            
            String oldId = oldEntries.get(j).getTeacher().getTeacherId().toString();
            if(newEntries.contains(oldId)) //new entry has been submitted as present
            {
                //first remove from newEntries for later
                newEntries.remove(oldId);
                
                
                if(!oldEntries.get(j).getAttended())
                {
                    //case: old entry is absent, new entry is present
                    //TODO edit the entry
                }
                
                //case: old entry is present, new entry is present
                //do nothing
           
            }
            else
            {
                 //case: old entry is present, new entry is absent
                if(oldEntries.get(j).getAttended())
                {
                    //TODO remove old entry or set absent
                }
            
                //case: old entry is absent, new entry is absent
                //do nothing
            }
            
        }
        
        //for entries that are NEW:
        for(int j = 0; j < newEntries.size();j++)
        {
            attended(courseId, Integer.parseInt(newEntries.get(j)));
        }
        //get list of already entered teachers
        //for each already entered, compare to new list
        //modify ones that were absent that should be present, vice versa
        
        //then for new entries, add them
    }
    
    public boolean attendanceAlreadyEntered(int courseId, int teacherId)
    {
        return !(em.createNativeQuery("SELECT * FROM Attendance WHERE course_id = " + courseId + 
                " AND teacher_id = " + teacherId).getResultList().isEmpty());
        
    }
    
    public void attended(int courseId, int teacherId)
    {
        if(! attendanceAlreadyEntered(courseId, teacherId))
        {
            Attendance attendance = new Attendance();
        attendance.setAttendancePK(new AttendancePK(courseId, teacherId));
        attendance.setAttended(Boolean.TRUE);
        attendance.setCourse(em.find(Course.class, courseId));
        attendance.setTeacher(em.find(Teacher.class, teacherId));
        em.persist(attendance);
        }
    }
    
}
