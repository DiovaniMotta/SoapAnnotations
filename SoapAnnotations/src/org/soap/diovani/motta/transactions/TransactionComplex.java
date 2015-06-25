package org.soap.diovani.motta.transactions;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.soap.diovani.motta.annotations.entidades.ClassAnnotations;
import org.soap.diovani.motta.manager.Session;
import org.soap.diovani.motta.manager.SessionCache;
import org.soap.diovani.motta.marshel.MarshelUtil;
import org.soap.diovani.motta.serializable.SoapSerializable;
import org.soap.diovani.motta.utils.Klasse;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 15/05/2015
 * Classe responsável por efetuar as transacoes Soap com o servidor
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
	 * Método responsavel por retornar uma resposta do web service ao realizar a chamada de um serviço
	 * @param response o tipo de retorno
	 * @param service o nome do servico
	 * @return um objeto contendo o retorno
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T call(Class<?> response,String service) throws Exception{
		T target = null;
		target = Klasse.instancialize(response);
		ClassAnnotations classAnnotations = SessionCache.annotations(response);
		if(classAnnotations == null){
			throw new IllegalArgumentException("A classe do objeto repassado por parâmetro não está mapeada.");
		}
		if((URL == null) ||(URL.isEmpty())){
			throw new NullPointerException("Defina a url de conexão com o web service.");
		}
		if((service == null) ||(service.isEmpty())){
			throw new NullPointerException("Defina o serviço requisitado ao servidor.");
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
	 * Método responsavel por retornar uma resposta do web service ao realizar a chamada de um serviço
	 * @param response o tipo de retorno
	 * @param object o objeto a ser enviado
	 * @param service o nome do servico
	 * @return um objeto contendo o retorno
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T call(Object object,Class<?> response,String service) throws Exception{
		T target = null;
		ClassAnnotations classAnnotations = SessionCache.annotations(object.getClass());
		if(classAnnotations == null){
			throw new IllegalArgumentException("A classe do objeto repassado por parâmetro não está mapeada.");
		}
		ClassAnnotations retornoClass = SessionCache.annotations(response);
		if(retornoClass == null){
			throw new IllegalArgumentException("Somente é permitido retornar objeto mapeados");
		}
		target = Klasse.instancialize(response);
		if((URL == null) ||(URL.isEmpty())){
			throw new NullPointerException("Defina a url de conexão com o web service.");
		}
		if((service == null) ||(service.isEmpty())){
			throw new NullPointerException("Defina o serviço requisitado ao servidor.");
		}
		String namespace = classAnnotations.getNamespace();
		String name = classAnnotations.getId();
		SoapObject soapObject = new SoapObject(namespace,service);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		SoapSerializable soapSerializable = new SoapSerializable(object);
		PropertyInfo propertyInfo = new PropertyInfo();
		propertyInfo.setName(name);
		propertyInfo.setNamespace(namespace);
		propertyInfo.setType(object.getClass());
		propertyInfo.setValue(soapSerializable);
		soapObject.addProperty(propertyInfo);
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
	public void url(String URL) {
		this.URL = URL;
	}

	@Override
	public void namespace(String namespace) {
		this.NAMESPACE = namespace;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T call(Object[] params, Class<?> response, String service) throws Exception {
		T target = null;
		if((NAMESPACE == null) ||(NAMESPACE.isEmpty())){
			throw new NullPointerException("Defina o NAMESPACE do web service.");
		}
		if((URL == null) ||(URL.isEmpty())){
			throw new NullPointerException("Defina a url de conexão com o web service.");
		}
		if((service == null) ||(service.isEmpty())){
			throw new NullPointerException("Defina o serviço requisitado ao servidor.");
		}
		if(params == null){
			throw new NullPointerException("Uma lista de objetos mapeados deve ser informado.");
		}
		if(params.length == 0){
			throw new NullPointerException("Uma lista de objetos mapeados deve ser informado.");
		}
		SoapObject soapObject = new SoapObject(NAMESPACE,service);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		for(int x=0; x<params.length;x++){
			Object object = params[x];
			ClassAnnotations classAnnotations = SessionCache.annotations(object.getClass());
			if(classAnnotations == null){
				throw new IllegalArgumentException("A classe do objeto repassado por parâmetro não está mapeada.");
			}
			ClassAnnotations retornoClass = SessionCache.annotations(response);
			if(retornoClass == null){
				throw new IllegalArgumentException("Somente é permitido retornar objeto mapeados");
			}
			String name = classAnnotations.getId();
			String namespace = classAnnotations.getNamespace();
			target = Klasse.instancialize(response);
			SoapSerializable soapSerializable = new SoapSerializable(object);
			PropertyInfo propertyInfo = new PropertyInfo();
			propertyInfo.setName(name);
			propertyInfo.setNamespace(namespace);
			propertyInfo.setType(object.getClass());
			propertyInfo.setValue(soapSerializable);
			soapObject.addProperty(propertyInfo);
			envelope.setOutputSoapObject(soapObject);    
			soapObject.addProperty(propertyInfo);
		}
		MarshelUtil marshelUtil = new MarshelUtil();
		envelope.implicitTypes= true;
		envelope.setOutputSoapObject(soapObject);    
		for(int x=0; x<params.length ;x++){
			marshelUtil.addOject(params[x]);
			marshelUtil.register(envelope);
		}
		envelope.setOutputSoapObject(soapObject);    
		envelope.implicitTypes= true;
		HttpTransportSE http = new HttpTransportSE(URL);
		http.call("urn:"+service,envelope);
		SoapObject retorno = (SoapObject) envelope.getResponse();
		target = (T) Session.valueOf(response,retorno);
		return target;
	}
}
