package dto;

import com.google.gson.annotations.SerializedName;
import java.time.LocalDate;

import java.io.Serializable;
import java.util.List;

public class UsuarioDTO implements Serializable {

	private String nombre;
	private String apellido;
	@SerializedName("tipo_documento")
	private String tipoDocumento;
	@SerializedName("nro_documento")
	private Integer nroDocumento;
	@SerializedName("nro_telefono")
	private Integer nroTelefono;
	private String domicilio;
	@SerializedName("fecha_alta")
	private LocalDate fechaAlta;
	private String categoria;
	private Float consumo;
	@SerializedName("dispositivos")
	private List<DispositivoDto> dispositivosDto;

	public List<DispositivoDto> getDispositivosDto() {
		return dispositivosDto;
	}

	public void setDispositivosDto(List<DispositivoDto> dispositivosDto) {
		this.dispositivosDto = dispositivosDto;
	}

	public Float getConsumo() {
		return consumo;
	}

	public void setConsumo(Float consumo) {
		this.consumo = consumo;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Integer getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(Integer nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}
