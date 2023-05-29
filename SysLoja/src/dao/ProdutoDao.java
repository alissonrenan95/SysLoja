/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Produto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class ProdutoDao extends GenericoDao implements IDao{
    
    @Override
    public Boolean salvar(Object b){
        Produto p=(Produto)b;
        //ProdutoPK prodpk=p.getProdutoPK();
        try{
            session=Conect.getSessionFactory();
            Integer id=(Integer)session.createSQLQuery("select max(id) from Produto").list().get(0);
            //considerar futuramente max(id) por categoria(where categoria= ...)
            //prodpk.setId(id+1);
            p.setId(id+1);
        }
        catch(Exception e){
            p.setId(1);
            //prodpk.setId(1);
        }
        finally{
            session.close();
        }
        return super.salvar(p);
    }
    
    @Override
    public List listar() {
        return listargenerico("Produto.findAll", null);
    }

    public List listarIdNomeValorPorNome(String nome) {
        Map<String, Object> map=new HashMap();
        map.put("nome", nome+"%");
        return listargenerico("Produto.findIdNomeValorPorNome", map);
    }

    public List<Produto> listarPorId(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("id", id);
        return listargenerico("Produto.findById", map);
    }

    public List listarIdNomeValorPorId(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("id", id);
        return listargenerico("Produto.findIdNomeValorPorId", map);
    }

    public List listarIdNomeValorPorNomeCategoriaId(String nome, Integer categoriaId) {
        Map<String, Object> map=new HashMap();
        map.put("nome", nome+"%");
        map.put("categoriaProdutoId", categoriaId);
        return listargenerico("Produto.findIdNomeValorPorNomeCategoriaId", map);
    }
}
