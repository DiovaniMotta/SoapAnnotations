package org.soap.diovani.motta.utils;

import org.ksoap2.serialization.SoapObject;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 25/06/2015.
 * Classe responsavel por retornar o indice em que come��o uma collections contida em 
 * uma mensagem SOAP 
 *
 */
public class CollectionsSOAP {

	/**
	 * M�todo responsavel por retornar a posicao de inicio de uma lista de objetos em uma mensagem SOAP
	 * @param soapObject o objeto que ser� avaliado
	 * @param property o nome da propriedade do tipo List ou Collections que ser� verificado 
	 * @return -1 caso nao seja encontrada na lista e um valor diferente de -1 se for encontrada
	 */
	public static int indexOf(SoapObject soapObject,String property){
		for(int x=0; x<soapObject.getPropertyCount(); x++){
			if(soapObject.getProperty(x) instanceof SoapObject){
				SoapObject aux = (SoapObject) soapObject.getProperty(property);
				if(aux != null)
					return x;
			}
		}
		return -1;
	}
	
	/**
	 * M�todo respons�vel por verificar qual � o �ltimo elemento de uma lista em uma mensagem SOAP
	 * @param soapObject o objeto que ser� avaliado
	 * @param property o nome da propriedade do tipo List ou Collections que ser� verificado 
	 * @return -1 caso nao seja encontrada na lista e um valor diferente de -1 se for encontrada
	 */
	public static int lastIndexOf(SoapObject soapObject,String property){
		int lastIndex = -1;
		for(int x=0; x< soapObject.getPropertyCount(); x++){
			if(soapObject.getProperty(x) instanceof SoapObject){
				SoapObject aux = (SoapObject) soapObject.getProperty(property);
				if(aux != null)
					lastIndex = x;
			}
		}
		return lastIndex;
	}
}
