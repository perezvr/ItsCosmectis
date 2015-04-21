/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maurilio
 */
@Entity
@Table(name = "contas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contas.findAll", query = "SELECT c FROM Contas c"),
    @NamedQuery(name = "Contas.findByIdConta", query = "SELECT c FROM Contas c WHERE c.idConta = :idConta")})
public class Contas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Conta")
    private Integer idConta;
    @JoinColumn(name = "clientes_Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne(optional = false)
    private Clientes clientesIdCliente;
    @JoinColumn(name = "fornecedores_Id_Fornecedor", referencedColumnName = "Id_Fornecedor")
    @ManyToOne(optional = false)
    private Fornecedores fornecedoresIdFornecedor;

    public Contas() {
    }

    public Contas(Integer idConta) {
        this.idConta = idConta;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Clientes getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(Clientes clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public Fornecedores getFornecedoresIdFornecedor() {
        return fornecedoresIdFornecedor;
    }

    public void setFornecedoresIdFornecedor(Fornecedores fornecedoresIdFornecedor) {
        this.fornecedoresIdFornecedor = fornecedoresIdFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConta != null ? idConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contas)) {
            return false;
        }
        Contas other = (Contas) object;
        if ((this.idConta == null && other.idConta != null) || (this.idConta != null && !this.idConta.equals(other.idConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contas[ idConta=" + idConta + " ]";
    }
    
}
