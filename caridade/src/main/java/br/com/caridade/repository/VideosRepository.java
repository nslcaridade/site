package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.Videos;

public interface VideosRepository  extends JpaRepository<Videos, Long> {

}
