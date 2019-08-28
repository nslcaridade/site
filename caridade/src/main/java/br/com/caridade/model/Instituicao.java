package br.com.caridade.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "instituicao", schema = "db_nsl")
public class Instituicao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ativo")
	private Long ativo;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "data_fundacao")
	private LocalDate dataFundacao;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "descricao")
	private String descricao;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "endereco")
	private String endereco;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "nome")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "paroquea")
	private String paroquea;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "telefone")
	private String telefone;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "telefone_paroque")
	private String telefoneParoque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAtivo() {
		return ativo;
	}

	public void setAtivo(Long ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParoquea() {
		return paroquea;
	}

	public void setParoquea(String paroquea) {
		this.paroquea = paroquea;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneParoque() {
		return telefoneParoque;
	}

	public void setTelefoneParoque(String telefoneParoque) {
		this.telefoneParoque = telefoneParoque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((dataFundacao == null) ? 0 : dataFundacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((paroquea == null) ? 0 : paroquea.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((telefoneParoque == null) ? 0 : telefoneParoque.hashCode());
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
		Instituicao other = (Instituicao) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (dataFundacao == null) {
			if (other.dataFundacao != null)
				return false;
		} else if (!dataFundacao.equals(other.dataFundacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (paroquea == null) {
			if (other.paroquea != null)
				return false;
		} else if (!paroquea.equals(other.paroquea))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (telefoneParoque == null) {
			if (other.telefoneParoque != null)
				return false;
		} else if (!telefoneParoque.equals(other.telefoneParoque))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instituicao [id=" + id + ", ativo=" + ativo + ", dataFundacao=" + dataFundacao + ", descricao="
				+ descricao + ", endereco=" + endereco + ", nome=" + nome + ", paroquea=" + paroquea + ", telefone="
				+ telefone + ", telefoneParoque=" + telefoneParoque + "]";
	}

}
