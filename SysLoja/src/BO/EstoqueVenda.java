/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

/**
 *
 * @author Renan
 */
public class EstoqueVenda{
    private Integer quantidade;
    private Double valorUnitario;
    private Estoque estoque;
    private Venda venda;

    public EstoqueVenda() {
    }

    public EstoqueVenda(Venda venda, Estoque estoque, Double valorUnitario, Integer quantidade) {
        this.venda=venda;
        this.estoque=estoque;
        this.valorUnitario=valorUnitario;
        this.quantidade=quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public entidades.EstoqueVenda getEstoqueVendaEntity(){
        entidades.EstoqueVenda estoquevenda=new entidades.EstoqueVenda();
        entidades.EstoqueVendaPK estoquevendapk=new entidades.EstoqueVendaPK();
        estoquevenda.setEstoque(estoque.getEstoqueEntity());
        estoquevenda.setQuantidade(quantidade);
        estoquevenda.setValorUnitario(valorUnitario);
        estoquevenda.setVenda(venda.getVendaEntity());
        
        estoquevendapk.setEstoqueCodBarra(estoquevenda.getEstoque().getCodBarra());
        Integer idvenda=null;
        try{
            idvenda=estoquevenda.getVenda().getId();
        }
        catch(Exception e){
            
        }
        //estoquevendapk.setVendaId(0);
        estoquevenda.setEstoqueVendaPK(estoquevendapk);
        
        return estoquevenda;
    }

    @Override
    public String toString() {
        return "entidades.EstoqueVenda[ Venda=" + venda + " ]";
    }
    
}
