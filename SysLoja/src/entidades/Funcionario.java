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
 * @author Renan
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findById", query = "SELECT f FROM Funcionario f WHERE f.id = :id"),
    @NamedQuery(name = "Funcionario.findBySalario", query = "SELECT f FROM Funcionario f WHERE f.salario = :salario"),
    @NamedQuery(name = "Funcionario.findByClienteCpf", query = "SELECT f FROM Funcionario f, Cliente c WHERE c.cpf = :cpf AND f.clienteId.id = c.id"),
    @NamedQuery(name = "Funcionario.findByUsuarioId", query = "SELECT f FROM Funcionario f, Usuario u WHERE f.usuarioId.id=:usuarioId"),
    @NamedQuery(name = "Funcionario.findFuncionariosParaPagamentoByNome", query = "SELECT f FROM Funcionario f WHERE UPPER(f.clienteId.nome) LIKE UPPER(:nome) AND f.id NOT IN(SELECT pf.funcionarioId.id FROM PagamentoFuncionario pf WHERE EXTRACT(MONTH FROM pf.dataPago)=EXTRACT(MONTH FROM CURRENT_DATE) AND EXTRACT(YEAR FROM pf.dataPago)=EXTRACT(YEAR FROM CURRENT_DATE)) ORDER BY f.clienteId.nome ASC")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "salario")
    private double salario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioId")
    private List<PagamentoConta> pagamentoContaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioId")
    private List<Movimentacao> movimentacaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioId")
    private List<Venda> vendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioId")
    private List<PagamentoFuncionario> pagamentoFuncionarioList;
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cargo cargoId;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Funcionario() {
    }

    public Funcionario(Integer id) {
        this.id = id;
    }

    public Funcionario(Integer id, double salario) {
        this.id = id;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @XmlTransient
    public List<PagamentoConta> getPagamentoContaList() {
        return pagamentoContaList;
    }

    public void setPagamentoContaList(List<PagamentoConta> pagamentoContaList) {
        this.pagamentoContaList = pagamentoContaList;
    }

    @XmlTransient
    public List<Movimentacao> getMovimentacaoList() {
        return movimentacaoList;
    }

    public void setMovimentacaoList(List<Movimentacao> movimentacaoList) {
        this.movimentacaoList = movimentacaoList;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @XmlTransient
    public List<PagamentoFuncionario> getPagamentoFuncionarioList() {
        return pagamentoFuncionarioList;
    }

    public void setPagamentoFuncionarioList(List<PagamentoFuncionario> pagamentoFuncionarioList) {
        this.pagamentoFuncionarioList = pagamentoFuncionarioList;
    }

    public Cargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargo cargoId) {
        this.cargoId = cargoId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Funcionario[ id=" + id + " ]";
    }
    
}
