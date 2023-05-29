/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "forma_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPagamento.findAll", query = "SELECT f FROM FormaPagamento f"),
    @NamedQuery(name = "FormaPagamento.findById", query = "SELECT f FROM FormaPagamento f WHERE f.id = :id"),
    @NamedQuery(name = "FormaPagamento.findByNumParcelas", query = "SELECT f FROM FormaPagamento f WHERE f.numParcelas = :numParcelas"),
    @NamedQuery(name = "FormaPagamento.findByCartao", query = "SELECT f FROM FormaPagamento f WHERE f.cartao = :cartao"),
    @NamedQuery(name = "FormaPagamento.findByTaxaJuros", query = "SELECT f FROM FormaPagamento f WHERE f.taxaJuros = :taxaJuros"),
    @NamedQuery(name = "FormaPagamento.findByTipoCartao", query = "SELECT f FROM FormaPagamento f WHERE f.tipoCartao = :tipoCartao"),
    @NamedQuery(name = "FormaPagamento.findParcelasJurosByFormaTipo", query = "SELECT f.numParcelas, f.taxaJuros FROM FormaPagamento f WHERE f.cartao = :cartao AND f.tipoCartao = :tipoCartao ORDER BY f.numParcelas ASC"),
    @NamedQuery(name = "FormaPagamento.findByTipoCartaoParcelas", query = "SELECT f FROM FormaPagamento f WHERE f.cartao = :cartao AND f.tipoCartao = :tipoCartao AND f.numParcelas = :numParcelas")})
public class FormaPagamento implements Serializable {
    @Basic(optional = false)
    @Column(name = "tipo_cartao")
    private boolean tipoCartao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPagamentoId")
    private List<Venda> vendaList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "num_parcelas")
    private int numParcelas;
    @Basic(optional = false)
    @Column(name = "cartao")
    private boolean cartao;
    @Basic(optional = false)
    @Column(name = "taxa_juros")
    private double taxaJuros;

    public FormaPagamento() {
    }

    public FormaPagamento(Integer id) {
        this.id = id;
    }

    public FormaPagamento(Integer id, int numParcelas, boolean cartao, double taxaJuros) {
        this.id = id;
        this.numParcelas = numParcelas;
        this.cartao = cartao;
        this.taxaJuros = taxaJuros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public boolean getCartao() {
        return cartao;
    }

    public void setCartao(boolean cartao) {
        this.cartao = cartao;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public Boolean getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(Boolean tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPagamento)) {
            return false;
        }
        FormaPagamento other = (FormaPagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FormaPagamento[ id=" + id + " ]";
    }


    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }
    
}
