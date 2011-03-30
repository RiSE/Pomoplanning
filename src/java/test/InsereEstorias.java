package test;

import model.Estorias;
import model.Projeto;
import dao.Compare;
import dao.Condicao;
import dao.DAOException;
import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereEstorias {

	public static void main(String[] args) {
		Estorias estorias[] = new Estorias[8];
		
		String[] nomes = {"Estoria Pomodoro1", "Estoria Pomodoro2", "Estoria Rise1", "Estoria Rise2",
				"Estoria Poker1","Estoria Poker2","Estoria SCRUM1", "Estoria SCRUM2"};
		String[] demonstracoes = {"Demonstracao da Estoria Pomodoro1", "Demonstracao da Estoria Pomodoro2",
				"Demonstracao da Estoria Rise1", "Demonstracao da Estoria Rise2",
				"Demonstracao da Estoria Poker1","Demonstracao da Estoria Poker2",
				"Demonstracao da Estoria SCRUM1", "Demonstracao da Estoria SCRUM2"};
		String[] notas = {"Nota da Estoria Pomodoro1", "Nota da Estoria Pomodoro2",
				"Nota da  Estoria Rise1", "Nota da  Estoria Rise2", "Nota da Estoria Poker1",
				"Nota da  Estoria Poker2","Nota da Estoria SCRUM1", "Nota da Estoria SCRUM2"};
		int[] importancias = {30,25,15,40,20,30,45,10};
		int[] estimativas = {5,8,13,20,20,8,13,5};
		
		String[] projetos = {"Pomodoro", "Rise", "Poker","SCRUM"};
		
		for (int i = 0; i < nomes.length; i++)
		{
			estorias[i] = new Estorias();
			estorias[i].setNome(nomes[i]);
			estorias[i].setDemonstracao(demonstracoes[i]);
			estorias[i].setNotas(notas[i]);
			estorias[i].setImportancia(importancias[i]);
			estorias[i].setEstimativa(estimativas[i]);
		}
		
		try {
			for(int i = 0, j = 0; i < nomes.length; i+=2, j++)
			{
				estorias[i].setProjeto((Projeto)GenericDAO.search(Projeto.class, new Condicao("nomeProjeto", projetos[j], Compare.EQ)).get(0));
				estorias[i + 1].setProjeto((Projeto)GenericDAO.search(Projeto.class, new Condicao("nomeProjeto", projetos[j], Compare.EQ)).get(0));
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			for(int i=0;i<nomes.length;i++) {
				GenericDAO.insert(estorias[i]);
				GenericDAO.closeSession();
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
