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
public class FornecimentoEstoque{
    
    private int quantidade;
    private boolean disponivelEstoque;
    private double valorUnitario;
    private Date dataFabricacao;
    private Date dataVencimento;
    private Estoque estoque;
    private Fornecimento fornecimento;

    public FornecimentoEstoque() {
    }
    
    

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean getDisponivelEstoque() {
        return disponivelEstoque;
    }

    public void setDisponivelEstoque(boolean disponivelEstoque) {
        this.disponivelEstoque = disponivelEstoque;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Fornecimento getFornecimento() {
        return fornecimento;
    }

    public void setFornecimento(Fornecimento fornecimento) {
        this.fornecimento = fornecimento;
    }

    public entidades.FornecimentoEstoque getFornecimentoEstoqueEntity(){
        entidades.FornecimentoEstoque fet=new entidades.FornecimentoEstoque();
        fet.setDataFabricacao(dataFabricacao);
        fet.setDataVencimento(dataVencimento);
        fet.setDisponivelEstoque(disponivelEstoque);
        fet.setEstoque(estoque.getEstoqueEntity());
        fet.setFornecimento(fornecimento.getFornecimentoEntity());
        entidades.FornecimentoEstoquePK fetpk=new entidades.FornecimentoEstoquePK();
        fetpk.setEstoqueCodBarra(fet.getEstoque().getCodBarra());
        fet.setFornecimentoEstoquePK(fetpk);
        fet.setQuantidade(quantidade);
        fet.setValorUnitario(valorUnitario);
        return fet;
    }
    
    public void setFornecimentoEstoqueEntity(entidades.FornecimentoEstoque fet){
        dataFabricacao=fet.getDataFabricacao();
        dataVencimento=fet.getDataVencimento();
        disponivelEstoque=fet.getDisponivelEstoque();
        Estoque e=new Estoque();
        e.setEstoqueEntity(fet.getEstoque());
        estoque=e;
        quantidade=fet.getQuantidade();
        valorUnitario=fet.getValorUnitario();
    }
    
}
