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
 * @author Renan 2016
 */
@Embeddable
public class FornecimentoEstoquePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "fornecimento_id")
    private int fornecimentoId;
    @Basic(optional = false)
    @Column(name = "estoque_cod_barra")
    private long estoqueCodBarra;

    public FornecimentoEstoquePK() {
    }

    public FornecimentoEstoquePK(int fornecimentoId, long estoqueCodBarra) {
        this.fornecimentoId = fornecimentoId;
        this.estoqueCodBarra = estoqueCodBarra;
    }

    public int getFornecimentoId() {
        return fornecimentoId;
    }

    public void setFornecimentoId(int fornecimentoId) {
        this.fornecimentoId = fornecimentoId;
    }

    public long getEstoqueCodBarra() {
        return estoqueCodBarra;
    }

    public void setEstoqueCodBarra(long estoqueCodBarra) {
        this.estoqueCodBarra = estoqueCodBarra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fornecimentoId;
        hash += (int) estoqueCodBarra;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FornecimentoEstoquePK)) {
            return false;
        }
        FornecimentoEstoquePK other = (FornecimentoEstoquePK) object;
        if (this.fornecimentoId != other.fornecimentoId) {
            return false;
        }
        if (this.estoqueCodBarra != other.estoqueCodBarra) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FornecimentoEstoquePK[ fornecimentoId=" + fornecimentoId + ", estoqueCodBarra=" + estoqueCodBarra + " ]";
    }
    
}
