/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;

/**
 *
 * @author Renan
 */
public class ClienteDao extends GenericoDao implements IDao{
    @Override
    public List<Cliente> listar() {
        return listargenerico("Cliente.findAll", null);
    }

    public List listarNomeCpfPorNome(String text) {
        Map<String, Object> map=new HashMap();
        map.put("nome", text+"%");
        return listargenerico("Cliente.findByNomeParecido", map);
    }

    public List<Cliente> listarPorCpf(String text) {
        Map<String, Object> map=new HashMap();
        map.put("cpf", text);
        return listargenerico("Cliente.findByCpf", map);
    }
    
    public List listarNomeCpfPorCpf(String text) {
        Map<String, Object> map=new HashMap();
        map.put("cpf", text);
        return listargenerico("Cliente.findNomeAndCpfByCpf", map);
    }
    
    public List<Cliente> listarPorRg(String text){
        Map<String, Object> map=new HashMap();
        map.put("rg", text);
        return listargenerico("Cliente.findByRg", map);
    }
}
