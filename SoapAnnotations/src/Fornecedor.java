
import java.io.Serializable;

import org.soap.diovani.motta.annotations.SoapEntity;
import org.soap.diovani.motta.annotations.SoapProperty;
import org.soap.diovani.motta.annotations.SoapProperty.Type;

@SoapEntity(namespace="http://servico.com",id="fornecedor")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;
	@SoapProperty(property="codigo",type=Type.PRIMITIVE)
	private int codigo;
	@SoapProperty(property="nome",type=Type.PRIMITIVE)
	private String nome;
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(int codigo, String nome) {
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
		Fornecedor other = (Fornecedor) obj;
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
		return "Fornecedor [codigo=" + codigo + ", nome=" + nome + "]";
	}
}
