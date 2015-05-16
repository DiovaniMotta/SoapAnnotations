package org.soap.diovani.motta.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 09/05/2015
 * Annotação que deve ser usada em uma classe entidade/modelo que será mapeada para ser enviada ao servidor Soap 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SoapObject {
	
	String namespace();
	
	String id();
}
