/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.List;
import java.util.Map;
import org.hibernate.Query;

/**
 *
 * @author Renan
 */
public class UsuarioDao extends GenericoDao implements IDao{
    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public entidades.Usuario pesquisarUsuarioPorEmail(String email){
        session=Conect.getSessionFactory();
        Query q=session.getNamedQuery("Usuario.findByEmail");
        q.setParameter("email", email);
        List<entidades.Usuario> lista=q.list();
        if(lista.size()>0){
            return lista.get(0);
        }
        return null;
    }
    public entidades.Usuario pesquisarUsuarioPorNomeUsuario(String nomeusuario){
        session=Conect.getSessionFactory();
        Query q=session.getNamedQuery("Usuario.findByNomeUsuario");
        q.setParameter("nomeUsuario", nomeusuario);
        List<entidades.Usuario> lista=q.list();
        if(lista.size()>0){
            return lista.get(0);
        }
        return null;
    }
    public entidades.Usuario login(entidades.Usuario u){
        session=Conect.getSessionFactory();
        Query q=session.getNamedQuery("Usuario.findByNomeUsuarioAndSenha");
        q.setParameter("nomeUsuario", u.getNomeUsuario());
        q.setParameter("senha", u.getSenha());
        List<entidades.Usuario> lista=q.list();
        if(lista.size()>0){
            return lista.get(0);
        }
        return null;
    }
    
    
    public Boolean recuperarSenha(entidades.Usuario u){
        if(!u.getNomeUsuario().isEmpty()){
            entidades.Usuario usuario=pesquisarUsuarioPorNomeUsuario(u.getNomeUsuario());
            if(usuario!=null){
                enviarEmailUsuario(usuario);
                return true;
            }
        }
        else if(!u.getEmail().isEmpty()){
            entidades.Usuario usuario=pesquisarUsuarioPorEmail(u.getEmail());
            if(usuario!=null){
                enviarEmailUsuario(usuario);
                return true;
            }
        }
        return false;
    }
    
    public void enviarEmailUsuario(entidades.Usuario usuario){
        Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                //return new PasswordAuthentication("syslojaperfumes2016@gmail.com", "sysloja123456");
                return new PasswordAuthentication("", "");
            }
        });
        session.setDebug(true);
        try{
            Message message = new MimeMessage(session);
            System.out.println("2");
            message.setFrom(new InternetAddress("")); //Remetente
            Address[] toUser = InternetAddress //Destinatário(s) separados por virgula+espaço
                             .parse(usuario.getEmail());  
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Recuperação de dados do seu Usuário no SysLoja");//Assunto
            System.out.println("aqui");
            message.setText("Segue suas informações de Usuário e Senha: \n"
                    + "Usuário: "+usuario.getNomeUsuario()+"\n"
                    + "Senha: "+usuario.getSenha());
            System.out.println("3");
            Transport.send(message);
            System.out.println("Feito!");
        }catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> listarPorId(Integer id) {
        Map<String, Object> map=new HashMap();
        map.put("id", id);
        return listargenerico("Usuario.findById", map);
    }

    public List<Usuario> listarPorNome(String nome) {
        Map<String, Object> map=new HashMap();
        map.put("nome", nome+"%");
        return listargenerico("Usuario.findByNomeParecido", map);
    }

    public List<Usuario> listarPorEmail(String email) {
        Map<String, Object> map=new HashMap();
        map.put("email", email);
        return listargenerico("Usuario.findByEmail", map);
    }

    public List listarIdNomeEmailPorNome(String nome) {
        Map<String, Object> map=new HashMap();
        map.put("nome", nome+"%");
        return listargenerico("Usuario.findIdNomeEmailByNome", map);
    }

    public List listarIdNomeEmailPorEmail(String email) {
        Map<String, Object> map=new HashMap();
        map.put("email", email+"%");
        return listargenerico("Usuario.findIdNomeEmailByEmail", map);
    }
}
