/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.VendaDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Venda{
    private Integer id;
    private Date dataVenda;
    private double valorTotal;
    private Double valorDesconto;
    private Double valorJuros;
    private List<EstoqueVenda> estoqueVendaList;
    private Cliente clienteId;
    private FormaPagamento formaPagamentoId;
    private Funcionario funcionarioId;

    public Venda() {
    }

    public Venda(Integer id) {
        this.id = id;
    }

    public Venda(Integer id, Date dataVenda, double valorTotal) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getValorJuros() {
        return valorJuros;
    }

    public void setValorJuros(Double valorJuros) {
        this.valorJuros = valorJuros;
    }
    
    public List<EstoqueVenda> getEstoqueVendaList() {
        return estoqueVendaList;
    }

    public void setEstoqueVendaList(List<EstoqueVenda> estoqueVendaList) {
        this.estoqueVendaList = estoqueVendaList;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public FormaPagamento getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public void setFormaPagamentoId(FormaPagamento formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
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
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Venda[ id=" + id + " ]";
    }
    
    public entidades.Venda getVendaEntity(){
        entidades.Venda vendaentity=new entidades.Venda();
        vendaentity.setClienteId(clienteId.getClienteEntity());
        vendaentity.setDataVenda(dataVenda);
        List<entidades.EstoqueVenda> estoquesvenda=new ArrayList();
        vendaentity.setFormaPagamentoId(formaPagamentoId.getFormaPagamentoEntity());
        vendaentity.setFuncionarioId(frames.MenuPrincipal.funcionario.getFuncionarioEntity());
        vendaentity.setId(id);
        vendaentity.setValorDesconto(valorDesconto);
        vendaentity.setValorJuros(valorJuros);
        vendaentity.setValorTotal(valorTotal);
        /*
        for(EstoqueVenda estoquevenda:estoqueVendaList){
            estoquesvenda.add(estoquevenda.getEstoqueVendaEntity());
        }
        vendaentity.setEstoqueVendaList(estoquesvenda);*/
        
        return vendaentity;
    }
    
    

    public Boolean salvar() {
        entidades.Venda venda=new entidades.Venda();
        venda=getVendaEntity();
        List<entidades.EstoqueVenda> estoquesvenda=new ArrayList();
        for(EstoqueVenda estoquevenda:estoqueVendaList){
            estoquesvenda.add(estoquevenda.getEstoqueVendaEntity());
        }
        venda.setEstoqueVendaList(estoquesvenda);
        return new VendaDao().salvar(venda);
    }
    
}
