/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
/**
 * Esta é a classe que irá utilizar o hibernate para efetuar as operações de
 * persistência sobre os objetos.
 * 
 * @author Saulo
 * 
 * @version 0.2
 */
public class GenericDAO {

	private static Session session;
	private static Transaction transaction;
	
	private static void startOperation() {
		 session = HibernateUtil.getSession();
		 transaction = session.beginTransaction();
	}
	
	/**
	 * Insere um objeto no banco de dados. 
	 *  
	 * @param	obj
	 * 			Objeto a ser persistido no banco de dados 
	 */
	public static void insert(Object obj) throws DAOException {
		try{
			startOperation();
			session.save(obj);
			transaction.commit();
		}catch(HibernateException ex){
			System.err.println("Erro na inserção "+ex);
			transaction.rollback();
			throw new DAOException("Erro na inserção");
		}
	}
	
	/**
	 * Retorna um {@code List} de objetos da classe informada em {@code cls} 
	 * recuperados no banco de dados.  
	 * 
	 * @param	cls
	 * 			Classe que se deseja buscar no banco de dados
	 * 
	 * @return	List<?>
	 * 			Lista de objetos recuperados do banco de dados
	 */
	public static List<?> list(Class<?> cls) throws DAOException {
		List<?> objects = null;
		try {
			startOperation();
			objects = session.createQuery("from " + cls.getName()).list();
			transaction.commit();
		} catch (HibernateException ex) {
			System.err.println("Erro na consulta "+ex);
			throw new DAOException("Erro na consulta");
		}
		return objects;
	}
	
	/**
	 * Retorna um {@code Object} contendo o objeto recuperado do banco de
	 * dados que tenha o {@code id} igual ao passado como parâmetro.
	 * 
	 * @param cls
	 * 		  Classe do objeto que se deseja recuperar do banco de dados
	 * @param id
	 * 		  Numero de identificaçã do objeto que se deseja procurar
	 * 
	 * @return Object
	 * 		   Objeto a ser retornado caso seja encontrado no banco de dados.
	 * 		   Caso o objeto não seja encontrado, será retornado {@code null}
	 */
    public static Object get(Class<?> cls, Long id) throws DAOException {
        Object object = null;
        try {
            startOperation();
            object = session.load(cls, id);
        } catch (HibernateException ex) {
            System.err.println("Erro na consulta "+ex);
            throw new DAOException("Erro na consulta");
        }
        return object;
    }


    public static List<?> search(Class<?> cls, Condicao condicao) throws DAOException {
    	List<?> objects = null;
    	try {
    		startOperation();

    		Criteria crit = session.createCriteria(cls);

    		switch(condicao.getCompare()) {
    		case EQ:
    			System.out.println("Adicionado criterio " + condicao.getKey() + " = " + condicao.getValue());
    			crit.add(Restrictions.eq(condicao.getKey(), condicao.getValue()));
    			break;
    		case NE:
    			System.out.println("Adicionado criterio " + condicao.getKey() + " != " + condicao.getValue());
    			crit.add(Restrictions.ne(condicao.getKey(), condicao.getValue()));
    			break;
    		case GT:
    			System.out.println("Adicionado criterio " + condicao.getKey() + " > " + condicao.getValue());
    			crit.add(Restrictions.gt(condicao.getKey(), condicao.getValue()));
    			break;
    		case GE:
    			System.out.println("Adicionado criterio " + condicao.getKey() + " >= " + condicao.getValue());
    			crit.add(Restrictions.ge(condicao.getKey(), condicao.getValue()));
    			break;
    		case LT:
    			System.out.println("Adicionado criterio " + condicao.getKey() + " < " + condicao.getValue());
    			crit.add(Restrictions.lt(condicao.getKey(), condicao.getValue()));
    			break;
    		case LE:
    			System.out.println("Adicionado criterio " + condicao.getKey() + " <= " + condicao.getValue());
    			crit.add(Restrictions.le(condicao.getKey(), condicao.getValue()));
    			break;
    		}

    		objects = crit.list();
    		transaction.commit();
    	} catch (HibernateException ex) {
    		System.err.println("Erro na consulta "+ex);
    		throw new DAOException("Erro na consulta");
    	}
    	return objects;
    }

