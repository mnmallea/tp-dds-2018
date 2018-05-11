package dominio;

import java.time.LocalDate;
import java.time.Period;

public class Administrador {
	private String nombre;
	private String apellido;
	private LocalDate fechaAlta;
	private Integer nroIdentificacion;	

	public Administrador(String nombre, String apellido, LocalDate fechaAlta, Integer nroIdentificacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaAlta = fechaAlta;
		this.nroIdentificacion = nroIdentificacion;
	}

	public int mesesDeAdministrador(){
		return Period.between(fechaAlta, LocalDate.now()).getMonths();
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNroIdentificacion() {
		return nroIdentificacion;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	

}

