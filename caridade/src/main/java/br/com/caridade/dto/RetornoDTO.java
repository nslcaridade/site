package br.com.caridade.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.caridade.model.DadosUsuario;
import br.com.caridade.model.Mensagem;
import br.com.caridade.model.Videos;

public class RetornoDTO {
	
	@JsonInclude(Include.NON_NULL)
	private int idUsuario;
	
	private int codigo;
	
	private List<Mensagem> mensagem = new ArrayList<Mensagem>();
	
	@JsonInclude(Include.NON_DEFAULT)
	private int etapa;
	
	@JsonInclude(Include.NON_DEFAULT)
	private String status;
	
	@JsonInclude(Include.NON_NULL)
	private DadosUsuario dadosUsuario;
	
	@JsonInclude(Include.NON_NULL)
	private String descricaoRotina;
	
	@JsonInclude(Include.NON_NULL)
	private String processo;
	
	@JsonInclude(Include.NON_NULL)
	private List<Object[]> relatorioDoacao;
	
	@JsonInclude(Include.NON_NULL)
	private List<Videos> ltVideos;
	
	public RetornoDTO() {
		this.codigo = 0;
		Mensagem msg = new Mensagem();
		msg.setTexto("OK");
		this.mensagem.add(msg);
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public RetornoDTO setIdUsuario1(int idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public RetornoDTO setCodigo1(int codigo) {
		this.codigo = codigo;
		return this;
	}
	
	public List<Mensagem> getMensagem() {
		return mensagem;
	}

	public void setMensagem(List<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}

	public int getEtapa() {
		return etapa;
	}

	public void setEtapa(int etapa) {
		this.etapa = etapa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricaoRotina() {
		return descricaoRotina;
	}

	public void setDescricaoRotina(String descricaoRotina) {
		this.descricaoRotina = descricaoRotina;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public DadosUsuario getDadosUsuario() {
		return dadosUsuario;
	}

	public void setDadosUsuario(DadosUsuario dadosUsuario) {
		this.dadosUsuario = dadosUsuario;
	}

	public List<Object[]> getRelatorioDoacao() {
		return relatorioDoacao;
	}

	public void setRelatorioDoacao(List<Object[]> relatorioDoacao) {
		this.relatorioDoacao = relatorioDoacao;
		
	}

	public List<Videos> getLtVideos() {
		return ltVideos;
	}

	public void setLtVideos(List<Videos> ltVideos) {
		this.ltVideos = ltVideos;
	}

}
