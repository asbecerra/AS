/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author leley
 */
@Entity
@Table(name = "oficinas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oficinas.findAll", query = "SELECT o FROM Oficinas o")
    , @NamedQuery(name = "Oficinas.findByCodigoOficina", query = "SELECT o FROM Oficinas o WHERE o.codigoOficina = :codigoOficina")
    , @NamedQuery(name = "Oficinas.findByCalleOficina", query = "SELECT o FROM Oficinas o WHERE o.calleOficina = :calleOficina")
    , @NamedQuery(name = "Oficinas.findByNumeroOficina", query = "SELECT o FROM Oficinas o WHERE o.numeroOficina = :numeroOficina")
    , @NamedQuery(name = "Oficinas.findByCodigoPostalOficina", query = "SELECT o FROM Oficinas o WHERE o.codigoPostalOficina = :codigoPostalOficina")
    , @NamedQuery(name = "Oficinas.findByTelefonoOficina", query = "SELECT o FROM Oficinas o WHERE o.telefonoOficina = :telefonoOficina")})
public class Oficinas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_oficina")
    private Integer codigoOficina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "calle_oficina")
    private String calleOficina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_oficina")
    private int numeroOficina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_postal_oficina")
    private int codigoPostalOficina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono_oficina")
    private long telefonoOficina;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oficinaCoche")
    private Collection<Coches> cochesCollection;
    @JoinColumn(name = "id_ciudad_oficina", referencedColumnName = "id_ciudad")
    @ManyToOne(optional = false)
    private Ciudades idCiudadOficina;

    public Oficinas() {
    }

    public Oficinas(Integer codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public Oficinas(Integer codigoOficina, String calleOficina, int numeroOficina, int codigoPostalOficina, long telefonoOficina) {
        this.codigoOficina = codigoOficina;
        this.calleOficina = calleOficina;
        this.numeroOficina = numeroOficina;
        this.codigoPostalOficina = codigoPostalOficina;
        this.telefonoOficina = telefonoOficina;
    }

    public Integer getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(Integer codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String getCalleOficina() {
        return calleOficina;
    }

    public void setCalleOficina(String calleOficina) {
        this.calleOficina = calleOficina;
    }

    public int getNumeroOficina() {
        return numeroOficina;
    }

    public void setNumeroOficina(int numeroOficina) {
        this.numeroOficina = numeroOficina;
    }

    public int getCodigoPostalOficina() {
        return codigoPostalOficina;
    }

    public void setCodigoPostalOficina(int codigoPostalOficina) {
        this.codigoPostalOficina = codigoPostalOficina;
    }

    public long getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setTelefonoOficina(long telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    @XmlTransient
    public Collection<Coches> getCochesCollection() {
        return cochesCollection;
    }

    public void setCochesCollection(Collection<Coches> cochesCollection) {
        this.cochesCollection = cochesCollection;
    }

    public Ciudades getIdCiudadOficina() {
        return idCiudadOficina;
    }

    public void setIdCiudadOficina(Ciudades idCiudadOficina) {
        this.idCiudadOficina = idCiudadOficina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOficina != null ? codigoOficina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficinas)) {
            return false;
        }
        Oficinas other = (Oficinas) object;
        if ((this.codigoOficina == null && other.codigoOficina != null) || (this.codigoOficina != null && !this.codigoOficina.equals(other.codigoOficina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.entidades.Oficinas[ codigoOficina=" + codigoOficina + " ]";
    }
    
}
