/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 *
 * @author Naldinho
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({InsereGerenteTest.class, InsereDesenvolvedorTest.class,
	InsereProjetoTest.class, InsereEstoriasTest.class, InsereTarefasTest.class,
	InsereSprintTest.class, InsereReuniaoTest.class})
public class AllTestsTest {

    public AllTestsTest() {
    }


}