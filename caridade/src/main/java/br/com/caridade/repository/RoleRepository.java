package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}