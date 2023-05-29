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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Renan
 */
@Entity
@Table(name = "movimentacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m"),
    @NamedQuery(name = "Movimentacao.findById", query = "SELECT m FROM Movimentacao m WHERE m.id = :id"),
    @NamedQuery(name = "Movimentacao.findByDescricao", query = "SELECT m FROM Movimentacao m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Movimentacao.findByDataMov", query = "SELECT m FROM Movimentacao m WHERE m.dataMov = :dataMov"),
    @NamedQuery(name = "Movimentacao.findByValor", query = "SELECT m FROM Movimentacao m WHERE m.valor = :valor"),
    @NamedQuery(name = "Movimentacao.findByEntradaOuSaida", query = "SELECT m FROM Movimentacao m WHERE m.entradaOuSaida = :entradaOuSaida")})
public class Movimentacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "data_mov")
    @Temporal(TemporalType.DATE)
    private Date dataMov;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "entrada_ou_saida")
    private Character entradaOuSaida;
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario funcionarioId;

    public Movimentacao() {
    }

    public Movimentacao(Integer id) {
        this.id = id;
    }

    public Movimentacao(Integer id, String descricao, Date dataMov, double valor, Character entradaOuSaida) {
        this.id = id;
        this.descricao = descricao;
        this.dataMov = dataMov;
        this.valor = valor;
        this.entradaOuSaida = entradaOuSaida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataMov() {
        return dataMov;
    }

    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Character getEntradaOuSaida() {
        return entradaOuSaida;
    }

    public void setEntradaOuSaida(Character entradaOuSaida) {
        this.entradaOuSaida = entradaOuSaida;
    }

    public Funcionario getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Funcionario funcionarioId) {
        this.funcionarioId = funcionarioId;
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
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Movimentacao[ id=" + id + " ]";
    }
    
}
