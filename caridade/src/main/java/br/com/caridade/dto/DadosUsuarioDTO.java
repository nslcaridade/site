package br.com.caridade.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DadosUsuarioDTO {
	
	@JsonInclude(Include.NON_NULL)
	private int id_usuario;
	
	@JsonInclude(Include.NON_NULL)
	private Boolean ativo;
	
	@JsonInclude(Include.NON_NULL)
	private int cod_escala;
	
	@JsonInclude(Include.NON_NULL)
	private LocalDate data_nacimento;
	
	@JsonInclude(Include.NON_NULL)
	private String device_token;
	
	@JsonInclude(Include.NON_NULL)
	private String email;
	
	@JsonInclude(Include.NON_NULL)
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private String plataforma;
	
	@JsonInclude(Include.NON_NULL)
	private String semana_escala;
	
	@JsonInclude(Include.NON_NULL)
	private String telefone;

	public int getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public int getCodEscala() {
		return cod_escala;
	}

	public void setCodEscala(int cod_escala) {
		this.cod_escala = cod_escala;
	}

	public LocalDate getDataNacimento() {
		return data_nacimento;
	}

	public void setDataNacimento(LocalDate data_nacimento) {
		this.data_nacimento = data_nacimento;
	}

	public String getDeviceToken() {
		return device_token;
	}

	public void setDeviceToken(String device_token) {
		this.device_token = device_token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getSemanaEscala() {
		return semana_escala;
	}

	public void setSemanaEscala(String semana_escala) {
		this.semana_escala = semana_escala;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + cod_escala;
		result = prime * result + ((data_nacimento == null) ? 0 : data_nacimento.hashCode());
		result = prime * result + ((device_token == null) ? 0 : device_token.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id_usuario;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		result = prime * result + ((semana_escala == null) ? 0 : semana_escala.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		DadosUsuarioDTO other = (DadosUsuarioDTO) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (cod_escala != other.cod_escala)
			return false;
		if (data_nacimento == null) {
			if (other.data_nacimento != null)
				return false;
		} else if (!data_nacimento.equals(other.data_nacimento))
			return false;
		if (device_token == null) {
			if (other.device_token != null)
				return false;
		} else if (!device_token.equals(other.device_token))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_usuario != other.id_usuario)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		if (semana_escala == null) {
			if (other.semana_escala != null)
				return false;
		} else if (!semana_escala.equals(other.semana_escala))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DadosUsuarioDTO [id_usuario=" + id_usuario + ", ativo=" + ativo + ", cod_escala=" + cod_escala
				+ ", data_nacimento=" + data_nacimento + ", device_token=" + device_token + ", email=" + email
				+ ", nome=" + nome + ", plataforma=" + plataforma + ", semana_escala=" + semana_escala + ", telefone="
				+ telefone + "]";
	}

	
}
