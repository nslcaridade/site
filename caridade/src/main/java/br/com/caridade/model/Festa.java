package br.com.caridade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "festa", schema = "db_nsl")
public class Festa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_festa")
	private Long idFesta;
	
	@Column(name = "descricao")
	private String descricao;
	
	public Long getIdFesta() {
		return idFesta;
	}

	public void setIdFesta(Long idFesta) {
		this.idFesta = idFesta;
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
		result = prime * result + ((idFesta == null) ? 0 : idFesta.hashCode());
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
		Festa other = (Festa) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idFesta == null) {
			if (other.idFesta != null)
				return false;
		} else if (!idFesta.equals(other.idFesta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Festa [idFesta=" + idFesta + ", descricao=" + descricao + "]";
	}
	
}
