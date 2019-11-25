package br.com.sentinela.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sentinela.model.PastoralCaridade;

public interface PastoralCaridadeRepository extends JpaRepository<PastoralCaridade, Long> {
	List<PastoralCaridade> findByGtIsNotNullOrderByOrderGt();
	List<PastoralCaridade> findBySemana(Long semana);
	
	@Query(value = "SELECT " +
				   "id, nome, endereco, complemento, bairro, cidade, uf, cep, celular, email, data_nascimento, tipo_sangue, missa_acolhida, horario_acolhida, gt, order_gt, semana " +
				   "from db_nsl.pastoral_caridade where DATE_FORMAT(data_nascimento,'%m-%d') = DATE_FORMAT(:dataAniversario,'%m-%d')",  nativeQuery = true)
	@Qualifier
	List<PastoralCaridade> findByBirthday(@Param("dataAniversario") String dataAniversario );

}
