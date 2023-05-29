/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import dao.ClienteDao;
import dao.FuncionarioDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renan
 */
public class Funcionario{
    private Integer id;
    private Double salario;
    private Cargo cargoId;
    private Cliente clienteId;
    private Usuario usuarioId;

    public Funcionario() {
    }

    public Funcionario(Integer id) {
        this.id = id;
    }

    public Funcionario(Integer id, Double salario) {
        this.id = id;
        this.salario = salario;
    }
    
    public Funcionario(Integer id, Double salario, Cargo cargoId, Cliente clienteId, Usuario usuarioId){
        this.id=id;
        this.salario=salario;
        this.cargoId=cargoId;
        this.clienteId=clienteId;
        this.usuarioId=usuarioId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Cargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargo cargoId) {
        this.cargoId = cargoId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Funcionario[ id=" + id + " ]";
    }
    
    public entidades.Funcionario getFuncionarioEntity(){
        entidades.Cliente cliente=new entidades.Cliente();
        cliente.setId(id);
        cliente.setNome(clienteId.getNome());
        cliente.setDataNasc(clienteId.getDataNasc());
        cliente.setTelefone(clienteId.getTelefone());
        cliente.setEndereco(clienteId.getEndereco());
        cliente.setBairro(clienteId.getBairro());
        cliente.setCidade(clienteId.getCidade());
        cliente.setRg(clienteId.getRg());
        cliente.setCpf(clienteId.getCpf());
        cliente.setCnpj(clienteId.getCnpj());
        entidades.Usuario usuario=new entidades.Usuario();
        usuario.setId(null);
        usuario.setNomeUsuario(usuarioId.getNomeUsuario());
        usuario.setSenha(usuarioId.getSenha());
        usuario.setEmail(usuarioId.getEmail());
        entidades.Cargo cargo=new entidades.Cargo();
        cargo.setId(cargoId.getId());
        cargo.setNome(cargoId.getNome());
        cargo.setDescricao(cargoId.getDescricao());
        cargo.setNivelAcesso(cargoId.getNivelAcesso());
        entidades.Funcionario funcionario=new entidades.Funcionario();
        funcionario.setId(id);
        funcionario.setSalario(salario);
        funcionario.setCargoId(cargo);
        funcionario.setClienteId(cliente);
        funcionario.setUsuarioId(usuario);
        return funcionario;
        
    }
    public void setFuncionarioEntity(entidades.Funcionario funcionario){
        id=funcionario.getId();
        salario=funcionario.getSalario();
        Cargo cargo=new Cargo();
        cargo.setCargoEntity(funcionario.getCargoId());
        cargoId=cargo;
        Cliente cliente=new Cliente();
        cliente.setClienteEntity(funcionario.getClienteId());
        clienteId=cliente;
        Usuario usuario=new Usuario();
        usuario.setUsuarioEntity(funcionario.getUsuarioId());
        usuarioId=usuario;
        
    }
    
    private Boolean saveMergeOrDelete(int acao){
        FuncionarioDao funcionariodao=new FuncionarioDao();
        entidades.Funcionario funcionario=getFuncionarioEntity();
        Boolean b=false;
        b=(acao==1)?funcionariodao.salvar(funcionario):(acao==2)?funcionariodao.alterar(funcionario):funcionariodao.excluir(funcionario);
        return b;
    }
    public Boolean salvar(){
        return saveMergeOrDelete(1);
    }
    public Boolean alterar(){
        return saveMergeOrDelete(2);
    }
    public Boolean excluir(){
        return saveMergeOrDelete(3);
    }
    
    public List<Funcionario> listarPorCpf(String text){
        if(text.length()==11){
            List<entidades.Funcionario> funcionarios=new FuncionarioDao().listarPorCpf(text);
            List<Funcionario> funcionariosbo=new ArrayList();
            for(entidades.Funcionario f:funcionarios){
                Funcionario funcionariobo=new Funcionario();
                funcionariobo.setFuncionarioEntity(f);
                funcionariosbo.add(funcionariobo);
            }
            return funcionariosbo;
        }
        return null;
    }
    
    
    public List<Cliente> listarNomeCpfPorCpf(String text) {
        if(text.length()==11){
            List clientes=new ClienteDao().listarNomeCpfPorCpf(text);
            return convertToTableListBO(clientes);
        }
        return null;
    }
    public List<Cliente> listarNomeCpfPorNome(String text) {
        List clientes=new ClienteDao().listarNomeCpfPorNome(text);
        return convertToTableListBO(clientes);
    }    
    private List<Cliente> convertToTableListBO(List clientes){
        List<Cliente> clientesbo = new ArrayList<Cliente>();
        for(Object o:clientes){
            Object [] o1=(Object[]) o;
            Cliente cliente=new Cliente(o1[0].toString(), o1[1].toString());
            clientesbo.add(cliente);
        }
        return clientesbo;
    }
    public List<Cliente> listarPorRg(String text){
        List<Cliente> lista=new ArrayList<Cliente>();
        List<entidades.Cliente> clientes=new ClienteDao().listarPorRg(text);
        for(entidades.Cliente c:clientes){
            Cliente clientebo=new Cliente();
            clientebo.setClienteEntity(c);
            lista.add(clientebo);
        }
        return lista;
    }

    public Funcionario listarPorUsuario(Integer id) {
        List<entidades.Funcionario> funcionarios=new FuncionarioDao().listarPorUsuario(id);
        Funcionario f=new Funcionario();
        if(funcionarios!=null){
            f.setFuncionarioEntity(funcionarios.get(0));
            return f;
        }
        return null;
    }

    public List<Funcionario> listarPorId(Integer id) {
        List<Funcionario> lista=new ArrayList();
        List<entidades.Funcionario> funcionarios=new FuncionarioDao().listarPorId(id);
        for(entidades.Funcionario f:funcionarios){
            Funcionario fbo=new Funcionario();
            fbo.setFuncionarioEntity(f);
            lista.add(fbo);
        }
        return lista;
    }

    public List<Funcionario> listarFuncionariosParaPagamentoPorNome(String nome) {
        List<Funcionario> lista=new ArrayList();
        List<entidades.Funcionario> funcionarios=new FuncionarioDao().listarFuncionariosParaPagamentoPorNome(nome);
        for(entidades.Funcionario f:funcionarios){
            Funcionario fbo=new Funcionario();
            fbo.setFuncionarioEntity(f);
            lista.add(fbo);
        }
        return lista;
    }
    
    
}
