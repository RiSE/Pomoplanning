package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.Gerente;

import org.junit.Before;
import org.junit.Test;

import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */
public class InsereGerenteTest {

	ArrayList<Gerente> gerentes;
	
	@Before
	public void executaAntesTeste(){
		gerentes = new ArrayList<Gerente>();
	}
		
	@Test
	public void testMain() {
		
		try{
			gerentes =(ArrayList<Gerente>)GenericDAO.list(Gerente.class);
			assertEquals(4, gerentes.size());
		}catch (Exception e) {
			System.out.println("Erro ao consultar Usuario"+e);
		}
		
	}

}
