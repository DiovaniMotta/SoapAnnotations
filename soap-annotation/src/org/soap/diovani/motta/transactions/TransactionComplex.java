package org.soap.diovani.motta.transactions;

import java.io.IOException;

import javax.xml.bind.PropertyException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.soap.diovani.motta.annotations.entidades.ClassAnnotations;
import org.soap.diovani.motta.manager.Session;
import org.soap.diovani.motta.manager.SessionCache;
import org.soap.diovani.motta.marshel.MarshelUtil;
import org.soap.diovani.motta.utils.Klasse;
import org.xmlpull.v1.XmlPullParserException;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 15/05/2015
 * Classe respons�vel por efetuar as transacoes Soap com o servidor
 */
public class TransactionComplex  implements Transaction {
	
	// url de conexao com o web service
	public String URL;
	public String NAMESPACE;
	
	public TransactionComplex() {
	}

	public TransactionComplex(String URL, String NAMESPACE) {
		this.URL = URL;
		this.NAMESPACE = NAMESPACE;
	}
	public TransactionComplex(String URL) {
		this.URL = URL;
	}

	/**
	 * M�todo responsavel por retornar uma resposta do web service ao realizar a chamada de um servi�o
	 * @param response o tipo de retorno
	 * @param service o nome do servico
	 * @return um objeto contendo o retorno
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws XmlPullParserException 
	 * @throws IOException 
	 * @throws HttpResponseException 
	 * @throws PropertyException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T call(Class<?> response,String service) throws Exception{
		T target = null;
		target = Klasse.instancialize(response);
		ClassAnnotations classAnnotations = SessionCache.annotations(response);
		if(classAnnotations == null){
			throw new IllegalArgumentException("A classe do objeto repassado por par�metro n�o est� mapeada.");
		}
		if((URL == null) ||(URL.isEmpty())){
			throw new NullPointerException("Defina a url de conex�o com o web service.");
		}
		if((service == null) ||(service.isEmpty())){
			throw new NullPointerException("Defina o servi�o requisitado ao servidor.");
		}
		SoapObject soapObject = new SoapObject(NAMESPACE,service);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(soapObject);    
		envelope.implicitTypes= true;
		HttpTransportSE http = new HttpTransportSE(URL);
		http.call("urn:"+service,envelope);
		SoapObject retorno = (SoapObject) envelope.getResponse();
		target = (T) Session.valueOf(response,retorno);
		return target;
	}
	
	/**
	 * M�todo responsavel por retornar uma resposta do web service ao realizar a chamada de um servi�o
	 * @param response o tipo de retorno
	 * @param object o objeto a ser enviado
	 * @param service o nome do servico
	 * @return um objeto contendo o retorno
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws XmlPullParserException 
	 * @throws IOException 
	 * @throws HttpResponseException 
	 * @throws PropertyException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T call(Object object,Class<?> response,String service) throws Exception{
		T target = null;
		ClassAnnotations classAnnotations = SessionCache.annotations(object.getClass());
		if(classAnnotations == null){
			throw new IllegalArgumentException("A classe do objeto repassado por par�metro n�o est� mapeada.");
		}
		ClassAnnotations retornoClass = SessionCache.annotations(response);
		if(retornoClass == null){
			throw new IllegalArgumentException("Somente � permitido retornar objeto mapeados");
		}
		target = Klasse.instancialize(response);
		if((URL == null) ||(URL.isEmpty())){
			throw new NullPointerException("Defina a url de conex�o com o web service.");
		}
		if((service == null) ||(service.isEmpty())){
			throw new NullPointerException("Defina o servi�o requisitado ao servidor.");
		}
		String namespace = classAnnotations.getNamespace();
		SoapObject soapObject = new SoapObject(namespace,service);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		PropertyInfo info = new PropertyInfo();
		info.setValue(object);
		Class<?> clazz = object.getClass();
		info.setType(clazz);
		info.setName(retornoClass.getId());
		info.setNamespace(namespace);
		soapObject.addProperty(info);
		envelope.setOutputSoapObject(soapObject);    
		envelope.implicitTypes= true;
		MarshelUtil marshelUtil = new MarshelUtil(object);
		marshelUtil.register(envelope);
		HttpTransportSE http = new HttpTransportSE(URL);
		http.call("urn:"+service,envelope);
		SoapObject retorno = (SoapObject) envelope.getResponse();
		target = (T) Session.valueOf(response,retorno);
		return target;
	}

	@Override
	public void addURL(String URL) {
		this.URL = URL;
	}

	@Override
	public void addNamespace(String namespace) {
		this.NAMESPACE = namespace;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T call(Object[] params, Class<?> response, String service) throws Exception {
		T target = null;
		if(params == null){
			throw new NullPointerException("Uma lista de objetos mapeados deve ser informado.");
		}
		if(params.length == 0){
			throw new NullPointerException("Uma lista de objetos mapeados deve ser informado.");
		}
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		for(int x=0; x<params.length;x++){
			Object object = params[x];
			ClassAnnotations classAnnotations = SessionCache.annotations(object.getClass());
			if(classAnnotations == null){
				throw new IllegalArgumentException("A classe do objeto repassado por par�metro n�o est� mapeada.");
			}
			ClassAnnotations retornoClass = SessionCache.annotations(response);
			if(retornoClass == null){
				throw new IllegalArgumentException("Somente � permitido retornar objeto mapeados");
			}
			target = Klasse.instancialize(response);
			if((URL == null) ||(URL.isEmpty())){
				throw new NullPointerException("Defina a url de conex�o com o web service.");
			}
			if((service == null) ||(service.isEmpty())){
				throw new NullPointerException("Defina o servi�o requisitado ao servidor.");
			}
			String namespace = classAnnotations.getNamespace();
			SoapObject soapObject = new SoapObject(namespace,service);
			PropertyInfo info = new PropertyInfo();
			info.setValue(object);
			Class<?> clazz = object.getClass();
			info.setType(clazz);
			info.setName(retornoClass.getId());
			info.setNamespace(namespace);
			soapObject.addProperty(info);
			envelope.setOutputSoapObject(soapObject);    
			envelope.implicitTypes= true;
			MarshelUtil marshelUtil = new MarshelUtil(object);
			marshelUtil.register(envelope);
		}
		HttpTransportSE http = new HttpTransportSE(URL);
		http.call("urn:"+service,envelope);
		SoapObject retorno = (SoapObject) envelope.getResponse();
		target = (T) Session.valueOf(response,retorno);
		return target;
	}
}
