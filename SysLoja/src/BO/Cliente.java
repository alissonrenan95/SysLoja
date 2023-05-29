/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.ClienteDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Renan
 */

public class Cliente{
    private Integer id;
    private String nome;
    private Date dataNasc;
    private String telefone;
    private String endereco;
    private String bairro;
    private String cidade;
    private String rg;
    private String cpf;
    private String cnpj;
    
    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }
    
    public Cliente(String nome, String cpf){
        this.nome=nome;
        this.cpf=cpf;
    }

    public Cliente(Integer id, String nome, Date dataNasc, String telefone, String endereco, String bairro, String cidade, String rg, String cpf, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rg=rg;
        this.cpf=cpf;
        this.cnpj=cnpj;
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public entidades.Cliente getClienteEntity(){
        entidades.Cliente cliente=new entidades.Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setDataNasc(dataNasc);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        cliente.setBairro(bairro);
        cliente.setCidade(cidade);
        cliente.setRg(rg);
        cliente.setCpf(cpf);
        cliente.setCnpj(cnpj);
        return cliente;
    }
    public void setClienteEntity(entidades.Cliente cliente){
        id=cliente.getId();
        nome=cliente.getNome();
        dataNasc=cliente.getDataNasc();
        telefone=cliente.getTelefone();
        endereco=cliente.getEndereco();
        bairro=cliente.getBairro();
        cidade=cliente.getCidade();
        rg=cliente.getRg();
        cpf=cliente.getCpf();
        cnpj=cliente.getCnpj();
    }
    
    private Boolean saveMergeOrDelete(int acao){
        ClienteDao clientedao=new ClienteDao();
        entidades.Cliente cliente=getClienteEntity();
        Boolean b=false;
        b=(acao==1)?clientedao.salvar(cliente):(acao==2)?clientedao.alterar(cliente):clientedao.excluir(cliente);
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
    
    public List<Cliente> listarPorCpf(String text){
        if(text.length()==11){
            List<entidades.Cliente> clientes=new ClienteDao().listarPorCpf(text);
            List<Cliente> clientesbo=new ArrayList();
            for(entidades.Cliente c:clientes){
                Cliente clientebo=new Cliente();
                clientebo.setClienteEntity(c);
                clientesbo.add(clientebo);
            }
            return clientesbo;
        }
        return new ArrayList();
    }
    
    
    public List<Cliente> listarNomeCpfPorCpf(String text) {
        if(text.length()==11){
            List clientes=new ClienteDao().listarNomeCpfPorCpf(text);
            return convertToTableListBO(clientes);
        }
        return new ArrayList();
    }
    public List<Cliente> listarNomeCpfPorNome(String text) {
        List clientes=new ClienteDao().listarNomeCpfPorNome(text);
        return convertToTableListBO(clientes);
    }    
    private List<Cliente> convertToTableListBO(List clientes){
        List<Cliente> clientesbo = new ArrayList();
        for(Object o:clientes){
            Object [] o1=(Object[]) o;
            Cliente cliente=new Cliente(o1[0].toString(), o1[1].toString());
            clientesbo.add(cliente);
        }
        return clientesbo;
    }
    public List<Cliente> listarPorRg(String text){
        List<Cliente> lista=new ArrayList<Cliente>();
        List<entidades.Cliente> clientes=new ClienteDao().listarPorRg(text);
        for(entidades.Cliente c:clientes){
            Cliente clientebo=new Cliente();
            clientebo.setClienteEntity(c);
            lista.add(clientebo);
        }
        return lista;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
