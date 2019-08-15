package br.com.caridade.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historico_doacao", schema = "db_nsl")
public class HistoricoDoacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_historico")
	private Long idHistorico;
	
	@Column(name = "cod_doacao")
	private Long codDoacao;
	
	@Column(name = "cod_instituicao")
	private Long codInstituicao;
	
	@Column(name = "data_doacao")
	private LocalDate dataDoacao;
	
	@Column(name = "quantidade")
	private int quantidade;

	public Long getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(Long idHistorico) {
		this.idHistorico = idHistorico;
	}

	public Long getCodDoacao() {
		return codDoacao;
	}

	public void setCodDoacao(Long codDoacao) {
		this.codDoacao = codDoacao;
	}

	public Long getCodInstituicao() {
		return codInstituicao;
	}

	public void setCodInstituicao(Long codInstituicao) {
		this.codInstituicao = codInstituicao;
	}

	public LocalDate getDataDoacao() {
		return dataDoacao;
	}

	public void setDataDoacao(LocalDate dataDoacao) {
		this.dataDoacao = dataDoacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codDoacao == null) ? 0 : codDoacao.hashCode());
		result = prime * result + ((codInstituicao == null) ? 0 : codInstituicao.hashCode());
		result = prime * result + ((dataDoacao == null) ? 0 : dataDoacao.hashCode());
		result = prime * result + ((idHistorico == null) ? 0 : idHistorico.hashCode());
		result = prime * result + quantidade;
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
		HistoricoDoacao other = (HistoricoDoacao) obj;
		if (codDoacao == null) {
			if (other.codDoacao != null)
				return false;
		} else if (!codDoacao.equals(other.codDoacao))
			return false;
		if (codInstituicao == null) {
			if (other.codInstituicao != null)
				return false;
		} else if (!codInstituicao.equals(other.codInstituicao))
			return false;
		if (dataDoacao == null) {
			if (other.dataDoacao != null)
				return false;
		} else if (!dataDoacao.equals(other.dataDoacao))
			return false;
		if (idHistorico == null) {
			if (other.idHistorico != null)
				return false;
		} else if (!idHistorico.equals(other.idHistorico))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HistoricoDoacao [idHistorico=" + idHistorico + ", codDoacao=" + codDoacao + ", codInstituicao="
				+ codInstituicao + ", dataDoacao=" + dataDoacao + ", quantidade=" + quantidade + "]";
	}

}
