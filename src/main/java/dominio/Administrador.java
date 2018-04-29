package dominio;

import java.time.LocalDate;
import java.time.Period;

public class Administrador {
	private String nombre;
	private String apellido;
	private LocalDate fechaAlta;
	private Integer nroIdentificacion;

//	private String nombreUsuario;
//	private String contrasenia;


	public int mesesDeAdministrador(){
		return Period.between(fechaAlta, LocalDate.now()).getMonths();
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}

