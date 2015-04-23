/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ClientesFisicos;
import model.ClientesJuridicos;
import model.Factory;

/**
 *
 * @author Maurilio
 */
public abstract class ControleCliente {

    /**
     *
     * @param clienteFis
     * @return boolean se cadastrou;
     */
    public static boolean gravaClienteFisico(ClientesFisicos clienteFis) {
        EntityManager em = Factory.getConn();
        try {
            em.getTransaction().begin();
            int id = ControleCliente.lastIdCliente();
            clienteFis.getClientes().setIdCliente(id);
            clienteFis.setClientesIdCliente(id);
            em.persist(clienteFis);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    /**
     *
     * @param clienteJur
     * @return boolean se cadastrou;
     */
    public static boolean gravaClienteJuridico(ClientesJuridicos clienteJur) {
        EntityManager em = Factory.getConn();
        try {
            em.getTransaction().begin();
            int id = ControleCliente.lastIdCliente();
            clienteJur.getClientes().setIdCliente(id);
            clienteJur.setClientesIdCliente(id);
            em.persist(clienteJur);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    private static int lastIdCliente() {
        EntityManager em = Factory.getConn();
        try {
            Query query = em.createNamedQuery("Clientes.lastId");
            return ((int) query.getSingleResult()) + 1;
        } catch (Exception ex) {
            return 1;
        }
    }
}
