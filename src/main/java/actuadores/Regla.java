package actuadores;

import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoReglas")
public class Regla<TipoCondicion, TipoDispositivo extends DispositivoInteligente<?>> {

	@GeneratedValue
	@Id
	private Long id;
	@ManyToOne
	private Condicion<TipoCondicion> condicion;
	@ManyToMany
	private List<Actuador<TipoDispositivo>> actuadores;
	@ManyToOne
	private TipoDispositivo dispositivo;

	public Regla(Condicion<TipoCondicion> condicion, List<Actuador<TipoDispositivo>> actuadores,
			TipoDispositivo dispositivo) {
		this.condicion = condicion;
		this.actuadores = actuadores;
		this.dispositivo = dispositivo;
	}

	public Regla() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void seTomoMedicion(TipoCondicion medicion) {
		if (condicion.seCumple(medicion)) {
			actuadores.forEach(actuador -> actuador.actuaSobre(dispositivo));
		}
	}
}
