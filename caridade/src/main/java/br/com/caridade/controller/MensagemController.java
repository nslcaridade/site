package br.com.caridade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caridade.dto.RetornoDTO;
import br.com.caridade.model.Mensagem;
import br.com.caridade.repository.MensagemRepository;

@RestController
@CrossOrigin
@RequestMapping("/Mensagem")
public class MensagemController {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	@GetMapping
	public ResponseEntity<RetornoDTO> getMensagem(){
		RetornoDTO retorno = new RetornoDTO();
		List<Mensagem> ltMensagem = mensagemRepository.findAll();
		if ( !ltMensagem.isEmpty() ) {
			retorno.setMensagem(ltMensagem);
		}
		
		System.out.println("DEBUG - mensagem:" + retorno.getMensagem());
		
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
}
