/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.ProdutoDao;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Produto{
    private Integer id;
    private String nome;
    private Double valorUnitario;
    private CategoriaProduto categoriaProduto;

    public Produto() {
    }

    public Produto(Integer id, String nome, Double valorUnitario){
        this.id=id;
        this.nome=nome;
        this.valorUnitario=valorUnitario;
    }
    
    public Produto(Integer id, String nome, Double valorUnitario, CategoriaProduto categoriaProduto) {
        this.id=id;
        this.nome=nome;
        this.valorUnitario=valorUnitario;
        this.categoriaProduto=categoriaProduto;
                
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public Long convertToCodBarra(){
        return (getCategoriaProduto().getId()*1000000L+getId());
    }
    
    public List<Produto> listarIdNomeValorPorNome(String text) {
        List produtos=new ProdutoDao().listarIdNomeValorPorNome(text);
        return convertToTableListBO(produtos);
    }
    
    private List<Produto> convertToTableListBO(List produtos){
        List<Produto> produtosbo = new ArrayList();
        for(Object o:produtos){
            Object [] o1=(Object[]) o;
            Produto produto=new Produto(Integer.parseInt(o1[0].toString()), o1[1].toString(), Double.parseDouble(o1[2].toString()));
            produtosbo.add(produto);
        }
        return produtosbo;
    }
    
    @Override
    public String toString() {
        return nome;
    }

    
    public entidades.Produto getProdutoEntity(){
        entidades.Produto produto=new entidades.Produto();
        try{
            produto.setId(id);
        }
        catch(Exception e){
        }
        produto.setNome(nome);
        produto.setValorUnitario(valorUnitario);
        produto.setCategoriaProdutoId(new entidades.CategoriaProduto(categoriaProduto.getId(), categoriaProduto.getNome()));
        return produto;
    }
    public void setProdutoEntity(entidades.Produto produto){
        id=produto.getId();
        nome=produto.getNome();
        valorUnitario=produto.getValorUnitario();
        categoriaProduto=new CategoriaProduto(produto.getCategoriaProdutoId().getId(), produto.getCategoriaProdutoId().getNome());
    }
    
    private Boolean saveMergeOrDelete(int acao){
        ProdutoDao produtodao=new ProdutoDao();
        entidades.Produto produto=getProdutoEntity();
        Boolean b=false;
        b=(acao==1)?produtodao.salvar(produto):(acao==2)?produtodao.alterar(produto):produtodao.excluir(produto);
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

    public List<Produto> listarPorId(Integer id) {
        List<entidades.Produto> produtos=new ProdutoDao().listarPorId(id);
        List<Produto> produtosbo = new ArrayList();
        for(entidades.Produto p:produtos){
            Produto produtobo=new Produto();
            produtobo.setProdutoEntity(p);
            produtosbo.add(produtobo);
        }
        return (produtosbo.size()>0)?produtosbo:null;
    }

    public List<Produto> listarIdNomeValorPorId(Integer id) {
        List produtos=new ProdutoDao().listarIdNomeValorPorId(id);
        return convertToTableListBO(produtos);
    }

    public List<Produto> listarIdNomeValorPorNomeCategoriaId(String text, Integer id) {
        List produtos=new ProdutoDao().listarIdNomeValorPorNomeCategoriaId(text, id);
        return convertToTableListBO(produtos);
    }
    
    
}
