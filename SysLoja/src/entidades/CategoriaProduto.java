/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renan 2016
 */
@Entity
@Table(name = "categoria_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaProduto.findAll", query = "SELECT c FROM CategoriaProduto c"),
    @NamedQuery(name = "CategoriaProduto.findById", query = "SELECT c FROM CategoriaProduto c WHERE c.id = :id"),
    @NamedQuery(name = "CategoriaProduto.findByNome", query = "SELECT c FROM CategoriaProduto c WHERE c.nome = :nome"),
    @NamedQuery(name = "CategoriaProduto.findByNomeParecido", query = "SELECT c FROM CategoriaProduto c WHERE UPPER(c.nome) LIKE UPPER(:nome)")})
public class CategoriaProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    public CategoriaProduto() {
    }

    public CategoriaProduto(Integer id) {
        this.id = id;
    }

    public CategoriaProduto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProduto)) {
            return false;
        }
        CategoriaProduto other = (CategoriaProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CategoriaProduto[ id=" + id + " ]";
    }
    
}
