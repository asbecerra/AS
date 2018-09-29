/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leley
 */
@Entity
@Table(name = "alquileres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alquileres.findAll", query = "SELECT a FROM Alquileres a")
    , @NamedQuery(name = "Alquileres.findByIdAlquiler", query = "SELECT a FROM Alquileres a WHERE a.idAlquiler = :idAlquiler")
    , @NamedQuery(name = "Alquileres.findByFechaInicialAlquiler", query = "SELECT a FROM Alquileres a WHERE a.fechaInicialAlquiler = :fechaInicialAlquiler")
    , @NamedQuery(name = "Alquileres.findByFechaFinalAlquiler", query = "SELECT a FROM Alquileres a WHERE a.fechaFinalAlquiler = :fechaFinalAlquiler")
    , @NamedQuery(name = "Alquileres.findByDiasAlquiler", query = "SELECT a FROM Alquileres a WHERE a.diasAlquiler = :diasAlquiler")
    , @NamedQuery(name = "Alquileres.findByTipoSeguro", query = "SELECT a FROM Alquileres a WHERE a.tipoSeguro = :tipoSeguro")
    , @NamedQuery(name = "Alquileres.findByPrecioAlquiler", query = "SELECT a FROM Alquileres a WHERE a.precioAlquiler = :precioAlquiler")})
public class Alquileres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alquiler")
    private Integer idAlquiler;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicial_alquiler")
    @Temporal(TemporalType.DATE)
    private Date fechaInicialAlquiler;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_final_alquiler")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalAlquiler;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_alquiler")
    private int diasAlquiler;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_seguro")
    private String tipoSeguro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_alquiler")
    private BigDecimal precioAlquiler;
    @JoinColumn(name = "conductor_alquiler", referencedColumnName = "dni_cliente")
    @ManyToOne(optional = false)
    private Clientes conductorAlquiler;
    @JoinColumn(name = "coche_alquiler", referencedColumnName = "matricula_coche")
    @ManyToOne(optional = false)
    private Coches cocheAlquiler;

    public Alquileres() {
    }

    public Alquileres(Integer idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Alquileres(Integer idAlquiler, Date fechaInicialAlquiler, Date fechaFinalAlquiler, int diasAlquiler, String tipoSeguro, BigDecimal precioAlquiler) {
        this.idAlquiler = idAlquiler;
        this.fechaInicialAlquiler = fechaInicialAlquiler;
        this.fechaFinalAlquiler = fechaFinalAlquiler;
        this.diasAlquiler = diasAlquiler;
        this.tipoSeguro = tipoSeguro;
        this.precioAlquiler = precioAlquiler;
    }

    public Integer getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Integer idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Date getFechaInicialAlquiler() {
        return fechaInicialAlquiler;
    }

    public void setFechaInicialAlquiler(Date fechaInicialAlquiler) {
        this.fechaInicialAlquiler = fechaInicialAlquiler;
    }

    public Date getFechaFinalAlquiler() {
        return fechaFinalAlquiler;
    }

    public void setFechaFinalAlquiler(Date fechaFinalAlquiler) {
        this.fechaFinalAlquiler = fechaFinalAlquiler;
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public BigDecimal getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(BigDecimal precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public Clientes getConductorAlquiler() {
        return conductorAlquiler;
    }

    public void setConductorAlquiler(Clientes conductorAlquiler) {
        this.conductorAlquiler = conductorAlquiler;
    }

    public Coches getCocheAlquiler() {
        return cocheAlquiler;
    }

    public void setCocheAlquiler(Coches cocheAlquiler) {
        this.cocheAlquiler = cocheAlquiler;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlquiler != null ? idAlquiler.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alquileres)) {
            return false;
        }
        Alquileres other = (Alquileres) object;
        if ((this.idAlquiler == null && other.idAlquiler != null) || (this.idAlquiler != null && !this.idAlquiler.equals(other.idAlquiler))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.entidades.Alquileres[ idAlquiler=" + idAlquiler + " ]";
    }
    
}
