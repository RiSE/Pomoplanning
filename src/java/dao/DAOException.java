/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package dao;

/**
 * Exceção lancada quando ocorre um erro com o DAO.
 * 
 * @author Saulo
 *
 */
public class DAOException extends Exception {
	
	private static final long serialVersionUID = 1933561632667272154L;

	public DAOException() {
		super();
	}
	
	public DAOException(String msg) {
		super(msg);
	}
}
