/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import error.ValidarException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Clientes;
import model.ClientesFisicos;
import model.ClientesJuridicos;

/**
 *
 * @author Maurilio
 */
public class Main {

    public static void main(String[] args) throws ValidarException {
        Clientes cliente = new Clientes();
        ClientesFisicos cliFis = new ClientesFisicos();
        cliente.setCliTipoCliente('F');
        cliFis.setCliNome("Maurílio");
        ControleCliente.gravaClienteFisico(cliente, cliFis);
    }
}
