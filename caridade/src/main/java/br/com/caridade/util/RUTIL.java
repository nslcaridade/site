package br.com.caridade.util;

import java.sql.Timestamp;
import java.util.Calendar;

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

}
