package org.soap.diovani.motta.types;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Timer;

import org.soap.diovani.motta.conversor.Conversor;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data:10/05/2015 
 * Classe responsável por tratar de desencapsular os valores primitivos usados pela aplicacao
 */
public class PrimitiveValue {

	/**
	 * Método responsável por desencampsultar um valor primitivo e retorna-lo 
	 * @param tipoCampo o tipo de objeto que será desencapsulado
	 * @param soapPrimitive um objeto primitivo
	 * @return o objeto convertido
	 * @throws Exception 
	 */
	public Object valueOf(Class<?> tipoCampo,Object object) throws Exception{
		Object valor = null;
		if(tipoCampo == String.class){
			valor = object.toString();
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
			throw new Exception("Tipo de dados não implementado.");
		}
		if(valor == null){
			throw new NullPointerException("O retorno nao pode ser nulo.");
		}
		return valor;
	}
	
	/**
	 * Método responsavel por converter os valores que serão enviados ao web service em string
	 * @param tipoCampo o tipo do campo
	 * @param object o objeto a ser convertido em String
	 * @return o valor do parametro convertido em String
	 * @throws Exception
	 */
	public String parse(Class<?> tipoCampo,Object object) throws Exception{
		String valor = null;
		if(tipoCampo == String.class){
			valor = object.toString();
		}
		else if((tipoCampo == Integer.class) || (tipoCampo == int.class)){
			valor = Conversor.toString(object);
		}
		else if((tipoCampo == Character.class) || (tipoCampo == char.class)){
		}
		else if(tipoCampo == Long.class){
			valor = Conversor.toString(object);
		}
		else if((tipoCampo == Double.class) || (tipoCampo == double.class)){
			valor = Conversor.toString(object);		
		}
		else if((tipoCampo == Float.class) || (tipoCampo == float.class)){
			valor = Conversor.toString(object);
		}
		else if(tipoCampo == Short.class){
			valor = Conversor.toString(object);
		}
		else if(tipoCampo == BigDecimal.class){
			valor = Conversor.toString(object);	
		}
		else if((tipoCampo == Boolean.class) || (tipoCampo == boolean.class)){
			valor = Conversor.toString(object);
		}
		else if(tipoCampo == Date.class){
			valor = Conversor.parse(object);
		}
		else if(tipoCampo == Timer.class){
			
		} else {
			throw new Exception("Tipo de dados não implementado.");
		}
		if(valor == null){
			throw new NullPointerException("O retorno nao pode ser nulo.");
		}
		return valor;
	}
}
