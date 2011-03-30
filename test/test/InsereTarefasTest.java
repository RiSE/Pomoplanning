package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.Tarefas;

import org.junit.Before;
import org.junit.Test;

import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereTarefasTest {
	ArrayList<Tarefas> tarefas;
	
	@Before
	public void executaAntesTeste(){
		tarefas = new ArrayList<Tarefas>();
	}
	
	@Test
	public void testMain() {
				
		try{
			tarefas =(ArrayList<Tarefas>)GenericDAO.list(Tarefas.class);
			assertEquals(16, tarefas.size());
		}catch (Exception e) {
			System.out.println("Erro ao consultar departamentos"+e);
		}
	}

}
