package br.com.caridade.mensagem;

public class RelatorioMensal {
	private int codDoacao;
	private String item;
	private Long quantidade;
	private Long peso;
	public int getCodDoacao() {
		return codDoacao;
	}
	public void setCodDoacao(int codDoacao) {
		this.codDoacao = codDoacao;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public Long getPeso() {
		return peso;
	}
	public void setPeso(Long peso) {
		this.peso = peso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codDoacao;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantidade);
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
		RelatorioMensal other = (RelatorioMensal) obj;
		if (codDoacao != other.codDoacao)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(quantidade) != Double.doubleToLongBits(other.quantidade))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "{\"codDoacao\":" + codDoacao + ", \"item\":\"" + item + "\", \"quantidade\":" + quantidade + ", \"peso\":"
				+ peso + "}";
	}
	
}
