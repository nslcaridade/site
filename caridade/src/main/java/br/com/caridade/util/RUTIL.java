package br.com.caridade.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caridade.dto.RelatorioDoacaoDTO;
import br.com.caridade.model.PastoralCaridade;
import br.com.caridade.model.RelatorioDoacao;

public final class RUTIL {
	

	public static int semana(String semana) {
		int retorno = 0;
		switch (semana) {
		case "primeira":
			retorno = 1;
			break;
		case "segunda":
			retorno = 2;
			break;
		case "terceira":
			retorno = 3;
			break;
		case "quarta":
			retorno = 4;
			break;
		case "quinta":
			retorno = 5;
			break;
		}
		return retorno;
	}
	
	public static int mes(Timestamp times) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(times);
		return cal.get(Calendar.MONTH);
	}
	
	public static int diaMes(Timestamp times) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(times);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int semanaAtual() {
		return Calendar.getInstance().get(Calendar.WEEK_OF_MONTH); 
	}
	
	public static int semanaDoDia(int dia) {
		
		int hoje =  Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		int proximoDia = dia;
		int diaParaProximo = proximoDia - hoje;
		Calendar calendar = Calendar.getInstance();
		
		if ( diaParaProximo > 0 ) {
			calendar.add(Calendar.DAY_OF_YEAR, diaParaProximo);
		} else if ( diaParaProximo < 0 ) {
			diaParaProximo = 7 - diaParaProximo;
			calendar.add(Calendar.DAY_OF_YEAR, diaParaProximo);
		}
		
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}
	
	public static List<PastoralCaridade> getListaDoDia(String dia, List<PastoralCaridade> lstPC){
		List<PastoralCaridade> retorno = new ArrayList<PastoralCaridade>();
		
		if ( lstPC != null && !lstPC.isEmpty() ) {
			for (PastoralCaridade pastoralCaridade : lstPC) {
				if ( pastoralCaridade.getMissaAcolhida().contains(dia) ) {
					retorno.add(pastoralCaridade);
				}
			}
		}
			
		return retorno;
	}
	
	public static RelatorioDoacaoDTO somatoriaTotal(List<RelatorioDoacao> lstRelatorioDoacao) {
		RelatorioDoacaoDTO retorno = new RelatorioDoacaoDTO();
		Long jan = new Long(0);
		Long fev = new Long(0);
		Long mar = new Long(0);
		Long abr = new Long(0);
		Long mai = new Long(0);
		Long jun = new Long(0);
		Long jul = new Long(0);
		Long ago = new Long(0);
		Long set = new Long(0);
		Long out = new Long(0);
		Long nov = new Long(0);
		Long des = new Long(0);
		Long tot = new Long(0);
		for (RelatorioDoacao relatorioDoacao : lstRelatorioDoacao) {
			jan += relatorioDoacao.getJan();
			fev += relatorioDoacao.getFev();
			mar += relatorioDoacao.getMar();
			abr += relatorioDoacao.getAbr();
			mai += relatorioDoacao.getMai();
			jun += relatorioDoacao.getJun();
			jul += relatorioDoacao.getJul();
			ago += relatorioDoacao.getAgo();
			set += relatorioDoacao.getSet();
			out += relatorioDoacao.getOut();
			nov += relatorioDoacao.getNov();
			des += relatorioDoacao.getDec();
			tot = jan+fev+mar+abr+mai+jun+jul+ago+set+out+nov+des;
		}
		retorno.setInstituicao("TOTAL");
		retorno.setJan(jan);
		retorno.setFev(fev);
		retorno.setMar(mar);
		retorno.setAbr(abr);
		retorno.setMai(mai);
		retorno.setJun(jun);
		retorno.setJul(jul);
		retorno.setAgo(ago);
		retorno.setSet(set);
		retorno.setOut(out);
		retorno.setNov(nov);
		retorno.setDec(des);
		retorno.setTotAno(tot);
		return retorno;
	}
	
}
