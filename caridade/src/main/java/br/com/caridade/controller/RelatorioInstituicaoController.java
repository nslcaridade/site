package br.com.caridade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.model.Instituicao;
import br.com.caridade.repository.InstituicaoRepository;

@Controller
@RequestMapping("/instituicao")
public class RelatorioInstituicaoController {
	@Autowired
	InstituicaoRepository instituicaoRepository;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("instituicao/listar");
		List<Instituicao> findAll = instituicaoRepository.findAll();
		mv.addObject("instituicao", findAll);
		return mv;
	}
	
}
