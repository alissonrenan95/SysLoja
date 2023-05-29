/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.PagamentoFuncionarioDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Renan
 */
public class PagamentoFuncionario{
    private Integer id;
    private Date dataPago;
    private Double valor;
    private Funcionario funcionarioId;
    private Usuario usuarioId;

    public PagamentoFuncionario() {
    }

    public PagamentoFuncionario(Integer id) {
        this.id = id;
    }

    public PagamentoFuncionario(Integer id, Date dataPago, Double valor) {
        this.id = id;
        this.dataPago = dataPago;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPago() {
        return dataPago;
    }

    public void setDataPago(Date dataPago) {
        this.dataPago = dataPago;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Funcionario funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof PagamentoFuncionario)) {
            return false;
        }
        PagamentoFuncionario other = (PagamentoFuncionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PagamentoFuncionario[ id=" + id + " ]";
    }
    
    public void setPagamentoFuncionarioEntity(entidades.PagamentoFuncionario pf){
        id=pf.getId();
        dataPago=pf.getDataPago();
        valor=pf.getValor();
        Funcionario f=new Funcionario();
        f.setFuncionarioEntity(pf.getFuncionarioId());
        funcionarioId=f;
        Usuario u=new Usuario();
        u.setUsuarioEntity(pf.getUsuarioId());
        usuarioId=u;
        
    }
    public entidades.PagamentoFuncionario getPagamentoFuncionarioEntity(){
        entidades.PagamentoFuncionario pf=new entidades.PagamentoFuncionario();
        pf.setDataPago(dataPago);
        pf.setFuncionarioId(funcionarioId.getFuncionarioEntity());
        pf.setId(id);
        pf.setUsuarioId(usuarioId.getUsuarioEntity());
        pf.setValor(valor);
        return pf;
    }

    private Boolean saveMergeOrDelete(int acao){
        PagamentoFuncionarioDao pfdao=new PagamentoFuncionarioDao();
        entidades.PagamentoFuncionario pf=getPagamentoFuncionarioEntity();
        Boolean b=false;
        b=(acao==1)?pfdao.salvar(pf):(acao==2)?pfdao.alterar(pf):pfdao.excluir(pf);
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
    
    
    
    public List<PagamentoFuncionario> listarPorData(Date dt) {
        List<PagamentoFuncionario> listapfbo=new ArrayList();
        List<entidades.PagamentoFuncionario> listapf=new PagamentoFuncionarioDao().listarPorData(dt);
        for(entidades.PagamentoFuncionario pf:listapf){
            PagamentoFuncionario pfbo=new PagamentoFuncionario();
            pfbo.setPagamentoFuncionarioEntity(pf);
            listapfbo.add(pfbo);
        }
        return listapfbo;
    }

    public List<PagamentoFuncionario> listarPorNomeFuncionario(String nome) {
        List<PagamentoFuncionario> listapfbo=new ArrayList();
        List<entidades.PagamentoFuncionario> listapf=new PagamentoFuncionarioDao().listarPorNomeFuncionario(nome);
        for(entidades.PagamentoFuncionario pf:listapf){
            PagamentoFuncionario pfbo=new PagamentoFuncionario();
            pfbo.setPagamentoFuncionarioEntity(pf);
            listapfbo.add(pfbo);
        }
        return listapfbo;
    }
    
    
}
