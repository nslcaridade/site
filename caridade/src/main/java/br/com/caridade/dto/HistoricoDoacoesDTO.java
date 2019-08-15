package br.com.caridade.dto;

import java.time.LocalDate;

public class HistoricoDoacoesDTO {

	private int codInstituicao;
	private LocalDate startDate;
	private LocalDate endDate;
	public int getCodInstituicao() {
		return codInstituicao;
	}
	public void setCodInstituicao(int codInstituicao) {
		this.codInstituicao = codInstituicao;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codInstituicao;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		HistoricoDoacoesDTO other = (HistoricoDoacoesDTO) obj;
		if (codInstituicao != other.codInstituicao)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HistoricoDoacoesDTO [codInstituicao=" + codInstituicao + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}

}
