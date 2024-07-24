package admin_user.mobiliario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_mobiliario")
public class TipoMobiliario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 125, nullable = false)
	private String nombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoMobiliario() {
		super();
	}

	public TipoMobiliario(String nombre) {
		super();
		this.nombre = nombre;
	}

	public TipoMobiliario(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

}
