/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cargo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class CargoDao extends GenericoDao implements IDao{

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cargo> listarPorId(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("id", id);
        return listargenerico("Cargo.findById", map);
    }

    public List<Cargo> listarPorNome(String nome) {
        Map<String, Object> map=new HashMap();
        map.put("nome", nome+"%");
        return listargenerico("Cargo.findByNomeParecido", map);
    }
    
}
