package br.com.caridade.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caridade.model.PastoralCaridade;

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
	
}
