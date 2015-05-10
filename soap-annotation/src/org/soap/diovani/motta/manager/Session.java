package org.soap.diovani.motta.manager;

import java.lang.reflect.Field;
import java.util.List;

import org.ksoap2.serialization.SoapPrimitive;
import org.soap.diovani.motta.annotations.SoapProperty.Type;
import org.soap.diovani.motta.annotations.entidades.FieldAnnotations;
import org.soap.diovani.motta.types.PrimitiveValue;


/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 09/05/2015
 * Classe responsável por gerenciar o envio e recebimento de objetos enviados através de mensagens Soap para o servidor
 */
public class Session {

	/**
	 * Método responsável por desenpacotar um SoapObject retornado do WebService 
	 * @param classe a classe a qual se deseja retornar um objeto
	 * @param object o SoapObject que se deseja desenpacotar
	 * @return um novo objeto do web service.
	 */
	public static <T> T response(Class<T> classe,org.ksoap2.serialization.SoapObject object){
		T target = null;
		try {
			//crio uma instancia da classe recebida por parametro
			target = classe.newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException("Não foi possível criar um instância do objeto "+classe.getSimpleName()+".");
		}
		List<FieldAnnotations> fields = SessionCache.annotations(classe).getFields();
		Field field = null;
		Type propertyType = null;
		try
		{
			for(FieldAnnotations annotations : fields){
				field = annotations.getField();
				propertyType = annotations.getType();
				Object campo = object.getProperty(annotations.getName());
				//verifico se o atributo iterado está contido na mensagem recebida pelo web service
				if(campo == null){
					continue;
				}
				Object valor = null;
				//retorno o tipo do campo iterado
				Class<?> tipoCampo = field.getType();
				if(propertyType == Type.PRIMITIVE){
					SoapPrimitive soapPrimitive = (SoapPrimitive) campo;
					PrimitiveValue primitiveValue = new PrimitiveValue();
					valor = primitiveValue.value(tipoCampo, soapPrimitive);
				}
				field.setAccessible(true);
				field.set(target,valor);
			}
		}
		catch(Exception exception)
		{
			
		}
		return target;
	}
}
