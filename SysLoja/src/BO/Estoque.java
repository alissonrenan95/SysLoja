/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.EstoqueDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Estoque{
    private Long codBarra;
    private Boolean disponivelVenda;
    private Integer quantidade;
    private List<EstoqueVenda> estoqueVendaList;
    private Produto produto;

    public Estoque() {
    }

    public Estoque(Long codBarra) {
        this.codBarra = codBarra;
    }

    public Estoque(Long codBarra, Boolean disponivelVenda, Integer quantidade) {
        this.codBarra = codBarra;
        this.disponivelVenda = disponivelVenda;
        this.quantidade = quantidade;
    }

    public Long getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(Long codBarra) {
        this.codBarra = codBarra;
    }

    public Boolean getDisponivelVenda() {
        return disponivelVenda;
    }

    public void setDisponivelVenda(Boolean disponivelVenda) {
        this.disponivelVenda = disponivelVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public List<EstoqueVenda> getEstoqueVendaList() {
        return estoqueVendaList;
    }

    public void setEstoqueVendaList(List<EstoqueVenda> estoqueVendaList) {
        this.estoqueVendaList = estoqueVendaList;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public entidades.Estoque getEstoqueEntity(){
        entidades.Estoque estoque=new entidades.Estoque();
        estoque.setCodBarra(codBarra);
        estoque.setDisponivelVenda(disponivelVenda);
        if(produto!=null){
            estoque.setProdutoId(produto.getProdutoEntity());
        }
        //estoque.setProduto(new Produto().getProdutoEntity());
        estoque.setQuantidade(quantidade);
        return estoque;
    }
    public void setEstoqueEntity(entidades.Estoque estoque){
        codBarra=estoque.getCodBarra();
        disponivelVenda=estoque.getDisponivelVenda();
        BO.Produto produtobo=new BO.Produto();
        produtobo.setProdutoEntity(estoque.getProdutoId());
        produto=produtobo;
        quantidade=estoque.getQuantidade();
    }
    
    
    public Estoque listarEstoquePorCodigoQuantidade(Long codBarra, Integer quantidade){
        entidades.Estoque estoque=new EstoqueDao().listarEstoquePorCodigoQuantidade(codBarra, quantidade);
        if(estoque!=null){
            setEstoqueEntity(estoque);
            return this;
        }
        return null;
    }
    public List<Estoque> listarPorCodBarra(Long codBarra){
        List<Estoque> listabo=new ArrayList();
        List<entidades.Estoque> lista=new EstoqueDao().listarPorCodBarra(codBarra);
        for(entidades.Estoque estoque:lista){
            Estoque estoquebo=new Estoque();
            estoquebo.setEstoqueEntity(estoque);
            listabo.add(estoquebo);
        }
        return listabo;
    }
    
    public Estoque consultarPorCodBarra(Long codBarra){
        List<Estoque> estoque=listarPorCodBarra(codBarra);
        if(estoque.size()>0){
            return estoque.get(0);
        }
        return null;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBarra != null ? codBarra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.codBarra == null && other.codBarra != null) || (this.codBarra != null && !this.codBarra.equals(other.codBarra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return produto.getNome();
    }

    public List consultarEstoquePorProdutoNome(String nome) {
        return new EstoqueDao().consultarEstoquePorProdutoNome(nome);
    }
    
    public List consultarEstoquePorProdutoId(Integer id){
        return new EstoqueDao().consultarEstoquePorProdutoId(id);
    }

    public List<Estoque> listarEstoquePorProdutoId(Integer produtoId){
        List<Estoque> listestoquebo=new ArrayList();
        List<entidades.Estoque> listestoque=new EstoqueDao().listarEstoquePorProdutoId(produtoId);
        for(entidades.Estoque estoque:listestoque){
            Estoque estoquebo=new Estoque();
            estoquebo.setEstoqueEntity(estoque);
            listestoquebo.add(estoquebo);
        }
        return listestoquebo;
    }

    public List<Estoque> listarCodbarraIdNomeValorPorId(Integer id) {
        List estoque=new EstoqueDao().listarCodbarraIdNomeValorPorId(id);
        return convertToTableListBO(estoque);
    }
    
    public List<Estoque> listarCodbarraIdNomeValorPorCodbarra(Long codbarra){
        List estoque=new EstoqueDao().listarCodbarraIdNomeValorPorCodbarra(codbarra);
        return convertToTableListBO(estoque);
    }
    
    public List<Estoque> listarCodbarraIdNomeValorPorNome(String text) {
        List estoque=new EstoqueDao().listarCodbarraIdNomeValorPorNome(text);
        return convertToTableListBO(estoque);
    }
    
    private List<Estoque> convertToTableListBO(List estoque){
        List<Estoque> estoquebo = new ArrayList();
        for(Object o:estoque){
            Object [] o1=(Object[]) o;
            Estoque e=new Estoque();
            e.setCodBarra(Long.parseLong(o1[0].toString()));
            Produto prod=new Produto(Integer.parseInt(o1[1].toString()), o1[2].toString(), Double.parseDouble(o1[3].toString()));
            e.setProduto(prod);
            estoquebo.add(e);
        }
        return estoquebo;
    }

    private Boolean saveMergeOrDelete(int acao){
        EstoqueDao cargodao=new EstoqueDao();
        entidades.Estoque estoque=getEstoqueEntity();
        Boolean b=(acao==1)?cargodao.salvar(estoque):(acao==2)?cargodao.alterar(estoque):cargodao.excluir(estoque);
        return b;
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
