/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.util.Date;

/**
 *
 * @author Renan
 */
public class PagamentoConta{
    private Integer id;
    private Double valorPago;
    private Date dataPagamento;
    private Conta contaId;
    private Funcionario funcionarioId;

    public PagamentoConta() {
    }

    public PagamentoConta(Integer id) {
        this.id = id;
    }

    public PagamentoConta(Integer id, Double valorPago, Date dataPagamento) {
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

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
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
    
    public void setPagamentoContaEntity(entidades.PagamentoConta pc){
        id=pc.getId();
        valorPago=pc.getValorPago();
        dataPagamento=pc.getDataPagamento();
        Conta c=new Conta();
        c.setContaEntity(pc.getContaId());
        contaId=c;
        Funcionario f=new Funcionario();
        f.setFuncionarioEntity(pc.getFuncionarioId());
        funcionarioId=f;
    }
    
    public entidades.PagamentoConta getPagamentoContaEntity(){
        entidades.PagamentoConta pc=new entidades.PagamentoConta();
        pc.setId(id);
        pc.setValorPago(valorPago);
        pc.setDataPagamento(dataPagamento);
        pc.setContaId(contaId.getContaEntity());
        pc.setFuncionarioId(funcionarioId.getFuncionarioEntity());
        return pc;
    }
    
}
