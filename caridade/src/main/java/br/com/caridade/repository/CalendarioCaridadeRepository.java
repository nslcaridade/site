package br.com.caridade.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.caridade.model.CalendarioCaridade;


public interface CalendarioCaridadeRepository  extends JpaRepository<CalendarioCaridade, Long> {

	@Query(value = "SELECT ID_CALENDARIO_CARIDADE," + 
			       " DESCRICAO," +
			       " DATA_CALENDARIO," +
			       " CONFIRMADO," +
			       " ID_BAZAR," +
			       " ID_BINGO," +
			       " ID_PASSEIO," +
			       " ID_FESTA," +
			       " ID_VIDEO FROM db_nsl.calendario_caridade WHERE YEAR(DATA_CALENDARIO) = :ano ORDER BY DATA_CALENDARIO",nativeQuery = true)
	@Qualifier
	List<CalendarioCaridade> findByCalendaByAno(@Param("ano") Long ano);
}
