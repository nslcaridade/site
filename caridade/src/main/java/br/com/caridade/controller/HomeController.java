package br.com.caridade.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.model.Mensagem;
import br.com.caridade.repository.MensagemRepository;

@Controller
public class HomeController {
	
	@Autowired
	MensagemRepository mensagemRepository;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("usuario", "Duarte");
		Optional<Mensagem> findById = mensagemRepository.findByTipo("menu");
		mv.addObject("mensagem", findById.get());
		return mv;
	}

}
