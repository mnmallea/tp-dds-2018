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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroIdentificacion() {
		return nroIdentificacion;
	}

	public void setNroIdentificacion(Integer nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	

}

