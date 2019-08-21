package br.com.sentinela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sentinela.model.DadosUsuario;

public interface DadosUsuarioRepository extends JpaRepository<DadosUsuario, Long> {


}
