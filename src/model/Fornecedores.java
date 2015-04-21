/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maurilio
 */
@Entity
@Table(name = "fornecedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedores.findAll", query = "SELECT f FROM Fornecedores f"),
    @NamedQuery(name = "Fornecedores.findByIdFornecedor", query = "SELECT f FROM Fornecedores f WHERE f.idFornecedor = :idFornecedor")})
public class Fornecedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Fornecedor")
    private Integer idFornecedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedoresIdFornecedor")
    private List<FornecedoresProdutos> fornecedoresProdutosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedoresIdFornecedor")
    private List<Contas> contasList;

    public Fornecedores() {
    }

    public Fornecedores(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @XmlTransient
    public List<FornecedoresProdutos> getFornecedoresProdutosList() {
        return fornecedoresProdutosList;
    }

    public void setFornecedoresProdutosList(List<FornecedoresProdutos> fornecedoresProdutosList) {
        this.fornecedoresProdutosList = fornecedoresProdutosList;
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
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedores)) {
            return false;
        }
        Fornecedores other = (Fornecedores) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fornecedores[ idFornecedor=" + idFornecedor + " ]";
    }
    
}
