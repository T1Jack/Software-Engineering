package admin_user.procedimineto;


import admin_user.equipoLaboratorio.EquipoLaboratorio;
import admin_user.equipomedico.EquipoMedico;
import admin_user.medicamento.Medicamento;
import admin_user.mobiliario.MobiliarioHospitalario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_recurso")
public class TipoRecurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@ManyToOne
	@JoinColumn(name = "equipolaboratorio_id")
	private EquipoLaboratorio equipolaboratorio;
	
	@ManyToOne
	@JoinColumn(name = "equipomedico_id")
	private EquipoMedico equipomedico;
	
	@ManyToOne
	@JoinColumn(name = "mobiliario_id")
	private MobiliarioHospitalario mobiliario_id ;
	
	@ManyToOne
	@JoinColumn(name = "medicamento_id")
	private Medicamento medicamento ;

}
