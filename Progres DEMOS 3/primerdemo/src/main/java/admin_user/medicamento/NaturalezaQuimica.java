package admin_user.medicamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "naturaleza_quimica")
public class NaturalezaQuimica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
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

	public NaturalezaQuimica(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public NaturalezaQuimica(String nombre) {
		super();
		this.nombre = nombre;
	}

	public NaturalezaQuimica() {
		super();
	}
}
