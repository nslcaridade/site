package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Missao;

public interface MissaoRepository extends JpaRepository<Missao,Long> {

}
