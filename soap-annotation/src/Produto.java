import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.soap.diovani.motta.annotations.SoapCollection;
import org.soap.diovani.motta.annotations.SoapObject;
import org.soap.diovani.motta.annotations.SoapProperty;
import org.soap.diovani.motta.annotations.SoapProperty.Type;

@SoapObject(namespace= "http:/www.teste.com.br", id = "produto")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SoapProperty(property="chave",type=Type.PRIMITIVE)
	private int chave;
	@SoapProperty(property="nome",type=Type.PRIMITIVE)
	private String nome;
	@SoapProperty(property="validade",type=Type.PRIMITIVE)	
	private Date validade;
	@SoapProperty(property="grupo",type=Type.COMPLEX)
	private Grupo grupo;
	@SoapProperty(property="familia",type=Type.COMPLEX)
	private Familia familia;
	@SoapCollection(property="lista",classe=Grupo.class)
	private List<Grupo> lista = new ArrayList<Grupo>();
	
	public Produto(int chave, String nome) {
		super();
		this.chave = chave;
		this.nome = nome;
	}
	
	public Produto() {
		super();
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

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public List<Grupo> getLista() {
		return lista;
	}

	public void setLista(List<Grupo> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Produto [chave=" + chave + ", nome=" + nome + ", validade="
				+ validade + ", grupo=" + grupo + ", familia=" + familia + "]";
	}
}
