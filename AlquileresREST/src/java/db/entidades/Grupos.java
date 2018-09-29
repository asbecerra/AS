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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leley
 */
@Entity
@Table(name = "grupos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupos.findAll", query = "SELECT g FROM Grupos g")
    , @NamedQuery(name = "Grupos.findByCaracterGrupo", query = "SELECT g FROM Grupos g WHERE g.caracterGrupo = :caracterGrupo")
    , @NamedQuery(name = "Grupos.findByTipoGrupo", query = "SELECT g FROM Grupos g WHERE g.gruposPK.tipoGrupo = :tipoGrupo")
    , @NamedQuery(name = "Grupos.findByTamanioGrupo", query = "SELECT g FROM Grupos g WHERE g.gruposPK.tamanioGrupo = :tamanioGrupo")})
public class Grupos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GruposPK gruposPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caracter_grupo")
    private Character caracterGrupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupos")
    private Collection<Coches> cochesCollection;

    public Grupos() {
    }

    public Grupos(GruposPK gruposPK) {
        this.gruposPK = gruposPK;
    }

    public Grupos(GruposPK gruposPK, Character caracterGrupo) {
        this.gruposPK = gruposPK;
        this.caracterGrupo = caracterGrupo;
    }

    public Grupos(String tipoGrupo, String tamanioGrupo) {
        this.gruposPK = new GruposPK(tipoGrupo, tamanioGrupo);
    }

    public GruposPK getGruposPK() {
        return gruposPK;
    }

    public void setGruposPK(GruposPK gruposPK) {
        this.gruposPK = gruposPK;
    }

    public Character getCaracterGrupo() {
        return caracterGrupo;
    }

    public void setCaracterGrupo(Character caracterGrupo) {
        this.caracterGrupo = caracterGrupo;
    }

    @XmlTransient
    public Collection<Coches> getCochesCollection() {
        return cochesCollection;
    }

    public void setCochesCollection(Collection<Coches> cochesCollection) {
        this.cochesCollection = cochesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gruposPK != null ? gruposPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupos)) {
            return false;
        }
        Grupos other = (Grupos) object;
        if ((this.gruposPK == null && other.gruposPK != null) || (this.gruposPK != null && !this.gruposPK.equals(other.gruposPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.entidades.Grupos[ gruposPK=" + gruposPK + " ]";
    }
    
}
