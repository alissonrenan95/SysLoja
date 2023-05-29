package BO;

import dao.CargoDao;
import java.util.ArrayList;
import java.util.List;

public class Cargo{
    private Integer id;
    private String nome;
    private String descricao;
    private Integer nivelAcesso;

    public Cargo() {
    }

    public Cargo(Integer id) {
        this.id = id;
    }

    public Cargo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Cargo(Integer id, String nome, String descricao, Integer nivelacesso){
        this.id=id;
        this.nome=nome;
        this.descricao=descricao;
        this.nivelAcesso=nivelacesso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(Integer nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
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
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public entidades.Cargo getCargoEntity(){
        entidades.Cargo cargo=new entidades.Cargo();
        cargo.setId(id);
        cargo.setNome(nome);
        cargo.setDescricao(descricao);
        cargo.setNivelAcesso(nivelAcesso);
        return cargo;
    }
    public void setCargoEntity(entidades.Cargo cargo){
        id=cargo.getId();
        nome=cargo.getNome();
        descricao=cargo.getDescricao();
        nivelAcesso=cargo.getNivelAcesso();
    }
    
    private Boolean saveMergeOrDelete(int acao){
        CargoDao cargodao=new CargoDao();
        entidades.Cargo cargo=getCargoEntity();
        Boolean b=false;
        b=(acao==1)?cargodao.salvar(cargo):(acao==2)?cargodao.alterar(cargo):cargodao.excluir(cargo);
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

    public List<Cargo> listarPorNome(String text) {
        List<Cargo> lista=new ArrayList();
        List<entidades.Cargo> cargos=new CargoDao().listarPorNome(text);
        for(entidades.Cargo c:cargos){
            Cargo cargobo=new Cargo();
            cargobo.setCargoEntity(c);
            lista.add(cargobo);
        }
        return lista;
    }

    public List<Cargo> listarPorId(Integer id) {
        List<Cargo> lista=new ArrayList();
        List<entidades.Cargo> cargos=new CargoDao().listarPorId(id);
        for(entidades.Cargo c:cargos){
            Cargo cargobo=new Cargo();
            cargobo.setCargoEntity(c);
            lista.add(cargobo);
        }
        return lista;
    }
}
