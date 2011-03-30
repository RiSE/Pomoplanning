package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.Estorias;

import org.junit.Before;
import org.junit.Test;

import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereEstoriasTest {

	ArrayList<Estorias> estorias;
	
	@Before
	public void executaAntesTeste(){
		estorias = new ArrayList<Estorias>();
	}
	
	
	@Test
	public void testMain() {
		try{
			estorias =(ArrayList<Estorias>)GenericDAO.list(Estorias.class);
			assertEquals(8, estorias.size());
		}catch (Exception e) {
			System.out.println("Erro ao consultar disciplinas"+e);
		}
	}

}
