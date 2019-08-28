package br.com.caridade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.model.DadosUsuario;
import br.com.caridade.model.PastoralCaridade;
import br.com.caridade.repository.DadosUsuarioRepository;
import br.com.caridade.repository.PastoralCaridadeRepository;

@Controller
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private DadosUsuarioRepository usuarioRepository;
    
    @Autowired
    PastoralCaridadeRepository pastoralCaridadeRepository;

    @GetMapping
    public List < DadosUsuario > listar() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/cadastro")
	public ModelAndView inicia() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/cadastro");
		mv.addObject("usuario", "Duarte");
		mv.addObject("mensagem", "Mensagem do controller");
		return mv;
	}
    
    @PostMapping("/inserir")
	public ModelAndView insere(@RequestBody List<PastoralCaridade> ltPast) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/cadastro");
		mv.setStatus(HttpStatus.OK);
		for (PastoralCaridade pastoralCaridade : ltPast) {
			pastoralCaridadeRepository.saveAndFlush(pastoralCaridade);
		}
		
		return mv;
	}
}