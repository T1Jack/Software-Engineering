package admin_user.equipomedico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prioridad")
public class PrioridadController {

    @Autowired
    private PrioridadRepository prioridadRepository;

    @GetMapping
    public String listarPrioridades(Model modelo) {
        List<Prioridad>  listaPrioridades = prioridadRepository.findAll();
        modelo.addAttribute("listaPrioridades", listaPrioridades);
        return "equipoMedico/prioridad";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaPrioridad(Model modelo) {
        modelo.addAttribute("prioridad", new Prioridad());
        return "equipoMedico/prioridad_formulario";
    }

    @PostMapping("/guardar")
    public String guardarPrioridad(Prioridad prioridad) {
        prioridadRepository.save(prioridad);
        return "redirect:/prioridad";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeModificarPrioridad(@PathVariable("id") Integer id, Model modelo) {
        Prioridad prioridad = prioridadRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        modelo.addAttribute("prioridad", prioridad);
        return "equipoMedico/prioridad_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPrioridad(@PathVariable("id") Integer id) {
        Prioridad prioridad = prioridadRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        prioridadRepository.delete(prioridad);
        return "redirect:/prioridad";
    }
}
