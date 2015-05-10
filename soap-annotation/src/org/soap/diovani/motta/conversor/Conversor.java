package org.soap.diovani.motta.conversor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 09/05/2015
 * Classe respons�vel por efetuar a convers�o dos valores lidos do web service
 */
public class Conversor {

	public static String toString(Object object) throws Exception {
		return object.toString();
	}
	
	public static Integer toInt(Object object) throws Exception {
		return Integer.parseInt(object.toString());
	}
	
	public static BigDecimal toBigDecimal(Object object) throws Exception {
		return BigDecimal.valueOf(Double.valueOf(object.toString()));
	}
	
	public static Date toDate(Object object) throws Exception{
		return null;
	}
	
	public static Boolean toBoolean(Object object) throws Exception{
		return Boolean.parseBoolean(object.toString());
	}
}