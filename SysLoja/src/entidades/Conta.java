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
 * @author Renan
 */
@Entity
@Table(name = "conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c"),
    @NamedQuery(name = "Conta.findById", query = "SELECT c FROM Conta c WHERE c.id = :id"),
    @NamedQuery(name = "Conta.findByDescricao", query = "SELECT c FROM Conta c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Conta.findByValorParcela", query = "SELECT c FROM Conta c WHERE c.valorParcela = :valorParcela"),
    @NamedQuery(name = "Conta.findByNumParcelas", query = "SELECT c FROM Conta c WHERE c.numParcelas = :numParcelas"),
    @NamedQuery(name = "Conta.findByDataCadastro", query = "SELECT c FROM Conta c WHERE c.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Conta.findByDataVencimento", query = "SELECT c FROM Conta c WHERE c.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "Conta.findByDescricaoParecida", query = "SELECT c FROM Conta c WHERE UPPER(c.descricao) LIKE UPPER(:descricao)"),
    @NamedQuery(name = "Conta.findIdDescricaoDataById", query = "SELECT c.id, c.descricao, c.dataVencimento FROM Conta c WHERE c.id = :id"),
    @NamedQuery(name = "Conta.findIdDescricaoDataByDescricao", query = "SELECT c.id, c.descricao, c.dataVencimento FROM Conta c WHERE UPPER(c.descricao) LIKE UPPER(:descricao)")})
public class Conta implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaId")
    private List<PagamentoConta> pagamentoContaList;
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
    @Column(name = "valor_parcela")
    private double valorParcela;
    @Basic(optional = false)
    @Column(name = "num_parcelas")
    private int numParcelas;
    @Basic(optional = false)
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Basic(optional = false)
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    public Conta() {
    }

    public Conta(Integer id) {
        this.id = id;
    }

    public Conta(Integer id, String descricao, double valorParcela, int numParcelas, Date dataCadastro, Date dataVencimento) {
        this.id = id;
        this.descricao = descricao;
        this.valorParcela = valorParcela;
        this.numParcelas = numParcelas;
        this.dataCadastro = dataCadastro;
        this.dataVencimento = dataVencimento;
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

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
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
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Conta[ id=" + id + " ]";
    }

    @XmlTransient
    public List<PagamentoConta> getPagamentoContaList() {
        return pagamentoContaList;
    }

    public void setPagamentoContaList(List<PagamentoConta> pagamentoContaList) {
        this.pagamentoContaList = pagamentoContaList;
    }
    
}
