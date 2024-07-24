package admin_user.procedimineto;

import admin_user.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recurso")
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@ManyToOne
	@JoinColumn(name = "usuario")
	private User usuario;

    @ManyToOne
    @JoinColumn(name = "tipo_recurso_id", nullable = false)
    private TipoRecurso tipoRecurso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoRecurso getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(TipoRecurso tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }
}