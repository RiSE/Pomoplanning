/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package dao;

public class Condicao {
	private String key;
	private Object value;
	private Compare compare;
	
	public Condicao(String key, Object value, Compare compare) {
		super();
		this.key = key;
		this.value = value;
		this.compare = compare;
	}

	public String getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}

	public Compare getCompare() {
		return compare;
	}
}
