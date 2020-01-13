package br.com.caridade.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.caridade.model.PastoralCaridade;

public interface PastoralCaridadeRepository extends JpaRepository<PastoralCaridade, Long> {
	List<PastoralCaridade> findByGtIsNotNullOrderByOrderGt();
	List<PastoralCaridade> findBySemana(Long semana);
	List<PastoralCaridade> findAllByOrderByNomeAsc();
	@Query(value = "select id,\r\n" + 
			" nome,\r\n" + 
			" endereco,\r\n" + 
			" complemento,\r\n" + 
			" bairro,\r\n" + 
			" cidade,\r\n" + 
			" uf,\r\n" + 
			" cep,\r\n" + 
			" celular,\r\n" + 
			" email,\r\n" + 
			" data_nascimento,\r\n" + 
			" tipo_sangue,\r\n" + 
			" missa_acolhida,\r\n" + 
			" horario_acolhida,\r\n" + 
			" gt,\r\n" + 
			" order_gt,\r\n" + 
			" semana,\r\n" + 
			" status from db_nsl.pastoral_caridade where status = :status order by nome",nativeQuery = true)
	List<PastoralCaridade> findAllByAtivos(@Param("status")char status);

}
