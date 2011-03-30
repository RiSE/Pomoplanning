/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idUsuario;
    
    @Column(nullable=false,length=50)
    private String nome;
    
    @Column(nullable=false,length=30)
    private String email;
    
    @Column(unique=true,nullable=false,length=20)    
    private String login;
    
    /**
     * O campo senha tem um tamanho de 128 caracteres pois a senha gerada pela encriptação
     * SHA-512 gera uma saída deste tamanho.
     */
    @Column(unique=false,nullable=false,length=128)
    private String senha;

	public Usuario(){
    }

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
