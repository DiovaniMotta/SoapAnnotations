package org.soap.diovani.motta.serializable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.soap.diovani.motta.annotations.entidades.ClassAnnotations;
import org.soap.diovani.motta.annotations.entidades.FieldAnnotations;
import org.soap.diovani.motta.conversor.Conversor;
import org.soap.diovani.motta.manager.SessionCache;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data:10/05/2015.
 * Classe responsável por serializar um objeto que será enviado para o servidor
 * @see KvmSerializable,ClassAnnotations,FieldAnnotations
 */
public class SoapSerializable implements KvmSerializable{

	//armazena o objeto que será serializado
	private Object object;
	// armazena as anotacoes de classe usadas
	private ClassAnnotations classAnnotation;
	//armazena as anotações contidas nos atributos da classe
	private List<FieldAnnotations> atributos;
	
	public SoapSerializable() {
		super();
	}

	public SoapSerializable(Object object) {
		super();
		this.object = object;
		inicialize();
	}

	/**
	 * Método responsável por informar a classe qual tipo de Objeto será serializado
	 * @param object
	 */
	public void serializable(Object object){
		this.object = object;
		inicialize();
	}
	
	/**
	 * Método responsável por inicializar os objetos do tipo ClassAnnotations e uma lista de objetos FieldAnnotations
	 */
	private void inicialize(){
		classAnnotation = SessionCache.annotations(object.getClass());
		atributos = classAnnotation.getFields();
	}
	
	@Override
	public String getInnerText() {
		return null;
	}

	@Override
	public Object getProperty(int position) {
		Object object = null;
		try
		{
			object = atributos.get(position).getField().get(object);
			if(object instanceof Date){
				Object aux = Conversor.parse(object);
				object = aux;
			}
			if(object instanceof BigDecimal){
				Object aux = Conversor.toString(object);
				object = aux;
			}
		}
		catch(Exception exception){}
		return object;
	}

	@Override
	public int getPropertyCount() {
		return atributos.size();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int position, Hashtable hashtable, PropertyInfo info) {
		FieldAnnotations annotations = atributos.get(position);
		info.name = annotations.getName();
		Class<?> kclasse = annotations.getField().getType();
		if(kclasse.equals(Date.class)){
			info.type =  String.class;
		}
		if(kclasse.equals(BigDecimal.class)){
			info.type =  String.class;
		}
		info.type = kclasse;		
	}

	@Override
	public void setInnerText(String text) {
	}

	@Override
	public void setProperty(int position, Object object) {
	}

}
