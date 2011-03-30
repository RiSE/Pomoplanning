package test;

import java.util.Date;

import model.Reuniao;
import model.Sprint;

import java.util.Calendar;

import dao.Compare;
import dao.Condicao;
import dao.DAOException;
import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereReuniao {
	public static void main(String[] args) {		
		Reuniao reuniao[] = new Reuniao[16];
		
		Date[] data = new Date[] {new Date(11/04/03),new Date(11/04/18),new Date(11/05/03),
				new Date(11/05/13),new Date(11/05/23),new Date(11/06/02),new Date(11/06/18),
				new Date(11/07/02), new Date(11/04/05),new Date(11/04/20),new Date(11/05/05),
				new Date(11/05/15),new Date(11/05/25),new Date(11/06/05),new Date(11/06/20),
				new Date(11/07/05)};
		Calendar[] horario = new Calendar[16];
		
		String[] sprints = {"Completar Estoria Pomodoro1", "Completar Estoria Pomodoro2",
				"Completar Estoria Rise1", "Completar Estoria Rise2", "Completar Estoria Poker1",
				"Completar Estoria Poker2","Completar Estoria SCRUM1", "Completar Estoria SCRUM2"};
		
		for (int i = 0; i < data.length; i++)
		{
			reuniao[i] = new Reuniao();
			reuniao[i].setData(data[i]);
			horario[i] = Calendar.getInstance();
			horario[i].set(Calendar.HOUR_OF_DAY, 10);
			horario[i].set(Calendar.MINUTE, 00);
			horario[i].set(Calendar.SECOND, 00);
			reuniao[i].setHorario(horario[i]);
			reuniao[i].setLocal("Sala " + (i + 1));
		}
		
		try {
			for(int i = 0, j = 0; i < data.length; i+=2, j++)
			{
				reuniao[i].setSprint((Sprint)GenericDAO.search(Sprint.class, new Condicao("objetivo", sprints[j], Compare.EQ)).get(0));
				reuniao[i + 1].setSprint((Sprint)GenericDAO.search(Sprint.class, new Condicao("objetivo", sprints[j], Compare.EQ)).get(0));
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			for(int i=0;i<data.length;i++) {
				GenericDAO.insert(reuniao[i]);
				GenericDAO.closeSession();
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
