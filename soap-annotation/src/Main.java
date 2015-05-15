import java.math.BigDecimal;
import java.util.Date;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.SoapObject;
import org.soap.diovani.motta.conversor.DateConvert;
import org.soap.diovani.motta.manager.Session;


public class Main {

	public static void main(String[] args) {

		SoapObject soapObject = new SoapObject("http:/www.teste.com.br","produto");
		soapObject.addProperty("chave", 1);
		soapObject.addProperty("nome", "Teste");
		soapObject.addProperty("validade", new Date());
		SoapObject grupo = new SoapObject("http:/www.teste.com.br","grupo");
		grupo.addProperty("chave", 1);
		grupo.addProperty("nome","Grupo");
		grupo.addProperty("comissao",BigDecimal.TEN);
		soapObject.addSoapObject(grupo);
		SoapObject familia = new SoapObject("http:/www.teste.com.br","familia");
		familia.addProperty("chave", 2);
		familia.addProperty("nome","Grupo");
		soapObject.addSoapObject(familia);
		Produto produto = Session.parse(Produto.class, soapObject);
		System.out.println(produto.toString());
		
	}

}