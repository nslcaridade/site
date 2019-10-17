package br.com.caridade.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.dto.DoacaoDTO;
import br.com.caridade.dto.HistoricoDoacoesDTO;
import br.com.caridade.dto.RetornoDTO;
import br.com.caridade.mensagem.RelatorioMensal;
import br.com.caridade.model.Doacao;
import br.com.caridade.model.HistoricoDoacao;
import br.com.caridade.model.Instituicao;
import br.com.caridade.model.Mensagem;
import br.com.caridade.model.RelatorioDoacao;
import br.com.caridade.model.TipoDoacao;
import br.com.caridade.repository.DoacaoRepository;
import br.com.caridade.repository.HistoricoDoacaoRepository;
import br.com.caridade.repository.InstituicaoRepository;
import br.com.caridade.repository.RelatorioDoacaoRepository;
import br.com.caridade.repository.TipoDoacaoRepository;
import br.com.caridade.util.GravaRelatorioAnual;
import br.com.caridade.util.GravaRelatorioMensal;
import br.com.caridade.util.UtilsTools;

@Controller
@CrossOrigin
@RequestMapping("/doacao")
public class DoacaoController {
	
	@Autowired
	HistoricoDoacaoRepository historicoDoacaoRepository;
	
	@Autowired
	DoacaoRepository doacaoRepository;
	
	@Autowired
	InstituicaoRepository instituicaoRepository;
	
	@Autowired
	RelatorioDoacaoRepository relatorioDoacaoRepository;
	
	@Autowired
	TipoDoacaoRepository tipoDoacaoRepository;
	
	@GetMapping("/listar")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doacao/listar");
		List<Doacao> findAll = doacaoRepository.findAll();
		mv.addObject("doacao", findAll);
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
	
	@GetMapping("/preparar")
	public ModelAndView buscaInstituicaoAndDoacao() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("doacao/preparar");
		List<Instituicao> findAll = instituicaoRepository.findAll();
		mv.addObject("instituicoes", findAll);
		List<TipoDoacao> findAll3 = tipoDoacaoRepository.findAll();
		mv.addObject("tipoDoacao", findAll3);
		List<Doacao> findAll2 = doacaoRepository.findAll();
		mv.addObject("itensDoacao", findAll2);
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
	
	@PostMapping("/inserir")
	public ModelAndView insere(@RequestBody List<HistoricoDoacao> ltHist) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doacao/preparar");
		mv.setStatus(HttpStatus.OK);
		for (HistoricoDoacao historicoDoacao : ltHist) {
			historicoDoacaoRepository.saveAndFlush(historicoDoacao);
		}
		
