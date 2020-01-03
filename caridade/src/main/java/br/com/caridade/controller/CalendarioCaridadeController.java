package br.com.caridade.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.dto.CalendarioDTO;
import br.com.caridade.model.CalendarioCaridade;
import br.com.caridade.model.Mensagem;
import br.com.caridade.repository.CalendarioCaridadeRepository;

@RestController
@CrossOrigin
@RequestMapping("/calendario")
public class CalendarioCaridadeController {

	@Autowired
	CalendarioCaridadeRepository calendarioCaridadeRepository;
	
	@GetMapping("/listar/{ano}")
	public ModelAndView listar(@PathVariable Long ano,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calendario/listar");
		List<CalendarioCaridade> findCal = calendarioCaridadeRepository.findByCalendaByAno(ano);
		mv.addObject("calendario", findCal);
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
	
	@GetMapping("/Lista")
	public ResponseEntity<CalendarioDTO> getCalendario(){
		CalendarioDTO retorno = new CalendarioDTO();
		List<CalendarioCaridade> ltCal = calendarioCaridadeRepository.findAll();
		Mensagem msg = new Mensagem();
		if ( ltCal != null && ! ltCal.isEmpty()) {
			retorno.setLtCalendario(ltCal);
		}
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
	
	@GetMapping("/videos")
	public ModelAndView getVideos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calendario/videos");
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
}
