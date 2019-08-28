package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Passeio;

public interface PasseioRepository extends JpaRepository<Passeio, Long> {

}
