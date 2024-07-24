package admin_user.equipomedico;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo_medico")
public class EquipoMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_equipo_id")
    private CategoriaEquipo categoriaEquipo;

    @Column(length = 45, nullable = false)
    private String estado;

    private LocalDate fechaCompra;

    @ManyToOne
    @JoinColumn(name = "prioridad_id")
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;

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

	public CategoriaEquipo getCategoriaEquipo() {
		return categoriaEquipo;
	}

	public void setCategoriaEquipo(CategoriaEquipo categoriaEquipo) {
		this.categoriaEquipo = categoriaEquipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public EquipoMedico(Integer id, String nombre, CategoriaEquipo categoriaEquipo, String estado,
			LocalDate fechaCompra, Prioridad prioridad, Ubicacion ubicacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoriaEquipo = categoriaEquipo;
		this.estado = estado;
		this.fechaCompra = fechaCompra;
		this.prioridad = prioridad;
		this.ubicacion = ubicacion;
	}

	public EquipoMedico(String nombre, CategoriaEquipo categoriaEquipo, String estado, LocalDate fechaCompra,
			Prioridad prioridad, Ubicacion ubicacion) {
		super();
		this.nombre = nombre;
		this.categoriaEquipo = categoriaEquipo;
		this.estado = estado;
		this.fechaCompra = fechaCompra;
		this.prioridad = prioridad;
		this.ubicacion = ubicacion;
	}

	public EquipoMedico(String nombre) {
		super();
		this.nombre = nombre;
	}

	public EquipoMedico() {
		super();
	}
    
    

}
