package br.com.caridade.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.model.Mensagem;
import br.com.caridade.repository.MensagemRepository;

@Controller
@CrossOrigin
@RequestMapping("/documento")
public class DocumentoController {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	@GetMapping("/diretriz")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView();
		Optional<Mensagem> mensagem = mensagemRepository.findByTipo("diretriz");
		if ( mensagem != null && mensagem.isPresent() )
			mv.addObject("diretriz", mensagem.get());
		mv.setViewName("documento/diretriz");
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
}
