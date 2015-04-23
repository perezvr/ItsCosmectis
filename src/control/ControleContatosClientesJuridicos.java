/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ContatosClientesJuridicos;
import model.Factory;

/**
 *
 * @author MrPerez
 */
public class ControleContatosClientesJuridicos {
    
    public static boolean gravaContatoClienteJuridico(ContatosClientesJuridicos contato){
        EntityManager em = Factory.getConn();
        
        try {
            em.getTransaction().begin();
            int id = lastIdContatos();
            contato.setIdContatoclientesjuridicos(id);
            em.persist(contato);
            em.getTransaction().commit();
        } catch(Exception ex){
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    private static int lastIdContatos() {
        EntityManager em = Factory.getConn();

        try {
            Query query = em.createNamedQuery("ContatosClientesJuridicos.lastId");
            return ((int) query.getSingleResult() + 1);
        } catch (Exception ex) {
            return 1;
        }
    }
}
