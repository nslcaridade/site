package br.com.sentinela.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mensagem_enviada")
public class MensagemEnviada {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_mensagem_enviada")
	private Long idMensagemEnviada;

	@Column(name = "id_mensagem")
	private Long idMensagem;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "data_mensagem_enviada")
	private Timestamp dataMensagemEnviada;

	public Long getIdMensagemEnviada() {
		return idMensagemEnviada;
	}

	public void setIdMensagemEnviada(Long idMensagemEnviada) {
		this.idMensagemEnviada = idMensagemEnviada;
	}

	public Long getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Timestamp getDataMensagemEnviada() {
		return dataMensagemEnviada;
	}

	public void setDataMensagemEnviada(Timestamp dataMensagemEnviada) {
		this.dataMensagemEnviada = dataMensagemEnviada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataMensagemEnviada == null) ? 0 : dataMensagemEnviada.hashCode());
		result = prime * result + ((idMensagem == null) ? 0 : idMensagem.hashCode());
		result = prime * result + ((idMensagemEnviada == null) ? 0 : idMensagemEnviada.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		MensagemEnviada other = (MensagemEnviada) obj;
		if (dataMensagemEnviada == null) {
			if (other.dataMensagemEnviada != null)
				return false;
		} else if (!dataMensagemEnviada.equals(other.dataMensagemEnviada))
			return false;
		if (idMensagem == null) {
			if (other.idMensagem != null)
				return false;
		} else if (!idMensagem.equals(other.idMensagem))
			return false;
		if (idMensagemEnviada == null) {
			if (other.idMensagemEnviada != null)
				return false;
		} else if (!idMensagemEnviada.equals(other.idMensagemEnviada))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MensagemEnviada [idMensagemEnviada=" + idMensagemEnviada + ", idMensagem=" + idMensagem + ", idUsuario="
				+ idUsuario + ", dataMensagemEnviada=" + dataMensagemEnviada + "]";
	}
}
