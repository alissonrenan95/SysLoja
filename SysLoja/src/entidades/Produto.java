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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByValorUnitario", query = "SELECT p FROM Produto p WHERE p.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Produto.findIdNomeValorPorId", query = "SELECT p.id, p.nome, p.valorUnitario FROM Produto p WHERE p.id = :id"),
    @NamedQuery(name = "Produto.findIdNomeValorPorNome", query = "SELECT p.id, p.nome, p.valorUnitario FROM Produto p WHERE UPPER(p.nome) LIKE UPPER(:nome) ORDER BY p.nome ASC"),
    @NamedQuery(name = "Produto.findIdNomeValorPorNomeCategoriaId", query = "SELECT p.id, p.nome, p.valorUnitario FROM Produto p WHERE UPPER(p.nome) LIKE UPPER(:nome) AND p.categoriaProdutoId.id = :categoriaProdutoId ORDER BY p.nome ASC")})
public class Produto implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private List<Estoque> estoqueList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "valor_unitario")
    private double valorUnitario;
    @JoinColumn(name = "categoria_produto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoriaProduto categoriaProdutoId;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, String nome, double valorUnitario) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public CategoriaProduto getCategoriaProdutoId() {
        return categoriaProdutoId;
    }

    public void setCategoriaProdutoId(CategoriaProduto categoriaProdutoId) {
        this.categoriaProdutoId = categoriaProdutoId;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Produto[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }
    
}
