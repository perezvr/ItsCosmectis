/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Enderecos;
import model.Factory;

/**
 *
 * @author MrPerez
 */
public class ControleEndereco {
    
    public static boolean gravaEndereco(Enderecos endereco){
        EntityManager em = Factory.getConn();
        
        try{
            em.getTransaction().begin();
            int id = lastIdEndereco();
            endereco.setIdEndereco(id);
            em.persist(endereco);
            em.getTransaction().commit();
        } catch(Exception ex){
            em.getTransaction().rollback();
            return false;
        }
        
        return true;
    }
    
    private static int lastIdEndereco(){
        EntityManager em = Factory.getConn();
        try{
            Query query = em.createNamedQuery("Enderecos.lastId");
            return ((int)query.getSingleResult() + 1);
        }catch(Exception ex){
            return 1;
        }
    }
    
}
