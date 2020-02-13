package br.com.caridade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Doacao;
import br.com.caridade.model.TipoDoacao;

public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
	List<Doacao> findByTipoDoacao(TipoDoacao tipoDoacao);

}
