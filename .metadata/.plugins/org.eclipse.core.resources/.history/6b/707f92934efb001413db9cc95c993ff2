package org.soap.diovani.motta.utils;
/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 11/05/2015
 * Classe responsável por instânciar um objeto do através da classe repassada como parametro
 */
public class Klasse {

	/**
	 * Método responsável por instânciar um novo objeto através de sua classe 
	 * @param kclasse a classe a qual se deseja instanciar o objeto
	 * @return um objeto do tipo informado criado.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T instancialize(Class<?> kclasse) throws InstantiationException,IllegalAccessException{
		T target = null;
		target = (T) kclasse.newInstance();
		return target;
	}
}
