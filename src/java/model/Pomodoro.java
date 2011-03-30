/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

//package

package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pomodoro implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idPomodoro;
	@Column(length=11,nullable=false)
    @Temporal(TemporalType.TIME)
    private Date inicio;
	@Column(length=11,nullable=false)
    @Temporal(TemporalType.TIME)
    private Date fim;
	@Column(length=11,nullable=false)
    @Temporal(TemporalType.TIME)
    private Date intervalo;
    	
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idTarefa")
    private Tarefas tarefas;
	
    public Pomodoro(){
        super();
    }

	public long getIdPomodoro() {
		return idPomodoro;
	}

	public void setIdPomodoro(long idPomodoro) {
		this.idPomodoro = idPomodoro;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Date getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Date intervalo) {
		this.intervalo = intervalo;
	}

	public Tarefas getTarefas() {
		return tarefas;
	}

	public void setTarefas(Tarefas tarefas) {
		this.tarefas = tarefas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}