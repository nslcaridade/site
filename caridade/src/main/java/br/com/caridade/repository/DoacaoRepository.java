package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Doacao;

public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

}
