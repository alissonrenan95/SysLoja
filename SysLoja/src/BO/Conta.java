/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.ContaDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Renan
 */

public class Conta{
    private Integer id;
    private String descricao;
    private Double valorParcela;
    private Integer numParcelas;
    private Date dataCadastro;
    private Date dataVencimento;

    public Conta() {
    }

    public Conta(Integer id) {
        this.id = id;
    }
    
    public Conta(Integer id, String descricao){
        this.id=id;
        this.descricao=descricao;
    }

    public Conta(Integer id, String descricao, Double valorParcela, Integer numParcelas, Date dataCadastro, Date dataVencimento) {
        this.id = id;
        this.descricao = descricao;
        this.valorParcela = valorParcela;
        this.numParcelas = numParcelas;
        this.dataCadastro = dataCadastro;
        this.dataVencimento = dataVencimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
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
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    public entidades.Conta getContaEntity(){
        entidades.Conta conta=new entidades.Conta();
        conta.setId(id);
        conta.setDescricao(descricao);
        conta.setValorParcela(valorParcela);
        conta.setNumParcelas(numParcelas);
        conta.setDataCadastro(dataCadastro);
        conta.setDataVencimento(dataVencimento);
        return conta;
    }
    public void setContaEntity(entidades.Conta conta){
        id=conta.getId();
        descricao=conta.getDescricao();
        valorParcela=conta.getValorParcela();
        numParcelas=conta.getNumParcelas();
        dataCadastro=conta.getDataCadastro();
        dataVencimento=conta.getDataVencimento();
    }
    
    private Boolean saveMergeOrDelete(int acao){
        ContaDao contadao=new ContaDao();
        entidades.Conta conta=getContaEntity();
        Boolean b=false;
        b=(acao==1)?contadao.salvar(conta):(acao==2)?contadao.alterar(conta):contadao.excluir(conta);
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

    public List<Conta> listarPorDescricao(String text) {
        List<Conta> lista=new ArrayList();
        List<entidades.Conta> contas=new ContaDao().listarPorDescricao(text);
        for(entidades.Conta c:contas){
            Conta contabo=new Conta();
            contabo.setContaEntity(c);
            lista.add(contabo);
        }
        return lista;
    }

    public List<Conta> listarPorId(Integer id) {
        List<Conta> lista=new ArrayList();
        List<entidades.Conta> contas=new ContaDao().listarPorId(id);
        for(entidades.Conta c:contas){
            Conta contabo=new Conta();
            contabo.setContaEntity(c);
            lista.add(contabo);
        }
        return lista;
    }

    public List<Conta> listarIdDescricaoDataPorId(Integer id) {
        List contas=new ContaDao().listarIdDescricaoDataPorId(id);
        return convertToTableListBO(contas);
    }
    
    public List<Conta> listarIdDescricaoDataPorDescricao(String descricao) {
        List contas=new ContaDao().listarIdDescricaoDataPorDescricao(descricao);
        return convertToTableListBO(contas);
    }

    private List<Conta> convertToTableListBO(List contas){
        List<Conta> contasbo = new ArrayList();
        for(Object o:contas){
            Object [] o1=(Object[]) o;
            Conta conta=new Conta(Integer.parseInt(o1[0].toString()), o1[1].toString());
            try {
                conta.setDataVencimento(new SimpleDateFormat("yyyy-MM-dd").parse(o1[2].toString()));
            } catch (ParseException ex) {
                conta.setDataVencimento(null);
            }
            contasbo.add(conta);
        }
        return contasbo;
    }
    
    
}
