package br.com.caridade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "doacao", schema = "db_nsl")
public class Doacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cod_item")
	private Long codItem;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "item")
	private String item;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "peso_gramas")
	private double pesoGramas;

	public Long getCodItem() {
		return codItem;
	}

	public void setCodItem(Long codItem) {
		this.codItem = codItem;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPesoGramas() {
		return pesoGramas;
	}

	public void setPesoGramas(double pesoGramas) {
		this.pesoGramas = pesoGramas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItem == null) ? 0 : codItem.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pesoGramas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Doacao other = (Doacao) obj;
		if (codItem == null) {
			if (other.codItem != null)
				return false;
		} else if (!codItem.equals(other.codItem))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (Double.doubleToLongBits(pesoGramas) != Double.doubleToLongBits(other.pesoGramas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doacao [codItem=" + codItem + ", item=" + item + ", pesoGramas=" + pesoGramas + "]";
	}

	
}
