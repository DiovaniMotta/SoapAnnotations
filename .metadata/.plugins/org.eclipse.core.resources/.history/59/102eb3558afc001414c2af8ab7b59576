import java.io.Serializable;
import java.math.BigDecimal;

import org.soap.diovani.motta.annotations.SoapObject;
import org.soap.diovani.motta.annotations.SoapProperty;
import org.soap.diovani.motta.annotations.SoapProperty.Type;

@SoapObject(namespace="http:/www.teste.com.br",id="grupo")
public class Grupo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SoapProperty(property="chave",type=Type.PRIMITIVE)
	private int chave;
	@SoapProperty(property="nome",type=Type.PRIMITIVE)
	private String nome;
	@SoapProperty(property="comissao",type=Type.PRIMITIVE)
	private BigDecimal comissao = BigDecimal.ZERO;
	
	public Grupo() {
		super();
	}
	
	public Grupo(int chave, String nome) {
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
	
	public Grupo(int chave, String nome, BigDecimal comissao) {
		super();
		this.chave = chave;
		this.nome = nome;
		this.comissao = comissao;
	}

	@Override
	public String toString() {
		return "Grupo [chave=" + chave + ", nome=" + nome + ", comissao="
				+ comissao + "]";
	}

}
