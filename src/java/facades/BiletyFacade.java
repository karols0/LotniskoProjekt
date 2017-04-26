/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Bilety;
import entities.Klienci;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Karol
 */
@Stateless
public class BiletyFacade extends AbstractFacade<Bilety> {

    @PersistenceContext(unitName = "LotniskoProjektPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BiletyFacade() {
        super(Bilety.class);
    }
    
    public List<Bilety> findByIdBiletu(Klienci x){
        Query query = em.createNamedQuery("Bilety.findByIdKlienta");
        query.setParameter("idKlienta", x);
        List<Bilety> results = query.getResultList();
        return results;
    }
    
}