    public static List<?> search(Class<?> cls, List<Condicao> condicoes) throws DAOException {
    	List<?> objects = null;
    	try {
    		startOperation();
    		Criteria crit = session.createCriteria(cls);
			for (Condicao condicao : condicoes) {
	    		switch(condicao.getCompare()) {
	    			case EQ:
	    	    		System.out.println("Adicionado criterio " + condicao.getKey() + " = " + condicao.getValue());
	    				crit.add(Restrictions.eq(condicao.getKey(), condicao.getValue()));
	    				break;
	    			case NE:
	    	    		System.out.println("Adicionado criterio " + condicao.getKey() + " != " + condicao.getValue());
	    				crit.add(Restrictions.ne(condicao.getKey(), condicao.getValue()));
	    				break;
	    			case GT:
	    	    		System.out.println("Adicionado criterio " + condicao.getKey() + " > " + condicao.getValue());
	    				crit.add(Restrictions.gt(condicao.getKey(), condicao.getValue()));
	    				break;
	    			case GE:
	    	    		System.out.println("Adicionado criterio " + condicao.getKey() + " >= " + condicao.getValue());
	    				crit.add(Restrictions.ge(condicao.getKey(), condicao.getValue()));
	    				break;
	    			case LT:
	    	    		System.out.println("Adicionado criterio " + condicao.getKey() + " < " + condicao.getValue());
	    				crit.add(Restrictions.lt(condicao.getKey(), condicao.getValue()));
	    				break;
	    			case LE:
	    	    		System.out.println("Adicionado criterio " + condicao.getKey() + " <= " + condicao.getValue());
	    				crit.add(Restrictions.le(condicao.getKey(), condicao.getValue()));
	    				break;
	    		}
			}
    		
			objects = crit.list();
    		transaction.commit();
    	} catch (HibernateException ex) {
            System.err.println("Erro na consulta "+ex);
            throw new DAOException("Erro na consulta");
        }
        return objects;
    }

	/**
	 * Modifica o objeto {@code obj} no banco de dados, desde que exista um objeto
	 * com o id igual ao passado como parâmetro, caso não exista, este objeto será
	 * incluído ao banco de dados.	
	 * @param	obj
	 * 			Objeto a ser modificado ou incluido no banco de dados
	 */
	public static void saveOrUpdate(Object obj) throws DAOException {
		try{
			startOperation();
			session.saveOrUpdate(obj);
			transaction.commit();

		}catch(HibernateException ex){
			System.err.println("Erro na atualização "+ex);
			transaction.rollback();
			throw new DAOException("Erro na atualização");
		}
	}
	
	/**
	 * Modifica o objeto {@code obj} no banco de dados, desde que exista um objeto
	 * com o id igual ao passado como parâmetro.	
	 * @param	obj
	 * 			Objeto a ser modificado no banco de dados
	 */
	public static void update(Object obj) throws DAOException {
		try{
			startOperation();
			session.update(obj);
			transaction.commit();

		}catch(HibernateException ex){
			System.err.println("Erro na atualização "+ex);
			transaction.rollback();
			throw new DAOException("Erro na atualização");
		}
	}

	/**
	 * Remove um objeto do banco de dados, desde que o {@code obj} contenha um
	 * objeto cujo id esteja presente no banco de dados. 
	 * @param	obj
	 * 			Objeto a ser removido do banco de dados
	 */
	public static void remove(Object obj) throws DAOException {
		try{
			startOperation();
			session.delete(obj);
			transaction.commit();

		}catch(HibernateException ex){
			System.err.println("Erro na remoção "+ex);
			transaction.rollback();
			throw new DAOException("Erro na remoção");
		}
	}
	
	/**
	 * Método para fechar a sessão com o banco de dados.
	 */
	public static void closeSession() {
		session.close();
	}
}