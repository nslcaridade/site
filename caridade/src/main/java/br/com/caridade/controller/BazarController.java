package br.com.caridade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caridade.dto.BazarDTO;
import br.com.caridade.model.Bazar;
import br.com.caridade.model.Mensagem;
import br.com.caridade.repository.BazarRepository;


@RestController
@CrossOrigin
@RequestMapping("/Bazar")
public class BazarController {
	@Autowired
	private BazarRepository bazarRepository;

	@GetMapping("/Todos")
	public ResponseEntity<BazarDTO> getBazares() {
		BazarDTO retorno = new BazarDTO();
		List<Bazar> ltBazar = bazarRepository.findAll();
		Mensagem msg = new Mensagem();
		if ( ltBazar.isEmpty() ) {
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		} else {
			retorno.setLtBazar(ltBazar);
		}
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}

}
