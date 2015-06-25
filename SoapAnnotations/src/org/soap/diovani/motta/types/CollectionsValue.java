package org.soap.diovani.motta.types;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.SoapObject;
import org.soap.diovani.motta.manager.Session;
import org.soap.diovani.motta.utils.CollectionsSOAP;
import org.soap.diovani.motta.utils.Klasse;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data:10/05/2015 
 * Classe responsável por tratar de encapsular os valores de objetos complexos usados pela aplicacao
 */
public class CollectionsValue <E> {

	//Armazena uma lista de objetos definidos no parametro
	private List<E> lista = new ArrayList<E>();
	//armazena o namespace usado pela aplicacao
	private String namespace;
	//armazena o nome do soapObject
	private String name;
	
	/**
	 * Método responsável por retornar um vetor de objetos informados no parametros
	 * @param soapObject o objeto que contém a lista a ser desencapsulada
	 * @return 
	 * @return um vetor de objetos repassados por parametro
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public List<E> valueOf(Class<?> classe,SoapObject soapObject) throws InstantiationException, IllegalAccessException{
		//itero sobre toda a lista de propriedades
		E target = Klasse.instancialize(classe);
		for(int x=0; x<soapObject.getPropertyCount(); x++){
			try
			{		
				SoapObject object = (SoapObject) soapObject.getProperty(x);
				target = (E) Session.valueOf(classe,object);
				lista.add(target);
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				throw new ClassCastException("Não foi possível realizar a conversão para o tipo de dados especificado.");
			}
		}
		return lista; 
	}
	
	
	/**
	 * Método responsável por retornar um vetor de objetos informados no parametros
	 * @param soapObject o objeto que contém a lista a ser desencapsulada
	 * @return 
	 * @return um vetor de objetos repassados por parametro
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public List<E> valueOf(Class<?> classe,String property,SoapObject soapObject) throws InstantiationException, IllegalAccessException{
		lista.clear();
		//retorno a posicao de inicio e fim da coleção dentro da mensagem SOAP
		int begin = CollectionsSOAP.indexOf(soapObject, property);
		int end = CollectionsSOAP.lastIndexOf(soapObject, property);
		if(begin == -1)
		  return lista;
		if(end == -1)
		  return lista;
		begin++;
		end++;
		//itero sobre toda a lista de propriedades
		for(int x=begin; x<end; x++){
			try
			{	
			    if(soapObject.getProperty(x) instanceof SoapObject){
			    	SoapObject aux = (SoapObject) soapObject.getProperty(x);
			    	if(aux != null){
			    		E target = Klasse.instancialize(classe);
			    		target = (E) Session.valueOf(classe,aux);
			    		lista.add(target);
			    	}
			    }
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				throw new ClassCastException("Não foi possível realizar a conversão para o tipo de dados especificado.");
			}
		}
		return lista; 
	}
	
	/**
	 * Método responsável por efetuar a conversao de um objeto mapeado em um SoapObject
	 * @param param uma lista de objetos que será convertido
	 * @return um objeto do tipo SOapObject
	 * @throws Exception 
	 */
	public SoapObject parse(Object param) throws Exception{
		List<?> lista = null;
		lista = (List<?>) param;
		if(lista == null){
			throw new ClassCastException("Não foi possível efetuar o casting.");
		}		
		if((namespace == null) || (namespace.isEmpty())){
			throw new NullPointerException("Defina o namespace usado pelo objeto");
		}
		if((name == null) || (name.isEmpty())){
			throw new NullPointerException("Defina o name usado pelo objeto");
		}
		SoapObject soapObject = new SoapObject(namespace,name);
		for(Object object : lista){
			SoapObject item = Session.parse(object);
			soapObject.addSoapObject(item);
		}
		return soapObject;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<E> getLista() {
		return lista;
	}

	public void setLista(List<E> lista) {
		this.lista = lista;
	}
}
