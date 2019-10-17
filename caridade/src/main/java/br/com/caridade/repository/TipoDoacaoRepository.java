package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.TipoDoacao;

public interface TipoDoacaoRepository  extends JpaRepository<TipoDoacao, Long> {

}
