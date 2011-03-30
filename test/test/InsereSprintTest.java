package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.Sprint;

import org.junit.Before;
import org.junit.Test;

import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereSprintTest {
	
	ArrayList<Sprint> sprints;
	
	@Before
	public void executaAntesTeste(){
		sprints = new ArrayList<Sprint>();
	}
	
	@Test
	public void testMain() {
		try{
			sprints=(ArrayList<Sprint>)GenericDAO.list(Sprint.class);
			assertEquals(8, sprints.size());
		}catch (Exception e) {
			System.out.println("Erro ao consultar matriculas"+e);
		}
	}

}
