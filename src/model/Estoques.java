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
@Table(name = "estoques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estoques.findAll", query = "SELECT e FROM Estoques e"),
    @NamedQuery(name = "Estoques.findByIdEstoque", query = "SELECT e FROM Estoques e WHERE e.idEstoque = :idEstoque")})
public class Estoques implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Estoque")
    private Integer idEstoque;
    @JoinColumn(name = "fornecedores_produtos_Id_fornecedores_produtos", referencedColumnName = "Id_fornecedores_produtos")
    @ManyToOne(optional = false)
    private FornecedoresProdutos fornecedoresprodutosIdfornecedoresprodutos;

    public Estoques() {
    }

    public Estoques(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public FornecedoresProdutos getFornecedoresprodutosIdfornecedoresprodutos() {
        return fornecedoresprodutosIdfornecedoresprodutos;
    }

    public void setFornecedoresprodutosIdfornecedoresprodutos(FornecedoresProdutos fornecedoresprodutosIdfornecedoresprodutos) {
        this.fornecedoresprodutosIdfornecedoresprodutos = fornecedoresprodutosIdfornecedoresprodutos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstoque != null ? idEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoques)) {
            return false;
        }
        Estoques other = (Estoques) object;
        if ((this.idEstoque == null && other.idEstoque != null) || (this.idEstoque != null && !this.idEstoque.equals(other.idEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estoques[ idEstoque=" + idEstoque + " ]";
    }
    
}
