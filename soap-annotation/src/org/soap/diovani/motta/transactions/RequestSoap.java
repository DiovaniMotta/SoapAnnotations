package org.soap.diovani.motta.transactions;

import java.util.Collections;

import org.ksoap2.serialization.SoapPrimitive;
import org.soap.diovani.motta.types.PrimitiveValue;
import org.soap.diovani.motta.utils.Klasse;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 15/05/2015
 * Classe responsavel por efetuar as requisicoes soap com o web service Soap 
 *
 */
public class RequestSoap {

	/**
	 * M�todo respons�vel por efetuar o retorno o processamento de uma requisi��o 
	 * e transforma-la em um tipo de dado primitivo
	 * @param kclasse a classe que se deseja retornar o objeto
	 * @param object a resposta obtida do servidor
	 * @return uma instancia do objeto repassado como parametro
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public <T> T primitive(Class<?> kclasse,Object object) throws Exception{
		T target;
		target = Klasse.instancialize(kclasse);
		PrimitiveValue primitiveValue = new PrimitiveValue();
		Object aux = primitiveValue.value(kclasse, object);
		target = ((T) aux);
		return target;
	}
	
	public <T> T complex(Class<?> kclasse,Object object){
		T target = null;
		
		return target;
	}
	
	public Collections<T> collections(Class<?> kclasse,Object object){
	 	
	}
	
	
}