package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.Projeto;

import org.junit.Before;
import org.junit.Test;

import dao.GenericDAO;

/*
 * @author Saulo de Tarso
 * 
 */

public class InsereProjetoTest {
	ArrayList<Projeto> projetos;

	@Before
	public void executaAntesTeste(){
		projetos = new ArrayList<Projeto>();
	}	
	
	@Test
	public void testMain() {
		 		
		try{
			projetos =(ArrayList<Projeto>)GenericDAO.list(Projeto.class);
			assertEquals(4, projetos.size());
		}catch (Exception e) {
			System.out.println("Erro ao consultar cursos"+e);
		}
	}

}
