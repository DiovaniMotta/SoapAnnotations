package org.soap.diovani.motta.types;

import java.util.Vector;

import org.ksoap2.serialization.SoapObject;
import org.soap.diovani.motta.manager.Session;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data:10/05/2015 
 * Classe responsável por tratar de encapsular os valores de objetos complexos usados pela aplicacao
 */
public class CollectionsValue <E> {

	//armazena um vetor de objetos informados no parametro
	private Vector<E> lista = new Vector<E>();
	
	/**
	 * Método responsável por retornar um vetor de objetos informados no parametros
	 * @param soapObject o objeto que contém a lista a ser desencapsulada
	 * @return um vetor de objetos repassados por parametro
	 */
	@SuppressWarnings("unchecked")
	public Vector<E> value(Class<?> classe,SoapObject soapObject){
		//itero sobre toda a lista de propriedades
		lista.clear();
		for(int x=0; x<soapObject.getPropertyCount(); x++){
			try
			{
				SoapObject property = (SoapObject) soapObject.getProperty(x);
				Object object = Session.parse(classe,property);
				lista.add((E) object);
			}
			catch(Exception exception)
			{
				throw new ClassCastException("Não foi possível realizar a conversão para o tipo de dados especificado.");
			}
		}
		return lista; 
	}
}
