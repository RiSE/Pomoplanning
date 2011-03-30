/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

//package

package model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Estorias implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idEstorias;
    @Column(nullable=false,length=50)    
    private String nome;
    @Column(nullable=true,length=500)    
    private String demonstracao;
    @Column(nullable=false)
    private int importancia;
    @Column(nullable=false)  
    private int estimativa;
    @Column(nullable=true,length=500)    
    private String notas;
    	
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idProjeto")
    private Projeto projeto;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="idEstoria")
    @Cascade(CascadeType.ALL)
    private List<Tarefas> tarefas= new LinkedList<Tarefas>();
	
    public Estorias(){
        super();
    }

	public long getIdEstorias() {
		return idEstorias;
	}

	public void setIdEstorias(long idEstorias) {
		this.idEstorias = idEstorias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDemonstracao() {
		return demonstracao;
	}

	public void setDemonstracao(String demonstracao) {
		this.demonstracao = demonstracao;
	}

	public int getImportancia() {
		return importancia;
	}

	public void setImportancia(int importancia) {
		this.importancia = importancia;
	}

	public int getEstimativa() {
		return estimativa;
	}

	public void setEstimativa(int estimativa) {
		this.estimativa = estimativa;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Tarefas> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefas> tarefas) {
		this.tarefas = tarefas;
	}
}