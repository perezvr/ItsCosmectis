/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import error.ValidarException;
import java.util.Date;
import model.Clientes;
import model.ClientesFisicos;

/**
 *
 * @author Maurilio
 */
public class Main {

    public static void main(String[] args) throws ValidarException {
        Clientes cliente = new Clientes();
        ClientesFisicos cliFis = new ClientesFisicos();
        cliente.setCliTipoCliente('F');
        cliFis.setCliNome("Maurílio2");
        cliFis.setCliSexo('M');
        cliFis.setCliDataNascimento(new Date("01/01/2014"));
        cliFis.setClientes(cliente);
        ControleCliente.gravaClienteFisico(cliFis);
    }
}
