/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Estoque;
import entidades.Produto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author Renan
 */
public class EstoqueDao extends GenericoDao implements IDao{
    
    @Override
    public Boolean salvar(Object obj) {
        
        Estoque estoque=(Estoque)obj;
         
        try {
            Estoque e = listarPorCodBarra(estoque.getCodBarra()).get(0);
            return false;
        }
        catch(Exception e){
            Produto p = estoque.getProdutoId();
            if (super.salvar(p)) {
                Session sessao=Conect.getSessionFactory();
                Integer id=1;
                try{
                    id = (Integer)sessao.createSQLQuery("select max(id) from Produto").list().get(0);
                }
                catch(Exception erro){
                }
                finally{
                    sessao.close();
                }
                System.out.println("ponto b");
                p.setId(id);
                
                
                
                if(estoque.getCodBarra()==null){
                    estoque.setCodBarra(p.getCategoriaProdutoId().getId()*1000000L+p.getId());
                }
                return super.salvar(estoque);
            }
        }
        
        
        /*
        Estoque estoque=(Estoque)obj;
        if (estoque.getCodBarra() != null) {
            Estoque e = listarPorCodBarra(estoque.getCodBarra()).get(0);
            return false;
        }
        else{
            Produto p = estoque.getProdutoId();
            System.out.println("ponto a");
            if (super.salvar(p)) {
                Session sessao=Conect.getSessionFactory();
                Integer id=1;
                try{
                    id = (Integer)sessao.createSQLQuery("select max(id) from Produto").list().get(0);
                }
                catch(Exception erro){
                }
                finally{
                    sessao.close();
                }
                System.out.println("ponto b");
                p.setId(id);
                if(estoque.getCodBarra()==null){
                    estoque.setCodBarra(p.getCategoriaProdutoId().getId()*1000000L+p.getId());
                }
                estoque.setProdutoId(p);
                return super.salvar(estoque);
            }
        }
                */
        return false;
    }
    @Override
    public Boolean alterar(Object obj) {
        Estoque estoque=(Estoque)obj;
         
        try {
            Produto p = estoque.getProdutoId();
            if (estoque.getCodBarra() == null) {
                System.out.println("Categoria = "+p.getCategoriaProdutoId().getId());
                estoque.setCodBarra(p.getCategoriaProdutoId().getId() * 1000000L + p.getId());
                System.out.println("CodBarra="+estoque.getCodBarra());
            }
            
            List<Estoque> listaest=listarEstoquePorProdutoId(p.getId());
            Estoque est=listaest.get(listaest.size()-1);
            estoque.setDisponivelVenda(est.getDisponivelVenda());
            if(estoque.getQuantidade()>=0){
                estoque.setQuantidade(est.getQuantidade());
            }
            
            try {
                Estoque e = listarPorCodBarra(estoque.getCodBarra()).get(0);
                if (e.getProdutoId().getId() == p.getId()) {
                    return super.alterar(estoque) && super.alterar(p);
                }
                return false;
            } catch (Exception e) {
                est.setDisponivelVenda(false);
                return super.alterar(est) && super.salvar(estoque) && super.alterar(p);
            }
        }
        catch(Exception e){
            
        }
        return false;
    }
    
    @Override
    public List<Estoque> listar() {
        return listargenerico("Estoque.findAll", null);
    }
    
    public Estoque listarEstoquePorCodigoQuantidade(Long codigo, Integer quantidade){
        Map<String, Object> map=new HashMap();
        map.put("codBarra", codigo);
        map.put("quantidade",quantidade);
        List<Estoque> lista=listargenerico("Estoque.findAvailableByCodBarraAndQuantidade", map);
        if(lista.isEmpty()){
            return null;
        }
        return lista.get(0);
    }
    
    public List consultarEstoquePorProdutoId(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("id", id);
        return listargenerico("Estoque.findIdNomeQuantidadeById", map);
    }

    public List consultarEstoquePorProdutoNome(String nome) {
        Map<String, Object> map=new HashMap();
        map.put("nome", nome);
        return listargenerico("Estoque.findIdNomeQuantidadeByNome", map);
    }

    public List<Estoque> listarPorCodBarra(Long codBarra) {
        Map<String, Object> map=new HashMap();
        map.put("codBarra", codBarra);
        return listargenerico("Estoque.findByCodigoBarra", map);
    }

    Boolean decrementarqtdproduto(Long codBarra, Integer quantidade) {
        Estoque estoque=listarPorCodBarra(codBarra).get(0);
        if(estoque.getQuantidade()>=quantidade){
            estoque.setQuantidade(estoque.getQuantidade()-quantidade);
            return super.alterar(estoque);
        }
        return false;
    }

    public List<Estoque> listarEstoquePorProdutoId(Integer produtoId) {
        Map<String, Object> map=new HashMap();
        map.put("produtoId", produtoId);
        return listargenerico("Estoque.findByProdutoId", map);
    }

    boolean atualizarQtdProduto(Estoque estoque, Integer quantidade) {
        estoque.setQuantidade(estoque.getQuantidade()+quantidade);
        return super.alterar(estoque);
    }

    public List listarCodbarraIdNomeValorPorId(Integer produtoId) {
        Map<String, Object> map=new HashMap();
        map.put("id", produtoId);
        return listargenerico("Estoque.findCodBarraIdNomeValorById", map);
    }

    public List listarCodbarraIdNomeValorPorCodbarra(Long codBarra) {
        Map<String, Object> map=new HashMap();
        map.put("codBarra", codBarra);
        return listargenerico("Estoque.findCodBarraIdNomeValorByCodBarra", map);
    }

    public List listarCodbarraIdNomeValorPorNome(String produtoNome) {
        Map<String, Object> map=new HashMap();
        map.put("nome", produtoNome+"%");
        return listargenerico("Estoque.findCodBarraIdNomeValorByNome", map);
    }

    
}
