/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "PACIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByCodpac", query = "SELECT p FROM Pacientes p WHERE p.codpac = :codpac"),
    @NamedQuery(name = "Pacientes.findByNome", query = "SELECT p FROM Pacientes p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pacientes.findByUsuario", query = "SELECT p FROM Pacientes p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "Pacientes.findBySenha", query = "SELECT p FROM Pacientes p WHERE p.senha = :senha")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPAC")
    private Integer codpac;
    @Size(max = 30)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 20)
    @Column(name = "SENHA")
    private String senha;
    @OneToMany(mappedBy = "codpac")
    private Collection<Consultas> consultasCollection;

    public Pacientes() {
    }

    public Pacientes(Integer codpac) {
        this.codpac = codpac;
    }

    public Integer getCodpac() {
        return codpac;
    }

    public void setCodpac(Integer codpac) {
        this.codpac = codpac;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public Collection<Consultas> getConsultasCollection() {
        return consultasCollection;
    }

    public void setConsultasCollection(Collection<Consultas> consultasCollection) {
        this.consultasCollection = consultasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpac != null ? codpac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.codpac == null && other.codpac != null) || (this.codpac != null && !this.codpac.equals(other.codpac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Pacientes[ codpac=" + codpac + " ]";
    }
    
}
