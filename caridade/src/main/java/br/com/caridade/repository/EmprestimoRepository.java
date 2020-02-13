package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
