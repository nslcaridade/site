package br.com.caridade.controller;

import java.util.List;
import java.util.Optional;

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
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
    
    @GetMapping("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/lista");
		List<PastoralCaridade> ltPast = pastoralCaridadeRepository.findAllByOrderByNomeAsc();
		mv.addObject("participante", ltPast);
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
    
    @GetMapping("/listagt")
	public ModelAndView listaGt() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/listagt");
		List<PastoralCaridade> ltPast = pastoralCaridadeRepository.findByGtIsNotNullOrderByOrderGt();
		mv.addObject("participante", ltPast);
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
    
    @GetMapping("/listagtcontato")
	public ModelAndView listaGtContato() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/listagtcontato");
		List<PastoralCaridade> ltPast = pastoralCaridadeRepository.findByGtIsNotNullOrderByOrderGt();
		mv.addObject("participante", ltPast);
		mv.setStatus(HttpStatus.OK);
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
    
    @GetMapping("/atualiza")
	public ModelAndView preparaAtualizacao() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/atualiza");
		List<PastoralCaridade> ltPast = pastoralCaridadeRepository.findAll();
		mv.addObject("participante", ltPast);
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
    
    @PostMapping("/atualiza")
   	public ModelAndView atualizacao(@RequestBody List<PastoralCaridade> ltPast) {
   		ModelAndView mv = new ModelAndView();
   		mv.setViewName("usuario/atualiza");
   		for (PastoralCaridade pastoralCaridade : ltPast) {
   			Optional<PastoralCaridade> findById =  pastoralCaridadeRepository.findById(pastoralCaridade.getIdUsuario());
   			findById.get().setCelular(pastoralCaridade.getCelular());
   			findById.get().setSemana(pastoralCaridade.getSemana());
   			findById.get().setMissaAcolhida(pastoralCaridade.getMissaAcolhida());
   			findById.get().setHorarioAcolhida(pastoralCaridade.getHorarioAcolhida());
			pastoralCaridadeRepository.saveAndFlush(findById.get());
		}
   		mv.setStatus(HttpStatus.OK);
   		return mv;
   	}
}