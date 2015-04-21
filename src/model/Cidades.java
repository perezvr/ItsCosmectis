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
@Table(name = "cidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidades.findAll", query = "SELECT c FROM Cidades c"),
    @NamedQuery(name = "Cidades.findByIdCidade", query = "SELECT c FROM Cidades c WHERE c.idCidade = :idCidade"),
    @NamedQuery(name = "Cidades.findByCidNome", query = "SELECT c FROM Cidades c WHERE c.cidNome = :cidNome")})
public class Cidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Cidade")
    private Integer idCidade;
    @Basic(optional = false)
    @Column(name = "cidNome")
    private String cidNome;
    @JoinColumn(name = "ufs_Id_Uf", referencedColumnName = "Id_Uf")
    @ManyToOne(optional = false)
    private Ufs ufsIdUf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadesIdCidade")
    private List<Enderecos> enderecosList;

    public Cidades() {
    }

    public Cidades(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Cidades(Integer idCidade, String cidNome) {
        this.idCidade = idCidade;
        this.cidNome = cidNome;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getCidNome() {
        return cidNome;
    }

    public void setCidNome(String cidNome) {
        this.cidNome = cidNome;
    }

    public Ufs getUfsIdUf() {
        return ufsIdUf;
    }

    public void setUfsIdUf(Ufs ufsIdUf) {
        this.ufsIdUf = ufsIdUf;
    }

    @XmlTransient
    public List<Enderecos> getEnderecosList() {
        return enderecosList;
    }

    public void setEnderecosList(List<Enderecos> enderecosList) {
        this.enderecosList = enderecosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCidade != null ? idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidades)) {
            return false;
        }
        Cidades other = (Cidades) object;
        if ((this.idCidade == null && other.idCidade != null) || (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cidades[ idCidade=" + idCidade + " ]";
    }
    
}
