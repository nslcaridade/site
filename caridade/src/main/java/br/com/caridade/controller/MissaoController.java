package br.com.caridade.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.model.Missao;
import br.com.caridade.repository.MissaoRepository;

@RestController
@CrossOrigin
@RequestMapping("/missao")
public class MissaoController {
	@Autowired
	private MissaoRepository missaoRepository; 
	
	@GetMapping("/carapicuiba")
	public ModelAndView lista() {
		Optional<Missao> opMissao = missaoRepository.findById(new Long(1));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("missao/carapicuiba");
		if ( opMissao.isPresent() )
			mv.addObject("carapicuiba", opMissao.get());
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
	
	@GetMapping("/itapevi")
	public ModelAndView listaItapevi() {
		Optional<Missao> opMissao = missaoRepository.findById(new Long(2));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("missao/itapevi");
		if ( opMissao.isPresent() )
			mv.addObject("itapevi", opMissao.get());
		mv.setStatus(HttpStatus.OK);
		return mv;
	}

}
