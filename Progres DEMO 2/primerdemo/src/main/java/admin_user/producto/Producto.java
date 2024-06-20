package admin_user.producto;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import admin_user.categoria.Categoria;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 128, nullable = false, unique = true)
	private String nombre;
	
	private float precio;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<ProductoDetalles> detalles = new CopyOnWriteArrayList<>();


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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void añadirDetalles(String nombre, String valor) {
		this.detalles.add(new ProductoDetalles(nombre, valor, this));
	}

	public List<ProductoDetalles> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<ProductoDetalles> detalles) {
		this.detalles = detalles;
	}
	public void setDetalle(Integer id, String nombre, String valor) {
		this.detalles.add(new ProductoDetalles(id, nombre, valor, this));
	}
	 
	public Producto(Integer id, String nombre, float precio, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Producto() {   
		super();
	}
	

	public Producto(String nombre, float precio, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}


	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}
	

}