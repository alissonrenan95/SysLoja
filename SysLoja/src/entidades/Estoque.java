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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renan 2016
 */
@Entity
@Table(name = "estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e"),
    @NamedQuery(name = "Estoque.findByCodBarra", query = "SELECT e FROM Estoque e WHERE e.codBarra = :codBarra"),
    @NamedQuery(name = "Estoque.findByDisponivelVenda", query = "SELECT e FROM Estoque e WHERE e.disponivelVenda = :disponivelVenda"),
    @NamedQuery(name = "Estoque.findByQuantidade", query = "SELECT e FROM Estoque e WHERE e.quantidade = :quantidade"),
    @NamedQuery(name = "Estoque.findByCodigoBarra", query = "SELECT e FROM Estoque e WHERE e.codBarra = :codBarra AND e.disponivelVenda=TRUE"),
    @NamedQuery(name = "Estoque.findAvailableByCodBarraAndQuantidade", query = "SELECT e FROM Estoque e WHERE e.codBarra = :codBarra AND e.quantidade >= :quantidade AND e.disponivelVenda=TRUE"),
    @NamedQuery(name = "Estoque.findCodBarraIdNomeValorById", query = "SELECT e.codBarra, p.id, p.nome, p.valorUnitario FROM Produto p, Estoque e WHERE e.produtoId.id=p.id AND e.disponivelVenda=TRUE AND p.id = :id ORDER BY e.codBarra DESC"),
    @NamedQuery(name = "Estoque.findCodBarraIdNomeValorByNome", query = "SELECT e.codBarra, p.id, p.nome, p.valorUnitario FROM Produto p, Estoque e WHERE e.produtoId.id=p.id AND UPPER(p.nome) LIKE UPPER(:nome) AND e.disponivelVenda=TRUE ORDER BY p.nome ASC, e.codBarra DESC"),
    @NamedQuery(name = "Estoque.findCodBarraIdNomeValorByCodBarra", query = "SELECT e.codBarra, p.id, p.nome, p.valorUnitario FROM Produto p, Estoque e WHERE e.produtoId.id=p.id AND e.codBarra=:codBarra AND e.disponivelVenda=TRUE"),
    @NamedQuery(name = "Estoque.findIdNomeQuantidadeById", query = "SELECT p.id, p.nome, SUM(e.quantidade) FROM Estoque e, Produto p WHERE p.id = :id AND p.id=e.produtoId.id AND e.disponivelVenda=TRUE GROUP BY p.id,p.nome"),
    @NamedQuery(name = "Estoque.findByProdutoId", query = "SELECT e from Estoque e, Produto p WHERE e.produtoId.id=p.id AND p.id=:produtoId AND e.disponivelVenda=TRUE"),
    @NamedQuery(name = "Estoque.findIdNomeQuantidadeByNome", query = "SELECT p.id, p.nome, SUM(e.quantidade) FROM Estoque e, Produto p WHERE UPPER(p.nome) = UPPER(:nome) AND p.id=e.produtoId.id AND e.disponivelVenda=TRUE GROUP BY p.id,p.nome")})
public class Estoque implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estoque")
    private List<FornecimentoEstoque> fornecimentoEstoqueList;
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_barra")
    private Long codBarra;
    @Basic(optional = false)
    @Column(name = "disponivel_venda")
    private boolean disponivelVenda;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produto produtoId;

    public Estoque() {
    }

    public Estoque(Long codBarra) {
        this.codBarra = codBarra;
    }

    public Estoque(Long codBarra, boolean disponivelVenda, int quantidade) {
        this.codBarra = codBarra;
        this.disponivelVenda = disponivelVenda;
        this.quantidade = quantidade;
    }

    public Long getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(Long codBarra) {
        this.codBarra = codBarra;
    }

    public boolean getDisponivelVenda() {
        return disponivelVenda;
    }

    public void setDisponivelVenda(boolean disponivelVenda) {
        this.disponivelVenda = disponivelVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBarra != null ? codBarra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.codBarra == null && other.codBarra != null) || (this.codBarra != null && !this.codBarra.equals(other.codBarra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estoque[ codBarra=" + codBarra + " ]";
    }

    @XmlTransient
    public List<FornecimentoEstoque> getFornecimentoEstoqueList() {
        return fornecimentoEstoqueList;
    }

    public void setFornecimentoEstoqueList(List<FornecimentoEstoque> fornecimentoEstoqueList) {
        this.fornecimentoEstoqueList = fornecimentoEstoqueList;
    }
    
}
