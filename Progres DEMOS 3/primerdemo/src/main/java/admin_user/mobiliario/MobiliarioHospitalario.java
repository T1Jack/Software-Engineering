package admin_user.mobiliario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mobiliario_hospitalario")
public class MobiliarioHospitalario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(length = 128, nullable = false, unique = true)
	private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "tipo_mobiliario", nullable = false)
    private TipoMobiliario tipoMobiliario;
    
	private int cantidad;

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

	public TipoMobiliario getTipoMobiliario() {
		return tipoMobiliario;
	}

	public void setTipoMobiliario(TipoMobiliario tipoMobiliario) {
		this.tipoMobiliario = tipoMobiliario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public MobiliarioHospitalario(Integer id, String nombre, TipoMobiliario tipoMobiliario, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoMobiliario = tipoMobiliario;
		this.cantidad = cantidad;
	}

	public MobiliarioHospitalario(String nombre, TipoMobiliario tipoMobiliario, int cantidad) {
		super();
		this.nombre = nombre;
		this.tipoMobiliario = tipoMobiliario;
		this.cantidad = cantidad;
	}

	public MobiliarioHospitalario() {
		super();
	}    
}
