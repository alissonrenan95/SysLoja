/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.PagamentoFuncionario;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class PagamentoFuncionarioDao extends GenericoDao implements IDao{
    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<PagamentoFuncionario> listarPorNomeFuncionario(String nome) {
        Map<String, Object> map=new HashMap();
        map.put("nome", nome);
        return listargenerico("PagamentoFuncionario.findByNomeFuncionario", map);
    }

    public List<PagamentoFuncionario> listarPorData(Date dt) {
        Map<String, Object> map=new HashMap();
        map.put("data", dt);
        return listargenerico("PagamentoFuncionario.findByData", map);
    }
}
