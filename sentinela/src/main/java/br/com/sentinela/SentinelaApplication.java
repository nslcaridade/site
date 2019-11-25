package br.com.sentinela;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.sentinela.defines.Constantes;
import br.com.sentinela.model.DadosUsuario;
import br.com.sentinela.model.Mensagem;
import br.com.sentinela.model.PastoralCaridade;
import br.com.sentinela.repository.DadosUsuarioRepository;
import br.com.sentinela.repository.MensagemEnviadaRepository;
import br.com.sentinela.repository.MensagemRepository;
import br.com.sentinela.repository.PastoralCaridadeRepository;
import br.com.sentinela.util.RUTIL;

@SpringBootApplication
public class SentinelaApplication {

	@Autowired
	DadosUsuarioRepository dadosRepository;
	
	@Autowired
	MensagemEnviadaRepository mensagemEnviadaRepository;
	
	@Autowired
	MensagemRepository mensagemRepository;
	
	/*
	 * @Autowired PastoralCaridadeRepository pastoralCaridadeRepository;
	 */

	public static void main(String[] args) {
		SpringApplication.run(SentinelaApplication.class, args);
	}
	
	private void toLigado(DadosUsuario dadosUsuario) {
		
		try {
			if ( dadosUsuario.getSemanaEscala() != null && RUTIL.semana(dadosUsuario.getSemanaEscala()) == RUTIL.semanaAtual()) {
				Optional<Mensagem> opMensgem = mensagemRepository.findById(new Long(Constantes.ESCALA));
			RUTIL.filtraEnvio(dadosUsuario, opMensgem.get(), this.mensagemEnviadaRepository);
			}
			if ( dadosUsuario.getDataNacimento() != null && RUTIL.mes(dadosUsuario.getDataNacimento()) == Calendar.getInstance().get(Calendar.MONTH) &&
					RUTIL.diaMes(dadosUsuario.getDataNacimento()) == Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
				
				Optional<Mensagem> opMensgem = mensagemRepository.findById(new Long(Constantes.ANIVERSARIO));
				RUTIL.filtraEnvio(dadosUsuario, opMensgem.get(), this.mensagemEnviadaRepository);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			System.out.println("DEBUG - Sentinela inicio");
			
			while (true) {
				List<DadosUsuario> findAll = dadosRepository.findAll();
				for (DadosUsuario dadosUsuario : findAll) {
					toLigado(dadosUsuario);
				}
				/*List<PastoralCaridade> listPastoral = pastoralCaridadeRepository.findByBirthday(RUTIL.hoje());
				for (PastoralCaridade pastoralCaridade : listPastoral) {
					Optional<Mensagem> opMensagem = mensagemRepository.findByIdMensagemAndTipo(Constantes.MSGANIVERSARIO, Constantes.TYPEEMAIL);
					if ( opMensagem != null && opMensagem.isPresent() )
						RUTIL.filtraEnvioEmail(pastoralCaridade, opMensagem.get(), mensagemEnviadaRepository);
				}*/
			}
		};
	}
}
