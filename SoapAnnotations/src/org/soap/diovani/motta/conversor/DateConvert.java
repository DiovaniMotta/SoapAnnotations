package org.soap.diovani.motta.conversor;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 11/05/2015.
 * Classe respons�vel por efetuar a convers�o de um objeto em String 
 */
public class DateConvert {

	//Objeto respons�vel por efetuar  a formata��o de string em datas
	private static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	//Objeto respons�vel por efetuar  a formata��o de string em datas
	private static SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		
	/**
	 * M�todo respons�vel por converter um objeto em um tipo de dado Date
	 * @param date o objeto java.util.Date a ser convertido
	 * @return um objeto do tipo Date
	 * @throws Exception
	 */
	public static Date toDate(Date date) throws Exception {
		String patterns = formater.format(date);
		return formater.parse(patterns);
	}
	
	/**
	 * M�todo respons�vel por converter um objeto em um tipo de dado Date
	 * @param date o objeto java.util.Date a ser convertido
	 * @return um objeto do tipo Date
	 * @throws Exception
	 */
	public static Date toDate(String string) throws Exception {
		return parser.parse(string);
	}
	
	/**
	 * M�todo respons�vel por converter um objeto, que  ser� convertido para Date em uma String.
	 * @param object o objeto String a ser convertido
	 * @return um String contendo o parametro convertido
	 * @throws Exception
	 */
	public static String toString(Object object) throws Exception{
		Date date = (Date) object;
		if(date == null){
			throw new NullPointerException("N�o foi poss�vel converter o par�metro em um objeto java.util.Date");
		}
		return formater.format(date);
	}
	
	/**
	 * M�todo respons�vel por converter um objeto  em uma String com formato de data yyyy-MM-dd
	 * @param object o objeto que ser� convertido
	 * @return o parametro recebebido em formato string
	 * @throws Exception
	 */
	public static String parse(Object object) throws Exception{
		Date date = (Date) object;
		if(date == null){
			throw new NullPointerException("N�o foi poss�vel converter o par�metro em um objeto java.lang.String");
		}
		return parser.format(date);
	}
}
