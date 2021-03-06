package br.com.caridade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "doacao", schema = "db_nsl")
public class Doacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cod_doacao")
	private Long codDoacao;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "item")
	private String item;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "peso_gramas")
	private double pesoGramas;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_doacao")
	private TipoDoacao tipoDoacao;

	public Long getCodDoacao() {
		return codDoacao;
	}

	public void setCodDoacao(Long codDoacao) {
		this.codDoacao = codDoacao;
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

	public TipoDoacao getTipoDoacao() {
		return tipoDoacao;
	}

	public void setTipoDoacao(TipoDoacao tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codDoacao == null) ? 0 : codDoacao.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pesoGramas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipoDoacao == null) ? 0 : tipoDoacao.hashCode());
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
		if (codDoacao == null) {
			if (other.codDoacao != null)
				return false;
		} else if (!codDoacao.equals(other.codDoacao))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (Double.doubleToLongBits(pesoGramas) != Double.doubleToLongBits(other.pesoGramas))
			return false;
		if (tipoDoacao == null) {
			if (other.tipoDoacao != null)
				return false;
		} else if (!tipoDoacao.equals(other.tipoDoacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doacao [codDoacao=" + codDoacao + ", item=" + item + ", pesoGramas=" + pesoGramas + ", tipoDoacao="
				+ tipoDoacao + "]";
	}

}
