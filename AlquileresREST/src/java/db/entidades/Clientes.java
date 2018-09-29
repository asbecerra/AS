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
 * @author leley
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByDniCliente", query = "SELECT c FROM Clientes c WHERE c.dniCliente = :dniCliente")
    , @NamedQuery(name = "Clientes.findByNombreCliente", query = "SELECT c FROM Clientes c WHERE c.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Clientes.findByCalleCliente", query = "SELECT c FROM Clientes c WHERE c.calleCliente = :calleCliente")
    , @NamedQuery(name = "Clientes.findByNumeroCliente", query = "SELECT c FROM Clientes c WHERE c.numeroCliente = :numeroCliente")
    , @NamedQuery(name = "Clientes.findByCodigoPostalCliente", query = "SELECT c FROM Clientes c WHERE c.codigoPostalCliente = :codigoPostalCliente")
    , @NamedQuery(name = "Clientes.findByTelefonoCliente", query = "SELECT c FROM Clientes c WHERE c.telefonoCliente = :telefonoCliente")
    , @NamedQuery(name = "Clientes.findByTarjetaCreditoCliente", query = "SELECT c FROM Clientes c WHERE c.tarjetaCreditoCliente = :tarjetaCreditoCliente")
    , @NamedQuery(name = "Clientes.findByEdadCliente", query = "SELECT c FROM Clientes c WHERE c.edadCliente = :edadCliente")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dni_cliente")
    private Long dniCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "calle_cliente")
    private String calleCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_cliente")
    private int numeroCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_postal_cliente")
    private int codigoPostalCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono_cliente")
    private long telefonoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarjeta_credito_cliente")
    private long tarjetaCreditoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad_cliente")
    private int edadCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conductorAlquiler")
    private Collection<Alquileres> alquileresCollection;

    public Clientes() {
    }

    public Clientes(Long dniCliente) {
        this.dniCliente = dniCliente;
    }

    public Clientes(Long dniCliente, String nombreCliente, String calleCliente, int numeroCliente, int codigoPostalCliente, long telefonoCliente, long tarjetaCreditoCliente, int edadCliente) {
        this.dniCliente = dniCliente;
        this.nombreCliente = nombreCliente;
        this.calleCliente = calleCliente;
        this.numeroCliente = numeroCliente;
        this.codigoPostalCliente = codigoPostalCliente;
        this.telefonoCliente = telefonoCliente;
        this.tarjetaCreditoCliente = tarjetaCreditoCliente;
        this.edadCliente = edadCliente;
    }

    public Long getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(Long dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCalleCliente() {
        return calleCliente;
    }

    public void setCalleCliente(String calleCliente) {
        this.calleCliente = calleCliente;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getCodigoPostalCliente() {
        return codigoPostalCliente;
    }

    public void setCodigoPostalCliente(int codigoPostalCliente) {
        this.codigoPostalCliente = codigoPostalCliente;
    }

    public long getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(long telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public long getTarjetaCreditoCliente() {
        return tarjetaCreditoCliente;
    }

    public void setTarjetaCreditoCliente(long tarjetaCreditoCliente) {
        this.tarjetaCreditoCliente = tarjetaCreditoCliente;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    @XmlTransient
    public Collection<Alquileres> getAlquileresCollection() {
        return alquileresCollection;
    }

    public void setAlquileresCollection(Collection<Alquileres> alquileresCollection) {
        this.alquileresCollection = alquileresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniCliente != null ? dniCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.dniCliente == null && other.dniCliente != null) || (this.dniCliente != null && !this.dniCliente.equals(other.dniCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.entidades.Clientes[ dniCliente=" + dniCliente + " ]";
    }
    
}
