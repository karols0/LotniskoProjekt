/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Przewoznicy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karol
 */
@Stateless
public class PrzewoznicyFacade extends AbstractFacade<Przewoznicy> {

    @PersistenceContext(unitName = "LotniskoProjektPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrzewoznicyFacade() {
        super(Przewoznicy.class);
    }
    
}
