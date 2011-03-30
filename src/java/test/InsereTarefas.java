package test;

import model.Estorias;
import model.Tarefas;
import dao.Compare;
import dao.Condicao;
import dao.DAOException;
import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereTarefas {
	public static void main(String[] args) {
		Tarefas tarefas[] = new Tarefas[16];
		
		String[] tarefa = {"1 Tarefa da Estoria Pomodoro1", "2 Tarefa da Estoria Pomodoro1",
				"1 Tarefa da Estoria Pomodoro2", "2 Tarefa da Estoria Pomodoro2",
				"1 Tarefa da Estoria Rise1", "2 Tarefa da Estoria Rise1", "1 Tarefa da Estoria Rise2",
				"2 Tarefa da Estoria Rise2", "1 Tarefa da Estoria Poker1",
				"2 Tarefa da Estoria Poker1", "1 Tarefa da Estoria Poker2",
				"2 Tarefa da Estoria Poker2", "1 Tarefa da Estoria SCRUM1",
				"2 Tarefa da Estoria SCRUM1", "1 Tarefa da Estoria SCRUM2",
				"2 Tarefa da Estoria SCRUM2"};
		int[] estimativas = {5,8,13,20,20,8,13,5,5,8,13,20,20,8,13,5};
		
		String[] estorias = {"Estoria Pomodoro1", "Estoria Pomodoro2", "Estoria Rise1", "Estoria Rise2",
				"Estoria Poker1","Estoria Poker2","Estoria SCRUM1", "Estoria SCRUM2"};
		
		for (int i = 0; i < tarefa.length; i++)
		{
			tarefas[i] = new Tarefas();
			tarefas[i].setTarefa(tarefa[i]);
			tarefas[i].setEstimativa(estimativas[i]);
		}
		
		try {
			for(int i = 0, j = 0; i < tarefas.length; i+=2, j++)
			{
				tarefas[i].setEstorias((Estorias)GenericDAO.search(Estorias.class, new Condicao("nome", estorias[j], Compare.EQ)).get(0));
				tarefas[i + 1].setEstorias((Estorias)GenericDAO.search(Estorias.class, new Condicao("nome", estorias[j], Compare.EQ)).get(0));
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			for(int i=0;i<tarefas.length;i++) {
				GenericDAO.insert(tarefas[i]);
				GenericDAO.closeSession();
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
