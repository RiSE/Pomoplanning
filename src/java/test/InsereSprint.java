package test;

import java.util.Date;

import model.Desenvolvedor;
import model.Sprint;
import model.Tarefas;
import dao.Compare;
import dao.Condicao;
import dao.DAOException;
import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereSprint {
		public static void main(String[] args) {
			Sprint sprints[] = new Sprint[8];
			
			String[] objetivos = {"Completar Estoria Pomodoro1", "Completar Estoria Pomodoro2",
					"Completar Estoria Rise1", "Completar Estoria Rise2", "Completar Estoria Poker1",
					"Completar Estoria Poker2","Completar Estoria SCRUM1", "Completar Estoria SCRUM2"};
			Date[] entregas = new Date[] {new Date(11/04/01),new Date(11/04/15),new Date(11/05/01),
					new Date(11/05/10),new Date(11/05/20),new Date(11/05/30),new Date(11/06/15),
					new Date(11/06/30)};
			
			String[] tarefas = {"1 Tarefa da Estoria Pomodoro1", "2 Tarefa da Estoria Pomodoro1",
					"1 Tarefa da Estoria Pomodoro2", "2 Tarefa da Estoria Pomodoro2",
					"1 Tarefa da Estoria Rise1", "2 Tarefa da Estoria Rise1", "1 Tarefa da Estoria Rise2",
					"2 Tarefa da Estoria Rise2", "1 Tarefa da Estoria Poker1",
					"2 Tarefa da Estoria Poker1", "1 Tarefa da Estoria Poker2",
					"2 Tarefa da Estoria Poker2", "1 Tarefa da Estoria SCRUM1",
					"2 Tarefa da Estoria SCRUM1", "1 Tarefa da Estoria SCRUM2",
					"2 Tarefa da Estoria SCRUM2"};
			
			String[] desenvolvedores = {"Diego", "Honda", "Esbel", "Jose"};
			
			for (int i = 0; i < objetivos.length; i++)
			{
				sprints[i] = new Sprint();
				sprints[i].setObjetivo(objetivos[i]);
				sprints[i].setEntrega(entregas[i]);
			}
			
			try {
				for(int i = 0, j = 0; i < sprints.length; i+=2, j++)
				{
					sprints[i].getDesenvolvedores().add((Desenvolvedor)GenericDAO.search(Desenvolvedor.class, new Condicao("nome", desenvolvedores[j], Compare.EQ)).get(0));
					sprints[i + 1].getDesenvolvedores().add((Desenvolvedor)GenericDAO.search(Desenvolvedor.class, new Condicao("nome", desenvolvedores[j], Compare.EQ)).get(0));
				}
				
				for (int i = 0, j = 0; i < tarefas.length; i+=2, j++)
				{
					sprints[j].getTarefas().add((Tarefas)GenericDAO.search(Tarefas.class, new Condicao("tarefa", tarefas[i], Compare.EQ)).get(0));
					GenericDAO.closeSession();
					sprints[j].getTarefas().add((Tarefas)GenericDAO.search(Tarefas.class, new Condicao("tarefa", tarefas[i + 1], Compare.EQ)).get(0));
					GenericDAO.closeSession();
				}
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				for(int i=0;i<sprints.length;i++) {
					GenericDAO.insert(sprints[i]);
					GenericDAO.closeSession();
				}
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
