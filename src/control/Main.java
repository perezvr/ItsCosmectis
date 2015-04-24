/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import error.ValidarException;
import java.util.Date;
import model.Cidades;
import model.Clientes;
import model.ClientesFisicos;
import model.Enderecos;

/**
 *
 * @author Maurilio
 */
public class Main {

    public static void main(String[] args) throws ValidarException {
//        Clientes cliente = new Clientes();
//        ClientesFisicos cliFis = new ClientesFisicos();
//        cliente.setCliTipoCliente('F');
//        cliFis.setCliNome("Maurílio2");
//        cliFis.setCliSexo('M');
//        cliFis.setCliDataNascimento(new Date("01/01/2014"));
//        cliFis.setClientes(cliente);
//        ControleCliente.gravaClienteFisico(cliFis);

        Enderecos end = new Enderecos();
        Cidades cidade = new Cidades();
        cidade.setIdCidade(1);
        Clientes cliente = new Clientes();
        cliente.setIdCliente(1);

        end.setEndLogradouro("Rua Cesar Lattes");
        end.setEndNumero("57");
        end.setEndComplemento("ap 403");
        end.setEndBairro("Limeiro");
        end.setEndCep("27281410");
        end.setCidadesIdCidade(cidade);
        end.setClientesIdCliente(cliente);
        ControleEndereco.gravaEndereco(end);

    }
}
