package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Bazar;

public interface BazarRepository extends JpaRepository<Bazar, Long> {
}
