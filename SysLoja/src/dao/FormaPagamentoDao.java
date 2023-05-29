/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.FormaPagamento;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Renan
 */
public class FormaPagamentoDao extends GenericoDao implements IDao{
    @Override
    public List<FormaPagamento> listar() {
        return listargenerico("FormaPagamento.findAll", new HashMap());
    }

    public List<FormaPagamento> listarPorId(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("id", id);
        return listargenerico("FormaPagamento.findById", map);
    }

    public List<FormaPagamento> listarParcelasPorFormaPagamento(Boolean cartao) {
        Map<String, Object> map=new HashMap();
        map.put("cartao", cartao);
        return listargenerico("FormaPagamento.findByCartao", map);
    }

    public List listarParcelasJurosPorFormaPagamentoTipo(Boolean cartao, Boolean tipoCartao) {
        Map<String, Object> map=new HashMap();
        map.put("cartao", cartao);
        map.put("tipoCartao", tipoCartao);
        return listargenerico("FormaPagamento.findParcelasJurosByFormaTipo", map);
    }

    public List<FormaPagamento> listarPorTipoCartaoParcelas(Boolean cartao, Boolean tipo, Integer parcelas) {
        Map<String, Object> map=new HashMap();
        map.put("cartao", cartao);
        map.put("tipoCartao", tipo);
        map.put("numParcelas", parcelas);
        return listargenerico("FormaPagamento.findByTipoCartaoParcelas", map);
    }
}
