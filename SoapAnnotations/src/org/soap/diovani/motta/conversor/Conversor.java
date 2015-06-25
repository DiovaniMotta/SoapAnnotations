package org.soap.diovani.motta.conversor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Timer;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 09/05/2015
 * Classe respons�vel por efetuar a convers�o dos valores lidos do web service
 */
public class Conversor {

	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto do tipo Object em String
	 * @param object o objeto a ser convertido
	 * @return uma String contendo o parametro convertido
	 * @throws Exception
	 */
	public static String toString(Object object) throws Exception {
		return String.valueOf(object);
	}
	
	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto do tipo Object em Integer
	 * @param object o objeto a ser convertido
	 * @return um Integer contendo o parametro convertido
	 * @throws Exception
	 */
	public static Integer toInt(Object object) throws Exception {
		return Integer.parseInt(object.toString());
	}
	
	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto do tipo Object em BigDecimal
	 * @param object o objeto a ser convertido
	 * @return um BigDecimal contendo o parametro convertido
	 * @throws Exception
	 */
	public static BigDecimal toBigDecimal(Object object) throws Exception {
		return BigDecimal.valueOf(Double.valueOf(object.toString()));
	}
	
	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto do tipo Object em Date
	 * @param object o objeto a ser convertido
	 * @return um Date contendo o parametro convertido
	 * @throws Exception
	 */
	public static Date toDate(Object object) throws Exception{
		if(object == null){
			throw new NullPointerException("N�o � possivel converter um valor nulo em um objeto Date");
		}
		String value = object.toString();
		return DateConvert.toDate(value);
	}
	
	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto do tipo Object em Boolean
	 * @param object o objeto a ser convertido
	 * @return um Boolean contendo o parametro convertido
	 * @throws Exception
	 */
	public static Boolean toBoolean(Object object) throws Exception{
		return Boolean.parseBoolean(object.toString());
	}
	
	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto do tipo Object em Long
	 * @param object o objeto a ser convertido
	 * @return um Long contendo o parametro convertido
	 * @throws Exception
	 */
	public static Long toLong(Object object) throws Exception{
		return Long.decode(object.toString());
	}

	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto do tipo Object em Float
	 * @param object o objeto a ser convertido
	 * @return um Float contendo o parametro convertido
	 * @throws Exception
	 */
	public static Float toFloat(Object object) throws Exception{
		return Float.valueOf(object.toString());
	}
	
	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto do tipo Object em Double
	 * @param object o objeto a ser convertido
	 * @return um Double contendo o parametro convertido
	 * @throws Exception
	 */
	public static Double toDouble(Object object) throws Exception{
		return Double.valueOf(object.toString());
	}
	
	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto do tipo Object em Double
	 * @param object o objeto a ser convertido
	 * @return um Double contendo o parametro convertido
	 * @throws Exception
	 */
	public static Short toShort(Object object) throws Exception{
		return Short.decode(object.toString());
	}
	
	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto do tipo Object em Double
	 * @param object o objeto a ser convertido
	 * @return um Double contendo o parametro convertido
	 * @throws Exception
	 */
	public static Timer toTimer(Object object) throws Exception{
		return null;
	}
	
	/**
	 * M�todo respons�vel por efetuar a conversao de um objeto em uma String
	 * @param object o objeto que ser� convertido
	 * @return uma string contedo o parametro formatado
	 * @throws Exception
	 */
	public static String parse(Object object) throws Exception{
		return DateConvert.parse(object);
	}
}
