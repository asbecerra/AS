/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "coches")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coches.findAll", query = "SELECT c FROM Coches c")
    , @NamedQuery(name = "Coches.findByMatriculaCoche", query = "SELECT c FROM Coches c WHERE c.matriculaCoche = :matriculaCoche")
    , @NamedQuery(name = "Coches.findByMarcaCoche", query = "SELECT c FROM Coches c WHERE c.marcaCoche = :marcaCoche")
    , @NamedQuery(name = "Coches.findByModeloCoche", query = "SELECT c FROM Coches c WHERE c.modeloCoche = :modeloCoche")
    , @NamedQuery(name = "Coches.findByNoAsientosCoche", query = "SELECT c FROM Coches c WHERE c.noAsientosCoche = :noAsientosCoche")
    , @NamedQuery(name = "Coches.findByNoPuertasCoche", query = "SELECT c FROM Coches c WHERE c.noPuertasCoche = :noPuertasCoche")
    , @NamedQuery(name = "Coches.findByCapMaleteroCoche", query = "SELECT c FROM Coches c WHERE c.capMaleteroCoche = :capMaleteroCoche")
    , @NamedQuery(name = "Coches.findByEdadMinimaCoche", query = "SELECT c FROM Coches c WHERE c.edadMinimaCoche = :edadMinimaCoche")})
public class Coches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "matricula_coche")
    private String matriculaCoche;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca_coche")
    private String marcaCoche;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modelo_coche")
    private int modeloCoche;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_asientos_coche")
    private int noAsientosCoche;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_puertas_coche")
    private int noPuertasCoche;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cap_maletero_coche")
    private BigInteger capMaleteroCoche;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad_minima_coche")
    private int edadMinimaCoche;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cocheAlquiler")
    private Collection<Alquileres> alquileresCollection;
    @JoinColumns({
        @JoinColumn(name = "tipo_coche", referencedColumnName = "tipo_grupo")
        , @JoinColumn(name = "tamanio_coche", referencedColumnName = "tamanio_grupo")})
    @ManyToOne(optional = false)
    private Grupos grupos;
    @JoinColumn(name = "oficina_coche", referencedColumnName = "codigo_oficina")
    @ManyToOne(optional = false)
    private Oficinas oficinaCoche;

    public Coches() {
    }

    public Coches(String matriculaCoche) {
        this.matriculaCoche = matriculaCoche;
    }

    public Coches(String matriculaCoche, String marcaCoche, int modeloCoche, int noAsientosCoche, int noPuertasCoche, BigInteger capMaleteroCoche, int edadMinimaCoche) {
        this.matriculaCoche = matriculaCoche;
        this.marcaCoche = marcaCoche;
        this.modeloCoche = modeloCoche;
        this.noAsientosCoche = noAsientosCoche;
        this.noPuertasCoche = noPuertasCoche;
        this.capMaleteroCoche = capMaleteroCoche;
        this.edadMinimaCoche = edadMinimaCoche;
    }

    public String getMatriculaCoche() {
        return matriculaCoche;
    }

    public void setMatriculaCoche(String matriculaCoche) {
        this.matriculaCoche = matriculaCoche;
    }

    public String getMarcaCoche() {
        return marcaCoche;
    }

    public void setMarcaCoche(String marcaCoche) {
        this.marcaCoche = marcaCoche;
    }

    public int getModeloCoche() {
        return modeloCoche;
    }

    public void setModeloCoche(int modeloCoche) {
        this.modeloCoche = modeloCoche;
    }

    public int getNoAsientosCoche() {
        return noAsientosCoche;
    }

    public void setNoAsientosCoche(int noAsientosCoche) {
        this.noAsientosCoche = noAsientosCoche;
    }

    public int getNoPuertasCoche() {
        return noPuertasCoche;
    }

    public void setNoPuertasCoche(int noPuertasCoche) {
        this.noPuertasCoche = noPuertasCoche;
    }

    public BigInteger getCapMaleteroCoche() {
        return capMaleteroCoche;
    }

    public void setCapMaleteroCoche(BigInteger capMaleteroCoche) {
        this.capMaleteroCoche = capMaleteroCoche;
    }

    public int getEdadMinimaCoche() {
        return edadMinimaCoche;
    }

    public void setEdadMinimaCoche(int edadMinimaCoche) {
        this.edadMinimaCoche = edadMinimaCoche;
    }

    @XmlTransient
    public Collection<Alquileres> getAlquileresCollection() {
        return alquileresCollection;
    }

    public void setAlquileresCollection(Collection<Alquileres> alquileresCollection) {
        this.alquileresCollection = alquileresCollection;
    }

    public Grupos getGrupos() {
        return grupos;
    }

    public void setGrupos(Grupos grupos) {
        this.grupos = grupos;
    }

    public Oficinas getOficinaCoche() {
        return oficinaCoche;
    }

    public void setOficinaCoche(Oficinas oficinaCoche) {
        this.oficinaCoche = oficinaCoche;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaCoche != null ? matriculaCoche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coches)) {
            return false;
        }
        Coches other = (Coches) object;
        if ((this.matriculaCoche == null && other.matriculaCoche != null) || (this.matriculaCoche != null && !this.matriculaCoche.equals(other.matriculaCoche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.entidades.Coches[ matriculaCoche=" + matriculaCoche + " ]";
    }
    
}
