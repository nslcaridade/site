package br.com.caridade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.RelatorioDoacao;


public interface RelatorioDoacaoRepository extends JpaRepository<RelatorioDoacao, String> {
	List<RelatorioDoacao> findByAnoOrderByTotAno(Long ano);
}
