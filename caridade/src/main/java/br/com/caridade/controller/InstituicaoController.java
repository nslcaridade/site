package br.com.caridade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caridade.dto.InstituicaoDTO;
import br.com.caridade.model.Instituicao;
import br.com.caridade.repository.InstituicaoRepository;

@RestController
@CrossOrigin
@RequestMapping("/ListInstitution")
public class InstituicaoController {
	
	@Autowired
	private InstituicaoRepository instituicaoRepository;

	@GetMapping("/Todas")
	public ResponseEntity<InstituicaoDTO> getListaInstituicoes() {
		InstituicaoDTO retorno = new InstituicaoDTO();
		List<Instituicao> ltInstituicao = instituicaoRepository.findAll();
		if ( ltInstituicao.isEmpty() ) {
			retorno.setMensagem("Não há Instituições cadastradas");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(retorno);
		} else {
			retorno.setListaInstituicao(ltInstituicao);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
}
