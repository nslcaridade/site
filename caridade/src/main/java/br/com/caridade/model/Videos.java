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
@Table(name = "videos", schema = "db_nsl")
public class Videos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_video")
	private Long idVideo;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "titulo")
	private String titulo; 
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "url")
	private String url;

	public Long getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(Long idVideo) {
		this.idVideo = idVideo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVideo == null) ? 0 : idVideo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Videos other = (Videos) obj;
		if (idVideo == null) {
			if (other.idVideo != null)
				return false;
		} else if (!idVideo.equals(other.idVideo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Videos [idVideo=" + idVideo + ", titulo=" + titulo + ", url=" + url + "]";
	} 

}
