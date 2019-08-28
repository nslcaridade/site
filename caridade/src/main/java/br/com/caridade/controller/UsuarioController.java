package br.com.caridade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.caridade.model.DadosUsuario;
import br.com.caridade.repository.DadosUsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private DadosUsuarioRepository usuarioRepository;

    @GetMapping
    public List < DadosUsuario > listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody DadosUsuario usuario) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(usuarioRepository.saveAndFlush(usuario));
    }
}