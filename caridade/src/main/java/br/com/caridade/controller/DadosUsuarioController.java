package br.com.caridade.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.dto.RetornoDTO;
import br.com.caridade.event.UserCreatedEvent;
import br.com.caridade.model.DadosUsuario;
import br.com.caridade.model.Mensagem;
import br.com.caridade.repository.DadosUsuarioRepository;
import br.com.caridade.util.UtilsTools;

@RestController
@CrossOrigin
@RequestMapping("/User")
public class DadosUsuarioController {
	
	@Autowired
	private DadosUsuarioRepository dadosUsuarioRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	/**
	 * Método utilizado para criação de usuário
	 * @param dadosLogin
	 * @param response
	 * @return
	 */
	
	@PostMapping("/Login")
	public DadosUsuario lista(@RequestBody DadosUsuario dadosUsuario) {
		DadosUsuario findByEmailAndAdmin = dadosUsuarioRepository.findByEmailAndPwdAndAdmin(dadosUsuario.getEmail(), dadosUsuario.getPwd(), 1);
		return findByEmailAndAdmin;
	}
	
	@PostMapping
	public ResponseEntity<RetornoDTO> criar(@RequestBody DadosUsuario dadosUsuario, HttpServletResponse response) {

		RetornoDTO retorno = new RetornoDTO();
		System.out.println("DEBUG - cria post dadosUsuario:"+dadosUsuario.toString());
		DadosUsuario findByUsuEmail = dadosUsuarioRepository.findByEmail(dadosUsuario.getEmail());
		List<Mensagem> ltMsg = new ArrayList<Mensagem>();
		Mensagem msg = new Mensagem();
		
		if (findByUsuEmail == null) {
			setaValoresDefault(dadosUsuario);
			dadosUsuarioRepository.save(dadosUsuario);
			msg.setTexto("Dados cadastrados na nossa base de dados! ");
			ltMsg.add(msg);
			retorno.setMensagem(ltMsg);
			dadosUsuario = dadosUsuarioRepository.findByEmail(dadosUsuario.getEmail());
			retorno.setIdUsuario(dadosUsuario.getIdUsuario());
			publisher.publishEvent(new UserCreatedEvent(this, response, new Long(dadosUsuario.getIdUsuario())));
			return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
		} else {
			msg.setTexto("Já existe um cadastro para o email informado! Deseja recuperar o cadastro?");
			ltMsg.add(msg);
			retorno.setMensagem(ltMsg);
			retorno.setCodigo1(-1);
			DadosUsuario findDadosUsuario = dadosUsuarioRepository.findByIdUsuario(findByUsuEmail.getIdUsuario());
			retorno.setIdUsuario(findDadosUsuario.getIdUsuario());
			return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
		}
	}

	@PutMapping("/Atualiza")
	public ResponseEntity<RetornoDTO> atualiza(@RequestBody DadosUsuario dadosUsuario, HttpServletResponse response) {

		RetornoDTO retorno = new RetornoDTO();
		System.out.println("DEBUG - Atualiza put dadosUsuario:"+dadosUsuario.toString());
		DadosUsuario dadosUsuarioChange = dadosUsuarioRepository.findByIdUsuario(dadosUsuario.getIdUsuario());
		List<Mensagem> ltMsg = new ArrayList<Mensagem>();
		Mensagem msg = new Mensagem();
		
		
		if (dadosUsuarioChange != null) {
			dadosUsuarioChange.setDataNacimento(dadosUsuario.getDataNacimento());
			dadosUsuarioChange.setTelefone(dadosUsuario.getTelefone());
			dadosUsuarioChange.setDiaAcolhida(dadosUsuario.getDiaAcolhida());
			dadosUsuarioChange.setSemanaEscala(dadosUsuario.getSemanaEscala());
			
			dadosUsuarioRepository.save(dadosUsuarioChange);
			msg.setTexto("Dados cadastrados na nossa base de dados! ");
			ltMsg.add(msg);
			retorno.setMensagem(ltMsg);
			retorno.setIdUsuario(dadosUsuario.getIdUsuario());
			retorno.setDadosUsuario(dadosUsuarioChange);
			publisher.publishEvent(new UserCreatedEvent(this, response, new Long(dadosUsuario.getIdUsuario())));
			return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
		} else {
			msg.setTexto("Não há registro para o usuario:"+dadosUsuario.getNome());
			ltMsg.add(msg);
			retorno.setMensagem(ltMsg);
			retorno.setCodigo1(-1);
			return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
		}
	}
	
	@GetMapping("/Localiza/{email}")
	public ResponseEntity<RetornoDTO> localiza(@PathVariable String email, HttpServletResponse response){
		RetornoDTO retorno = new RetornoDTO();
		System.out.println("DEBUG - Localiza get email:"+email);
		DadosUsuario dadosUsuarioFound = dadosUsuarioRepository.findByEmail(email);
		List<Mensagem> ltMsg = new ArrayList<Mensagem>();
		Mensagem msg = new Mensagem();
		
		if ( dadosUsuarioFound != null ) {
			retorno.setDadosUsuario(dadosUsuarioFound);
			msg.setTexto("Localizado");
			ltMsg.add(msg);
			retorno.setMensagem(ltMsg);
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		} else { 
			msg.setTexto("Não Localizado");
			ltMsg.add(msg);
			retorno.setMensagem(ltMsg);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);
		}
	}
	@DeleteMapping("/Delete/{idUsuario}")
	public ResponseEntity<RetornoDTO> exclui(@PathVariable int idUsuario, HttpServletResponse response){
		RetornoDTO retorno = new RetornoDTO();
		System.out.println("DEBUG - Delete put idUsuario:"+idUsuario);
		DadosUsuario dadosUsuarioFound = dadosUsuarioRepository.findByIdUsuario(idUsuario);
		System.out.println("DEBUG - dadosUsuarioFound:"+dadosUsuarioFound);
		
		if ( dadosUsuarioFound != null ) {
			dadosUsuarioRepository.delete(dadosUsuarioFound);
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		} else { 
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		}
	}
	
	private void setaValoresDefault(DadosUsuario dadosUsuario) {
		Timestamp currentTimestamp = UtilsTools.getCurrentTimestamp();
		dadosUsuario.setAtivo(true);
		dadosUsuario.setDataCadastro(currentTimestamp);
	}
}
