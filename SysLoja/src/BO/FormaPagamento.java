/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.FormaPagamentoDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class FormaPagamento{
    private Integer id;
    private Boolean cartao;
    private Boolean tipoCartao;
    private Integer numParcelas;
    private Double taxaJuros;

    public FormaPagamento() {
    }

    public FormaPagamento(Integer id) {
        this.id = id;
    }
    
    public FormaPagamento(Integer id, Boolean cartao, Boolean tipoCartao, Integer numparcelas, Double taxaJuros){
        this.id=id;
        this.cartao=cartao;
        this.tipoCartao=tipoCartao;
        this.numParcelas=numparcelas;
        this.taxaJuros=taxaJuros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(Integer numParcelas) {
        this.numParcelas = numParcelas;
    }

    public Boolean getCartao() {
        return cartao;
    }

    public void setCartao(Boolean cartao) {
        this.cartao = cartao;
    }
    
    public Boolean getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(Boolean tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(Double taxaJuros) {
        this.taxaJuros = taxaJuros;
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
        if (!(object instanceof FormaPagamento)) {
            return false;
        }
        FormaPagamento other = (FormaPagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FormaPagamento[ id=" + id + " ]";
    }
    
    public entidades.FormaPagamento getFormaPagamentoEntity(){
        entidades.FormaPagamento fp=new entidades.FormaPagamento();
        fp.setId(id);
        fp.setCartao(cartao);
        fp.setTipoCartao(tipoCartao);
        fp.setNumParcelas(numParcelas);
        fp.setTaxaJuros(taxaJuros);
        return fp;
    }
    public void setFormaPagamentoEntity(entidades.FormaPagamento fp){
        id=fp.getId();
        cartao=fp.getCartao();
        tipoCartao=fp.getTipoCartao();
        numParcelas=fp.getNumParcelas();
        taxaJuros=fp.getTaxaJuros();
    }
    
    private Boolean saveMergeOrDelete(int acao){
        FormaPagamentoDao fpdao=new FormaPagamentoDao();
        entidades.FormaPagamento fp=getFormaPagamentoEntity();
        System.out.println("salvando"+fp.getId()+fp.getTipoCartao());
        Boolean b=false;
        b=(acao==1)?fpdao.salvar(fp):(acao==2)?fpdao.alterar(fp):fpdao.excluir(fp);
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
    
    public List<FormaPagamento> listar() {
        List<FormaPagamento> lista=new ArrayList();
        List<entidades.FormaPagamento> listfp=new FormaPagamentoDao().listar();
        for(entidades.FormaPagamento fp:listfp){
            FormaPagamento fpbo=new FormaPagamento();
            fpbo.setFormaPagamentoEntity(fp);
            lista.add(fpbo);
        }
        return lista;
    }
    public List<FormaPagamento> listarPorId(Integer id) {
        List<FormaPagamento> lista=new ArrayList();
        List<entidades.FormaPagamento> listfp=new FormaPagamentoDao().listarPorId(id);
        listfp.stream().map((fp) -> {
            FormaPagamento fpbo=new FormaPagamento();
            fpbo.setFormaPagamentoEntity(fp);
            return fpbo;
        }).forEach((fpbo) -> {
            lista.add(fpbo);
        });
        return lista;
    }

    public List<FormaPagamento> listarParcelasPorFormaPagamento(Boolean cartao) {
        List<FormaPagamento> listabo=new ArrayList();
        List<entidades.FormaPagamento> lista=new FormaPagamentoDao().listarParcelasPorFormaPagamento(cartao);
        for(entidades.FormaPagamento fp:lista){
            FormaPagamento fpbo=new FormaPagamento();
            fpbo.setFormaPagamentoEntity(fp);
            listabo.add(fpbo);
        }
        return listabo;
    }

    public List<FormaPagamento> listarParcelasJurosPorFormaPagamentoTipo(Boolean cartao, Boolean tipoCartao) {
        List<FormaPagamento> listabo=new ArrayList();
        List lista=new FormaPagamentoDao().listarParcelasJurosPorFormaPagamentoTipo(cartao, tipoCartao);
        for(Object o:lista){
            Object[] o1=(Object[])o;
            FormaPagamento fpbo=new FormaPagamento();
            //fpbo.setCartao(cartao);
            //fpbo.setTipoCartao(tipoCartao);
            fpbo.setNumParcelas(Integer.parseInt(o1[0].toString()));
            fpbo.setTaxaJuros(Double.parseDouble(o1[1].toString()));
            listabo.add(fpbo);
        }
        return listabo;
    }

    public List<FormaPagamento> listarPorTipoCartaoParcelas(Boolean cartao, Boolean tipo, Integer parcelas) {
        List<FormaPagamento> listabo=new ArrayList();
        List<entidades.FormaPagamento> lista=new FormaPagamentoDao().listarPorTipoCartaoParcelas(cartao, tipo, parcelas);
        for(entidades.FormaPagamento fp:lista){
            FormaPagamento fpbo=new FormaPagamento();
            fpbo.setFormaPagamentoEntity(fp);
            listabo.add(fpbo);
        }
        return listabo;
    }
}
