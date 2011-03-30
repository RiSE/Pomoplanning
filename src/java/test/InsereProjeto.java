package test;

import model.Desenvolvedor;
import model.Gerente;
import model.Projeto;
import dao.Compare;
import dao.Condicao;
import dao.DAOException;
import dao.GenericDAO;


/*
 * @author Saulo de Tarso
 * 
 */

public class InsereProjeto {

	
	public static void main(String[] args) {
		Projeto [] projeto = new Projeto[4];
		
		String[] nomes = {"Pomodoro", "Rise", "Poker","SCRUM"};
		String[] gerentes = {"Evandro", "Ciro", "Saulo","Artur"};
		String[] desenvolvedores = {"Diego", "Honda", "Esbel", "Jose"};
		
		for (int i = 0; i < nomes.length; i++)
		{
			projeto[i] = new Projeto();
			projeto[i].setNomeProjeto(nomes[i]);
		}
		
		try {
			projeto[0].setGerente((Gerente)GenericDAO.search(Gerente.class, new Condicao("nome", gerentes[0], Compare.EQ)).get(0));
			for(int i=0;i<gerentes.length;i++)
				projeto[i].setGerente((Gerente)GenericDAO.search(Gerente.class, new Condicao("nome", gerentes[i], Compare.EQ)).get(0));
			
			for(int i=0;i<desenvolvedores.length;i++)
				projeto[i].getDesenvolvedores().add((Desenvolvedor)GenericDAO.search(Desenvolvedor.class, new Condicao("nome", desenvolvedores[i], Compare.EQ)).get(0));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			for(int i=0;i<nomes.length;i++) {
				GenericDAO.insert(projeto[i]);
				GenericDAO.closeSession();
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
