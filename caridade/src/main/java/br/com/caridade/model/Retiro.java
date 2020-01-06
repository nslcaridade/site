package br.com.caridade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retiro", schema = "db_nsl")
public class Retiro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_retiro")
	private Long idRetiro;
	
	@Column(name = "descricao")
	private String descricao;

	public Long getIdRetiro() {
		return idRetiro;
	}

	public void setIdRetiro(Long idRetiro) {
		this.idRetiro = idRetiro;
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
		result = prime * result + ((idRetiro == null) ? 0 : idRetiro.hashCode());
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
		Retiro other = (Retiro) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idRetiro == null) {
			if (other.idRetiro != null)
				return false;
		} else if (!idRetiro.equals(other.idRetiro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Retiro [idRetiro=" + idRetiro + ", descricao=" + descricao + "]";
	}
	
}
