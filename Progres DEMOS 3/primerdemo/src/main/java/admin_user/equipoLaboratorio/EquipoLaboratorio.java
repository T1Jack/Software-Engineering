package admin_user.equipoLaboratorio;

import java.time.LocalDate;

import admin_user.marca.Marca;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo_laboratorio")
public class EquipoLaboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(length = 128, nullable = false, unique = true)
	private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "tipo_equipo_lab_id")
    private TipoEquipoLab tipoEquipoLab;
    
    private String modelo;
    
    private LocalDate fechaAdquisicion;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;	

    // Getters y Setters
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

    public TipoEquipoLab getTipoEquipoLab() {
        return tipoEquipoLab;
    }

    public void setTipoEquipoLab(TipoEquipoLab tipoEquipoLab) {
        this.tipoEquipoLab = tipoEquipoLab;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
  
	@Override
	public String toString() {
		return "EquipoLaboratorio [nombre=" + nombre + "]";
	}

	public EquipoLaboratorio(String nombre) {
		super();
		this.nombre = nombre;
	}

	public EquipoLaboratorio(String nombre, TipoEquipoLab tipoEquipoLab, String modelo, LocalDate fechaAdquisicion,
			Marca marca) {
		super();
		this.nombre = nombre;
		this.tipoEquipoLab = tipoEquipoLab;
		this.modelo = modelo;
		this.fechaAdquisicion = fechaAdquisicion;
		this.marca = marca;
	}

	public EquipoLaboratorio() {
		super();
	}

	public EquipoLaboratorio(Integer id, String nombre, TipoEquipoLab tipoEquipoLab, String modelo,
			LocalDate fechaAdquisicion, Marca marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoEquipoLab = tipoEquipoLab;
		this.modelo = modelo;
		this.fechaAdquisicion = fechaAdquisicion;
		this.marca = marca;
	}
}
