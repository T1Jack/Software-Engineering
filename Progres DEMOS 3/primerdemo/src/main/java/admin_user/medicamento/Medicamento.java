package admin_user.medicamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

    private String fuerza;
    private int cantidadDisponible;

    @ManyToOne
    @JoinColumn(name = "id_naturaleza_quimica")
    private NaturalezaQuimica naturalezaQuimica;

    @ManyToOne
    @JoinColumn(name = "id_forma_farmaceutica")
    private FormaFarmaceutica formaFarmaceutica;

    @ManyToOne
    @JoinColumn(name = "id_via_dosificacion")
    private ViaDosificacion viaDosificacion;

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

	public String getFuerza() {
		return fuerza;
	}

	public void setFuerza(String fuerza) {
		this.fuerza = fuerza;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public NaturalezaQuimica getNaturalezaQuimica() {
		return naturalezaQuimica;
	}

	public void setNaturalezaQuimica(NaturalezaQuimica naturalezaQuimica) {
		this.naturalezaQuimica = naturalezaQuimica;
	}

	public FormaFarmaceutica getFormaFarmaceutica() {
		return formaFarmaceutica;
	}

	public void setFormaFarmaceutica(FormaFarmaceutica formaFarmaceutica) {
		this.formaFarmaceutica = formaFarmaceutica;
	}

	public ViaDosificacion getViaDosificacion() {
		return viaDosificacion;
	}

	public void setViaDosificacion(ViaDosificacion viaDosificacion) {
		this.viaDosificacion = viaDosificacion;
	}

	public Medicamento(Integer id, String nombre, String fuerza, int cantidadDisponible,
			NaturalezaQuimica naturalezaQuimica, FormaFarmaceutica formaFarmaceutica, ViaDosificacion viaDosificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.cantidadDisponible = cantidadDisponible;
		this.naturalezaQuimica = naturalezaQuimica;
		this.formaFarmaceutica = formaFarmaceutica;
		this.viaDosificacion = viaDosificacion;
	}

	public Medicamento(String nombre, String fuerza, int cantidadDisponible, NaturalezaQuimica naturalezaQuimica,
			FormaFarmaceutica formaFarmaceutica, ViaDosificacion viaDosificacion) {
		super();
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.cantidadDisponible = cantidadDisponible;
		this.naturalezaQuimica = naturalezaQuimica;
		this.formaFarmaceutica = formaFarmaceutica;
		this.viaDosificacion = viaDosificacion;
	}

	public Medicamento(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Medicamento() {
		super();
	}
}
