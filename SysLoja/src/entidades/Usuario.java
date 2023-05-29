/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByNomeUsuario", query = "SELECT u FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByNomeParecido", query = "SELECT u FROM Usuario u WHERE UPPER(u.nomeUsuario) LIKE UPPER(:nome)"),
    @NamedQuery(name = "Usuario.findIdNomeEmailByNome", query = "SELECT u.id, u.nomeUsuario, u.email FROM Usuario u WHERE UPPER(u.nomeUsuario) LIKE UPPER(:nome)"),
    @NamedQuery(name = "Usuario.findIdNomeEmailByEmail", query = "SELECT u.id, u.nomeUsuario, u.email FROM Usuario u WHERE UPPER(u.email) LIKE UPPER(:email)"),
    @NamedQuery(name = "Usuario.findByNomeUsuarioAndSenha", query = "SELECT u FROM Usuario u WHERE UPPER(u.nomeUsuario)=UPPER(:nomeUsuario) AND UPPER(u.senha)=UPPER(:senha)")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<PagamentoFuncionario> pagamentoFuncionarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<Funcionario> funcionarioList;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nomeUsuario, String senha, String email) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<PagamentoFuncionario> getPagamentoFuncionarioList() {
        return pagamentoFuncionarioList;
    }

    public void setPagamentoFuncionarioList(List<PagamentoFuncionario> pagamentoFuncionarioList) {
        this.pagamentoFuncionarioList = pagamentoFuncionarioList;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuario[ id=" + id + " ]";
    }
    
}
