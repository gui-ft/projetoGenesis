package gapps.com.Projetogenesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gapps.com.Projetogenesis.Model.Senha;
import gapps.com.Projetogenesis.Repository.SenhaRepository;

@Controller
public class SenhaController {
	
	@Autowired
	private SenhaRepository sr;
	
//	@GetMapping (path = "/")
//	public String index() {
//		return "index";
//	}
	
	@PostMapping (path = "gerarSenha")
	public String gerarSenha(Senha senha) {
		senha.setStatus(true);
		sr.save(senha);
		return "redirect:/";
	}
	
	@GetMapping(path = "/")
	public ModelAndView listaSenhas() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Senha> senhas = sr.findByStatus(false);
		Iterable<Senha> senhasChamar = sr.findByStatus(true);
		mv.addObject("senha", senhas);
		mv.addObject("senhaChamar", senhasChamar);
		return mv;
	}
	
	@RequestMapping(path ="chamarSenha")
	public String chamarSenha(Long id) {
		Senha senha = sr.findByIdSenha(id);
		senha.setStatus(false);
		sr.save(senha);
		return "redirect:/";
		
	}
	
}
