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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maurilio
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.lastId", query = "SELECT max(c.idCliente) FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdCliente", query = "SELECT c FROM Clientes c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Clientes.findByCliTipoCliente", query = "SELECT c FROM Clientes c WHERE c.cliTipoCliente = :cliTipoCliente")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "cliTipoCliente")
    private Character cliTipoCliente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clientes")
    private ClientesFisicos clientesFisicos;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clientes")
    private ClientesJuridicos clientesJuridicos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientesIdCliente")
    private List<Vendas> vendasList;
    @OneToMany(mappedBy = "clientesIdCliente")
    private List<Telefones> telefonesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientesIdCliente")
    private List<Enderecos> enderecosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientesIdCliente")
    private List<Contas> contasList;

    public Clientes() {
    }

    public Clientes(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Character getCliTipoCliente() {
        return cliTipoCliente;
    }

    public void setCliTipoCliente(Character cliTipoCliente) throws ValidarException {
        if (cliTipoCliente.toString().trim().equals("")) {
            throw new ValidarException();
        }
        if ((cliTipoCliente.toString().trim().equals("F")) || (cliTipoCliente.toString().trim().equals("J")) ) {
        } else {
            throw new ValidarException();
        }
        this.cliTipoCliente = cliTipoCliente;
    }

    public ClientesFisicos getClientesFisicos() {
        return clientesFisicos;
    }

    public void setClientesFisicos(ClientesFisicos clientesFisicos) {
        this.clientesFisicos = clientesFisicos;
    }

    public ClientesJuridicos getClientesJuridicos() {
        return clientesJuridicos;
    }

    public void setClientesJuridicos(ClientesJuridicos clientesJuridicos) {
        this.clientesJuridicos = clientesJuridicos;
    }

    @XmlTransient
    public List<Vendas> getVendasList() {
        return vendasList;
    }

    public void setVendasList(List<Vendas> vendasList) {
        this.vendasList = vendasList;
    }

    @XmlTransient
    public List<Telefones> getTelefonesList() {
        return telefonesList;
    }

    public void setTelefonesList(List<Telefones> telefonesList) {
        this.telefonesList = telefonesList;
    }

    @XmlTransient
    public List<Enderecos> getEnderecosList() {
        return enderecosList;
    }

    public void setEnderecosList(List<Enderecos> enderecosList) {
        this.enderecosList = enderecosList;
    }

    @XmlTransient
    public List<Contas> getContasList() {
        return contasList;
    }

    public void setContasList(List<Contas> contasList) {
        this.contasList = contasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clientes[ idCliente=" + idCliente + " ]";
    }

}
