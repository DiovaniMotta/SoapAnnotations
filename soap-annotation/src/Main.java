import java.math.BigDecimal;
import java.util.Date;
import org.ksoap2.serialization.SoapObject;
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
		Produto produto2 = new Produto(1,"PAO");
		produto2.setFamilia(new Familia(2, "Familia"));
		produto2.setGrupo(new Grupo(3, "Grupo"));
		produto2.setValidade(new Date());
		produto2.getLista().add(new Grupo(2, "Grupo"));
		produto2.getLista().add(new Grupo(4, "Grupo"));
		produto2.getLista().add(new Grupo(5, "Grupo"));
		produto2.getLista().add(new Grupo(6, "Grupo"));
		produto2.getLista().add(new Grupo(7, "Grupo"));
		
		System.out.println(produto2);
		try {
			SoapObject object = Session.parse(produto2);
			System.out.println(object.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
