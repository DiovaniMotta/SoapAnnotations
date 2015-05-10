package org.soap.diovani.motta.annotations.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 09/05/2015.
 * Classe responsável por armazenar as anotações contidas em uma classe
 */
public class ClassAnnotations {

	private Class<?> kclasse;
	private String namespace;
	private String typeId;
	private List<FieldAnnotations> fields = new ArrayList<FieldAnnotations>();
	
	public Class<?> getKclasse() {
		return kclasse;
	}
	public void setKclasse(Class<?> kclasse) {
		this.kclasse = kclasse;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public List<FieldAnnotations> getFields() {
		return fields;
	}
	public void setFields(List<FieldAnnotations> fields) {
		this.fields = fields;
	}
}
