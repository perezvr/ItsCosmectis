/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import error.ValidarException;
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
import util.Validacoes;

/**
 *
 * @author Maurilio
 */
@Entity
@Table(name = "enderecos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enderecos.findAll", query = "SELECT e FROM Enderecos e"),
    @NamedQuery(name = "Enderecos.findByIdEndereco", query = "SELECT e FROM Enderecos e WHERE e.idEndereco = :idEndereco"),
    @NamedQuery(name = "Enderecos.findByEndLogradouro", query = "SELECT e FROM Enderecos e WHERE e.endLogradouro = :endLogradouro"),
    @NamedQuery(name = "Enderecos.findByEndNumero", query = "SELECT e FROM Enderecos e WHERE e.endNumero = :endNumero"),
    @NamedQuery(name = "Enderecos.findByEndComplemento", query = "SELECT e FROM Enderecos e WHERE e.endComplemento = :endComplemento"),
    @NamedQuery(name = "Enderecos.findByEndReferencia", query = "SELECT e FROM Enderecos e WHERE e.endReferencia = :endReferencia"),
    @NamedQuery(name = "Enderecos.findByEndBairro", query = "SELECT e FROM Enderecos e WHERE e.endBairro = :endBairro"),
    @NamedQuery(name = "Enderecos.findByEndCep", query = "SELECT e FROM Enderecos e WHERE e.endCep = :endCep")})
public class Enderecos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Endereco")
    private Integer idEndereco;
    @Column(name = "endLogradouro")
    private String endLogradouro;
    @Column(name = "endNumero")
    private String endNumero;
    @Column(name = "endComplemento")
    private String endComplemento;
    @Column(name = "endReferencia")
    private String endReferencia;
    @Column(name = "endBairro")
    private String endBairro;
    @Column(name = "endCep")
    private String endCep;
    @JoinColumn(name = "cidades_Id_Cidade", referencedColumnName = "Id_Cidade")
    @ManyToOne(optional = false)
    private Cidades cidadesIdCidade;
    @JoinColumn(name = "clientes_Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne(optional = false)
    private Clientes clientesIdCliente;

    public Enderecos() {
    }

    public Enderecos(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getEndLogradouro() {
        return endLogradouro;
    }

    public void setEndLogradouro(String endLogradouro) throws ValidarException {
        if (!Validacoes.validaLenghtMinimoTexto(endLogradouro, 3)) {
            throw new ValidarException();
        }
        this.endLogradouro = endLogradouro;
    }

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) throws ValidarException {
        if (Validacoes.validaTextoVazio(endNumero)) {
            throw new ValidarException();
        }
        this.endNumero = endNumero;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    public String getEndReferencia() {
        return endReferencia;
    }

    public void setEndReferencia(String endReferencia) {
        this.endReferencia = endReferencia;
    }

    public String getEndBairro() {

        return endBairro;
    }

    public void setEndBairro(String endBairro) throws ValidarException {
        if (!Validacoes.validaLenghtMinimoTexto(endBairro, 3)) {
            throw new ValidarException();
        }
        this.endBairro = endBairro;
    }

    public String getEndCep() {

        endCep = endCep.substring(0, 5) + "-" + endCep.substring(5, 3);

        return endCep;
    }

    public void setEndCep(String endCep) throws ValidarException {
        if (!Validacoes.validaLenghtTexto(endCep, 8)) {
            throw new ValidarException();
        }

        endCep = endCep.replace("-","");
        
        this.endCep = endCep;
    }

    public Cidades getCidadesIdCidade() {
        return cidadesIdCidade;
    }

    public void setCidadesIdCidade(Cidades cidadesIdCidade) {
        this.cidadesIdCidade = cidadesIdCidade;
    }

    public Clientes getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(Clientes clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enderecos)) {
            return false;
        }
        Enderecos other = (Enderecos) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Enderecos[ idEndereco=" + idEndereco + " ]";
    }

}
