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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "fornecedores_produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FornecedoresProdutos.findAll", query = "SELECT f FROM FornecedoresProdutos f"),
    @NamedQuery(name = "FornecedoresProdutos.findByIdfornecedoresprodutos", query = "SELECT f FROM FornecedoresProdutos f WHERE f.idfornecedoresprodutos = :idfornecedoresprodutos")})
public class FornecedoresProdutos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_fornecedores_produtos")
    private Integer idfornecedoresprodutos;
    @JoinTable(name = "fornecedores_produtos_vendas", joinColumns = {
        @JoinColumn(name = "fornecedores_produtos_Id_fornecedores_produtos", referencedColumnName = "Id_fornecedores_produtos")}, inverseJoinColumns = {
        @JoinColumn(name = "vendas_Id_Vendas", referencedColumnName = "Id_Vendas")})
    @ManyToMany
    private List<Vendas> vendasList;
    @JoinColumn(name = "fornecedores_Id_Fornecedor", referencedColumnName = "Id_Fornecedor")
    @ManyToOne(optional = false)
    private Fornecedores fornecedoresIdFornecedor;
    @JoinColumn(name = "produtos_Id_Produto", referencedColumnName = "Id_Produto")
    @ManyToOne(optional = false)
    private Produtos produtosIdProduto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedoresprodutosIdfornecedoresprodutos")
    private List<Estoques> estoquesList;

    public FornecedoresProdutos() {
    }

    public FornecedoresProdutos(Integer idfornecedoresprodutos) {
        this.idfornecedoresprodutos = idfornecedoresprodutos;
    }

    public Integer getIdfornecedoresprodutos() {
        return idfornecedoresprodutos;
    }

    public void setIdfornecedoresprodutos(Integer idfornecedoresprodutos) {
        this.idfornecedoresprodutos = idfornecedoresprodutos;
    }

    @XmlTransient
    public List<Vendas> getVendasList() {
        return vendasList;
    }

    public void setVendasList(List<Vendas> vendasList) {
        this.vendasList = vendasList;
    }

    public Fornecedores getFornecedoresIdFornecedor() {
        return fornecedoresIdFornecedor;
    }

    public void setFornecedoresIdFornecedor(Fornecedores fornecedoresIdFornecedor) {
        this.fornecedoresIdFornecedor = fornecedoresIdFornecedor;
    }

    public Produtos getProdutosIdProduto() {
        return produtosIdProduto;
    }

    public void setProdutosIdProduto(Produtos produtosIdProduto) {
        this.produtosIdProduto = produtosIdProduto;
    }

    @XmlTransient
    public List<Estoques> getEstoquesList() {
        return estoquesList;
    }

    public void setEstoquesList(List<Estoques> estoquesList) {
        this.estoquesList = estoquesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfornecedoresprodutos != null ? idfornecedoresprodutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FornecedoresProdutos)) {
            return false;
        }
        FornecedoresProdutos other = (FornecedoresProdutos) object;
        if ((this.idfornecedoresprodutos == null && other.idfornecedoresprodutos != null) || (this.idfornecedoresprodutos != null && !this.idfornecedoresprodutos.equals(other.idfornecedoresprodutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FornecedoresProdutos[ idfornecedoresprodutos=" + idfornecedoresprodutos + " ]";
    }
    
}
