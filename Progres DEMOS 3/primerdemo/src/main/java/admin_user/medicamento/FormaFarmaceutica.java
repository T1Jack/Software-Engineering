package admin_user.medicamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "forma_farmaceutica")
public class FormaFarmaceutica {
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public FormaFarmaceutica(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public FormaFarmaceutica(String nombre) {
		super();
		this.nombre = nombre;
	}

	public FormaFarmaceutica() {
		super();
	}
    
}
