package br.com.sentinela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sentinela.model.MensagemEnviada;

public interface MensagemEnviadaRepository extends JpaRepository<MensagemEnviada, Long>{
	List<MensagemEnviada> findByIdUsuario(Long idUsuario);
	List<MensagemEnviada> findByIdUsuarioAndIdMensagem(Long idUsuario, Long idMensagem);
}
