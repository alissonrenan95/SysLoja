/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renan 2016
 */
@Entity
@Table(name = "fornecimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecimento.findAll", query = "SELECT f FROM Fornecimento f"),
    @NamedQuery(name = "Fornecimento.findById", query = "SELECT f FROM Fornecimento f WHERE f.id = :id"),
    @NamedQuery(name = "Fornecimento.findByDataPedido", query = "SELECT f FROM Fornecimento f WHERE f.dataPedido = :dataPedido"),
    @NamedQuery(name = "Fornecimento.findByDataPrevistaRecebimento", query = "SELECT f FROM Fornecimento f WHERE f.dataPrevistaRecebimento = :dataPrevistaRecebimento"),
    @NamedQuery(name = "Fornecimento.findByDataRecebida", query = "SELECT f FROM Fornecimento f WHERE f.dataRecebida = :dataRecebida"),
    @NamedQuery(name = "Fornecimento.findByValorTotal", query = "SELECT f FROM Fornecimento f WHERE f.valorTotal = :valorTotal"),
    @NamedQuery(name = "Fornecimento.findByProdutoNome", query = "SELECT f FROM Fornecimento f, FornecimentoEstoque fe, Estoque e, Produto p WHERE f.dataRecebida IS NULL AND f.id = fe.fornecimento.id AND fe.estoque.codBarra = e.codBarra AND e.produtoId.id = p.id AND UPPER(p.nome) LIKE UPPER(:nome)"),
    @NamedQuery(name = "Fornecimento.findByDataPedidoDisponivel", query = "SELECT f FROM Fornecimento f WHERE f.dataRecebida IS NULL AND f.dataPedido=:dataPedido")})
public class Fornecimento implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecimento")
    private List<FornecimentoEstoque> fornecimentoEstoqueList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_pedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @Column(name = "data_prevista_recebimento")
    @Temporal(TemporalType.DATE)
    private Date dataPrevistaRecebimento;
    @Column(name = "data_recebida")
    @Temporal(TemporalType.DATE)
    private Date dataRecebida;
    @Basic(optional = false)
    @Column(name = "valor_total")
    private double valorTotal;
    @JoinColumn(name = "fornecedor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Fornecedor fornecedorId;

    public Fornecimento() {
    }

    public Fornecimento(Integer id) {
        this.id = id;
    }

    public Fornecimento(Integer id, Date dataPedido, double valorTotal) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataPrevistaRecebimento() {
        return dataPrevistaRecebimento;
    }

    public void setDataPrevistaRecebimento(Date dataPrevistaRecebimento) {
        this.dataPrevistaRecebimento = dataPrevistaRecebimento;
    }

    public Date getDataRecebida() {
        return dataRecebida;
    }

    public void setDataRecebida(Date dataRecebida) {
        this.dataRecebida = dataRecebida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Fornecedor getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Fornecedor fornecedorId) {
        this.fornecedorId = fornecedorId;
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
        if (!(object instanceof Fornecimento)) {
            return false;
        }
        Fornecimento other = (Fornecimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Fornecimento[ id=" + id + " ]";
    }

    @XmlTransient
    public List<FornecimentoEstoque> getFornecimentoEstoqueList() {
        return fornecimentoEstoqueList;
    }

    public void setFornecimentoEstoqueList(List<FornecimentoEstoque> fornecimentoEstoqueList) {
        this.fornecimentoEstoqueList = fornecimentoEstoqueList;
    }
    
}
