package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.Desenvolvedor;

import org.junit.Before;
import org.junit.Test;

import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereDesenvolvedorTest {
	

	ArrayList<Desenvolvedor> desenvolvedores;
	
	@Before
	public void executaAntesTeste(){
		desenvolvedores = new ArrayList<Desenvolvedor>();
	}
	
	@Test
	public void testMain() {
		try{
			desenvolvedores =(ArrayList<Desenvolvedor>)GenericDAO.list(Desenvolvedor.class);
			assertEquals(4, desenvolvedores.size());
		}catch (Exception e) {
			System.out.println("Erro ao consultar professores"+e);
		}
	}

}
