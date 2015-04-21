/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Maurilio
 */
public abstract class Factory {

    /**
     * Retorna uma conexão com o banco especificado.
     * @param banco
     * @return
     */
    public static EntityManager getConn(String banco){
        EntityManagerFactory em = Persistence.createEntityManagerFactory(banco);
        return em.createEntityManager();
    }
    /**
     * Retorna uma conexão com o banco MySQL ItsCosmectis.
     * @return
     */
    public static EntityManager getConn(){
        EntityManagerFactory em = Persistence.createEntityManagerFactory("ItsCosmectisPU");
        return em.createEntityManager();
    }
}
