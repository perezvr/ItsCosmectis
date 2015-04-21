/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Clientes;
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
     * @param cliente
     * @param clienteFis
     */
    public static void gravaClienteFisico(Clientes cliente, ClientesFisicos clienteFis) {
        EntityManager em = Factory.getConn();
        em.getTransaction().begin();
        cliente.setIdCliente(ControleCliente.lastIdCliente());
        clienteFis.setClientesIdCliente(cliente.getIdCliente());
        em.persist(cliente);
        clienteFis.setClientesIdCliente(cliente.getIdCliente());
        em.persist(clienteFis);
        em.getTransaction().commit();
    }

    /**
     *
     * @param cliente
     * @param clienteJur
     */
    public static void gravaClienteJuridico(Clientes cliente, ClientesJuridicos clienteJur) {
        EntityManager em = Factory.getConn();
        em.getTransaction().begin();
        cliente.setIdCliente(ControleCliente.lastIdCliente());
        clienteJur.setClientesIdCliente(cliente.getIdCliente());
        em.persist(cliente);
        clienteJur.setClientesIdCliente(cliente.getIdCliente());
        em.persist(clienteJur);
        em.getTransaction().commit();
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
