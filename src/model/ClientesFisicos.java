/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import error.ValidarException;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import util.Validacoes;

/**
 *
 * @author Maurilio
 */
@Entity
@Table(name = "clientes_fisicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientesFisicos.findAll", query = "SELECT c FROM ClientesFisicos c"),
    @NamedQuery(name = "ClientesFisicos.findByClientesIdCliente", query = "SELECT c FROM ClientesFisicos c WHERE c.clientesIdCliente = :clientesIdCliente"),
    @NamedQuery(name = "ClientesFisicos.findByCliNome", query = "SELECT c FROM ClientesFisicos c WHERE c.cliNome = :cliNome"),
    @NamedQuery(name = "ClientesFisicos.findByCliSexo", query = "SELECT c FROM ClientesFisicos c WHERE c.cliSexo = :cliSexo"),
    @NamedQuery(name = "ClientesFisicos.findByCliDataNascimento", query = "SELECT c FROM ClientesFisicos c WHERE c.cliDataNascimento = :cliDataNascimento"),
    @NamedQuery(name = "ClientesFisicos.findByCliEmail", query = "SELECT c FROM ClientesFisicos c WHERE c.cliEmail = :cliEmail")})
public class ClientesFisicos implements Serializable {
    @Column(name = "cliDataNascimento")
    @Temporal(TemporalType.DATE)
    private Date cliDataNascimento;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clientes_Id_Cliente")
    private Integer clientesIdCliente;
    @Basic(optional = false)
    @Column(name = "cliNome")
    private String cliNome;
    @Column(name = "cliSexo")
    private Character cliSexo;
    @Column(name = "cliEmail")
    private String cliEmail;
    @JoinColumn(name = "clientes_Id_Cliente", referencedColumnName = "Id_Cliente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Clientes clientes;

    public ClientesFisicos() {
    }

    public ClientesFisicos(Integer clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public ClientesFisicos(Integer clientesIdCliente, String cliNome) {
        this.clientesIdCliente = clientesIdCliente;
        this.cliNome = cliNome;
    }

    public Integer getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(Integer clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) throws ValidarException {
        if (Validacoes.validaTextoVazio(cliNome)) {
            throw new ValidarException();
        }
        this.cliNome = cliNome;
    }

    public Character getCliSexo() {
        return cliSexo;
    }

    public void setCliSexo(Character cliSexo) throws ValidarException {
        if (Validacoes.validaTextoVazio(cliSexo.toString())) {
            throw new ValidarException();
        }
        this.cliSexo = cliSexo;
    }


    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientesIdCliente != null ? clientesIdCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesFisicos)) {
            return false;
        }
        ClientesFisicos other = (ClientesFisicos) object;
        if ((this.clientesIdCliente == null && other.clientesIdCliente != null) || (this.clientesIdCliente != null && !this.clientesIdCliente.equals(other.clientesIdCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ClientesFisicos[ clientesIdCliente=" + clientesIdCliente + " ]";
    }

    public Date getCliDataNascimento() {
        return cliDataNascimento;
    }

    public void setCliDataNascimento(Date cliDataNascimento) {
        this.cliDataNascimento = cliDataNascimento;
    }
    
}
