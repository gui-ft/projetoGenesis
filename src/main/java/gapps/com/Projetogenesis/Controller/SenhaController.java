package gapps.com.Projetogenesis.Controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import gapps.com.Projetogenesis.Model.Senha;
import gapps.com.Projetogenesis.Repository.SenhaRepository;

@Controller
public class SenhaController {
	
	@Autowired
	private SenhaRepository sr;
	
	@PostMapping (path = "gerarSenha")
	public String gerarSenha(Senha senha) {
		senha.setStatus(false);
		sr.save(senha);
		return "redirect:/";
	}
	
	@GetMapping(path = "/")
	public ModelAndView senhas() {
		ModelAndView mv = new ModelAndView("index");
		Collection<Senha> ultimaSenhaChamada = sr.findByStatus(true);
		mv.addObject("ultimaSenhaChamada", ultimaSenhaChamada);
		return mv;
	}
	
	@GetMapping(path = "/gerente")
	public ModelAndView listaSenhas() {
		ModelAndView mv = new ModelAndView("gerente");
		Collection<Senha> senhasChamar = sr.findByStatus(false);
		mv.addObject("senhaChamar", senhasChamar);
		Collection<Senha> ultimaSenhaChamada = sr.findByStatus(true);
		mv.addObject("ultimaSenhaChamada", ultimaSenhaChamada);
		return mv;
	}
	
	@GetMapping(path ="chamarSenha")
	public String chamarSenha() {
		Collection<Senha> senhas = (Collection<Senha>) sr.findAll();
		Senha senha;
		Iterator<Senha> itr = senhas.iterator();
		
	    if (itr.hasNext()) {
	    	senha = itr.next();
	    	
	    	if (senha.getStatus() == false) {
	    		senha.setStatus(true);
	    		sr.save(senha);
	    	}
	    	else if (senha.getStatus() == true){
	    		sr.delete(senha);
	    		chamarSenha();
	    	}
	    }
		return "redirect:/gerente";
	}
	
	@GetMapping(path = "reiniciar")
	public String reiniciar() {
		sr.deleteAll();
		return "redirect:/gerente";
	}
}