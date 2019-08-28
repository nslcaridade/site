package br.com.caridade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity	
@Table(name = "mensagem	", schema = "db_nsl")
public class Mensagem {
	
	@Id
	@Column(name = "id_mensagem", unique=true, nullable=false)
	private int idMensagem;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "texto")
	private String texto; 

	@Column(name = "tipo")
	private String tipo;

	public int getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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
		result = prime * result + idMensagem;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		Mensagem other = (Mensagem) obj;
		if (idMensagem != other.idMensagem)
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
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
		return "Mensagem [idMensagem=" + idMensagem + ", texto=" + texto + ", tipo=" + tipo + "]";
	}

	
}
