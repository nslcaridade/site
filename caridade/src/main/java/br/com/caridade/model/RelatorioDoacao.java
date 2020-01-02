package br.com.caridade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "consolida_doacoes", schema = "db_nsl")
public class RelatorioDoacao {
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Ano")
	private Long ano;
	
	@Id
	@Column(name = "Instituicao")
	private String instituicao;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Jan")
	private Long jan;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Fev")
	private Long fev;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Mar")
	private Long mar;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Abr")
	private Long abr;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Mai")
	private Long mai;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Jun")
	private Long jun;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Jul")
	private Long jul;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Ago")
	private Long ago;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Set")
	private Long set;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Out")
	private Long out;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Nov")
	private Long nov;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "Dec")
	private Long dec;
	
	public Long getAno() {
		return ano;
	}
	public void setAno(Long ano) {
		this.ano = ano;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public Long getJan() {
		return jan;
	}
	public void setJan(Long jan) {
		this.jan = jan;
	}
	public Long getFev() {
		return fev;
	}
	public void setFev(Long fev) {
		this.fev = fev;
	}
	public Long getMar() {
		return mar;
	}
	public void setMar(Long mar) {
		this.mar = mar;
	}
	public Long getAbr() {
		return abr;
	}
	public void setAbr(Long abr) {
		this.abr = abr;
	}
	public Long getMai() {
		return mai;
	}
	public void setMai(Long mai) {
		this.mai = mai;
	}
	public Long getJun() {
		return jun;
	}
	public void setJun(Long jun) {
		this.jun = jun;
	}
	public Long getJul() {
		return jul;
	}
	public void setJul(Long jul) {
		this.jul = jul;
	}
	public Long getAgo() {
		return ago;
	}
	public void setAgo(Long ago) {
		this.ago = ago;
	}
	public Long getSet() {
		return set;
	}
	public void setSet(Long set) {
		this.set = set;
	}
	public Long getOut() {
		return out;
	}
	public void setOut(Long out) {
		this.out = out;
	}
	public Long getNov() {
		return nov;
	}
	public void setNov(Long nov) {
		this.nov = nov;
	}
	public Long getDec() {
		return dec;
	}
	public void setDec(Long dec) {
		this.dec = dec;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abr == null) ? 0 : abr.hashCode());
		result = prime * result + ((ago == null) ? 0 : ago.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((dec == null) ? 0 : dec.hashCode());
		result = prime * result + ((instituicao == null) ? 0 : instituicao.hashCode());
		result = prime * result + ((fev == null) ? 0 : fev.hashCode());
		result = prime * result + ((jan == null) ? 0 : jan.hashCode());
		result = prime * result + ((jul == null) ? 0 : jul.hashCode());
		result = prime * result + ((jun == null) ? 0 : jun.hashCode());
		result = prime * result + ((mai == null) ? 0 : mai.hashCode());
		result = prime * result + ((mar == null) ? 0 : mar.hashCode());
		result = prime * result + ((nov == null) ? 0 : nov.hashCode());
		result = prime * result + ((out == null) ? 0 : out.hashCode());
		result = prime * result + ((set == null) ? 0 : set.hashCode());
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
		RelatorioDoacao other = (RelatorioDoacao) obj;
		if (abr == null) {
			if (other.abr != null)
				return false;
		} else if (!abr.equals(other.abr))
			return false;
		if (ago == null) {
			if (other.ago != null)
				return false;
		} else if (!ago.equals(other.ago))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (dec == null) {
			if (other.dec != null)
				return false;
		} else if (!dec.equals(other.dec))
			return false;
		if (instituicao == null) {
			if (other.instituicao != null)
				return false;
		} else if (!instituicao.equals(other.instituicao))
			return false;
		if (fev == null) {
			if (other.fev != null)
				return false;
		} else if (!fev.equals(other.fev))
			return false;
		if (jan == null) {
			if (other.jan != null)
				return false;
		} else if (!jan.equals(other.jan))
			return false;
		if (jul == null) {
			if (other.jul != null)
				return false;
		} else if (!jul.equals(other.jul))
			return false;
		if (jun == null) {
			if (other.jun != null)
				return false;
		} else if (!jun.equals(other.jun))
			return false;
		if (mai == null) {
			if (other.mai != null)
				return false;
		} else if (!mai.equals(other.mai))
			return false;
		if (mar == null) {
			if (other.mar != null)
				return false;
		} else if (!mar.equals(other.mar))
			return false;
		if (nov == null) {
			if (other.nov != null)
				return false;
		} else if (!nov.equals(other.nov))
			return false;
		if (out == null) {
			if (other.out != null)
				return false;
		} else if (!out.equals(other.out))
			return false;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "{\"ano\":" + ano + ", \"instituicao\":\"" + instituicao + "\", \"jan\":" + jan + ", \"fev\":"
				+ fev + ", \"mar\":" + mar + ", \"abr\":" + abr + ", \"mai\":" + mai + ", \"jun\":" + jun + ", \"jul\":" + jul + ", \"ago\":"
				+ ago + ", \"set\":" + set + ", \"out\":" + out + ", \"nov\":" + nov + ", \"dec\":" + dec + "}";
	}
	
	
	
}
