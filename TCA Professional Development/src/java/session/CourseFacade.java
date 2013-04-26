/*
 * WORKAROUND FOR ERROR
 * Exception [EclipseLink-6044] (Eclipse Persistence Services - 2.3.2.v20111125-r10461): 
 * org.eclipse.persistence.exceptions.QueryException
 * Exception Description: The primary key read from the row [ArrayRecord(
 * during the execution of the query was detected to be null. Primary keys must not contain null.
 * TO GET THIS TO WORK:
 * In the 3.1.2 glassfish installation folder under glassfish/modules/
 * Replace all org.eclipse.*.jar with the version from 3.1.1
 * There are 7 jars to delete, and 6 jars to put in their place
 * (moxy is not in the old version, delete it)
 * There is a BUG in 3.1.2 version that messes up the lower/upper case of
 * column names
 * As a result, createNativeQuery results mapped to Course.class are unusable
 * because the primary key cannot be identified.
 * For more info: http://www.eclipse.org/forums/index.php/m/885235/
 */
package session;

import Data_Objects.Course;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Panda
 */
@Stateless
public class CourseFacade extends AbstractFacade<Course> {
    @PersistenceContext(unitName = "TCA_Professional_DevelopmentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CourseFacade() {
        super(Course.class);
    }
    
     public List<Course> findNextMonthCourses() {
         return em.createNativeQuery("SELECT * FROM course WHERE date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)", Course.class).getResultList();
    } 
//     
//     public List<Course> findNextMonthCourses2(List<Course> all)
//     {
//         List<Course> current = new ArrayList<Course>();
//         for(Course c : all)
//         {
//             if(dateInNextMonth(c.getDate())) {
//                 current.add(c);
//             }
//         }
//         return current;
//                 
//     }
//     
//     public static boolean dateInNextMonth(Date date)
//     {
//         Calendar cal = Calendar.getInstance();
//         Date today = cal.getTime();
//         cal.add(Calendar.DAY_OF_MONTH, 30);
//         Date next = cal.getTime();
//         
//         return (date.compareTo(today) > 0 && date.compareTo(next) < 0);
//     }
     
}
