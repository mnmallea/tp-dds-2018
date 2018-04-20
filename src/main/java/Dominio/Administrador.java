package Dominio;

import org.joda.time.LocalDate;
import org.joda.time.Months;

public class Administrador {
	private String nombre;
	private String apellido;
	private LocalDate fechaAlta;
	private Integer nroIdentificacion;

//	private String nombreUsuario;
//	private String contrasenia;


	public int mesesDeAdministrador(){
		return Months.monthsBetween(fechaAlta, new LocalDate()).getMonths();
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}

