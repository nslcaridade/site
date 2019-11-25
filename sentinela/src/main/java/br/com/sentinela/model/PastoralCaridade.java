package br.com.sentinela.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pastoral_caridade", schema = "db_nsl")
public class PastoralCaridade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idUsuario;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "complemento")
	private String complemento;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "uf")
	private String uf;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "celular")
	private String celular;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "tipo_sangue")
	private String tipoSangue;
	
	@Column(name = "missa_acolhida")
	private String missaAcolhida;
	
	@Column(name = "horario_acolhida")
	private String horarioAcolhida;
	
	@Column(name = "gt")
	private String gt;
	
	@Column(name = "order_gt")
	private int orderGt;
	
	@Column(name = "semana")
	private Long semana;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTipoSangue() {
		return tipoSangue;
	}

	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public String getMissaAcolhida() {
		return missaAcolhida;
	}

	public void setMissaAcolhida(String missaAcolhida) {
		this.missaAcolhida = missaAcolhida;
	}

	public String getHorarioAcolhida() {
		return horarioAcolhida;
	}

	public void setHorarioAcolhida(String horarioAcolhida) {
		this.horarioAcolhida = horarioAcolhida;
	}

	public String getGt() {
		return gt;
	}

	public void setGt(String gt) {
		this.gt = gt;
	}

	public int getOrderGt() {
		return orderGt;
	}

	public void setOrderGt(int orderGt) {
		this.orderGt = orderGt;
	}

	public Long getSemana() {
		return semana;
	}

	public void setSemana(Long semana) {
		this.semana = semana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((gt == null) ? 0 : gt.hashCode());
		result = prime * result + ((horarioAcolhida == null) ? 0 : horarioAcolhida.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((missaAcolhida == null) ? 0 : missaAcolhida.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + orderGt;
		result = prime * result + ((semana == null) ? 0 : semana.hashCode());
		result = prime * result + ((tipoSangue == null) ? 0 : tipoSangue.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		PastoralCaridade other = (PastoralCaridade) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (gt == null) {
			if (other.gt != null)
				return false;
		} else if (!gt.equals(other.gt))
			return false;
		if (horarioAcolhida == null) {
			if (other.horarioAcolhida != null)
				return false;
		} else if (!horarioAcolhida.equals(other.horarioAcolhida))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (missaAcolhida == null) {
			if (other.missaAcolhida != null)
				return false;
		} else if (!missaAcolhida.equals(other.missaAcolhida))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (orderGt != other.orderGt)
			return false;
		if (semana == null) {
			if (other.semana != null)
				return false;
		} else if (!semana.equals(other.semana))
			return false;
		if (tipoSangue == null) {
			if (other.tipoSangue != null)
				return false;
		} else if (!tipoSangue.equals(other.tipoSangue))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PastoralCaridade [idUsuario=" + idUsuario + ", nome=" + nome + ", endereco=" + endereco
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep="
				+ cep + ", celular=" + celular + ", email=" + email + ", dataNascimento=" + dataNascimento
				+ ", tipoSangue=" + tipoSangue + ", missaAcolhida=" + missaAcolhida + ", horarioAcolhida="
				+ horarioAcolhida + ", gt=" + gt + ", orderGt=" + orderGt + ", semana=" + semana + "]";
	}

}
