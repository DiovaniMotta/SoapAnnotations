package org.soap.diovani.motta.manager;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.soap.diovani.motta.annotations.SoapObject;
import org.soap.diovani.motta.annotations.SoapProperty;
import org.soap.diovani.motta.annotations.entidades.*;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 09/05/2015
 * Classe respons�vel por armazenar em memoria os atributos contidos na classe 
 */
public class SessionCache {

	//Objeto respons�vel por armazenar uma cole��o de classe e anosta��es das mesmas
	private static final HashMap<Class<?>, ClassAnnotations> cache = new HashMap<Class<?>,ClassAnnotations>();

	/**
	 * M�todo respons�vel por retornar um objeto contendo as anota��es de classe e de seus atributos
	 * @param kclasse a classe que ser� verificada
	 * @return um objeto do tipo ClassAnnotations, contendo as anota��es de classes e objetos
	 */
	public static ClassAnnotations annotations(Class<?> kclasse){
		//verifico se o objeto j� est� contido na lista
		ClassAnnotations classAnnotations = cache.get(kclasse);
		// se nao estiver contido
		if(classAnnotations == null){
			// verifico se existe a anota��o SoapObject
			SoapObject soapObject = kclasse.getAnnotation(SoapObject.class);
			if(soapObject == null){
				throw new NullPointerException("A classe n�o possui as anota��es necess�rias.");
			}
			//instancio um objeto do tipo ClassAnotations 
			classAnnotations = new ClassAnnotations();
			classAnnotations.setKclasse(kclasse);
			classAnnotations.setNamespace(soapObject.namespace());
			classAnnotations.setTypeId(soapObject.typeId());
			// retorno todos os atributos declarados na classe
			Field[] fields = kclasse.getDeclaredFields();
			//itero toda a lista de objetos
			for(Field field : fields){
				//veirifico se o atributo possui a anota��o SoapProperty  
				SoapProperty soapProperty = field.getAnnotation(SoapProperty.class);
				if(field != null){
					field.setAccessible(true);
					FieldAnnotations fieldAnnotations = new FieldAnnotations();
					fieldAnnotations.setField(field);
					fieldAnnotations.setName(soapProperty.property());
					fieldAnnotations.setType(soapProperty.type());
					if(fieldAnnotations.getName().isEmpty()){
						fieldAnnotations.setName(field.getName());
					}
					classAnnotations.getFields().add(fieldAnnotations);
				}
			}
			cache.put(kclasse,classAnnotations);
		}
		return classAnnotations;
	}
}
