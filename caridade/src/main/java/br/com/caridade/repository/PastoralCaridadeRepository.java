package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.PastoralCaridade;

public interface PastoralCaridadeRepository extends JpaRepository<PastoralCaridade, Long> {

}
