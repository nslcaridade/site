package br.com.caridade.util;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UtilsTools {
	
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(Calendar.getInstance().getTime().getTime());
	}

	public static List<Mes> getListMes(){
		List<Mes> ltMes = new ArrayList<Mes>();
		Mes mes = new Mes();
		mes.setId(1); mes.setNome("JAN");ltMes.add(mes);
		mes = new Mes();mes.setId(2); mes.setNome("FEV");ltMes.add(mes);
		mes = new Mes();mes.setId(3); mes.setNome("MAR");ltMes.add(mes);
		mes = new Mes();mes.setId(4); mes.setNome("ABR");ltMes.add(mes);
		mes = new Mes();mes.setId(5); mes.setNome("MAI");ltMes.add(mes);
		mes = new Mes();mes.setId(6); mes.setNome("JUN");ltMes.add(mes);
		mes = new Mes();mes.setId(7); mes.setNome("JUL");ltMes.add(mes);
		mes = new Mes();mes.setId(8); mes.setNome("AGO");ltMes.add(mes);
		mes = new Mes();mes.setId(9); mes.setNome("SET");ltMes.add(mes);
		mes = new Mes();mes.setId(10); mes.setNome("OUT");ltMes.add(mes);
		mes = new Mes();mes.setId(11); mes.setNome("NOV");ltMes.add(mes);
		mes = new Mes();mes.setId(12); mes.setNome("DES");ltMes.add(mes);
		return ltMes;
	}
	
	public static String getNomeMes(int mes) {
		String retorno = "atual";
		switch (mes) {
		case 1:
			retorno = "janeiro";
			break;
		case 2:
			retorno = "fevereiro";
			break;
		case 3:
			retorno = "março";
			break;
		case 4:
			retorno = "abril";
			break;
		case 5:
			retorno = "maio";
			break;
		case 6:
			retorno = "junho";
			break;
		case 7:
			retorno = "julho";
			break;
		case 8:
			retorno = "agosto";
			break;
		case 9:
			retorno = "setembro";
			break;
		case 10:
			retorno = "outubro";
			break;
		case 11:
			retorno = "novembro";
			break;
		case 12:
			retorno = "desembro";
			break;

		}
		
		return retorno;
	}
	
	public static String formatNumber(Long vlr) {
		String retorno = "";
		if ( vlr > 0 ) {
			DecimalFormat df = new DecimalFormat();
			df.applyPattern("###,###.###");
			double dbVlr = vlr;
			retorno = String.valueOf(df.format(dbVlr));
		}
		return retorno;
	}
}
