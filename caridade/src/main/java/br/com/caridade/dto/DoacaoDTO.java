package br.com.caridade.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.caridade.model.Doacao;

public class DoacaoDTO {
	
	
	@JsonInclude(Include.NON_NULL)
	private List<Doacao> doacao;

	public List<Doacao> getDoacao() {
		return doacao;
	}

	public void setDoacao(List<Doacao> doacao) {
		this.doacao = doacao;
	}

	@Override
	public String toString() {
		return "{\"doacao\":" + doacao + "}";
	}
	
}
