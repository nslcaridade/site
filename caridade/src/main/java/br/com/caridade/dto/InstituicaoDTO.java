package br.com.caridade.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.caridade.model.Instituicao;

public class InstituicaoDTO {

	@JsonInclude(Include.NON_NULL)
	private List<Instituicao> ltInstituicao;

	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<Instituicao> getListaInstituicao() {
		return this.ltInstituicao;
	}

	public void setListaInstituicao(List<Instituicao> ltInstituicao) {
		this.ltInstituicao = ltInstituicao;
	}

	@Override
	public String toString() {
		return "DoacaoDTO [doacao=" + ltInstituicao + "]";
	}
}
