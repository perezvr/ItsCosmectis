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
import util.Validacoes;

/**
 *
 * @author Maurilio
 */
@Entity
@Table(name = "contatos_clientes_juridicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContatosClientesJuridicos.findAll", query = "SELECT c FROM ContatosClientesJuridicos c"),
    @NamedQuery(name = "ContatosClientesJuridicos.lastId", query = "SELECT max(c.idContatosClientesJuridicos c)"),
    @NamedQuery(name = "ContatosClientesJuridicos.findByIdContatoclientesjuridicos", query = "SELECT c FROM ContatosClientesJuridicos c WHERE c.idContatoclientesjuridicos = :idContatoclientesjuridicos"),
    @NamedQuery(name = "ContatosClientesJuridicos.findByCcjNome", query = "SELECT c FROM ContatosClientesJuridicos c WHERE c.ccjNome = :ccjNome"),
    @NamedQuery(name = "ContatosClientesJuridicos.findByCcjSetor", query = "SELECT c FROM ContatosClientesJuridicos c WHERE c.ccjSetor = :ccjSetor"),
    @NamedQuery(name = "ContatosClientesJuridicos.findByCcjEmail", query = "SELECT c FROM ContatosClientesJuridicos c WHERE c.ccjEmail = :ccjEmail")})
public class ContatosClientesJuridicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Contato_clientes_juridicos")
    private Integer idContatoclientesjuridicos;
    @Basic(optional = false)
    @Column(name = "ccjNome")
    private String ccjNome;
    @Column(name = "ccjSetor")
    private String ccjSetor;
    @Column(name = "ccjEmail")
    private String ccjEmail;
    @OneToMany(mappedBy = "contatosclientesjuridicosIdContatoclientesjuridicos")
    private List<Telefones> telefonesList;
    @JoinColumn(name = "clientes_juridicos_clientes_Id_Cliente", referencedColumnName = "clientes_Id_Cliente")
    @ManyToOne(optional = false)
    private ClientesJuridicos clientesjuridicosclientesIdCliente;

    public ContatosClientesJuridicos() {
    }

    public ContatosClientesJuridicos(Integer idContatoclientesjuridicos) {
        this.idContatoclientesjuridicos = idContatoclientesjuridicos;
    }

    public ContatosClientesJuridicos(Integer idContatoclientesjuridicos, String ccjNome) {
        this.idContatoclientesjuridicos = idContatoclientesjuridicos;
        this.ccjNome = ccjNome;
    }

    public Integer getIdContatoclientesjuridicos() {
        return idContatoclientesjuridicos;
    }

    public void setIdContatoclientesjuridicos(Integer idContatoclientesjuridicos) {
        this.idContatoclientesjuridicos = idContatoclientesjuridicos;
    }

    public String getCcjNome() {
        return ccjNome;
    }

    public void setCcjNome(String ccjNome) throws ValidarException{
        if (!Validacoes.validaLenghtMinimoTexto(ccjNome, 5)) {
            throw new ValidarException();
        }
        this.ccjNome = ccjNome;
    }

    public String getCcjSetor() {
        return ccjSetor;
    }

    public void setCcjSetor(String ccjSetor) throws ValidarException{
        if (Validacoes.validaTextoVazio(ccjSetor)) {
            throw new ValidarException();
        }
        this.ccjSetor = ccjSetor;
    }

    public String getCcjEmail() {
        return ccjEmail;
    }

    public void setCcjEmail(String ccjEmail) throws ValidarException{
        
        if (!Validacoes.isEmailValid(ccjEmail)) {
            if (!ccjEmail.trim().isEmpty()) {
                throw new ValidarException();
            }
        }
        this.ccjEmail = ccjEmail;
    }

    @XmlTransient
    public List<Telefones> getTelefonesList() {
        return telefonesList;
    }

    public void setTelefonesList(List<Telefones> telefonesList) {
        this.telefonesList = telefonesList;
    }

    public ClientesJuridicos getClientesjuridicosclientesIdCliente() {
        return clientesjuridicosclientesIdCliente;
    }

    public void setClientesjuridicosclientesIdCliente(ClientesJuridicos clientesjuridicosclientesIdCliente) {
        this.clientesjuridicosclientesIdCliente = clientesjuridicosclientesIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContatoclientesjuridicos != null ? idContatoclientesjuridicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContatosClientesJuridicos)) {
            return false;
        }
        ContatosClientesJuridicos other = (ContatosClientesJuridicos) object;
        if ((this.idContatoclientesjuridicos == null && other.idContatoclientesjuridicos != null) || (this.idContatoclientesjuridicos != null && !this.idContatoclientesjuridicos.equals(other.idContatoclientesjuridicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ContatosClientesJuridicos[ idContatoclientesjuridicos=" + idContatoclientesjuridicos + " ]";
    }
    
}
