package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Instituicao;


public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

}
