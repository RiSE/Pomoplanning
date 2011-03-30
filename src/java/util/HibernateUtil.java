/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 * Esta classe � a encarregada por fazer a liga��o do hibernate com o SGBD.
 * � necess�ria a cria��o de um usu�rio chamado usuario, com senha usuario,
 * limitado, por quest�es de seguran�a.
 * 
 * @author Saulo
 * 
 * @version 0.1
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.getProperties().setProperty("hibernate.connection.password","postgres");
	        cfg.getProperties().setProperty("hibernate.connection.username","postgres");
			cfg.configure();
	        
			sessionFactory = cfg.buildSessionFactory();
		} catch(Exception ex){
			System.out.println("Erro ao criar SessionFactory "+ex);
			sessionFactory=null;
		}
	}

	public static Session getSession(){
		return sessionFactory.openSession();
	}	
}
