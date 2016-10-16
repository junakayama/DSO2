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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Leon
 */
@Entity
@Table(name = "PROFISSIONAIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profissionais.findAll", query = "SELECT p FROM Profissionais p"),
    @NamedQuery(name = "Profissionais.findByCodpr", query = "SELECT p FROM Profissionais p WHERE p.codpr = :codpr"),
    @NamedQuery(name = "Profissionais.findByNome", query = "SELECT p FROM Profissionais p WHERE p.nome = :nome")})
public class Profissionais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPR")
    private Integer codpr;
    @Size(max = 30)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(mappedBy = "codpr")
    private Collection<Consultas> consultasCollection;
    @JoinColumn(name = "SETOR", referencedColumnName = "NOME")
    @ManyToOne
    private Setores setor;

    public Profissionais() {
    }

    public Profissionais(Integer codpr) {
        this.codpr = codpr;
    }

    public Integer getCodpr() {
        return codpr;
    }

    public void setCodpr(Integer codpr) {
        this.codpr = codpr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Consultas> getConsultasCollection() {
        return consultasCollection;
    }

    public void setConsultasCollection(Collection<Consultas> consultasCollection) {
        this.consultasCollection = consultasCollection;
    }

    public Setores getSetor() {
        return setor;
    }

    public void setSetor(Setores setor) {
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpr != null ? codpr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profissionais)) {
            return false;
        }
        Profissionais other = (Profissionais) object;
        if ((this.codpr == null && other.codpr != null) || (this.codpr != null && !this.codpr.equals(other.codpr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Profissionais[ codpr=" + codpr + " ]";
    }
    
}
