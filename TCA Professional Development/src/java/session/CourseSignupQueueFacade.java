/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import session.AbstractFacade;
import Data_Objects.CourseSignupQueue;
import Data_Objects.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Panda
 */
@Stateless
public class CourseSignupQueueFacade extends AbstractFacade<CourseSignupQueue> {
    @PersistenceContext(unitName = "TCA_Professional_DevelopmentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CourseSignupQueueFacade() {
        super(CourseSignupQueue.class);
    }
    
    public List<Teacher> getAttendees(int id)
    {
        List<Teacher> attendees = new ArrayList<Teacher>();
        List<CourseSignupQueue> signup = em.createNamedQuery("CourseSignupQueue.findByCourseId", CourseSignupQueue.class).getResultList();
        for(int j = 0; j<signup.size();j++)
        {
            attendees.add(signup.get(j).getTeacher());
        }
        return attendees;
    }
    
}
