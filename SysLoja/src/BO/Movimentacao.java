/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.MovimentacaoDao;
import java.util.Date;

/**
 *
 * @author Renan
 */
public class Movimentacao{
    private Integer id;
    private String descricao;
    private Date dataMov;
    private Double valor;
    private Character entradaOuSaida;
    private Funcionario funcionarioId;

    public Movimentacao() {
    }

    public Movimentacao(Integer id) {
        this.id = id;
    }

    public Movimentacao(Integer id, String descricao, Date dataMov, Double valor, Character entradaOuSaida, Funcionario funcionarioId) {
        this.id = id;
        this.descricao = descricao;
        this.dataMov = dataMov;
        this.valor = valor;
        this.entradaOuSaida = entradaOuSaida;
        this.funcionarioId = funcionarioId;
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

    public Date getDataMov() {
        return dataMov;
    }

    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Character getEntradaOuSaida() {
        return entradaOuSaida;
    }

    public void setEntradaOuSaida(Character entradaOuSaida) {
        this.entradaOuSaida = entradaOuSaida;
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
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Movimentacao[ id=" + id + " ]";
    }
    
    public entidades.Movimentacao getMovimentacaoEntity(){
        entidades.Movimentacao mov=new entidades.Movimentacao();
        mov.setId(id);
        mov.setDescricao(descricao);
        mov.setDataMov(dataMov);
        mov.setEntradaOuSaida(entradaOuSaida);
        mov.setValor(valor);
        mov.setFuncionarioId(frames.MenuPrincipal.funcionario.getFuncionarioEntity());
        return mov;
    }
    public void setMovimentacaoEntity(entidades.Movimentacao mov){
        id=mov.getId();
        descricao=mov.getDescricao();
        dataMov=mov.getDataMov();
        entradaOuSaida=mov.getEntradaOuSaida();
        valor=mov.getValor();
        funcionarioId.setFuncionarioEntity(mov.getFuncionarioId());
    }
    
    private Boolean saveMergeOrDelete(int acao){
        MovimentacaoDao movdao=new MovimentacaoDao();
        entidades.Movimentacao mov=getMovimentacaoEntity();
        Boolean b=false;
        b=(acao==1)?movdao.salvar(mov):(acao==2)?movdao.alterar(mov):movdao.excluir(mov);
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
