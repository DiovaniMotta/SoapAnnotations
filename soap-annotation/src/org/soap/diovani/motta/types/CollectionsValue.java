package org.soap.diovani.motta.types;

import java.util.List;
import java.util.Vector;

import org.ksoap2.serialization.SoapObject;
import org.soap.diovani.motta.manager.Session;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data:10/05/2015 
 * Classe respons�vel por tratar de encapsular os valores de objetos complexos usados pela aplicacao
 */
public class CollectionsValue <E> {

	//armazena um vetor de objetos informados no parametro
	private Vector<E> lista = new Vector<E>();
	//armazena o namespace usado pela aplicacao
	private String namespace;
	//armazena o nome do soapObject
	private String name;
	
	/**
	 * M�todo respons�vel por retornar um vetor de objetos informados no parametros
	 * @param soapObject o objeto que cont�m a lista a ser desencapsulada
	 * @return um vetor de objetos repassados por parametro
	 */
	@SuppressWarnings("unchecked")
	public Vector<E> valueOf(Class<?> classe,SoapObject soapObject){
		//itero sobre toda a lista de propriedades
		lista.clear();
		for(int x=0; x<soapObject.getPropertyCount(); x++){
			try
			{
				System.out.println("propertyCount: "+soapObject.getPropertyCount());
				System.out.println("x: "+x);
				System.out.println(soapObject.getProperty(x));
				SoapObject property = (SoapObject) soapObject.getProperty(x);
				Object object = Session.valueOf(classe,property);
				lista.add((E) object);
			}
			catch(Exception exception)
			{
				throw new ClassCastException("N�o foi poss�vel realizar a convers�o para o tipo de dados especificado.");
			}
		}
		return lista; 
	}
	
	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto mapeado em um SoapObject
	 * @param param uma lista de objetos que ser� convertido
	 * @return um objeto do tipo SOapObject
	 * @throws Exception 
	 */
	public SoapObject parse(Object param) throws Exception{
		List<?> lista = null;
		lista = (List<?>) param;
		if(lista == null){
			throw new ClassCastException("N�o foi poss�vel efetuar o casting.");
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
}
