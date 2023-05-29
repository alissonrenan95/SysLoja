/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Conta;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class ContaDao extends GenericoDao implements IDao{
    @Override
    public List listar() {
        return listargenerico("Conta.findAll", null);
    }

    public List<Conta> listarPorDescricao(String descricao) {
        Map<String, Object> map=new HashMap();
        map.put("descricao", descricao+"%");
        return listargenerico("Conta.findByDescricaoParecida", map);
    }

    public List<Conta> listarPorId(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("id", id);
        return listargenerico("Conta.findById", map);
    }

    public List listarIdDescricaoDataPorId(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("id", id);
        return listargenerico("Conta.findIdDescricaoDataById", map);
    }

    public List listarIdDescricaoDataPorDescricao(String descricao) {
        Map<String, Object> map=new HashMap();
        map.put("descricao", descricao+"%");
        return listargenerico("Conta.findIdDescricaoDataByDescricao", map);
    }
    
}
