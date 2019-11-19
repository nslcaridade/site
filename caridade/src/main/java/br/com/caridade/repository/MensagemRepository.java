package br.com.caridade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Mensagem;


public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	public List<Mensagem> findByTipo(String tipo);

}
