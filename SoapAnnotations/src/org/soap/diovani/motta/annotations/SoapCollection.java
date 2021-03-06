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
 * Annota��o usada para mapear as propriedades do tipo lista usadas pela classe anotada
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SoapCollection {

	String property();
	
	Class<?> classe();
}
