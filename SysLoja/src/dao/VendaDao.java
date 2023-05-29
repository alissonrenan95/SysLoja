/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.EstoqueVenda;
import entidades.Venda;
import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author Renan
 */
public class VendaDao extends GenericoDao implements IDao{

    @Override
    public Boolean salvar(Object o){
        Venda v=(Venda)o;
        List<EstoqueVenda> listestoquevenda=v.getEstoqueVendaList();
        v.setEstoqueVendaList(null);
        
        if(!super.salvar(v)){
            return false;
        }
        Integer ultimoid=buscarUltimoId();
        for(EstoqueVenda estoquevenda:listestoquevenda){
            estoquevenda.getEstoqueVendaPK().setVendaId(ultimoid);
            estoquevenda.setVenda(v);
            estoquevenda.getVenda().setId(ultimoid);
            if(!super.salvar(estoquevenda)|| !atualizarQtdEstoqueVenda(estoquevenda)){
                return false;
            }
        }
        return true;
    }
    public Integer buscarUltimoId(){
        session=Conect.getSessionFactory();
        try{
            return Integer.parseInt(session.createQuery("SELECT MAX(v.id) FROM Venda v").list().get(0).toString());
        }
        catch(Exception e){
            return 0;
        }
    }
    
    public Boolean salvarVenda(Object o){
        session=Conect.getSessionFactory();
        Venda v=(Venda)o;
        v.setId(null);
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(v);
            tx.commit();
            session.close();
            return true;
        }
        catch(Exception e){
            tx.rollback();
            return false;
        }
        finally{
            session.close();
        }
    }
    public Boolean salvarEstoqueVenda(EstoqueVenda estoquevenda){
        return super.salvar(estoquevenda);
    }
    public Boolean atualizarQtdEstoqueVenda(EstoqueVenda estoquevenda){
        if(!new EstoqueDao().decrementarqtdproduto(estoquevenda.getEstoque().getCodBarra(), estoquevenda.getQuantidade())){
            return false;
        }
        return true;
    }
    
    @Override
    public List<Venda> listar() {
        return listargenerico("Venda.findAll", null);
    }
}
