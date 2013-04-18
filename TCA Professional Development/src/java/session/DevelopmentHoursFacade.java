/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import Access_control.DevelopmentHours;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Panda
 */
@Stateless
public class DevelopmentHoursFacade extends AbstractFacade<DevelopmentHours> {
    @PersistenceContext(unitName = "TCA_Professional_DevelopmentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevelopmentHoursFacade() {
        super(DevelopmentHours.class);
    }
    
}
