/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.FornecimentoDao;
import dao.FornecimentoEstoqueDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Renan
 */
public class Fornecimento{
    private Integer id;
    private Date dataPedido;
    private Date dataPrevistaRecebimento;
    private Date dataRecebida;
    private Double valorTotal;
    private Fornecedor fornecedorId;
    private List<FornecimentoEstoque> fornecimentoEstoqueTotalList;

    public Fornecimento() {
    }

    public Fornecimento(Integer id) {
        this.id = id;
    }

    public Fornecimento(Integer id, Date dataPedido, Double valorTotal) {
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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Fornecedor getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Fornecedor fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public List<FornecimentoEstoque> getFornecimentoEstoqueTotalList() {
        return fornecimentoEstoqueTotalList;
    }

    public void setFornecimentoEstoqueTotalList(List<FornecimentoEstoque> fornecimentoEstoqueTotalList) {
        this.fornecimentoEstoqueTotalList = fornecimentoEstoqueTotalList;
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
        return ""+id;
    }
    
    public entidades.Fornecimento getFornecimentoEntity(){
        entidades.Fornecimento f=new entidades.Fornecimento();
        f.setId(id);
        f.setValorTotal(valorTotal);
        f.setDataPedido(dataPedido);
        f.setDataPrevistaRecebimento(dataPrevistaRecebimento);
        f.setDataRecebida(dataRecebida);
        f.setFornecedorId(fornecedorId.getFornecedorEntity());
        List<entidades.FornecimentoEstoque> listfet=new ArrayList();
        return f;
    }
    
    public void setFornecimentoEntity(entidades.Fornecimento f){
        id=f.getId();
        valorTotal=f.getValorTotal();
        dataPedido=f.getDataPedido();
        dataPrevistaRecebimento=f.getDataPrevistaRecebimento();
        dataRecebida=f.getDataRecebida();
        Fornecedor fornecedor=new Fornecedor();
        fornecedor.setFornecedorEntity(f.getFornecedorId());
        fornecedorId=fornecedor;
        List<FornecimentoEstoque> listfetbo=new ArrayList();
        List<entidades.FornecimentoEstoque> listfet=new FornecimentoEstoqueDao().listarPorId(f.getId());
        for(entidades.FornecimentoEstoque fet:listfet){
            FornecimentoEstoque fetbo=new FornecimentoEstoque();
            fetbo.setFornecimentoEstoqueEntity(fet);
            fetbo.setFornecimento(this);
            listfetbo.add(fetbo);
        }
        fornecimentoEstoqueTotalList=listfetbo;
    }
    

    public List<Fornecimento> listarPorProdutoNome(String nome) {
        List<Fornecimento> lista=new ArrayList();
        List<entidades.Fornecimento> fornecimentos=new FornecimentoDao().listarPorProdutoNome(nome);
        for(entidades.Fornecimento f:fornecimentos){
            Fornecimento fbo=new Fornecimento();
            fbo.setFornecimentoEntity(f);
            lista.add(fbo);
        }
        return lista;
    }

    public List<Fornecimento> listarPorDataPedido(Date dt) {
        List<Fornecimento> lista=new ArrayList();
        List<entidades.Fornecimento> fornecimentos=new FornecimentoDao().listarPorDataPedido(dt);
        for(entidades.Fornecimento f:fornecimentos){
            Fornecimento fbo=new Fornecimento();
            fbo.setFornecimentoEntity(f);
            lista.add(fbo);
        }
        return lista;
    }

    private Boolean saveMergeOrDelete(int acao){
        entidades.Fornecimento f=new entidades.Fornecimento();
        f=getFornecimentoEntity();
        List<entidades.FornecimentoEstoque> estoquestotal=new ArrayList();
        for(FornecimentoEstoque fet:fornecimentoEstoqueTotalList){
            estoquestotal.add(fet.getFornecimentoEstoqueEntity());
        }
        f.setFornecimentoEstoqueList(estoquestotal);
        System.out.println("tamanho estoquevenda"+f.getFornecimentoEstoqueList().size());
        return (acao==1)?new FornecimentoDao().salvar(f):(acao==2)?new FornecimentoDao().alterar(f):new FornecimentoDao().excluir(f);
    }
    public Boolean salvar(){
        return saveMergeOrDelete(1);
    }
    public Boolean alterar(){
        
        
        return saveMergeOrDelete(2);
    }
    public Boolean excluir(){
        return saveMergeOrDelete(3);
    }
    
    
    
    
    
    
}
