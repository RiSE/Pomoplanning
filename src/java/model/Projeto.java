/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2010
*/

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
public class Projeto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idProjeto;
    @Column(nullable=false,length=50)
    private String nomeProjeto;
	
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idUsuario")
    private Gerente gerente;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="idProjeto")
    @Cascade(CascadeType.ALL)
    private List<Desenvolvedor> desenvolvedores= new LinkedList<Desenvolvedor>();
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="idProjeto")
    @Cascade(CascadeType.ALL)
    private List<Estorias> estorias= new LinkedList<Estorias>();
    
    public Projeto() {
		// TODO Auto-generated constructor stub
	}

	public long getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Desenvolvedor> getDesenvolvedores() {
		return desenvolvedores;
	}

	public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
		this.desenvolvedores = desenvolvedores;
	}

	public List<Estorias> getEstorias() {
		return estorias;
	}

	public void setEstorias(List<Estorias> estorias) {
		this.estorias = estorias;
	}
}