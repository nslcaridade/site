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
	
	@Query(value = "select h.cod_doacao, item, SUM(quantidade) as quantidade, SUM(peso_gramas)*SUM(quantidade) as peso_granas" + 
			"	from  historico_doacao as h, doacao as d " + 
			"	where h.cod_doacao = d.cod_doacao and h.cod_instituicao = :codInstituicao and data_doacao BETWEEN :startDate AND :endDate group by d.cod_doacao", nativeQuery = true)
	List<Object[]> findByBetweenDataDoacao(@Param("codInstituicao")int codInstituicao,@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);
	
	@Query(value = "select DATE_FORMAT(data_doacao, '%Y') as ano, MONTH(data_doacao) as mes ," + 
			"   db_nsl.historico_doacao.cod_instituicao" + 
			"   , nome ," +
			" SUM((db_nsl.historico_doacao.quantidade * db_nsl.doacao.peso_gramas)/1000) " +
			"from db_nsl.historico_doacao " + 
			"inner join db_nsl.instituicao " + 
			"on db_nsl.instituicao.cod_instituicao = db_nsl.historico_doacao.cod_instituicao " +
			"inner join db_nsl.doacao " + 
			"on db_nsl.doacao.cod_doacao = db_nsl.historico_doacao.cod_doacao " + 
			"where DATE_FORMAT(data_doacao, '%Y') = :ano and db_nsl.doacao.id_tipo_doacao = 1 group by db_nsl.historico_doacao.cod_instituicao, MONTHNAME(data_doacao) order by db_nsl.historico_doacao.cod_instituicao", nativeQuery = true)
	List<Object[]> findByRelatoiroAnoAlimentos(@Param("ano")int ano);
	
	@Query(value = "select DATE_FORMAT(data_doacao, '%Y') as ano, ELT(MONTH(data_doacao), 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez') as mes ," + 
			"	db_nsl.historico_doacao.cod_instituicao" + 
			"	, nome ," + 
			"	SUM((db_nsl.historico_doacao.quantidade * db_nsl.doacao.peso_gramas)/1000) AS peso," + 
			"	SUM(db_nsl.historico_doacao.quantidade) as quantidade," + 
			"	db_nsl.tipo_doacao.descricao as tipo " + 
			" from db_nsl.historico_doacao " + 
			"	inner join db_nsl.instituicao " + 
			"		on db_nsl.instituicao.cod_instituicao = db_nsl.historico_doacao.cod_instituicao " + 
			"	inner join db_nsl.doacao " + 
			"		on db_nsl.doacao.cod_doacao = db_nsl.historico_doacao.cod_doacao" + 
			"	inner join db_nsl.tipo_doacao" + 
			"		on db_nsl.doacao.id_tipo_doacao = db_nsl.tipo_doacao.id_tipo_doacao " + 
			" where DATE_FORMAT(data_doacao, '%Y') = :ano group by db_nsl.historico_doacao.cod_instituicao, MONTHNAME(data_doacao), db_nsl.doacao.id_tipo_doacao order by db_nsl.historico_doacao.cod_instituicao, MONTH(data_doacao)", nativeQuery = true)
	List<Object[]> findByRelatorioAnoQtdItens(@Param("ano")int ano);

}
