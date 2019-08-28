package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Bingo;

public interface BingoRepository extends JpaRepository<Bingo, Long> {

}
