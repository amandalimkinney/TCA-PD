package session;

import Data_Objects.Course;
import Data_Objects.CourseSignupQueue;
import Data_Objects.CourseSignupQueuePK;
import Data_Objects.DevelopmentHours;
import Data_Objects.Teacher;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CourseSignUpManager {

    @PersistenceContext(unitName = "TCA_Professional_DevelopmentPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

//This is a transaction; all actions must work, or they all fail
//returns int: 0 = fail, -1 = class full, 1 = success
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int signUpForCourse(Course course, Teacher teacher) 
    {
        //TODO: fix teacher
        teacher = em.find(Teacher.class, 1001);
        if(isCourseFull(course))
            {
                return -1;
            }
        
         //course is not full
        try {
            //add the teacher to the coursesignupqueue
            addToQueue(course, teacher);

            //add the course to the teacher's hours
            addCourseToHours(course, teacher);
            return 1;
        } catch (Exception e) {
            context.setRollbackOnly();
            return 0;
        }
    
}

    private void addToQueue(Course course, Teacher teacher)
    {
        CourseSignupQueue queue = new CourseSignupQueue();
        queue.setCourse(course);
        queue.setTeacher(teacher);
        queue.setAppliedOn(new Date()); //current date
        queue.setWaitinglistNum(-1); //-1 means not in line for waiting list
        queue.setCourseSignupQueuePK(new CourseSignupQueuePK(course.getCourseId(), teacher.getTeacherId()));
        em.persist(queue);
    }
    
    private void addCourseToHours(Course course, Teacher teacher)
    {
        DevelopmentHours hrs = new DevelopmentHours();
        hrs.setTeacherId(teacher);
        hrs.setDate(new Date());
        hrs.setNumHours(course.getHours());
        hrs.setMethod("TCA course");
        hrs.setHostOrganization("TCA");
        hrs.setLocation("on-site");
        hrs.setType(course.getCourseType());
        hrs.setTopic(course.getCourseTopic());
        em.persist(hrs);
    }
    
    private boolean isCourseFull(Course course) {
        int total = course.getTotalSeats();
        int current = em.createNamedQuery("CourseSignupQueue.findByCourseId")
                .setParameter("courseId", course.getCourseId())
                .getResultList().size();

        return total <= (current + 1);

    }
}
