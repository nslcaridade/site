package br.com.caridade.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.caridade.model.HistoricoDoacao;


public interface HistoricoDoacaoRepository  extends JpaRepository<HistoricoDoacao, Long> {
	Optional<HistoricoDoacao> findByCodInstituicaoAndCodDoacaoAndDataDoacao(Long cod_instituicao, Long cod_doacao, LocalDate data_doacao);
	//@Query(value = "from HistoricoDoacoes where data_doacao BETWEEN :startDate AND :endDate AND cod_instituicao = :codInstituicao")
	//List<HistoricoDoacoes> findByBetweenDataDoacao(@Param("codInstituicao")int codInstituicao,@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);
	
	@Query(value = "select cod_item, item, SUM(quantidade) as quantidade, SUM(peso_gramas)*SUM(quantidade) as peso_granas" + 
			"	from  historico_doacao as h, doacao as d " + 
			"	where h.cod_doacao = d.cod_item and h.cod_instituicao = :codInstituicao and data_doacao BETWEEN :startDate AND :endDate group by d.cod_item", nativeQuery = true)
	List<Object[]> findByBetweenDataDoacao(@Param("codInstituicao")int codInstituicao,@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);

}
