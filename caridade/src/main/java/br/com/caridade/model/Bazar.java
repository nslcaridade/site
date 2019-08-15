package br.com.caridade.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bazar")
public class Bazar {
	@Id
	@Column(name = "id_bazar", unique=true, nullable=false)
	private Long idBazar;
	
	@Column(name = "valor")
	private Long valor;
	
	@Column(name = "data_bazar")
	private LocalDate dataBazar;

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

	public LocalDate getDataBazar() {
		return dataBazar;
	}

	public void setDataBazar(LocalDate dataBazar) {
		this.dataBazar = dataBazar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataBazar == null) ? 0 : dataBazar.hashCode());
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
		if (dataBazar == null) {
			if (other.dataBazar != null)
				return false;
		} else if (!dataBazar.equals(other.dataBazar))
			return false;
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
		return "Bazar [idBazar=" + idBazar + ", valor=" + valor + ", dataBazar=" + dataBazar + "]";
	}
	
}
