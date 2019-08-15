package br.com.caridade.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "dados_usuario")
public class DadosUsuario {

	@Id
	@Column(name = "id_usuario", unique=true, nullable=false)
	private int idUsuario;
	
	@Column(name = "email", unique=true, nullable=false)
	private String email;

	@Column(name = "nome", unique=true, nullable=false)
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "data_nacimento")
	private LocalDate dataNacimento; 
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "ativo", unique=true, nullable=false)
	private Boolean ativo; 
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "telefone", unique=true, nullable=false)
	private String telefone;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "plataforma", unique=true, nullable=false)
	private String plataforma;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "device_token", unique=true, nullable=false)
	private String deviceToken;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "semana_escala", unique=true, nullable=false)
	private String semanaEscala;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "data_cadastro", unique=true, nullable=false)
	private Timestamp dataCadastro;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "dia_acolhida")
	private String diaAcolhida;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "uuid")
	private String uuid;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "pushreceiverid")
	private String pushReceiverId;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "admin")
	private int admin;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "pwd")
	private String pwd;
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public LocalDate getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(LocalDate dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getSemanaEscala() {
		return semanaEscala;
	}

	public void setSemanaEscala(String semanaEscala) {
		this.semanaEscala = semanaEscala;
	}

	public Timestamp getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDiaAcolhida() {
		return diaAcolhida;
	}

	public void setDiaAcolhida(String diaAcolhida) {
		this.diaAcolhida = diaAcolhida;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPushReceiverId() {
		return pushReceiverId;
	}

	public void setPushReceiverId(String pushReceiverId) {
		this.pushReceiverId = pushReceiverId;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + admin;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataNacimento == null) ? 0 : dataNacimento.hashCode());
		result = prime * result + ((deviceToken == null) ? 0 : deviceToken.hashCode());
		result = prime * result + ((diaAcolhida == null) ? 0 : diaAcolhida.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idUsuario;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		result = prime * result + ((pushReceiverId == null) ? 0 : pushReceiverId.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((semanaEscala == null) ? 0 : semanaEscala.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		DadosUsuario other = (DadosUsuario) obj;
		if (admin != other.admin)
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataNacimento == null) {
			if (other.dataNacimento != null)
				return false;
		} else if (!dataNacimento.equals(other.dataNacimento))
			return false;
		if (deviceToken == null) {
			if (other.deviceToken != null)
				return false;
		} else if (!deviceToken.equals(other.deviceToken))
			return false;
		if (diaAcolhida == null) {
			if (other.diaAcolhida != null)
				return false;
		} else if (!diaAcolhida.equals(other.diaAcolhida))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUsuario != other.idUsuario)
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
		if (pushReceiverId == null) {
			if (other.pushReceiverId != null)
				return false;
		} else if (!pushReceiverId.equals(other.pushReceiverId))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (semanaEscala == null) {
			if (other.semanaEscala != null)
				return false;
		} else if (!semanaEscala.equals(other.semanaEscala))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DadosUsuario [idUsuario=" + idUsuario + ", email=" + email + ", nome=" + nome + ", dataNacimento="
				+ dataNacimento + ", ativo=" + ativo + ", telefone=" + telefone + ", plataforma=" + plataforma
				+ ", deviceToken=" + deviceToken + ", semanaEscala=" + semanaEscala + ", dataCadastro=" + dataCadastro
				+ ", diaAcolhida=" + diaAcolhida + ", uuid=" + uuid + ", pushReceiverId=" + pushReceiverId + ", admin="
				+ admin + ", pwd=" + pwd + "]";
	}

}

