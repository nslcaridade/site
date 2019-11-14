package br.com.caridade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.PastoralCaridade;

public interface PastoralCaridadeRepository extends JpaRepository<PastoralCaridade, Long> {
	List<PastoralCaridade> findByGtIsNotNullOrderByOrderGt();
	List<PastoralCaridade> findBySemana(Long semana);

}
