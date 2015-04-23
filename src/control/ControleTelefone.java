/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Factory;
import model.Telefones;

/**
 *
 * @author MrPerez
 */
public class ControleTelefone {
    
    public static boolean gravaTelefone(Telefones telefone){
        EntityManager em = Factory.getConn();
        
        try{
            em.getTransaction().begin();
            int id = lastIdTelefone();
            telefone.setIdTelefone(id);
            em.persist(telefone);
            em.getTransaction().commit();
        } catch(Exception ex){
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }
    
    private static int lastIdTelefone() {
        EntityManager em = Factory.getConn();
        try {
            Query query = em.createNamedQuery("Telefones.lastId");
            return ((int) query.getSingleResult()) + 1;
        } catch (Exception ex) {
            return 1;
        }
    }
    
}
