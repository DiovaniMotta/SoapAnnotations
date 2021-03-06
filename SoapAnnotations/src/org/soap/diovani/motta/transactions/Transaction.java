package org.soap.diovani.motta.transactions;

/**
 * 
 * @author Diovani Bernardi da Motta
 * Data: 17/05/2015.
 * Interface que deve ser implementada para tratar de transacoes que contenham objetos complexos ou primitivos
 * 
 */
public interface Transaction {

	public <T> T call(Class<?> response,String service) throws Exception;
	
	public <T> T call(Object object,Class<?> response,String service) throws Exception; 
	
	public <T> T call(Object[] params,Class<?> response,String service) throws Exception;
		
	public void url(String URL);
	
	public void namespace(String namespace);
}
