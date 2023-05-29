/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CategoriaProduto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class CategoriaProdutoDao extends GenericoDao implements IDao{
    @Override
    public List listar() {
        return listargenerico("CategoriaProduto.findAll", null);
    }

    public List<CategoriaProduto> listarPorId(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("id", id);
        return listargenerico("CategoriaProduto.findById", map);
    }
    
    public List<CategoriaProduto> listarPorNome(String text) {
        Map<String, Object> map=new HashMap();
        map.put("nome", text+"%");
        return listargenerico("CategoriaProduto.findByNomeParecido", map);
    }

}
