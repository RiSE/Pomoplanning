/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@PrimaryKeyJoinColumn(name = "idUsuario")
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"idUsuario"})})
public class Gerente extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="idUsuario")
    @Cascade(CascadeType.ALL)
    private List<Projeto> projetos = new LinkedList<Projeto>();
	
	public Gerente(){
		
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
