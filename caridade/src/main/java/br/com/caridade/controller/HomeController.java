package br.com.caridade.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.model.PastoralCaridade;
import br.com.caridade.repository.MensagemRepository;
import br.com.caridade.repository.PastoralCaridadeRepository;
import br.com.caridade.util.RUTIL;

@Controller
public class HomeController {
	
	@Autowired
	MensagemRepository mensagemRepository;
	
	@Autowired
	PastoralCaridadeRepository pastoralCaridadeRepository;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("usuario", "Duarte");
		File folder;
		try {
			//folder = new File("C:\\Users\\alexandre.duarte\\estudo\\site\\caridade\\src\\main\\resources\\static\\image");
			folder = new File("/home/disdi/disdi.uh-app.com.br/webapps/caridade/WEB-INF/classes/static/image/");
			List<String> result = new ArrayList<>();
			for (File f : folder.listFiles()) {
				if ( f.getName().substring(0,5).equals("camp_"))
					result.add(f.getName());
			}
			mv.addObject("imagens",result);
		} catch ( Exception e ) {
			System.out.println("ERRO: Diretorio inexistente");
		}
		List<PastoralCaridade> lstPC = pastoralCaridadeRepository.findBySemana(new Long(RUTIL.semanaAtual()));
		List<PastoralCaridade> lstQuinta = new ArrayList<PastoralCaridade>();
		List<PastoralCaridade> lstSabado = new ArrayList<PastoralCaridade>();
		List<PastoralCaridade> lstDomingoM = new ArrayList<PastoralCaridade>();
		List<PastoralCaridade> lstDomingoT = new ArrayList<PastoralCaridade>();
		List<PastoralCaridade> lstDomingoN = new ArrayList<PastoralCaridade>();
		if ( lstPC != null && !lstPC.isEmpty() ) {
			for (PastoralCaridade pastoralCaridade : lstPC) {
				if ( pastoralCaridade.getMissaAcolhida().contains("Quinta") ) {
					lstQuinta.add(pastoralCaridade);
				}
				if ( pastoralCaridade.getMissaAcolhida().contains("Sabado") ) {
					lstSabado.add(pastoralCaridade);
				}
				if ( pastoralCaridade.getMissaAcolhida().contains("Domingo") ) {
					if ( pastoralCaridade.getHorarioAcolhida().contains("19:30") ) {
						lstDomingoN.add(pastoralCaridade);
					} 
					if ( pastoralCaridade.getHorarioAcolhida().contains("11:00") ) {
						lstDomingoT.add(pastoralCaridade);
					} 
					if ( pastoralCaridade.getHorarioAcolhida().contains("09:00") ) {
						lstDomingoM.add(pastoralCaridade);
					}
				}
			}
			mv.addObject("participantesQuinta",lstQuinta);
			mv.addObject("participantesSabado",lstSabado);
			mv.addObject("participantesDomingoM",lstDomingoM);
			mv.addObject("participantesDomingoT",lstDomingoT);
			mv.addObject("participantesDomingoN",lstDomingoN);
		}
		
		//Optional<Mensagem> findById = mensagemRepository.findByTipo("menu");
		//mv.addObject("mensagem", findById.get());
		return mv;
	}

}
