import org.soap.diovani.motta.transactions.Transaction;
import org.soap.diovani.motta.transactions.TransactionComplex;
import org.soap.diovani.motta.transactions.TransactionPrimitive;


public class Main {

	public static void main(String[] args) {
		try
		{
			Transaction transaction = new TransactionComplex();
			transaction.url("http://localhost:8080/WebService/services/Consulta?wsdl");
			transaction.namespace("http://servico.com");
			Produto produto = transaction.call(Produto.class,"consulta");
			System.out.println(produto.toString());
			Transaction transaction2 = new TransactionPrimitive();
			transaction2.url("http://localhost:8080/WebService/services/Consulta?wsdl");
			transaction2.namespace("http://servico.com");
			String retorno = transaction2.call(produto, String.class, "toString");
			System.out.println(retorno);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

}
