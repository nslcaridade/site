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
@Table(name = "calendario_caridade", schema = "db_nsl")
public class CalendarioCaridade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_calendario_caridade")
	private Long idCalendarioCaridade;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "data_calendario")
	private LocalDate dataCalendario;
	
	@Column(name = "confirmado")
	private int confirmado;
	
	@ManyToOne
	@JoinColumn(name = "id_bazar")
	private Bazar bazar;
	
	@ManyToOne
	@JoinColumn(name = "id_bingo")
	private Bingo bingo;
	
	@ManyToOne
	@JoinColumn(name = "id_passeio")
	private Passeio passeio;
	
	@ManyToOne
	@JoinColumn(name = "id_festa")
	private Festa festa;
	
	@ManyToOne
	@JoinColumn(name = "id_video")
	private Videos videos;
	
	@ManyToOne
	@JoinColumn(name = "id_retiro")
	private Retiro retiro;

	public Retiro getRetiro() {
		return retiro;
	}

	public void setRetiro(Retiro retiro) {
		this.retiro = retiro;
	}

	public Long getIdCalendarioCaridade() {
		return idCalendarioCaridade;
	}

	public void setIdCalendarioCaridade(Long idCalendarioCaridade) {
		this.idCalendarioCaridade = idCalendarioCaridade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCalendario() {
		return dataCalendario;
	}

	public void setDataCalendario(LocalDate dataCalendario) {
		this.dataCalendario = dataCalendario;
	}

	public int getConfirmado() {
		return confirmado;
	}

	public void setConfirmado(int confirmado) {
		this.confirmado = confirmado;
	}

	public Bazar getBazar() {
		return bazar;
	}

	public void setBazar(Bazar bazar) {
		this.bazar = bazar;
	}

	public Bingo getBingo() {
		return bingo;
	}

	public void setBingo(Bingo bingo) {
		this.bingo = bingo;
	}

	public Passeio getPasseio() {
		return passeio;
	}

	public void setPasseio(Passeio passeio) {
		this.passeio = passeio;
	}

	public Festa getFesta() {
		return festa;
	}

	public void setFesta(Festa festa) {
		this.festa = festa;
	}

	public Videos getVideos() {
		return videos;
	}

	public void setVideos(Videos videos) {
		this.videos = videos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bazar == null) ? 0 : bazar.hashCode());
		result = prime * result + ((bingo == null) ? 0 : bingo.hashCode());
		result = prime * result + confirmado;
		result = prime * result + ((dataCalendario == null) ? 0 : dataCalendario.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((festa == null) ? 0 : festa.hashCode());
		result = prime * result + ((idCalendarioCaridade == null) ? 0 : idCalendarioCaridade.hashCode());
		result = prime * result + ((passeio == null) ? 0 : passeio.hashCode());
		result = prime * result + ((retiro == null) ? 0 : retiro.hashCode());
		result = prime * result + ((videos == null) ? 0 : videos.hashCode());
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
		CalendarioCaridade other = (CalendarioCaridade) obj;
		if (bazar == null) {
			if (other.bazar != null)
				return false;
		} else if (!bazar.equals(other.bazar))
			return false;
		if (bingo == null) {
			if (other.bingo != null)
				return false;
		} else if (!bingo.equals(other.bingo))
			return false;
		if (confirmado != other.confirmado)
			return false;
		if (dataCalendario == null) {
			if (other.dataCalendario != null)
				return false;
		} else if (!dataCalendario.equals(other.dataCalendario))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (festa == null) {
			if (other.festa != null)
				return false;
		} else if (!festa.equals(other.festa))
			return false;
		if (idCalendarioCaridade == null) {
			if (other.idCalendarioCaridade != null)
				return false;
		} else if (!idCalendarioCaridade.equals(other.idCalendarioCaridade))
			return false;
		if (passeio == null) {
			if (other.passeio != null)
				return false;
		} else if (!passeio.equals(other.passeio))
			return false;
		if (retiro == null) {
			if (other.retiro != null)
				return false;
		} else if (!retiro.equals(other.retiro))
			return false;
		if (videos == null) {
			if (other.videos != null)
				return false;
		} else if (!videos.equals(other.videos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CalendarioCaridade [idCalendarioCaridade=" + idCalendarioCaridade + ", descricao=" + descricao
				+ ", dataCalendario=" + dataCalendario + ", confirmado=" + confirmado + ", bazar=" + bazar + ", bingo="
				+ bingo + ", passeio=" + passeio + ", festa=" + festa + ", videos=" + videos + ", retiro=" + retiro
				+ "]";
	}

}
