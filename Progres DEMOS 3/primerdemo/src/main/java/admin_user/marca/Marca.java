package admin_user.marca;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import admin_user.categoria.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 45, nullable = false, unique = true)
    private String nombre;
    
    @OneToMany
    @JoinColumn(name = "marca_id")
    private List<Categoria> categorias = new CopyOnWriteArrayList<>();

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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Marca() {
    }

    public Marca(Integer id, String nombre, List<Categoria> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public Marca(String nombre, List<Categoria> categorias) {
        this.nombre = nombre;
        this.categorias = categorias;
    }
}
