package org.soap.diovani.motta.annotations.message;

import org.ksoap2.serialization.SoapObject;
/**
 * 
 * @author Diovani Bernardi da Motta
 * data: 16/05/2015
 * Classe responsavel por conter as informa��es que ser�o enviadas para o webservice
 */
public class MessageSoap {

	//armazena a url de conexao com servidor
	public String URL;
	//armazena o objeto que sera enviado para o servidor
	public SoapObject object;
	
	public MessageSoap() {
		super();
	}

	public MessageSoap(String uRL, SoapObject object) {
		super();
		URL = uRL;
		this.object = object;
	}

	public SoapObject getObject() {
		return object;
	}
	
	public void setObject(SoapObject object) {
		this.object = object;
	}
}