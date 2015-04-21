/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maurilio
 */
@Entity
@Table(name = "vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v"),
    @NamedQuery(name = "Vendas.findByIdVendas", query = "SELECT v FROM Vendas v WHERE v.idVendas = :idVendas")})
public class Vendas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Vendas")
    private Integer idVendas;
    @ManyToMany(mappedBy = "vendasList")
    private List<FornecedoresProdutos> fornecedoresProdutosList;
    @JoinColumn(name = "clientes_Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne(optional = false)
    private Clientes clientesIdCliente;
    @JoinColumn(name = "vendedores_Id_Vendedor", referencedColumnName = "Id_Vendedor")
    @ManyToOne(optional = false)
    private Vendedores vendedoresIdVendedor;

    public Vendas() {
    }

    public Vendas(Integer idVendas) {
        this.idVendas = idVendas;
    }

    public Integer getIdVendas() {
        return idVendas;
    }

    public void setIdVendas(Integer idVendas) {
        this.idVendas = idVendas;
    }

    @XmlTransient
    public List<FornecedoresProdutos> getFornecedoresProdutosList() {
        return fornecedoresProdutosList;
    }

    public void setFornecedoresProdutosList(List<FornecedoresProdutos> fornecedoresProdutosList) {
        this.fornecedoresProdutosList = fornecedoresProdutosList;
    }

    public Clientes getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(Clientes clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public Vendedores getVendedoresIdVendedor() {
        return vendedoresIdVendedor;
    }

    public void setVendedoresIdVendedor(Vendedores vendedoresIdVendedor) {
        this.vendedoresIdVendedor = vendedoresIdVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendas != null ? idVendas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.idVendas == null && other.idVendas != null) || (this.idVendas != null && !this.idVendas.equals(other.idVendas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vendas[ idVendas=" + idVendas + " ]";
    }
    
}
