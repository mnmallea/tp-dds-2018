package dominio;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	private Long usuario;
	private String password;
	@Enumerated
	private TipoUsuario tipoUsuario;
	
	public Usuario(Long usuario, String password, TipoUsuario tipoUsuario) {
		this.usuario = usuario;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}
	
	
	public Usuario() {
		
	}

	public Long getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	
}
