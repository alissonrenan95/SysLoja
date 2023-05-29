/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.FornecimentoEstoque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class FornecimentoEstoqueDao extends GenericoDao implements IDao{

    @Override
    public List listar() {
        return listargenerico("FornecimentoEstoqueTotal.findAll", null);
    }
    public List<FornecimentoEstoque> listarPorId(Integer id){
        Map<String, Object> map=new HashMap();
        map.put("fornecimentoId", id);
        return listargenerico("FornecimentoEstoque.findByFornecimentoId", map);
    }
    
}
