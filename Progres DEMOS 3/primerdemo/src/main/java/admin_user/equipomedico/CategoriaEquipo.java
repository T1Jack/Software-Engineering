package admin_user.equipomedico;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria_equipo")
public class CategoriaEquipo {
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

	public CategoriaEquipo(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public CategoriaEquipo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public CategoriaEquipo() {
		super();
	}

}
