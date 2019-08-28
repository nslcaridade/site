package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Festa;

public interface FestaRepository extends JpaRepository<Festa, Long> {

}
