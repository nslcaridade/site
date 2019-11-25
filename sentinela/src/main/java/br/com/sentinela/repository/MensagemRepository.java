package br.com.sentinela.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sentinela.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	public Optional<Mensagem> findByTipo(String tipo);
	public Optional<Mensagem> findByIdMensagemAndTipo(Long idMensagem, String tipo);

}
