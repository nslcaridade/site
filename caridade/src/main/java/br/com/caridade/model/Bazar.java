package br.com.caridade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bazar", schema = "db_nsl")
public class Bazar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_bazar")
	private Long idBazar;
	
	@Column(name = "valor")
	private Long valor;
	
	public Long getIdBazar() {
		return idBazar;
	}

	public void setIdBazar(Long idBazar) {
		this.idBazar = idBazar;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBazar == null) ? 0 : idBazar.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Bazar other = (Bazar) obj;
		if (idBazar == null) {
			if (other.idBazar != null)
				return false;
		} else if (!idBazar.equals(other.idBazar))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bazar [idBazar=" + idBazar + ", valor=" + valor + "]";
	}
	
}
