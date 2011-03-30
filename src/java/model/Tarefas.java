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
public class Tarefas implements Serializable{
 
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idTarefa;
    @Column(nullable=false)
    private int estimativa;
    @Column(nullable=false,length=500)
    private String tarefa;
	
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idEstoria")
    private Estorias estorias;
    
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idSprint")
    private Sprint sprint;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="idTarefas")
    @Cascade(CascadeType.ALL)
    private List<Pomodoro> pomodoros= new LinkedList<Pomodoro>();
	
    public Tarefas(){
        super();
    }

	public long getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(long idTarefa) {
		this.idTarefa = idTarefa;
	}

	public int getEstimativa() {
		return estimativa;
	}

	public void setEstimativa(int estimativa) {
		this.estimativa = estimativa;
	}

	public String getTarefa() {
		return tarefa;
	}

	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}

	public Estorias getEstorias() {
		return estorias;
	}

	public void setEstorias(Estorias estorias) {
		this.estorias = estorias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public List<Pomodoro> getPomodoros() {
		return pomodoros;
	}

	public void setPomodoros(List<Pomodoro> pomodoros) {
		this.pomodoros = pomodoros;
	}
}