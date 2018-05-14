package gapps.com.Projetogenesis.Repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import gapps.com.Projetogenesis.Model.Senha;

public interface SenhaRepository extends CrudRepository<Senha, Long>{
	
	public Collection<Senha> findByStatus(boolean status);
	public Senha findByIdSenha(Long idSenha);
}
