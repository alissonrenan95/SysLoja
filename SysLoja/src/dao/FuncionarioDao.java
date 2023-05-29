/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import entidades.Funcionario;
import entidades.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class FuncionarioDao extends GenericoDao implements IDao{
    @Override
    public Boolean salvar(Object o){
        Funcionario f=(Funcionario)o;
        List<Cliente> listcli = new ClienteDao().listarPorCpf(f.getClienteId().getCpf());
        List<Usuario> listusu = new UsuarioDao().listarPorNome(f.getUsuarioId().getNomeUsuario());
        if (listcli!=null || listusu!=null) {
            return false;
        }
        else{
            if(super.salvar(f.getClienteId()) || super.salvar(f.getUsuarioId())){
                Cliente cliente = new ClienteDao().listarPorCpf(f.getClienteId().getCpf()).get(0);
                f.setClienteId(cliente);
                Usuario usuario = new UsuarioDao().listarPorNome(f.getUsuarioId().getNomeUsuario()).get(0);
                f.setUsuarioId(usuario);
                return super.salvar(f);
            }
        }
        return false;
    }
    @Override
    public Boolean alterar(Object o){
        Funcionario f=(Funcionario)o;
        Funcionario funclist=new FuncionarioDao().listarPorId(f.getId()).get(0);
        Cliente c=f.getClienteId();
        c.setId(funclist.getClienteId().getId());
        f.setClienteId(c);
        Usuario u=f.getUsuarioId();
        u.setId(funclist.getUsuarioId().getId());
        f.setUsuarioId(u);
        return super.alterar(u) && super.alterar(c) && super.alterar(f);
    }
    @Override
    public Boolean excluir(Object o){
        Funcionario f=(Funcionario)o;
        Funcionario funclist=new FuncionarioDao().listarPorId(f.getId()).get(0);
        return super.excluir(funclist) && super.excluir(funclist.getClienteId()) && super.excluir(funclist.getUsuarioId());
    }
    /*
    private Boolean saveMergeOrDeleteFuncionario(Object t, int acao){
        Funcionario func=(Funcionario)t;
        
        
        
        
        
        
        try{
            Funcionario f=(Funcionario)t;
            try{
                Cliente c=new ClienteDao().listarPorCpf(f.getClienteId().getCpf()).get(0);
                if(acao==1){
                    return false;
                }
                else{
                    Cliente cli=f.getClienteId();
                    cli.setId(c.getId());
                    f.setClienteId(cli);
                }
            }
            catch(Exception e){
                if(new ClienteDao().salvar(f.getClienteId())){
                    Cliente c=new ClienteDao().listarPorCpf(f.getClienteId().getCpf()).get(0);
                    f.setClienteId(c);
                }
                else{
                    return false;
                }
            }
            try{
                Usuario u=new UsuarioDao().listarPorNome(f.getUsuarioId().getNomeUsuario()).get(0);
                if(acao==1){
                    return false;
                }
                else{
                    f.getUsuarioId().setId(u.getId());
                }
            }
            catch(Exception e){
                if(new UsuarioDao().salvar(f.getUsuarioId())){
                    Usuario u=new UsuarioDao().pesquisarUsuarioPorNomeUsuario(f.getUsuarioId().getNomeUsuario());
                    f.setUsuarioId(u);
                }
                else{
                    return false;
                }
            }
            if(acao==1){
                return super.salvar(f);
            }
            else if(acao==2){
                return super.alterar(f);
            }
            else if(acao==3){
                return super.excluir(f);
            }
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    */
    
    @Override
    public List listar() {
        return listargenerico("Funcionario.findByAll", null);
    }

    public List<Funcionario> listarPorCpf(String cpf) {
        Map<String, Object> map=new HashMap();
        map.put("cpf", cpf);
        return listargenerico("Funcionario.findByClienteCpf", map);
    }

    public List<Funcionario> listarPorUsuario(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("usuarioId", id);
        return listargenerico("Funcionario.findByUsuarioId", map);
    }

    public List<Funcionario> listarPorId(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("id", id);
        return listargenerico("Funcionario.findById", map);
    }

    public List<Funcionario> listarFuncionariosParaPagamentoPorNome(String nome) {
        Map<String, Object> map=new HashMap();
        map.put("nome", nome+"%");
        return listargenerico("Funcionario.findFuncionariosParaPagamentoByNome", map);
    }
}
