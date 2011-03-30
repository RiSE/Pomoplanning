package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.Reuniao;

import org.junit.Before;
import org.junit.Test;

import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereReuniaoTest {
	
	ArrayList<Reuniao> reuniao;
	
	@Before
	public void executaAntesTeste(){
		reuniao = new ArrayList<Reuniao>();
	}
	
	@Test
	public void testMain() {
		try{
			reuniao =(ArrayList<Reuniao>)GenericDAO.list(Reuniao.class);
			assertEquals(16, reuniao.size());
		}catch (Exception e) {
			System.out.println("Erro ao consultar universidade"+e);
		}
	}

}
