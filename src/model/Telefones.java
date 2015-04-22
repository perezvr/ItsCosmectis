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
@Table(name = "telefones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefones.findAll", query = "SELECT t FROM Telefones t"),
    @NamedQuery(name = "Telefones.findByIdTelefone", query = "SELECT t FROM Telefones t WHERE t.idTelefone = :idTelefone"),
    @NamedQuery(name = "Telefones.findByTelTipoTelefone", query = "SELECT t FROM Telefones t WHERE t.telTipoTelefone = :telTipoTelefone"),
    @NamedQuery(name = "Telefones.findByTelDDD", query = "SELECT t FROM Telefones t WHERE t.telDDD = :telDDD"),
    @NamedQuery(name = "Telefones.findByTelNumero", query = "SELECT t FROM Telefones t WHERE t.telNumero = :telNumero"),
    @NamedQuery(name = "Telefones.findByTelRamal", query = "SELECT t FROM Telefones t WHERE t.telRamal = :telRamal")})
public class Telefones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Telefone")
    private Integer idTelefone;
    @Basic(optional = false)
    @Column(name = "telTipoTelefone")
    private String telTipoTelefone;
    @Column(name = "telDDD")
    private String telDDD;
    @Basic(optional = false)
    @Column(name = "telNumero")
    private String telNumero;
    @Column(name = "telRamal")
    private String telRamal;
    @JoinColumn(name = "clientes_Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne
    private Clientes clientesIdCliente;
    @JoinColumn(name = "contatos_clientes_juridicos_IdContato_clientes_juridicos", referencedColumnName = "Id_Contato_clientes_juridicos")
    @ManyToOne
    private ContatosClientesJuridicos contatosclientesjuridicosIdContatoclientesjuridicos;

    public Telefones() {
    }

    public Telefones(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public Telefones(Integer idTelefone, String telTipoTelefone, String telNumero) {
        this.idTelefone = idTelefone;
        this.telTipoTelefone = telTipoTelefone;
        this.telNumero = telNumero;
    }

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelTipoTelefone() {
        return telTipoTelefone;
    }

    public void setTelTipoTelefone(String telTipoTelefone) throws ValidarException{
        if (telTipoTelefone.trim().equals("R") || telTipoTelefone.trim().equals("M") || telTipoTelefone.trim().equals("C") || telTipoTelefone.trim().equals("O")) {           
        } else{
            throw  new ValidarException();
        }
        this.telTipoTelefone = telTipoTelefone;
    }

    public String getTelDDD() {
        return telDDD;
    }

    public void setTelDDD(String telDDD) throws ValidarException{
        if (!Validacoes.validaLenghtTexto(telDDD,2)) {
            throw new ValidarException();
        }
        this.telDDD = telDDD;
    }

    public String getTelNumero() {
        return telNumero;
    }

    public void setTelNumero(String telNumero) throws ValidarException{
        if ((!Validacoes.validaLenghtTexto(telNumero, 8) || !Validacoes.validaLenghtTexto(telNumero, 9))) {
            throw new ValidarException();
        }
        this.telNumero = telNumero;
    }

    public String getTelRamal() {
        return telRamal;
    }

    public void setTelRamal(String telRamal) {
        this.telRamal = telRamal;
    }

    public Clientes getClientesIdCliente() {
        return clientesIdCliente;
    }

    public void setClientesIdCliente(Clientes clientesIdCliente) {
        this.clientesIdCliente = clientesIdCliente;
    }

    public ContatosClientesJuridicos getContatosclientesjuridicosIdContatoclientesjuridicos() {
        return contatosclientesjuridicosIdContatoclientesjuridicos;
    }

    public void setContatosclientesjuridicosIdContatoclientesjuridicos(ContatosClientesJuridicos contatosclientesjuridicosIdContatoclientesjuridicos) {
        this.contatosclientesjuridicosIdContatoclientesjuridicos = contatosclientesjuridicosIdContatoclientesjuridicos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefone != null ? idTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefones)) {
            return false;
        }
        Telefones other = (Telefones) object;
        if ((this.idTelefone == null && other.idTelefone != null) || (this.idTelefone != null && !this.idTelefone.equals(other.idTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Telefones[ idTelefone=" + idTelefone + " ]";
    }
    
}
