/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan 2016
 */
@Entity
@Table(name = "fornecimento_estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FornecimentoEstoque.findAll", query = "SELECT f FROM FornecimentoEstoque f"),
    @NamedQuery(name = "FornecimentoEstoque.findByFornecimentoId", query = "SELECT f FROM FornecimentoEstoque f WHERE f.fornecimentoEstoquePK.fornecimentoId = :fornecimentoId"),
    @NamedQuery(name = "FornecimentoEstoque.findByEstoqueCodBarra", query = "SELECT f FROM FornecimentoEstoque f WHERE f.fornecimentoEstoquePK.estoqueCodBarra = :estoqueCodBarra"),
    @NamedQuery(name = "FornecimentoEstoque.findByQuantidade", query = "SELECT f FROM FornecimentoEstoque f WHERE f.quantidade = :quantidade"),
    @NamedQuery(name = "FornecimentoEstoque.findByDisponivelEstoque", query = "SELECT f FROM FornecimentoEstoque f WHERE f.disponivelEstoque = :disponivelEstoque"),
    @NamedQuery(name = "FornecimentoEstoque.findByValorUnitario", query = "SELECT f FROM FornecimentoEstoque f WHERE f.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "FornecimentoEstoque.findByDataFabricacao", query = "SELECT f FROM FornecimentoEstoque f WHERE f.dataFabricacao = :dataFabricacao"),
    @NamedQuery(name = "FornecimentoEstoque.findByDataVencimento", query = "SELECT f FROM FornecimentoEstoque f WHERE f.dataVencimento = :dataVencimento")})
public class FornecimentoEstoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FornecimentoEstoquePK fornecimentoEstoquePK;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "disponivel_estoque")
    private boolean disponivelEstoque;
    @Basic(optional = false)
    @Column(name = "valor_unitario")
    private double valorUnitario;
    @Column(name = "data_fabricacao")
    @Temporal(TemporalType.DATE)
    private Date dataFabricacao;
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @JoinColumn(name = "estoque_cod_barra", referencedColumnName = "cod_barra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estoque estoque;
    @JoinColumn(name = "fornecimento_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fornecimento fornecimento;

    public FornecimentoEstoque() {
    }

    public FornecimentoEstoque(FornecimentoEstoquePK fornecimentoEstoquePK) {
        this.fornecimentoEstoquePK = fornecimentoEstoquePK;
    }

    public FornecimentoEstoque(FornecimentoEstoquePK fornecimentoEstoquePK, int quantidade, boolean disponivelEstoque, double valorUnitario) {
        this.fornecimentoEstoquePK = fornecimentoEstoquePK;
        this.quantidade = quantidade;
        this.disponivelEstoque = disponivelEstoque;
        this.valorUnitario = valorUnitario;
    }

    public FornecimentoEstoque(int fornecimentoId, long estoqueCodBarra) {
        this.fornecimentoEstoquePK = new FornecimentoEstoquePK(fornecimentoId, estoqueCodBarra);
    }

    public FornecimentoEstoquePK getFornecimentoEstoquePK() {
        return fornecimentoEstoquePK;
    }

    public void setFornecimentoEstoquePK(FornecimentoEstoquePK fornecimentoEstoquePK) {
        this.fornecimentoEstoquePK = fornecimentoEstoquePK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean getDisponivelEstoque() {
        return disponivelEstoque;
    }

    public void setDisponivelEstoque(boolean disponivelEstoque) {
        this.disponivelEstoque = disponivelEstoque;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Fornecimento getFornecimento() {
        return fornecimento;
    }

    public void setFornecimento(Fornecimento fornecimento) {
        this.fornecimento = fornecimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fornecimentoEstoquePK != null ? fornecimentoEstoquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FornecimentoEstoque)) {
            return false;
        }
        FornecimentoEstoque other = (FornecimentoEstoque) object;
        if ((this.fornecimentoEstoquePK == null && other.fornecimentoEstoquePK != null) || (this.fornecimentoEstoquePK != null && !this.fornecimentoEstoquePK.equals(other.fornecimentoEstoquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FornecimentoEstoque[ fornecimentoEstoquePK=" + fornecimentoEstoquePK + " ]";
    }
    
}
