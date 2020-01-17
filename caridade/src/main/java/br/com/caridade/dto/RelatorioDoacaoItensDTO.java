package br.com.caridade.dto;

import java.util.ArrayList;
import java.util.List;

public class RelatorioDoacaoItensDTO {
	
	private int ano;
	private Long codInstituicao;
	private String nome;
	private List<Mes> mes;

	public static class Mes{
		private String descricao;
		private List<ItensDoados> itensDoados;
		
		public Mes() {
			itensDoados = new ArrayList<ItensDoados>();
		}
		
		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public List<ItensDoados> getItensDoados() {
			return itensDoados;
		}

		public void setItensDoados(List<ItensDoados> itensDoados) {
			this.itensDoados = itensDoados;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
			result = prime * result + ((itensDoados == null) ? 0 : itensDoados.hashCode());
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
			Mes other = (Mes) obj;
			if (descricao == null) {
				if (other.descricao != null)
					return false;
			} else if (!descricao.equals(other.descricao))
				return false;
			if (itensDoados == null) {
				if (other.itensDoados != null)
					return false;
			} else if (!itensDoados.equals(other.itensDoados))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Mes [descricao=" + descricao + ", itensDoados=" + itensDoados + "]";
		}

		public static class ItensDoados {

			private Long peso;
			private Long quantidade;
			private String tipo;
			public Long getPeso() {
				return peso;
			}
			public void setPeso(Long peso) {
				this.peso = peso;
			}
			public Long getQuantidade() {
				return quantidade;
			}
			public void setQuantidade(Long quantidade) {
				this.quantidade = quantidade;
			}
			public String getTipo() {
				return tipo;
			}
			public void setTipo(String tipo) {
				this.tipo = tipo;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((peso == null) ? 0 : peso.hashCode());
				result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
				result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
				ItensDoados other = (ItensDoados) obj;
				if (peso == null) {
					if (other.peso != null)
						return false;
				} else if (!peso.equals(other.peso))
					return false;
				if (quantidade == null) {
					if (other.quantidade != null)
						return false;
				} else if (!quantidade.equals(other.quantidade))
					return false;
				if (tipo == null) {
					if (other.tipo != null)
						return false;
				} else if (!tipo.equals(other.tipo))
					return false;
				return true;
			}
			@Override
			public String toString() {
				return "ItensDoados [peso=" + peso + ", quantidade=" + quantidade + ", tipo=" + tipo + "]";
			}
		}
		
	}
	public RelatorioDoacaoItensDTO() {
		ano = 1972;
		codInstituicao = new Long(0);
		nome = "";
		mes = new ArrayList<Mes>();
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Long getCodInstituicao() {
		return codInstituicao;
	}
	public void setCodInstituicao(Long codInstituicao) {
		this.codInstituicao = codInstituicao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Mes> getMes() {
		return mes;
	}
	public void setMes(List<Mes> mes) {
		this.mes = mes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((codInstituicao == null) ? 0 : codInstituicao.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		RelatorioDoacaoItensDTO other = (RelatorioDoacaoItensDTO) obj;
		if (ano != other.ano)
			return false;
		if (codInstituicao == null) {
			if (other.codInstituicao != null)
				return false;
		} else if (!codInstituicao.equals(other.codInstituicao))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RelatorioDoacaoItensDTO [ano=" + ano + ", codInstituicao=" + codInstituicao + ", nome=" + nome
				+ ", mes=" + mes + "]";
	}

}
