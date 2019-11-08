package br.com.caridade.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caridade.repository.MensagemRepository;

@Controller
public class HomeController {
	
	@Autowired
	MensagemRepository mensagemRepository;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("usuario", "Duarte");
		File folder;
		try {
			//File folder = new File("C:\\Users\\alexandre.duarte\\estudo\\site\\caridade\\src\\main\\resources\\static\\image");
			folder = new File("/home/disdi/disdi.uh-app.com.br/webapps/caridade/WEB-INF/classes/static/image/");
			List<String> result = new ArrayList<>();
			for (File f : folder.listFiles()) {
				if ( f.getName().substring(0,5).equals("camp_"))
					result.add(f.getName());
			}
			mv.addObject("imagens",result);
		} catch ( Exception e ) {
			System.out.println("ERRO: Diretorio inexistente");
		}
		
		//Optional<Mensagem> findById = mensagemRepository.findByTipo("menu");
		//mv.addObject("mensagem", findById.get());
		return mv;
	}

}
