package br.com.caridade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caridade.dto.RetornoDTO;
import br.com.caridade.model.Videos;
import br.com.caridade.repository.VideosRepository;

@RestController
@CrossOrigin
@RequestMapping("/ListVideos")
public class VideosController {
	
	@Autowired
	private VideosRepository videosRepository;
	
	@GetMapping("/Todos")
	public ResponseEntity<RetornoDTO> getListaVideos() {
		RetornoDTO retorno = new RetornoDTO();
		List<Videos> ltVideos = videosRepository.findAll();
		if ( ltVideos != null && !ltVideos.isEmpty()) {
			retorno.setLtVideos(ltVideos);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}

}
