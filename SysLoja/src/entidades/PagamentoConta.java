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
@Table(name = "pagamento_conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagamentoConta.findAll", query = "SELECT p FROM PagamentoConta p"),
    @NamedQuery(name = "PagamentoConta.findById", query = "SELECT p FROM PagamentoConta p WHERE p.id = :id"),
    @NamedQuery(name = "PagamentoConta.findByValorPago", query = "SELECT p FROM PagamentoConta p WHERE p.valorPago = :valorPago"),
    @NamedQuery(name = "PagamentoConta.findByDataPagamento", query = "SELECT p FROM PagamentoConta p WHERE p.dataPagamento = :dataPagamento")})
public class PagamentoConta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "valor_pago")
    private double valorPago;
    @Basic(optional = false)
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Conta contaId;
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario funcionarioId;

    public PagamentoConta() {
    }

    public PagamentoConta(Integer id) {
        this.id = id;
    }

    public PagamentoConta(Integer id, double valorPago, Date dataPagamento) {
        this.id = id;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Conta getContaId() {
        return contaId;
    }

    public void setContaId(Conta contaId) {
        this.contaId = contaId;
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
        if (!(object instanceof PagamentoConta)) {
            return false;
        }
        PagamentoConta other = (PagamentoConta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PagamentoConta[ id=" + id + " ]";
    }
    
}
