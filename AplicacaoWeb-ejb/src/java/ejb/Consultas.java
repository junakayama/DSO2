/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leon
 */
@Entity
@Table(name = "CONSULTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultas.findAll", query = "SELECT c FROM Consultas c"),
    @NamedQuery(name = "Consultas.findByCodc", query = "SELECT c FROM Consultas c WHERE c.codc = :codc"),
    @NamedQuery(name = "Consultas.findByHora", query = "SELECT c FROM Consultas c WHERE c.hora = :hora"),
    @NamedQuery(name = "Consultas.findByData", query = "SELECT c FROM Consultas c WHERE c.data = :data")})
public class Consultas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODC")
    private Integer codc;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "CODPAC", referencedColumnName = "CODPAC")
    @ManyToOne
    private Pacientes codpac;
    @JoinColumn(name = "CODPR", referencedColumnName = "CODPR")
    @ManyToOne
    private Profissionais codpr;

    public Consultas() {
    }

    public Consultas(Integer codc) {
        this.codc = codc;
    }

    public Integer getCodc() {
        return codc;
    }

    public void setCodc(Integer codc) {
        this.codc = codc;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Pacientes getCodpac() {
        return codpac;
    }

    public void setCodpac(Pacientes codpac) {
        this.codpac = codpac;
    }

    public Profissionais getCodpr() {
        return codpr;
    }

    public void setCodpr(Profissionais codpr) {
        this.codpr = codpr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codc != null ? codc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultas)) {
            return false;
        }
        Consultas other = (Consultas) object;
        if ((this.codc == null && other.codc != null) || (this.codc != null && !this.codc.equals(other.codc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Consultas[ codc=" + codc + " ]";
    }
    
}
