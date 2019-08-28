package br.com.caridade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caridade.model.DadosUsuario;

public interface DadosUsuarioRepository extends JpaRepository<DadosUsuario, Long> {
	public DadosUsuario findByIdUsuario(int idUsuario);
	public DadosUsuario findByEmail(String email);
	public DadosUsuario findByPushReceiverId(String pushReceiverId);
	public DadosUsuario findByEmailAndAdmin(String email, int admin);
	public DadosUsuario findByEmailAndPwdAndAdmin(String email, String pwd, int admin);

}
