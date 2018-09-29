/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author leley
 */
@Embeddable
public class GruposPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_grupo")
    private String tipoGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tamanio_grupo")
    private String tamanioGrupo;

    public GruposPK() {
    }

    public GruposPK(String tipoGrupo, String tamanioGrupo) {
        this.tipoGrupo = tipoGrupo;
        this.tamanioGrupo = tamanioGrupo;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public String getTamanioGrupo() {
        return tamanioGrupo;
    }

    public void setTamanioGrupo(String tamanioGrupo) {
        this.tamanioGrupo = tamanioGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoGrupo != null ? tipoGrupo.hashCode() : 0);
        hash += (tamanioGrupo != null ? tamanioGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GruposPK)) {
            return false;
        }
        GruposPK other = (GruposPK) object;
        if ((this.tipoGrupo == null && other.tipoGrupo != null) || (this.tipoGrupo != null && !this.tipoGrupo.equals(other.tipoGrupo))) {
            return false;
        }
        if ((this.tamanioGrupo == null && other.tamanioGrupo != null) || (this.tamanioGrupo != null && !this.tamanioGrupo.equals(other.tamanioGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.entidades.GruposPK[ tipoGrupo=" + tipoGrupo + ", tamanioGrupo=" + tamanioGrupo + " ]";
    }
    
}
