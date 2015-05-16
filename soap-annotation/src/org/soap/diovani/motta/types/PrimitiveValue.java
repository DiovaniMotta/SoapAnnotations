package org.soap.diovani.motta.types;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Timer;

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
	public Object valueOf(Class<?> tipoCampo,Object object) throws Exception{
		Object valor = null;
		if(tipoCampo == String.class){
			valor = Conversor.toString(object);
		}
		else if((tipoCampo == Integer.class) || (tipoCampo == int.class)){
			valor = Conversor.toInt(object);
		}
		else if((tipoCampo == Character.class) || (tipoCampo == char.class)){
		}
		else if(tipoCampo == Long.class){
			valor = Conversor.toLong(object);
		}
		else if((tipoCampo == Double.class) || (tipoCampo == double.class)){
			valor = Conversor.toDouble(object);		
		}
		else if((tipoCampo == Float.class) || (tipoCampo == float.class)){
			valor = Conversor.toFloat(object);
		}
		else if(tipoCampo == Short.class){
			valor = Conversor.toShort(object);
		}
		else if(tipoCampo == BigDecimal.class){
			valor = Conversor.toBigDecimal(object);	
		}
		else if((tipoCampo == Boolean.class) || (tipoCampo == boolean.class)){
			valor = Conversor.toBoolean(object);
		}
		else if(tipoCampo == Date.class){
			valor = Conversor.toDate(object);
		}
		else if(tipoCampo == Timer.class){
			
		} else {
			throw new Exception("Tipo de dados n�o implementado.");
		}
		if(valor == null){
			throw new NullPointerException("O retorno nao pode ser nulo.");
		}
		return valor;
	}
}
