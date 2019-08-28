package br.com.caridade.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.caridade.model.CalendarioCaridade;

public class CalendarioDTO {

	@JsonInclude(Include.NON_NULL)
	private List<CalendarioCaridade> ltCalendario;

	public List<CalendarioCaridade> getLtCalendario() {
		return ltCalendario;
	}

	public void setLtCalendario(List<CalendarioCaridade> ltCalendario) {
		this.ltCalendario = ltCalendario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ltCalendario == null) ? 0 : ltCalendario.hashCode());
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
		CalendarioDTO other = (CalendarioDTO) obj;
		if (ltCalendario == null) {
			if (other.ltCalendario != null)
				return false;
		} else if (!ltCalendario.equals(other.ltCalendario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CalendarioDTO [ltCalendario=" + ltCalendario + "]";
	}
	
}
