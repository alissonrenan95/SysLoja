/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Renan
 */
class GenericoDao {
    protected Session session;
    public Boolean salvar(Object t){
        return saveMergeOrDelete(t, 1);
    }
    public Boolean alterar(Object t){
        return saveMergeOrDelete(t, 2);
    }
    public Boolean excluir(Object t){
        return saveMergeOrDelete(t, 3);
    }
    private Boolean saveMergeOrDelete(Object t, Integer acao){
        session=Conect.getSessionFactory();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            if(acao==1){
                session.save(t);
            }
            else if(acao==2){
                session.update(t);
            }
            else if(acao==3){
                session.delete(t);
            }
            else{
                tx.rollback();
                session.close();
                return false;
            }
            tx.commit();
            session.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            tx.rollback();
            session.close();
        }
        return false;
    }
    protected List listargenerico(String queryname, Map<String, Object> map){
        session=Conect.getSessionFactory();
        List lista=new ArrayList();
        try{
            Query q=session.getNamedQuery(queryname);
            for(Map.Entry<String, Object> pair:map.entrySet()){
                q.setParameter(pair.getKey(), pair.getValue());
            }
            lista=q.list();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return lista;
    }
}
