package Dominio;

import java.util.Date;
import java.util.List;

public class Cliente {
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDocumento;
	private Integer nroDocumento;
	private Integer nroTelefono;
	private String domicilio;
	private Date fechaAlta;
	private Categoria categoria;
	private List<Dispositivo> dispositivos;
	
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


	/*Con respecto a estos requerimientos del cliente, para mi, podriamos solamente usar este metodo.

		● Saber la cantidad de dispositivos encendidos: es la funcion que defini
		● Saber la cantidad de dispositivos apagados: le haces el size a la lista de dispositivos, y le restas los que estan prendidos con el metodo que hice abajo

		Igualmente, lo codeo, pero el viernes se lo pregunto porque simplificaria bastante el código

	*/

	private Long cuantosDispositivosEstanEncendidos(List<Dispositivo> dispositivosList){
		Long cantidadDeEncendidos = dispositivosList.stream().filter(dispositivo -> dispositivo.getStatus()).count();
		return cantidadDeEncendidos;
	}

	private Long cuantosDispositivosEstanApagados(List<Dispositivo> dispositivoList){
		Long cantidadApagados = this.dispositivos.size() - this.cuantosDispositivosEstanEncendidos(dispositivoList);
		return cantidadApagados;
	}

	public int cantidadDispositivos(List<Dispositivo> dispositivosList ) {
		return dispositivosList.size();
	}


}
