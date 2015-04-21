/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import error.ValidarException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import util.Validacoes;

/**
 *
 * @author Maurilio
 */
@Entity
@Table(name = "clientes_juridicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientesJuridicos.findAll", query = "SELECT c FROM ClientesJuridicos c"),
    @NamedQuery(name = "ClientesJuridicos.findByClientesIdCliente", query = "SELECT c FROM ClientesJuridicos c WHERE c.clientesIdCliente = :clientesIdCliente"),
    @NamedQuery(name = "ClientesJuridicos.findByCliRazaoSocial", query = "SELECT c FROM ClientesJuridicos c WHERE c.cliRazaoSocial = :cliRazaoSocial"),
    @NamedQuery(name = "ClientesJuridicos.findByCliNomeFantasia", query = "SELECT c FROM ClientesJuridicos c WHERE c.cliNomeFantasia = :cliNomeFantasia"),
    @NamedQuery(name = "ClientesJuridicos.findByCliCNPJ", query = "SELECT c FROM ClientesJuridicos c WHERE c.cliCNPJ = :cliCNPJ"),
    @NamedQuery(name = "ClientesJuridicos.findByCliInscricaoEstadual", query = "SELECT c FROM ClientesJuridicos c WHERE c.cliInscricaoEstadual = :cliInscricaoEstadual"),
    @NamedQuery(name = "ClientesJuridicos.findByCliEmail", query = "SELECT c FROM ClientesJuridicos c WHERE c.cliEmail = :cliEmail")})
public class ClientesJuridicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clientes_Id_Cliente")
    private Integer clientesIdCliente;
    @Basic(optional = false)
    @Column(name = "cliRazaoSocial")
    private String cliRazaoSocial;
    @Basic(optional = false)
    @Column(name = "cliNomeFantasia")
    private String cliNomeFantasia;
    @Basic(optional = false)
    @Column(name = "cliCNPJ")
    private String cliCNPJ;
    @Basic(optional = false)
    @Column(name = "cliInscricaoEstadual")
    private String cliInscricaoEstadual;
    @Column(name = "cliEmail")
    private String cliEmail;
    @JoinColumn(name = "clientes_Id_Cliente", referencedColumnName = "Id_Cliente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Clientes clientes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientesjuridicosclientesIdCliente")
    private List<ContatosClientesJuridicos> contatosClientesJuridicosList;

    public ClientesJuridicos() {
    }

    public ClientesJuridicos(Integer clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public ClientesJuridicos(Integer clientesIdCliente, String cliRazaoSocial, String cliNomeFantasia, String cliCNPJ, String cliInscricaoEstadual) {
        this.clientesIdCliente = clientesIdCliente;
        this.cliRazaoSocial = cliRazaoSocial;
        this.cliNomeFantasia = cliNomeFantasia;
        this.cliCNPJ = cliCNPJ;
        this.cliInscricaoEstadual = cliInscricaoEstadual;
    }

    public Integer getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(Integer clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public String getCliRazaoSocial() {
        return cliRazaoSocial;
    }

    public void setCliRazaoSocial(String cliRazaoSocial) throws ValidarException {
        if (Validacoes.validaTextoVazio(cliRazaoSocial)) {
            throw new ValidarException();
        }
        this.cliRazaoSocial = cliRazaoSocial;
    }

    public String getCliNomeFantasia() {
        return cliNomeFantasia;
    }

    public void setCliNomeFantasia(String cliNomeFantasia) throws ValidarException {
        if (Validacoes.validaTextoVazio(cliNomeFantasia)) {
            throw new ValidarException();
        }
        this.cliNomeFantasia = cliNomeFantasia;
    }

    public String getCliCNPJ() {
        String cnpj;
        cnpj = this.cliCNPJ;
        cnpj=cnpj.substring(0, 2)+"."+ cnpj.substring(2, cnpj.length());
        cnpj=cnpj.substring(0, 6)+"."+ cnpj.substring(6, cnpj.length());
        cnpj=cnpj.substring(0, 10)+"/"+ cnpj.substring(10, cnpj.length());
        cnpj=cnpj.substring(0, 15)+"-"+ cnpj.substring(15, cnpj.length());
        return cnpj;
    }

    public void setCliCNPJ(String cliCNPJ) throws ValidarException {
        if (Validacoes.validaTextoVazio(cliCNPJ)) {
            throw new ValidarException();
        }
        if (Validacoes.isValidCNPJ(cliCNPJ)) {
            throw new ValidarException();
        }
        cliCNPJ = cliCNPJ.replace(".", "");
        cliCNPJ = cliCNPJ.replace("/", "");
        cliCNPJ = cliCNPJ.replace("-", "");

        this.cliCNPJ = cliCNPJ;
    }

    public String getCliInscricaoEstadual() {
        return cliInscricaoEstadual;
    }

    public void setCliInscricaoEstadual(String cliInscricaoEstadual) {
        this.cliInscricaoEstadual = cliInscricaoEstadual;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) throws ValidarException {
        if (!Validacoes.isEmailValid(cliEmail)) {
            if (!cliEmail.trim().isEmpty()) {
                throw new ValidarException();
            }
        }
        this.cliEmail = cliEmail;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @XmlTransient
    public List<ContatosClientesJuridicos> getContatosClientesJuridicosList() {
        return contatosClientesJuridicosList;
    }

    public void setContatosClientesJuridicosList(List<ContatosClientesJuridicos> contatosClientesJuridicosList) {
        this.contatosClientesJuridicosList = contatosClientesJuridicosList;
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
        if (!(object instanceof ClientesJuridicos)) {
            return false;
        }
        ClientesJuridicos other = (ClientesJuridicos) object;
        if ((this.clientesIdCliente == null && other.clientesIdCliente != null) || (this.clientesIdCliente != null && !this.clientesIdCliente.equals(other.clientesIdCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ClientesJuridicos[ clientesIdCliente=" + clientesIdCliente + " ]";
    }

}
