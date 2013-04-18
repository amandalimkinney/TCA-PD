package session;

import Data_Objects.DevelopmentHours;
import Data_Objects.Teacher;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Panda
 */
@Stateless
public class AddHoursManager {
    @PersistenceContext(unitName = "TCA_Professional_DevelopmentPU")
    private EntityManager em;
    
    public void addHours(Date date, int numHours, String method, String hostOrg, String location, String type, String topicName) 
    {
        DevelopmentHours hrs = addHoursHelper(date, numHours, method, hostOrg, location, type, topicName);
        
    }

    private DevelopmentHours addHoursHelper(Date date, int numHours, String method, String hostOrg, String location, String type, String topicName) 
    {
        Teacher t = em.find(Teacher.class, 1001);
        //em.refresh(t);
        DevelopmentHours hrs = new DevelopmentHours();
        hrs.setTeacherId(t);
        hrs.setDate(date);
        hrs.setNumHours(numHours);
        hrs.setMethod(method);
        hrs.setHostOrganization(hostOrg);
        hrs.setLocation(location);
        hrs.setType(type);
        hrs.setTopic(type);
        em.persist(hrs);
        return hrs;
    }

}
