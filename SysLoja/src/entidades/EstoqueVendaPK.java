/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Renan
 */
@Embeddable
public class EstoqueVendaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "estoque_cod_barra")
    private long estoqueCodBarra;
    @Basic(optional = false)
    @Column(name = "venda_id")
    private int vendaId;

    public EstoqueVendaPK() {
    }

    public EstoqueVendaPK(long estoqueCodBarra, int vendaId) {
        this.estoqueCodBarra = estoqueCodBarra;
        this.vendaId = vendaId;
    }

    public long getEstoqueCodBarra() {
        return estoqueCodBarra;
    }

    public void setEstoqueCodBarra(long estoqueCodBarra) {
        this.estoqueCodBarra = estoqueCodBarra;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) estoqueCodBarra;
        hash += (int) vendaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstoqueVendaPK)) {
            return false;
        }
        EstoqueVendaPK other = (EstoqueVendaPK) object;
        if (this.estoqueCodBarra != other.estoqueCodBarra) {
            return false;
        }
        if (this.vendaId != other.vendaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EstoqueVendaPK[ estoqueCodBarra=" + estoqueCodBarra + ", vendaId=" + vendaId + " ]";
    }
    
}
