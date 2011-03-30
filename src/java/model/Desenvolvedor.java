/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@PrimaryKeyJoinColumn(name = "idUsuario")
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"idUsuario"})})
public class Desenvolvedor extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idProjeto")
    private Projeto projeto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idSprint")
    private Sprint sprint;
	
	public Desenvolvedor() {
		
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

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
}
