package gapps.com.Projetogenesis.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Senha {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long idSenha;
	private String tipo;
	private boolean status;
	
	public Long getIdSenha() {
		return idSenha;
	}
	public void setIdSenha(Long idSenha) {
		this.idSenha = idSenha;
	}
	public String getTipo(){
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
