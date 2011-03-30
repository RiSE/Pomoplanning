package test;

import model.Gerente;
import util.Sha512;
import dao.DAOException;
import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereGerente {
	
	public static void main(String[] args) {		
	
	    Gerente [] gerentes = new Gerente[4];
	    
		String[] nomes = {"Evandro", "Ciro", "Saulo","Artur"};
		String[] logins = {"evandro", "ciro", "saulo","artur"};
		String[] senhas = {"evandro", "ciro", "saulo","artur"};			
		String[] emails = {"evandro@gmail.com", "ciro@gmail.com", "saulo@gmail.com","artur@gmail.com"};
		
		for (int i = 0; i < nomes.length; i++) {
			gerentes[i]= new Gerente();
			gerentes[i].setNome(nomes[i]);
			gerentes[i].setLogin(logins[i]);
			gerentes[i].setSenha(Sha512.crypto(senhas[i]));
			gerentes[i].setEmail(emails[i]);
			
			try {
				GenericDAO.insert(gerentes[i]);
				GenericDAO.closeSession();
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
