/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Sprint implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idSprint;
	
	@Column(nullable=false,length=100)
	private String objetivo;
	
	@Column(nullable=false,length=50)
	private Date entrega;
	
	@OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="idSprint")
    @Cascade(CascadeType.ALL)
    private List<Desenvolvedor> desenvolvedores= new LinkedList<Desenvolvedor>();
	
	@OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="idSprint")
    @Cascade(CascadeType.ALL)
    private List<Reuniao> reunioes= new LinkedList<Reuniao>();
	
	@OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="idSprint")
    @Cascade(CascadeType.ALL)
    private List<Tarefas> tarefas= new LinkedList<Tarefas>();
	
	public Sprint() {
		
	}

	public long getIdSprint() {
		return idSprint;
	}

	public void setIdSprint(long idSprint) {
		this.idSprint = idSprint;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getEntrega() {
		return entrega;
	}

	public void setEntrega(Date entrega) {
		this.entrega = entrega;
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

	public List<Reuniao> getReunioes() {
		return reunioes;
	}

	public void setReunioes(List<Reuniao> reunioes) {
		this.reunioes = reunioes;
	}

	public List<Tarefas> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefas> tarefas) {
		this.tarefas = tarefas;
	}
}
