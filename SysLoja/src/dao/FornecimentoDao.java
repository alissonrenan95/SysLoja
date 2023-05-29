/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Fornecimento;
import entidades.FornecimentoEstoque;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class FornecimentoDao extends GenericoDao implements IDao{
    
    @Override
    public Boolean salvar(Object o){
        Fornecimento f=(Fornecimento)o;
        List<FornecimentoEstoque> listestoquetotal=f.getFornecimentoEstoqueList();
        f.setFornecimentoEstoqueList(null);
        
        if(!super.salvar(f)){
            return false;
        }
        Integer ultimoid=buscarUltimoId();
        for(FornecimentoEstoque fet:listestoquetotal){
            fet.getFornecimentoEstoquePK().setFornecimentoId(ultimoid);
            fet.setFornecimento(f);
            fet.getFornecimento().setId(ultimoid);
            if(!super.salvar(fet)){
                return false;
            }
        }
        return true;
    }
    @Override
    public Boolean alterar(Object o){
        Fornecimento f=(Fornecimento)o;
        List<FornecimentoEstoque> listestoquetotal=f.getFornecimentoEstoqueList();
        f.setFornecimentoEstoqueList(null);
        if(!super.alterar(f)){
            return false;
        }
        for(FornecimentoEstoque fet:listestoquetotal){
            fet.getFornecimentoEstoquePK().setFornecimentoId(f.getId());
            fet.setFornecimento(f);
            if(!super.alterar(fet)|| !atualizarQtdEstoqueTotal(fet)){
                return false;
            }
        }
        return true;
    }
    public Integer buscarUltimoId(){
        session=Conect.getSessionFactory();
        try{
            Integer id = Integer.parseInt(session.createQuery("SELECT MAX(f.id) FROM Fornecimento f").list().get(0).toString());
            session.close();
            return id;
        }
        catch(Exception e){
            return 0;
        }
    }
    
    public Boolean atualizarQtdEstoqueTotal(FornecimentoEstoque fet){
        try{
            return new EstoqueDao().atualizarQtdProduto(new EstoqueDao().listarPorCodBarra(fet.getEstoque().getCodBarra()).get(0),fet.getQuantidade());
        }
        catch(Exception e){
            return false;
        }
    }
    
    @Override
    public List listar() {
        return listargenerico("Fornecimento.findAll", null);
    }

    public List<Fornecimento> listarPorProdutoNome(String nome) {
        Map<String, Object> map=new HashMap();
        map.put("nome", nome+"%");
        return listargenerico("Fornecimento.findByProdutoNome", map);
    }

    public List<Fornecimento> listarPorDataPedido(Date dt) {
        Map<String, Object> map=new HashMap();
        map.put("dataPedido", dt);
        return listargenerico("Fornecimento.findByDataPedidoDisponivel", map);
    }
}
