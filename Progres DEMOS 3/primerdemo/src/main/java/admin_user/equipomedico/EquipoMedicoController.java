package admin_user.equipomedico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipomedico")
public class EquipoMedicoController {

    @Autowired
    private EquipoMedicoRepository equipoMedicoRepository;

    @Autowired
    private CategoriaEquipoRepository categoriaEquipoRepository;

    @Autowired
    private PrioridadRepository prioridadRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @GetMapping
    public String listarEquiposMedicos(Model modelo) {
        List<EquipoMedico> listaEquiposMedicos = equipoMedicoRepository.findAll();
        modelo.addAttribute("listaEquiposMedicos", listaEquiposMedicos);
        return "equipoMedico/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoEquipoMedico(Model modelo) {
        List<CategoriaEquipo> listaCategorias = categoriaEquipoRepository.findAll();
        List<Prioridad> listaPrioridades = prioridadRepository.findAll();
        List<Ubicacion> listaUbicaciones = ubicacionRepository.findAll();
        modelo.addAttribute("equipoMedico", new EquipoMedico());
        modelo.addAttribute("listaCategorias", listaCategorias);
        modelo.addAttribute("listaPrioridades", listaPrioridades);
        modelo.addAttribute("listaUbicaciones", listaUbicaciones);
        return "equipoMedico/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEquipoMedico(EquipoMedico equipoMedico) {
        equipoMedicoRepository.save(equipoMedico);
        return "redirect:/equipomedico";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeModificarEquipoMedico(@PathVariable("id") Integer id, Model modelo) {
        EquipoMedico equipoMedico = equipoMedicoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        List<CategoriaEquipo> listaCategorias = categoriaEquipoRepository.findAll();
        List<Prioridad> listaPrioridades = prioridadRepository.findAll();
        List<Ubicacion> listaUbicaciones = ubicacionRepository.findAll();
        modelo.addAttribute("equipoMedico", equipoMedico);
        modelo.addAttribute("listaCategorias", listaCategorias);
        modelo.addAttribute("listaPrioridades", listaPrioridades);
        modelo.addAttribute("listaUbicaciones", listaUbicaciones);
        return "equipoMedico/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEquipoMedico(@PathVariable("id") Integer id) {
        EquipoMedico equipoMedico = equipoMedicoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        equipoMedicoRepository.delete(equipoMedico);
        return "redirect:/equipomedico";
    }
}
