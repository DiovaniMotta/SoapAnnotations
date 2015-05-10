package org.soap.diovani.motta.types;

import java.math.BigDecimal;
import java.util.Date;

import org.ksoap2.serialization.SoapPrimitive;
import org.soap.diovani.motta.conversor.Conversor;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data:10/05/2015 
 * Classe respons�vel por tratar de desencapsular os valores primitivos usados pela aplicacao
 */
public class PrimitiveValue {

	/**
	 * M�todo respons�vel por desencampsultar um valor primitivo e retorna-lo 
	 * @param tipoCampo o tipo de objeto que ser� desencapsulado
	 * @param soapPrimitive um objeto primitivo
	 * @return o objeto convertido
	 * @throws Exception 
	 */
	public Object value(Class<?> tipoCampo,SoapPrimitive soapPrimitive) throws Exception{
		Object valor = null;
		if(tipoCampo == String.class){
			valor = Conversor.toString(soapPrimitive);
		}
		else if(tipoCampo == Integer.class){
			valor = Conversor.toInt(soapPrimitive);
		}
		else if(tipoCampo == Character.class){
		
		}
		else if(tipoCampo == Long.class){
			
		}
		else if(tipoCampo == Double.class){
			
		}
		else if(tipoCampo == Float.class){
			
		}
		else if(tipoCampo == Short.class){
			
		}
		else if(tipoCampo == BigDecimal.class){
			valor = Conversor.toBigDecimal(soapPrimitive);	
		}
		else if(tipoCampo == Boolean.class){
			valor = Conversor.toBoolean(soapPrimitive);
		}
		else if(tipoCampo == Date.class){
			valor = Conversor.toDate(soapPrimitive);
		}
		else {
			throw new Exception("Tipo de dados n�o implementado.");
		}
		if(valor == null){
			throw new NullPointerException("O retorno nao pode ser nulo.");
		}
		return valor;
	}
	
}
