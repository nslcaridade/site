package br.com.caridade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin
@RequestMapping("/documento")
public class DocumentoController {

	@GetMapping("/diretriz")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("documento/diretriz");
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
}
