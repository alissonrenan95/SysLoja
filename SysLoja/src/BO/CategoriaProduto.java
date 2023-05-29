/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.CategoriaProdutoDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class CategoriaProduto{
    private Integer id;
    private String nome;

    public CategoriaProduto() {
    }

    public CategoriaProduto(Integer id) {
        this.id = id;
    }

    public CategoriaProduto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProduto)) {
            return false;
        }
        CategoriaProduto other = (CategoriaProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public entidades.CategoriaProduto getCategoriaProdutoEntity(){
        entidades.CategoriaProduto categoria=new entidades.CategoriaProduto();
        categoria.setId(id);
        categoria.setNome(nome);
        return categoria;
    }
    public void setCategoriaProdutoEntity(entidades.CategoriaProduto categoria){
        id=categoria.getId();
        nome=categoria.getNome();
    }
    
    private Boolean saveMergeOrDelete(int acao){
        CategoriaProdutoDao categoriadao=new CategoriaProdutoDao();
        entidades.CategoriaProduto categoria=getCategoriaProdutoEntity();
        Boolean b=false;
        b=(acao==1)?categoriadao.salvar(categoria):(acao==2)?categoriadao.alterar(categoria):categoriadao.excluir(categoria);
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

    public List<CategoriaProduto> listarPorNome(String text) {
        List<CategoriaProduto> lista=new ArrayList();
        List<entidades.CategoriaProduto> categorias=new CategoriaProdutoDao().listarPorNome(text);
        for(entidades.CategoriaProduto cp:categorias){
            CategoriaProduto categoriabo=new CategoriaProduto();
            categoriabo.setCategoriaProdutoEntity(cp);
            lista.add(categoriabo);
        }
        return lista;
    }

    public List<CategoriaProduto> listarPorId(Integer id) {
        List<CategoriaProduto> lista=new ArrayList();
        List<entidades.CategoriaProduto> categorias=new CategoriaProdutoDao().listarPorId(id);
        for(entidades.CategoriaProduto cp:categorias){
            CategoriaProduto categoriabo=new CategoriaProduto();
            categoriabo.setCategoriaProdutoEntity(cp);
            lista.add(categoriabo);
        }
        return lista;
    }
    
}
