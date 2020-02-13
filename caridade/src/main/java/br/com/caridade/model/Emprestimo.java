package br.com.caridade.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprestimo", schema = "db_nsl")
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_emprestimo")
	private Long idEmprestimo;
	
	@ManyToOne
	@JoinColumn(name = "cod_doacao")
	private Doacao doacao;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private PastoralCaridade pastoralCaridade;
	
	@Column(name = "data_emprestimo")
	private LocalDate dataEmprestimo;
	
	@Column(name = "data_devolucao")
	private LocalDate dataDevolucao;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "entregue")
	private int entregue;

	public Long getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Doacao getDoacao() {
		return doacao;
	}

	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
	}

	public PastoralCaridade getPastoralCaridade() {
		return pastoralCaridade;
	}

	public void setPastoralCaridade(PastoralCaridade pastoralCaridade) {
		this.pastoralCaridade = pastoralCaridade;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEntregue() {
		return entregue;
	}

	public void setEntregue(int entregue) {
		this.entregue = entregue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((doacao == null) ? 0 : doacao.hashCode());
		result = prime * result + entregue;
		result = prime * result + ((idEmprestimo == null) ? 0 : idEmprestimo.hashCode());
		result = prime * result + ((pastoralCaridade == null) ? 0 : pastoralCaridade.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (dataDevolucao == null) {
			if (other.dataDevolucao != null)
				return false;
		} else if (!dataDevolucao.equals(other.dataDevolucao))
			return false;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (doacao == null) {
			if (other.doacao != null)
				return false;
		} else if (!doacao.equals(other.doacao))
			return false;
		if (entregue != other.entregue)
			return false;
		if (idEmprestimo == null) {
			if (other.idEmprestimo != null)
				return false;
		} else if (!idEmprestimo.equals(other.idEmprestimo))
			return false;
		if (pastoralCaridade == null) {
			if (other.pastoralCaridade != null)
				return false;
		} else if (!pastoralCaridade.equals(other.pastoralCaridade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emprestimo [idEmprestimo=" + idEmprestimo + ", doacao=" + doacao + ", pastoralCaridade="
				+ pastoralCaridade + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao
				+ ", descricao=" + descricao + ", entregue=" + entregue + "]";
	}
}
