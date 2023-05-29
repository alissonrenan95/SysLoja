/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.UsuarioDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Usuario{
    private Integer id;
    private String nomeUsuario;
    private String senha;
    private String email;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }
    
    public Usuario(String nomeUsuario, String senha){
        this.nomeUsuario=nomeUsuario;
        this.senha=senha;
    }
    
    public Usuario(Integer id, String nomeUsuario, String senha, String email){
        this.id=id;
        this.nomeUsuario=nomeUsuario;
        this.senha=senha;
        this.email=email;
    }
    
    private Usuario(Integer id, String nomeUsuario, String email){
        this.id=id;
        this.nomeUsuario=nomeUsuario;
        this.email=email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
    public entidades.Usuario getUsuarioEntity(){
        entidades.Usuario usuario=new entidades.Usuario();
        usuario.setId(id);
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        return usuario;
    }
    public void setUsuarioEntity(entidades.Usuario usuario){
        id=usuario.getId();
        nomeUsuario=usuario.getNomeUsuario();
        senha=usuario.getSenha();
        email=usuario.getEmail();
    }
    
    public Boolean login(){
        entidades.Usuario u=new UsuarioDao().login(getUsuarioEntity());
        if(u!=null){
            setUsuarioEntity(u);
            return true;
        }
        return false;
    }
    
    public Boolean recuperarSenha(){
        return new UsuarioDao().recuperarSenha(getUsuarioEntity());
    }
    
    public List<Usuario> listarPorId(Integer id) {
        List<Usuario> lista=new ArrayList();
        List<entidades.Usuario> usuarios=new UsuarioDao().listarPorId(id);
        for(entidades.Usuario u:usuarios){
            Usuario usuariobo=new Usuario();
            usuariobo.setUsuarioEntity(u);
            lista.add(usuariobo);
        }
        return lista;
    }
    
    public List<Usuario> listarPorNome(String text) {
        List<Usuario> lista=new ArrayList();
        List<entidades.Usuario> usuarios=new UsuarioDao().listarPorNome(text);
        for(entidades.Usuario u:usuarios){
            Usuario usuariobo=new Usuario();
            usuariobo.setUsuarioEntity(u);
            lista.add(usuariobo);
        }
        return lista;
    }

    public List<Usuario> listarPorEmail(String text) {
        List<Usuario> lista=new ArrayList();
        List<entidades.Usuario> usuarios=new UsuarioDao().listarPorEmail(text);
        for(entidades.Usuario u:usuarios){
            Usuario usuariobo=new Usuario();
            usuariobo.setUsuarioEntity(u);
            lista.add(usuariobo);
        }
        return lista;
    }
    public List<Usuario> listarIdNomeEmailPorNome(String text) {
        List usuarios=new UsuarioDao().listarIdNomeEmailPorNome(text);
        return convertToTableListBO(usuarios);
    }
    public List<Usuario> listarIdNomeEmailPorEmail(String text) {
        List usuarios=new UsuarioDao().listarIdNomeEmailPorEmail(text);
        return convertToTableListBO(usuarios);
    }
    private List<Usuario> convertToTableListBO(List usuarios){
        List<Usuario> usuariosbo = new ArrayList();
        for(Object o:usuarios){
            Object [] o1=(Object[]) o;
            Usuario usuario=new Usuario(Integer.parseInt(o1[0].toString()), o1[1].toString(), o1[2].toString());
            usuariosbo.add(usuario);
        }
        return usuariosbo;
    }
    
    
    
    private Boolean saveMergeOrDelete(int acao){
        UsuarioDao usuariodao=new UsuarioDao();
        entidades.Usuario usuario=getUsuarioEntity();
        Boolean b=false;
        b=(acao==1)?usuariodao.salvar(usuario):(acao==2)?usuariodao.alterar(usuario):usuariodao.excluir(usuario);
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
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuario[ id=" + id + " ]";
    }
    
}
