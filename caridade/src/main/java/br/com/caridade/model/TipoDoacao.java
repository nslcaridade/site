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
@Table(name = "tipo_doacao", schema = "db_nsl")
public class TipoDoacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_tipo_doacao")
	private Long idTipoDoacao;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "descricao")
	private String descricao;

	public Long getIdTipoDoacao() {
		return idTipoDoacao;
	}

	public void setIdTipoDoacao(Long idTipoDoacao) {
		this.idTipoDoacao = idTipoDoacao;
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
		result = prime * result + ((idTipoDoacao == null) ? 0 : idTipoDoacao.hashCode());
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
		TipoDoacao other = (TipoDoacao) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idTipoDoacao == null) {
			if (other.idTipoDoacao != null)
				return false;
		} else if (!idTipoDoacao.equals(other.idTipoDoacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoDoacao [idTipoDoacao=" + idTipoDoacao + ", descricao=" + descricao + "]";
	}

}
