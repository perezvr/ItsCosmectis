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
@Table(name = "ufs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ufs.findAll", query = "SELECT u FROM Ufs u"),
    @NamedQuery(name = "Ufs.findByIdUf", query = "SELECT u FROM Ufs u WHERE u.idUf = :idUf"),
    @NamedQuery(name = "Ufs.findByUfSigla", query = "SELECT u FROM Ufs u WHERE u.ufSigla = :ufSigla"),
    @NamedQuery(name = "Ufs.findByUfNome", query = "SELECT u FROM Ufs u WHERE u.ufNome = :ufNome")})
public class Ufs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Uf")
    private Integer idUf;
    @Basic(optional = false)
    @Column(name = "ufSigla")
    private String ufSigla;
    @Basic(optional = false)
    @Column(name = "ufNome")
    private String ufNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ufsIdUf")
    private List<Cidades> cidadesList;

    public Ufs() {
    }

    public Ufs(Integer idUf) {
        this.idUf = idUf;
    }

    public Ufs(Integer idUf, String ufSigla, String ufNome) {
        this.idUf = idUf;
        this.ufSigla = ufSigla;
        this.ufNome = ufNome;
    }

    public Integer getIdUf() {
        return idUf;
    }

    public void setIdUf(Integer idUf) {
        this.idUf = idUf;
    }

    public String getUfSigla() {
        return ufSigla;
    }

    public void setUfSigla(String ufSigla) {
        this.ufSigla = ufSigla;
    }

    public String getUfNome() {
        return ufNome;
    }

    public void setUfNome(String ufNome) {
        this.ufNome = ufNome;
    }

    @XmlTransient
    public List<Cidades> getCidadesList() {
        return cidadesList;
    }

    public void setCidadesList(List<Cidades> cidadesList) {
        this.cidadesList = cidadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUf != null ? idUf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ufs)) {
            return false;
        }
        Ufs other = (Ufs) object;
        if ((this.idUf == null && other.idUf != null) || (this.idUf != null && !this.idUf.equals(other.idUf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ufs[ idUf=" + idUf + " ]";
    }
    
}
