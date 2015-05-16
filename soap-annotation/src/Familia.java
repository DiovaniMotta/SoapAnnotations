import java.io.Serializable;

import org.soap.diovani.motta.annotations.SoapObject;
import org.soap.diovani.motta.annotations.SoapProperty;
import org.soap.diovani.motta.annotations.SoapProperty.Type;

@SoapObject(namespace="http:/www.teste.com.br",id="familia")
public class Familia  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SoapProperty(property="chave",type=Type.PRIMITIVE)
	private int chave;
	@SoapProperty(property="codigo",type=Type.PRIMITIVE)
	private String nome;
	
	public Familia() {
		super();
	}

	public Familia(int chave, String nome) {
		super();
		this.chave = chave;
		this.nome = nome;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Familia [chave=" + chave + ", nome=" + nome + "]";
	}
}
