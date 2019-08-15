package br.com.caridade.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.caridade.model.Bazar;

public class BazarDTO {
	@JsonInclude(Include.NON_NULL)
	private List<Bazar> ltBazar;

	public List<Bazar> getLtBazar() {
		return ltBazar;
	}

	public void setLtBazar(List<Bazar> ltBazar) {
		this.ltBazar = ltBazar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ltBazar == null) ? 0 : ltBazar.hashCode());
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
		BazarDTO other = (BazarDTO) obj;
		if (ltBazar == null) {
			if (other.ltBazar != null)
				return false;
		} else if (!ltBazar.equals(other.ltBazar))
			return false;
		return true;
	}
}
