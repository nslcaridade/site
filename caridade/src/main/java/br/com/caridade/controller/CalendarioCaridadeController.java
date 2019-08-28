package br.com.caridade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caridade.dto.CalendarioDTO;
import br.com.caridade.model.CalendarioCaridade;
import br.com.caridade.model.Mensagem;
import br.com.caridade.repository.CalendarioCaridadeRepository;

@RestController
@CrossOrigin
@RequestMapping("/Calendario")
public class CalendarioCaridadeController {

	@Autowired
	CalendarioCaridadeRepository calendarioCaridadeRepository;
	
	@GetMapping("/Todos")
	public ResponseEntity<CalendarioDTO> getCalendario() {
		CalendarioDTO retorno = new CalendarioDTO();
		List<CalendarioCaridade> ltCalendario = calendarioCaridadeRepository.findAll();
		Mensagem msg = new Mensagem();
		if ( ltCalendario.isEmpty() ) {
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		} else {
			retorno.setLtCalendario(ltCalendario);
		}
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
}
