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

import br.com.caridade.definitions.Constantes;
import br.com.caridade.dto.DoacaoDTO;
import br.com.caridade.dto.HistoricoDoacoesDTO;
import br.com.caridade.dto.RelatorioDoacaoDTO;
import br.com.caridade.dto.RelatorioDoacaoItensDTO;
import br.com.caridade.dto.RelatorioDoacaoItensDTO.Mes;
import br.com.caridade.dto.RelatorioDoacaoItensDTO.Mes.ItensDoados;
import br.com.caridade.dto.RetornoDTO;
import br.com.caridade.mensagem.RelatorioMensal;
import br.com.caridade.model.Doacao;
import br.com.caridade.model.Emprestimo;
import br.com.caridade.model.HistoricoDoacao;
import br.com.caridade.model.Instituicao;
import br.com.caridade.model.Mensagem;
import br.com.caridade.model.PastoralCaridade;
import br.com.caridade.model.TipoDoacao;
import br.com.caridade.repository.DoacaoRepository;
import br.com.caridade.repository.EmprestimoRepository;
import br.com.caridade.repository.HistoricoDoacaoRepository;
import br.com.caridade.repository.InstituicaoRepository;
import br.com.caridade.repository.PastoralCaridadeRepository;
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
	
	@Autowired
    PastoralCaridadeRepository pastoralCaridadeRepository;
	
	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	@GetMapping("/listar")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doacao/listar");
		List<Doacao> findAll = doacaoRepository.findAll();
		mv.addObject("doacao", findAll);
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
	
	@GetMapping("/listaEmprestimo")
	public ModelAndView listaEmprestimo() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doacao/listaEmprestimo");
		List<Emprestimo> findAll = emprestimoRepository.findAll();
		mv.addObject("emprestimo", findAll);
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
	
	@GetMapping("/emprestimo")
	public ModelAndView buscaInstituicaoAndDoacaoAndParticipante() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("doacao/emprestimo");
		List<PastoralCaridade> ltPast = pastoralCaridadeRepository.findAllByAtivos(Constantes.ATIVO);
		mv.addObject("participante", ltPast);
		
		TipoDoacao tipoDoacao = new TipoDoacao();
		tipoDoacao.setIdTipoDoacao(new Long(Constantes.EMPRESTIMO));
		List<Doacao> findAll2 = doacaoRepository.findByTipoDoacao(tipoDoacao);
		mv.addObject("doacao", findAll2);
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
	
	@PostMapping("/emprestimo/inserir")
	public ModelAndView insereEmprestimo(@RequestBody List<Emprestimo> ltEmp) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doacao/preparar");
		mv.setStatus(HttpStatus.OK);
		for (Emprestimo emprestimo : ltEmp) {
			emprestimoRepository.saveAndFlush(emprestimo);
		}
		
		return mv;
	}
	
	@GetMapping("/itens")
	public ModelAndView buscaTipoDoacao() {
		ModelAndView mv = new ModelAndView();
		
		List<TipoDoacao> findAll3 = tipoDoacaoRepository.findAll();
		mv.addObject("tipoDoacao", findAll3);
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
	
	@PostMapping("/inserir/itens")
	public ModelAndView insereItens(@RequestBody List<Doacao> ltDoacao) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doacao/itens");
		mv.setStatus(HttpStatus.OK);
		for (Doacao doacao : ltDoacao) {
			doacaoRepository.saveAndFlush(doacao);
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
	public ResponseEntity<List<RelatorioDoacaoDTO>> buscaDoacaoAnual(@PathVariable Long ano,HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		RelatorioDoacaoDTO relatorioDoacaoDTO = new RelatorioDoacaoDTO();
		List<RelatorioDoacaoDTO> lstRelatorioDoacaoDTO = new ArrayList<RelatorioDoacaoDTO>();
		mv.setViewName("doacao/ano");
		List<Object[]> lRelatorio = historicoDoacaoRepository.findByRelatoiroAnoAlimentos(ano.intValue());
		relatorioDoacaoDTO = new RelatorioDoacaoDTO();
		Long codInst = new Long(0);
		Long totInst = new Long(0);
		Long totGeralJan = new Long(0);
		Long totGeralFev = new Long(0);
		Long totGeralMar = new Long(0);
		Long totGeralAbr = new Long(0);
		Long totGeralMai = new Long(0);
		Long totGeralJun = new Long(0);
		Long totGeralJul = new Long(0);
		Long totGeralAgo = new Long(0);
		Long totGeralSet = new Long(0);
		Long totGeralOut = new Long(0);
		Long totGeralNov = new Long(0);
		Long totGeralDez = new Long(0);
		Long totGeral = new Long(0);
		for (Object[] objects : lRelatorio) {
			Long lAux = new Long(((int) objects[2]));
			if ( codInst == 0 || !codInst.equals(lAux) ) {
				
				if ( codInst > 0 ) {
					relatorioDoacaoDTO.setTotAno(totInst);
					totGeral += totInst;
					lstRelatorioDoacaoDTO.add(relatorioDoacaoDTO);
					totInst = new Long(0);
				}
				
				relatorioDoacaoDTO = new RelatorioDoacaoDTO();
				relatorioDoacaoDTO.setCodInstituicao(new Long((int) objects[2]));
				relatorioDoacaoDTO.setInstituicao(((String) objects[3]));
			}
			codInst = new Long(((int) objects[2]));
			relatorioDoacaoDTO.setAno(ano);
			totInst +=  Long.valueOf(((BigDecimal) objects[4]).longValue());
			switch((int) objects[1]) {
			case 1:
				totGeralJan += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setJan(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 2:
				totGeralFev += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setFev(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 3:
				totGeralMar += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setMar(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 4:
				totGeralAbr += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setAbr(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 5:
				totGeralMai += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setMai(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 6:
				totGeralJun += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setJun(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 7:
				totGeralJul += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setJul(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 8:
				totGeralAgo += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setAgo(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 9:
				totGeralSet += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setSet(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 10:
				totGeralOut += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setOut(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 11:
				totGeralNov += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setNov(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			case 12:
				totGeralDez += Long.valueOf(((BigDecimal) objects[4]).longValue());
				relatorioDoacaoDTO.setDec(Long.valueOf(((BigDecimal) objects[4]).longValue()));
				break;
			}
			
		}
		if ( totInst > 0 ) {
			relatorioDoacaoDTO.setTotAno(totInst);
			totGeral += totInst;
			lstRelatorioDoacaoDTO.add(relatorioDoacaoDTO);
		}
		
		relatorioDoacaoDTO = new RelatorioDoacaoDTO();
		relatorioDoacaoDTO.setInstituicao("TOTAL");
		relatorioDoacaoDTO.setJan(totGeralJan);
		relatorioDoacaoDTO.setFev(totGeralFev);
		relatorioDoacaoDTO.setMar(totGeralMar);
		relatorioDoacaoDTO.setAbr(totGeralAbr);
		relatorioDoacaoDTO.setMai(totGeralMai);
		relatorioDoacaoDTO.setJun(totGeralJun);
		relatorioDoacaoDTO.setJul(totGeralJul);
		relatorioDoacaoDTO.setAgo(totGeralAgo);
		relatorioDoacaoDTO.setSet(totGeralSet);
		relatorioDoacaoDTO.setOut(totGeralOut);
		relatorioDoacaoDTO.setNov(totGeralNov);
		relatorioDoacaoDTO.setDec(totGeralDez);
		relatorioDoacaoDTO.setTotAno(totGeral);
		lstRelatorioDoacaoDTO.add(relatorioDoacaoDTO);
		
		
		/*
		 * if (! lstRelatorioDoacaoDTO.isEmpty() ) { relatorioDoacaoDTO =
		 * RUTIL.somatoriaTotal(findByAno);
		 * lstRelatorioDoacaoDTO.add(relatorioDoacaoDTO); }
		 * 
		 * 
		 * GravaRelatorioAnual grava = new GravaRelatorioAnual();
		 * grava.record(lstRelatorioDoacaoDTO);
		 */
		
		GravaRelatorioAnual grava = new GravaRelatorioAnual();
		grava.record(lstRelatorioDoacaoDTO);
		 
		mv.setStatus(HttpStatus.OK);
		mv.addObject("relatorioDoacao", lstRelatorioDoacaoDTO);
		  
		return ResponseEntity.status(HttpStatus.OK).body(lstRelatorioDoacaoDTO);
 
	}
	
	@GetMapping("/anualItens")
	public ModelAndView anualItens() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doacao/anualItens");
		mv.setStatus(HttpStatus.OK);
		return mv;
	}
	
	@GetMapping("/anualItens/{ano}")
	public ResponseEntity<List<RelatorioDoacaoItensDTO>> buscaDoacaoAnualItens(@PathVariable Long ano,HttpServletResponse response) {
		List<RelatorioDoacaoItensDTO> lstRelatorioDoacaoDTO = new ArrayList<RelatorioDoacaoItensDTO>();
		RelatorioDoacaoItensDTO relatorioDoacaoItensDTO = new RelatorioDoacaoItensDTO();
		
		Long codInst = new Long(0);
		ItensDoados itensDoados = new ItensDoados();
		Mes mes = new Mes();
		String nomeInstituicao = "";
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doacao/anualItens");
		
		List<Object[]> lRelatorio = historicoDoacaoRepository.findByRelatorioAnoQtdItens(ano.intValue());
		
		for (Object[] objects : lRelatorio) {
			Long lAux = new Long(((int) objects[2]));
			String nomeMes = new String((String) objects[1]);
			if ( codInst == 0 || !codInst.equals(lAux) ) {
				
				if ( codInst > 0 ) {
					relatorioDoacaoItensDTO.setNome(nomeInstituicao);
					relatorioDoacaoItensDTO.getMes().add(mes);
					relatorioDoacaoItensDTO.setCodInstituicao(codInst);
					relatorioDoacaoItensDTO.setAno(ano.intValue());
					lstRelatorioDoacaoDTO.add(relatorioDoacaoItensDTO);
					relatorioDoacaoItensDTO = new RelatorioDoacaoItensDTO();
					mes = new Mes();
				}
			}
			if ( !mes.getDescricao().isEmpty() && ! nomeMes.equals(mes.getDescricao())) {
				relatorioDoacaoItensDTO.getMes().add(mes);
				mes = new Mes();
				itensDoados = new ItensDoados();
			}
			nomeInstituicao = ((String) objects[3]);
			mes.setDescricao(((String) objects[1]));
			codInst = new Long(((int) objects[2]));
			itensDoados.setPeso(Long.valueOf(((BigDecimal) objects[4]).longValue()));
			itensDoados.setQuantidade(Long.valueOf(((BigDecimal) objects[5]).longValue()));
			itensDoados.setTipo(((String) objects[6]));
			mes.getItensDoados().add(itensDoados);
			itensDoados = new ItensDoados();
			
		}
		
		if ( codInst > 0 ) {
			relatorioDoacaoItensDTO.setNome(nomeInstituicao);
			relatorioDoacaoItensDTO.getMes().add(mes);
			relatorioDoacaoItensDTO.setCodInstituicao(codInst);
			relatorioDoacaoItensDTO.setAno(ano.intValue());
			lstRelatorioDoacaoDTO.add(relatorioDoacaoItensDTO);
		}
		
		mv.setStatus(HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(lstRelatorioDoacaoDTO);
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
	
	@GetMapping("/mensal/{inst}/{mes}/{ano}")
	public ResponseEntity<List<RelatorioMensal>> buscaInstMes(@PathVariable int inst, @PathVariable int mes,  @PathVariable int ano, HttpServletResponse response) {
		List<RelatorioMensal> ltRel = new ArrayList<RelatorioMensal>();
		
		LocalDate startDate = LocalDate.of(ano, mes,1);
		LocalDate endDate = LocalDate.of(ano, mes, 1).plusMonths(1).minusDays(1);
		
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
