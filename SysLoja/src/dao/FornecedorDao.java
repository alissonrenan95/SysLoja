/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Fornecedor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class FornecedorDao extends GenericoDao implements IDao{
    @Override
    public List listar() {
        return listargenerico("Fornecedor.findAll", null);
    }

    public List<Fornecedor> listarPorCnpj(String text) {
        Map<String, Object> map=new HashMap();
        map.put("cnpj", text);
        return listargenerico("Fornecedor.findByCnpj", map);
    }

    public List listarNomeCnpjPorCnpj(String text) {
        Map<String, Object> map=new HashMap();
        map.put("cnpj", text);
        return listargenerico("Fornecedor.findNomeCnpjByCnpj", map);
    }

    public List listarNomeCnpjPorNome(String text) {
        Map<String, Object> map=new HashMap();
        map.put("nome", text+"%");
        return listargenerico("Fornecedor.findNomeCnpjByNome", map);
    }

    public List<Fornecedor> listarPorNome(String nome) {
        Map<String, Object> map=new HashMap();
        map.put("nome", nome+"%");
        return listargenerico("Fornecedor.findByNomeParecido", map);
    }
}
