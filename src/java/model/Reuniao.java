/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package model;

import java.io.Serializable;
import java.util.Calendar;
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
public class Reuniao implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idReuniao;
    @Column(length=11,nullable=false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(length=11,nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar horario;
    @Column(nullable=false,length=50)    
    private String local;
    
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idSprint")
    private Sprint sprint;
    
    public Reuniao(){
        super();
    }

	public long getIdReuniao() {
		return idReuniao;
	}

	public void setIdReuniao(long idReuniao) {
		this.idReuniao = idReuniao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Calendar getHorario() {
		return horario;
	}

	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}