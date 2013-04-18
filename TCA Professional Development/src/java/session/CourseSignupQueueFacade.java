/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import session.AbstractFacade;
import Data_Objects.CourseSignupQueue;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
