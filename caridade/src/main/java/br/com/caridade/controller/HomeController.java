package br.com.caridade.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.definitions.Constantes;
import br.com.caridade.model.Mensagem;
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
			folder = new File(Constantes.PATHIMAGEM);
			List<String> result = new ArrayList<>();
			for (File f : folder.listFiles()) {
				if ( f.getName().substring(0,5).equals("camp_"))
					result.add(f.getName());
			}
			mv.addObject("imagens",result);
		} catch ( Exception e ) {
			System.out.println("ERRO: Diretorio inexistente");
		}
		List<PastoralCaridade> lstQuinta = new ArrayList<PastoralCaridade>();
		List<PastoralCaridade> lstSabado = new ArrayList<PastoralCaridade>();
		List<PastoralCaridade> lstDomingoM = new ArrayList<PastoralCaridade>();
		List<PastoralCaridade> lstDomingoT = new ArrayList<PastoralCaridade>();
		List<PastoralCaridade> lstDomingoN = new ArrayList<PastoralCaridade>();
		
		List<PastoralCaridade> lstPQuinta = pastoralCaridadeRepository.findBySemana(new Long(RUTIL.semanaDoDia(Constantes.QUARTA)));
		lstQuinta = RUTIL.getListaDoDia(Constantes.SQUINTA, lstPQuinta);
		List<PastoralCaridade> lstPSabado = pastoralCaridadeRepository.findBySemana(new Long(RUTIL.semanaDoDia(Constantes.SABADO)));
		lstSabado = RUTIL.getListaDoDia(Constantes.SSABADO, lstPSabado);
		
		List<PastoralCaridade> lstPDomingo = pastoralCaridadeRepository.findBySemana(new Long(RUTIL.semanaDoDia(Constantes.DOMINGO)));
		if ( lstPDomingo != null && !lstPDomingo.isEmpty() ) {
			for (PastoralCaridade pastoralCaridade : lstPDomingo) {
				if ( pastoralCaridade.getMissaAcolhida().contains(Constantes.SDOMINGO) ) {
					if ( pastoralCaridade.getHorarioAcolhida().contains(Constantes.HORANDOMINGO) ) {
						lstDomingoN.add(pastoralCaridade);
					} 
					if ( pastoralCaridade.getHorarioAcolhida().contains(Constantes.HORATDOMINGO) ) {
						lstDomingoT.add(pastoralCaridade);
					} 
					if ( pastoralCaridade.getHorarioAcolhida().contains(Constantes.HORAMDOMINGO) ) {
						lstDomingoM.add(pastoralCaridade);
					}
				}
			}
		}
		mv.addObject("participantesQuinta",lstQuinta);
		mv.addObject("participantesSabado",lstSabado);
		mv.addObject("participantesDomingoM",lstDomingoM);
		mv.addObject("participantesDomingoT",lstDomingoT);
		mv.addObject("participantesDomingoN",lstDomingoN);
		
		List<Mensagem> findById = mensagemRepository.findByTipo("oracao");
		mv.addObject("oracao", findById);
		return mv;
	}

}
