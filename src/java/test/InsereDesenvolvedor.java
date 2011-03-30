package test;

import model.Desenvolvedor;
import util.Sha512;
import dao.DAOException;
import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereDesenvolvedor {

	
	public static void main(String[] args) {
		
	    Desenvolvedor [] desenvolvedores = new Desenvolvedor[4];
	    
		String[] nomes = {"Diego", "Honda", "Esbel", "Jose"};
		String[] logins = {"diego", "honda", "esbel", "jose"};
		String[] senhas = {"diego", "honda", "esbel", "jose"};			
		String[] emails = {"diego@gmail.com", "honda@gmail.com", "esbel@gmail.com", "jose@gmail.com"};
		
		for (int i = 0; i < nomes.length; i++) {
			desenvolvedores[i]= new Desenvolvedor();
			desenvolvedores[i].setNome(nomes[i]);
			desenvolvedores[i].setLogin(logins[i]);
			desenvolvedores[i].setSenha(Sha512.crypto(senhas[i]));
			desenvolvedores[i].setEmail(emails[i]);
			
			try {
				GenericDAO.insert(desenvolvedores[i]);
				GenericDAO.closeSession();
			} catch (DAOException e) {			
				e.printStackTrace();
			}
		}
	}

}
