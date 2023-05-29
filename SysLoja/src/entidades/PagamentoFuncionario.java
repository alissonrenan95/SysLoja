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
@Table(name = "pagamento_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagamentoFuncionario.findAll", query = "SELECT p FROM PagamentoFuncionario p"),
    @NamedQuery(name = "PagamentoFuncionario.findById", query = "SELECT p FROM PagamentoFuncionario p WHERE p.id = :id"),
    @NamedQuery(name = "PagamentoFuncionario.findByDataPago", query = "SELECT p FROM PagamentoFuncionario p WHERE p.dataPago = :dataPago"),
    @NamedQuery(name = "PagamentoFuncionario.findByValor", query = "SELECT p FROM PagamentoFuncionario p WHERE p.valor = :valor")})
public class PagamentoFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_pago")
    @Temporal(TemporalType.DATE)
    private Date dataPago;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario funcionarioId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public PagamentoFuncionario() {
    }

    public PagamentoFuncionario(Integer id) {
        this.id = id;
    }

    public PagamentoFuncionario(Integer id, Date dataPago, double valor) {
        this.id = id;
        this.dataPago = dataPago;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPago() {
        return dataPago;
    }

    public void setDataPago(Date dataPago) {
        this.dataPago = dataPago;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Funcionario funcionarioId) {
        this.funcionarioId = funcionarioId;
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
        if (!(object instanceof PagamentoFuncionario)) {
            return false;
        }
        PagamentoFuncionario other = (PagamentoFuncionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PagamentoFuncionario[ id=" + id + " ]";
    }
    
}
