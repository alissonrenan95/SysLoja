/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.FornecedorDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Fornecedor{
    private Integer id;
    private String nome;
    private String telefone;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cnpj;

    public Fornecedor() {
    }

    public Fornecedor(Integer id) {
        this.id = id;
    }
    
    private Fornecedor(String nome, String cnpj){
        this.nome=nome;
        this.cnpj=cnpj;
    }

    public Fornecedor(Integer id, String nome, String telefone, String endereco, String bairro, String cidade, String estado, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    
    public entidades.Fornecedor getFornecedorEntity(){
        entidades.Fornecedor f=new entidades.Fornecedor();
        f.setId(id);
        f.setNome(nome);
        f.setTelefone(telefone);
        f.setEndereco(endereco);
        f.setBairro(bairro);
        f.setCidade(cidade);
        f.setEstado(estado);
        f.setCnpj(cnpj);
        return f;
    }
    public void setFornecedorEntity(entidades.Fornecedor f){
        id=f.getId();
        nome=f.getNome();
        telefone=f.getTelefone();
        endereco=f.getEndereco();
        bairro=f.getBairro();
        cidade=f.getCidade();
        estado=f.getEstado();
        cnpj=f.getCnpj();
    }
    
    private Boolean saveMergeOrDelete(int acao){
        FornecedorDao fornecedordao=new FornecedorDao();
        entidades.Fornecedor fornecedor=getFornecedorEntity();
        Boolean b=false;
        b=(acao==1)?fornecedordao.salvar(fornecedor):(acao==2)?fornecedordao.alterar(fornecedor):fornecedordao.excluir(fornecedor);
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
    
    public List<Fornecedor> listarPorCnpj(String text){
        if(!text.isEmpty()){
            List<entidades.Fornecedor> fornecedores=new FornecedorDao().listarPorCnpj(text);
            List<Fornecedor> fornecedoresbo=new ArrayList();
            for(entidades.Fornecedor f: fornecedores){
                Fornecedor fornecedorbo=new Fornecedor();
                fornecedorbo.setFornecedorEntity(f);
                fornecedoresbo.add(fornecedorbo);
            }
            return fornecedoresbo;
        }
        return null;
    }
    
    
    public List<Fornecedor> listarNomeCnpjPorCnpj(String text) {
        if(text.length()>=11){
            List fornecedores=new FornecedorDao().listarNomeCnpjPorCnpj(text);
            return convertToTableListBO(fornecedores);
        }
        return null;
    }
    public List<Fornecedor> listarNomeCnpjPorNome(String text) {
        List fornecedores=new FornecedorDao().listarNomeCnpjPorNome(text);
        return convertToTableListBO(fornecedores);
    }    
    private List<Fornecedor> convertToTableListBO(List fornecedores){
        List<Fornecedor> fornecedoresbo = new ArrayList();
        for(Object o:fornecedores){
            Object [] o1=(Object[]) o;
            Fornecedor fornecedor=new Fornecedor(o1[0].toString(), o1[1].toString());
            fornecedoresbo.add(fornecedor);
        }
        return fornecedoresbo;
    }

    public List<Fornecedor> listarPorNome(String nome) {
        List<Fornecedor> lista=new ArrayList();
        List<entidades.Fornecedor> listf=new FornecedorDao().listarPorNome(nome);
        for(entidades.Fornecedor f:listf){
            Fornecedor fbo=new Fornecedor();
            fbo.setFornecedorEntity(f);
            lista.add(fbo);
        }
        return lista;
    }
}
