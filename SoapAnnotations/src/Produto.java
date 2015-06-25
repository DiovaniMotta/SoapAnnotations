
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.soap.diovani.motta.annotations.SoapCollection;
import org.soap.diovani.motta.annotations.SoapEntity;
import org.soap.diovani.motta.annotations.SoapProperty;
import org.soap.diovani.motta.annotations.SoapProperty.Type;

@SoapEntity(namespace="http://servico.com",id="produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	@SoapProperty(property="codigo",type=Type.PRIMITIVE)
	private int codigo;
	@SoapProperty(property="nome",type=Type.PRIMITIVE)
	private String nome;
	@SoapProperty(property="familia",type=Type.COMPLEX)
	private Familia familia;
	@SoapProperty(property="preco",type=Type.PRIMITIVE)
	private BigDecimal preco;
	@SoapProperty(property="cadastro",type=Type.PRIMITIVE)
	private Date cadastro;
	@SoapProperty(property="ativo",type=Type.PRIMITIVE)
	private boolean ativo;
	@SoapProperty(property="nl",type=Type.PRIMITIVE)
	private double valor;
	@SoapCollection(property="fornecedores",classe=Fornecedor.class)
	private List<Fornecedor> lista = new ArrayList<Fornecedor>();
	
	public Produto() {
		super();
	}

	public Produto(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Fornecedor> getLista() {
		return lista;
	}

	public void setLista(List<Fornecedor> lista) {
		this.lista = lista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", familia="
				+ familia + ", preco=" + preco + ", cadastro=" + cadastro
				+ ", ativo=" + ativo + ", valor=" + valor + ", lista=" + lista
				+ "]";
	}
}
