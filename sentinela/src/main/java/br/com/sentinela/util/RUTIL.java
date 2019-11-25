package br.com.sentinela.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.sentinela.defines.Constantes;
import br.com.sentinela.model.DadosUsuario;
import br.com.sentinela.model.Mensagem;
import br.com.sentinela.model.MensagemEnviada;
import br.com.sentinela.model.PastoralCaridade;
import br.com.sentinela.repository.MensagemEnviadaRepository;
import br.com.sentinela.rotina.SendEmail;
import br.com.sentinela.rotina.SendPush;

public final class RUTIL {
	
	public static void filtraEnvio(DadosUsuario dadosUsuario, Mensagem mensagem, MensagemEnviadaRepository mensagemEnviadaRepository) throws Exception {
		
		SendPush send = new SendPush();
		MensagemEnviada msgEnviada = new MensagemEnviada();
		
		if ( mensagem != null ) {
			List<MensagemEnviada> findByIdUsuario = mensagemEnviadaRepository.findByIdUsuarioAndIdMensagem(dadosUsuario.getIdUsuario(), mensagem.getIdMensagem());
			if ( findByIdUsuario != null && !findByIdUsuario.isEmpty() ) {
				for (MensagemEnviada mensagemEnviada :findByIdUsuario) {
					if ( ! jaEnviadoNaSemana(mensagemEnviada.getDataMensagemEnviada()) ) {
						send.sendPush(dadosUsuario, mensagem.getTexto());
						mensagemEnviada.setDataMensagemEnviada(new Timestamp(new Date().getTime()));
						mensagemEnviadaRepository.saveAndFlush(mensagemEnviada);
					} 
				}
			} else {
				send.sendPush(dadosUsuario, mensagem.getTexto());
				msgEnviada.setDataMensagemEnviada(new Timestamp(new Date().getTime()));
				msgEnviada.setIdUsuario(dadosUsuario.getIdUsuario());
				msgEnviada.setIdMensagem(mensagem.getIdMensagem());
				mensagemEnviadaRepository.saveAndFlush(msgEnviada);
			}
		}
	}
	
	public static boolean jaEnviadoNaSemana(Timestamp times) {
		
		Timestamp dataLimite = new Timestamp(new Date().getTime());
		
		int dias= Constantes.DIASSEMANA;
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(dataLimite.getTime());
		cal.add(Calendar.DAY_OF_MONTH, (dias*-1));
		dataLimite = new Timestamp(cal.getTime().getTime());
		
		return times.after(dataLimite);
	}
	
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
	
	public static String hoje() {
		String retorno;
		retorno = Calendar.getInstance().get(Calendar.YEAR) +"-"+Calendar.getInstance().get(Calendar.MONTH)+""+Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		return retorno;
	}
	
	
	public static void filtraEnvioEmail(PastoralCaridade pastoralCaridade, Mensagem mensagem, MensagemEnviadaRepository mensagemEnviadaRepository) throws Exception {
		
		SendEmail send = new SendEmail();
		MensagemEnviada msgEnviada = new MensagemEnviada();
		
		if ( mensagem != null ) {
			List<MensagemEnviada> findByIdUsuario = mensagemEnviadaRepository.findByIdUsuarioAndIdMensagem(pastoralCaridade.getIdUsuario(), mensagem.getIdMensagem());
			if ( findByIdUsuario != null && !findByIdUsuario.isEmpty() ) {
				for (MensagemEnviada mensagemEnviada :findByIdUsuario) {
					if ( ! jaEnviadoNaSemana(mensagemEnviada.getDataMensagemEnviada()) ) {
						send.sendEmail(pastoralCaridade, mensagem);
						mensagemEnviada.setDataMensagemEnviada(new Timestamp(new Date().getTime()));
						mensagemEnviadaRepository.saveAndFlush(mensagemEnviada);
					} 
				}
			} else {
				send.sendEmail(pastoralCaridade, mensagem);
				msgEnviada.setDataMensagemEnviada(new Timestamp(new Date().getTime()));
				msgEnviada.setIdUsuario(pastoralCaridade.getIdUsuario());
				msgEnviada.setIdMensagem(mensagem.getIdMensagem());
				mensagemEnviadaRepository.saveAndFlush(msgEnviada);
			}
		}
	}
}
