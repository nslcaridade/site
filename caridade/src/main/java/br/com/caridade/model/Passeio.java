package br.com.caridade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passeio", schema = "db_nsl")
public class Passeio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_passeio")
	private Long idPasseio;
	
	@Column(name = "descricao")
	private String descricao;
	
	public Long getIdPasseio() {
		return idPasseio;
	}

	public void setIdPasseio(Long idPasseio) {
		this.idPasseio = idPasseio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idPasseio == null) ? 0 : idPasseio.hashCode());
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
		Passeio other = (Passeio) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idPasseio == null) {
			if (other.idPasseio != null)
				return false;
		} else if (!idPasseio.equals(other.idPasseio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passeio [idPasseio=" + idPasseio + ", descricao=" + descricao + "]";
	}

}