		return mv;
	}
	
	@GetMapping("/anual")
	public ModelAndView preparaAno() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doacao/anual");
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
	
	
	@GetMapping("/anual/{ano}") 
	public ResponseEntity<List<RelatorioDoacao>> buscaDoacaoAnual(@PathVariable Long ano,HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		  
		mv.setViewName("doacao/ano");
		List<RelatorioDoacao> findByAno = relatorioDoacaoRepository.findByAnoOrderByTotAno(ano);
		GravaRelatorioAnual grava = new GravaRelatorioAnual();
		grava.record(findByAno);
		mv.setStatus(HttpStatus.OK);
		mv.addObject("relatorioDoacao", findByAno);
		  
		return ResponseEntity.status(HttpStatus.OK).body(findByAno);
 
	}
	
	@GetMapping("/mensal")
	public ModelAndView buscaInstMes() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("doacao/mensal");
		List<Instituicao> findAll = instituicaoRepository.findAll();
		mv.addObject("instituicoes", findAll);
		mv.addObject("mes", UtilsTools.getListMes());
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
	
	@GetMapping("/mensal/{inst}/{mes}")
	public ResponseEntity<List<RelatorioMensal>> buscaInstMes(@PathVariable int inst, @PathVariable int mes, HttpServletResponse response) {
		List<RelatorioMensal> ltRel = new ArrayList<RelatorioMensal>();
		
		LocalDate initial = LocalDate.now();

		LocalDate startDate = LocalDate.of(initial.getYear(), mes,1);
		LocalDate endDate = LocalDate.of(initial.getYear(), mes, 1).plusMonths(1).minusDays(1);
		
		List<Object[]> lRelatorio = historicoDoacaoRepository.findByBetweenDataDoacao(inst, startDate, endDate);
		for (Object[] objects : lRelatorio) {
			RelatorioMensal rel = new RelatorioMensal();
			rel.setCodDoacao((int) objects[0]);
			rel.setItem((String) objects[1]);
			rel.setQuantidade(Long.valueOf(((BigDecimal) objects[2]).longValue()));
			rel.setPeso(Long.valueOf(((BigDecimal) objects[3]).longValue()));
			ltRel.add(rel);
		}
		
		if ( !ltRel.isEmpty() ) {
			Optional<Instituicao> opInst = instituicaoRepository.findById(new Long(inst));
			GravaRelatorioMensal grava = new GravaRelatorioMensal();
			grava.record(opInst.get(),mes,ltRel);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ltRel);
	}
	
	@GetMapping("/Lista")
	public ResponseEntity<DoacaoDTO> verificaEtapa() {
		DoacaoDTO retorno = new DoacaoDTO();
		List<Doacao> ltDoacao = doacaoRepository.findAll();
		retorno.setDoacao(ltDoacao);
		
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
	
	@PostMapping("/Incluir")
	public ResponseEntity<RetornoDTO> criar(@RequestBody HistoricoDoacao historicoDoacao, HttpServletResponse response){
		
		RetornoDTO retorno = new RetornoDTO();
		Optional<HistoricoDoacao> opHistoricoDoacao = historicoDoacaoRepository.findByCodInstituicaoAndCodDoacaoAndDataDoacao(historicoDoacao.getCodInstituicao(),
																														   	    historicoDoacao.getCodDoacao(),
																																historicoDoacao.getDataDoacao());
		List<Mensagem> ltMsg = new ArrayList<Mensagem>();
		Mensagem msg = new Mensagem();
		
		retorno.setCodigo1(historicoDoacao.getCodDoacao().intValue());
		if ( opHistoricoDoacao.hashCode() == 0 ) {
			historicoDoacaoRepository.save(historicoDoacao);
			retorno.setCodigo1(0);
			msg.setTexto("Doacao Cadastrada");
			ltMsg.add(msg);
			retorno.setMensagem(ltMsg);
		} else {
			retorno.setCodigo1(200);
			msg.setTexto("Doacao ja esta na base");
			ltMsg.add(msg);
			retorno.setMensagem(ltMsg);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
	}
	
	@PostMapping("/Periodo")
	public ResponseEntity<RetornoDTO> listaDoacao(@RequestBody HistoricoDoacoesDTO historicoDoacaoDTO, HttpServletResponse response){
		
		System.out.println("DEBUG - dadosUsuario:"+historicoDoacaoDTO);
		RetornoDTO retorno = new RetornoDTO();
		List<Object[]> lRelatorio = historicoDoacaoRepository.findByBetweenDataDoacao(historicoDoacaoDTO.getCodInstituicao(),
																							  historicoDoacaoDTO.getStartDate(),
																							  historicoDoacaoDTO.getEndDate());
		List<Mensagem> ltMsg = new ArrayList<Mensagem>();
		Mensagem msg = new Mensagem();
		retorno.setRelatorioDoacao(lRelatorio);
		if (!lRelatorio.isEmpty()) {
			retorno.setCodigo1(0);
			retorno.setRelatorioDoacao(lRelatorio);
			msg.setTexto("Segue lista atualizada");
			ltMsg.add(msg);
			retorno.setMensagem(ltMsg);
		} else {
			msg.setTexto("Não há doacoes neste periodo");
			retorno.setCodigo1(200);
			ltMsg.add(msg);
			retorno.setMensagem(ltMsg);
		}
		/*Iterator<HistoricoDoacao> itHistorico = ltHistorico.iterator();
		List<RelatorioDoacaoDTO> lRelatorio = new ArrayList<RelatorioDoacaoDTO>();
		
		while(itHistorico.hasNext()) {
			HistoricoDoacao historico = itHistorico.next();
			Optional<Doacao> pDoacao = doacaoRepository.findById(new Long(historico.getCodDoacao()));
			if (! pDoacao.isPresent()) {
				continue;
			}
			Doacao doacao = pDoacao.get();
			RelatorioDoacaoDTO relatorio = new RelatorioDoacaoDTO();
			relatorio.setQtd(new Long(historico.getQuantidade()));
			relatorio.setItem(doacao.getItem());
			relatorio.setPesoGramas(new Long(doacao.getPesoGramas()));
			lRelatorio.add(relatorio);
			
		}
		
		retorno.setRelatorioDoacaoDTO(lRelatorio);
		
		if (!lRelatorio.isEmpty()) {
			retorno.setCodigo1(0);
			retorno.setMensagem("Segue lista atualizada");
		} else {
			retorno.setCodigo1(200);
			retorno.setMensagem("Não há doacoes neste periodo");
		}
		retorno.setCodigo(historicoDoacaoDTO.getCodInstituicao());*/
		
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
}
