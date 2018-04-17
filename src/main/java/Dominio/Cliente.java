package Dominio;

import java.util.Date;

public class Cliente {
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDocumento;
	private Integer nroDocumento;
	private Integer nroTelefono;
	private String domicilio;
	private Date fechaAlta;
	private Categoria categoria;
	
//	private String nombreUsuario;
//	private String contrasenia;	
	
	
	public Cliente(String nombre, String apellido, TipoDocumento tipoDocumento, Integer nroDocumento,
			Integer nroTelefono, String domicilio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nroTelefono = nroTelefono;
		this.domicilio = domicilio;
	}
	
//	private void categorizar() {
//		this.categoria=this.categorias.stream().findAny(categoria->cateegoria.pertenece(this.consumoMensual)).get();
//	}
}
