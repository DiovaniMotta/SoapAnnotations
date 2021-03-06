package org.soap.diovani.motta.annotations.entidades;

import java.lang.reflect.Field;

import org.soap.diovani.motta.annotations.SoapProperty.Type;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 09/05/2015.
 * Classe responsável por armazenar as anotações contidas nos atributos de uma classe
 */
public class FieldAnnotations {

	private Field field;
	private String name;
	private Type type;
	private Class<?> annotation;
	
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Class<?> getAnnotation() {
		return annotation;
	}
	public void setAnnotation(Class<?> annotation) {
		this.annotation = annotation;
	}
	@Override
	public String toString() {
		return "FieldAnnotations [field=" + field + ", name=" + name
				+ ", type=" + type + ", annotation=" + annotation + "]";
	}
}
