/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "estoque_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstoqueVenda.findAll", query = "SELECT e FROM EstoqueVenda e"),
    @NamedQuery(name = "EstoqueVenda.findByEstoqueCodBarra", query = "SELECT e FROM EstoqueVenda e WHERE e.estoqueVendaPK.estoqueCodBarra = :estoqueCodBarra"),
    @NamedQuery(name = "EstoqueVenda.findByVendaId", query = "SELECT e FROM EstoqueVenda e WHERE e.estoqueVendaPK.vendaId = :vendaId"),
    @NamedQuery(name = "EstoqueVenda.findByQuantidade", query = "SELECT e FROM EstoqueVenda e WHERE e.quantidade = :quantidade"),
    @NamedQuery(name = "EstoqueVenda.findByValorUnitario", query = "SELECT e FROM EstoqueVenda e WHERE e.valorUnitario = :valorUnitario")})
public class EstoqueVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstoqueVendaPK estoqueVendaPK;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "valor_unitario")
    private double valorUnitario;
    @JoinColumn(name = "estoque_cod_barra", referencedColumnName = "cod_barra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estoque estoque;
    @JoinColumn(name = "venda_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venda venda;

    public EstoqueVenda() {
    }

    public EstoqueVenda(EstoqueVendaPK estoqueVendaPK) {
        this.estoqueVendaPK = estoqueVendaPK;
    }

    public EstoqueVenda(EstoqueVendaPK estoqueVendaPK, int quantidade, double valorUnitario) {
        this.estoqueVendaPK = estoqueVendaPK;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public EstoqueVenda(long estoqueCodBarra, int vendaId) {
        this.estoqueVendaPK = new EstoqueVendaPK(estoqueCodBarra, vendaId);
    }

    public EstoqueVendaPK getEstoqueVendaPK() {
        return estoqueVendaPK;
    }

    public void setEstoqueVendaPK(EstoqueVendaPK estoqueVendaPK) {
        this.estoqueVendaPK = estoqueVendaPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estoqueVendaPK != null ? estoqueVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstoqueVenda)) {
            return false;
        }
        EstoqueVenda other = (EstoqueVenda) object;
        if ((this.estoqueVendaPK == null && other.estoqueVendaPK != null) || (this.estoqueVendaPK != null && !this.estoqueVendaPK.equals(other.estoqueVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EstoqueVenda[ estoqueVendaPK=" + estoqueVendaPK + " ]";
    }
    
}
