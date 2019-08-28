package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.CalendarioCaridade;

public interface CalendarioCaridadeRepository  extends JpaRepository<CalendarioCaridade, Long> {

}
