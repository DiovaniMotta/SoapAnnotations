package org.soap.diovani.motta.marshel;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.soap.diovani.motta.annotations.SoapCollection;
import org.soap.diovani.motta.annotations.SoapProperty;
import org.soap.diovani.motta.annotations.SoapProperty.Type;
import org.soap.diovani.motta.annotations.entidades.ClassAnnotations;
import org.soap.diovani.motta.annotations.entidades.FieldAnnotations;
import org.soap.diovani.motta.manager.SessionCache;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 10/05/2015
 * Classe respons�vel por registrar os atributos nao registrados por padr�o em um envelope
 */
public class MarshelUtil implements Marshal {

	//Objeto mapeado que ser� registrado
	private Object object;
	//Objeto que cont�m as anota��es da classe
	private ClassAnnotations annotations;
	
	public MarshelUtil(Object object) {
		super();
		this.object = object;
		inicialize();
	}

	public MarshelUtil() {
		super();
	}

	/**
	 * M�todo respons�vel por inicializar as anota��es contidas na classes entidades
	 */
	private void inicialize(){
		annotations = SessionCache.annotations(object.getClass());
		if(annotations == null){
			throw new NullPointerException("Erro ao inicializar as anota��es do objeto.");
		}
	}
	
	/**
	 * M�todo respons�vel por adicionar e registrar o envelope que ser� enviado para o servidor
	 * @param object o objeto que ser� adicionado
	 */
	public void addOject(Object object){
		this.object = object;
		inicialize();
	}
	
	@Override
	public Object readInstance(XmlPullParser parser, String arg1, String arg2,PropertyInfo info) 
			throws IOException, XmlPullParserException {
		return null;
	}

	@Override
	public void register(SoapSerializationEnvelope envelope) {
		// chamada o metodo que ira marcar/registrar os atributos no envelope
		mark(envelope,annotations);
	}

	@Override
	public void writeInstance(XmlSerializer xml, Object object) throws IOException {}

	
	/**
	 * M�todo respons�vel por registrar os atributos de um objeto do tipo complexo dentro do envelope que ser� enviado 
	 * @param envelope o objeto que ser� enviado para o servidor
	 * @param classAnnotations as anota��es contidas na classe
	 */
	private void mark(SoapSerializationEnvelope envelope,ClassAnnotations classAnnotations){
		List<FieldAnnotations> lista = classAnnotations.getFields();
		for(FieldAnnotations f : lista){
			if(f.getAnnotation().equals(SoapProperty.class)){
				if(f.getType() == Type.PRIMITIVE){
					//retorno o tipo de dados do atributo
					Class<?> clazz = f.getField().getType();
					// se o tipo de dado atributo for diferente de um java.util.Date
					if((!clazz.equals(Date.class)) && (!clazz.equals(String.class))){
					  String namespace = classAnnotations.getNamespace();
					  String name = f.getName();
					  envelope.addMapping(namespace, name, clazz, this);
				   }
				}
				if(f.getType() == Type.COMPLEX){
				   //retorno o tipo de dados do atributo
				   Class<?> clazz = f.getField().getType();
				   ClassAnnotations kclasse = SessionCache.annotations(clazz);
				   String namespace = kclasse.getNamespace();
				   String name = kclasse.getId();
				   mark(envelope, kclasse);
				   envelope.addMapping(namespace, name, clazz, this);
				}
			}
			if(f.getAnnotation().equals(SoapCollection.class)){
				
			}
		}
	}
}
