package admin_user.medicamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/viadosificacion")
public class ViaDosificacionController {

    @Autowired
    private ViaDosificacionRepository viaDosificacionRepository;

    @GetMapping
    public String listarViaDosificacion(Model modelo) {
        List<ViaDosificacion> listaViaDosificacion = viaDosificacionRepository.findAll();
        modelo.addAttribute("listaViaDosificacion", listaViaDosificacion);
        return "medicamento/viadosificacion";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaViaDosificacion(Model modelo) {
        modelo.addAttribute("viaDosificacion", new ViaDosificacion());
        return "medicamento/viaDosificacion_formulario";
    }

    @PostMapping("/guardar")
    public String guardarViaDosificacion(ViaDosificacion viaDosificacion) {
        viaDosificacionRepository.save(viaDosificacion);
        return "redirect:/viadosificacion";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeModificarViaDosificacion(@PathVariable("id") Integer id, Model modelo) {
        ViaDosificacion viaDosificacion = viaDosificacionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        modelo.addAttribute("viaDosificacion", viaDosificacion);
        return "medicamento/viaDosificacion_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarViaDosificacion(@PathVariable("id") Integer id) {
        ViaDosificacion viaDosificacion = viaDosificacionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        viaDosificacionRepository.delete(viaDosificacion);
        return "redirect:/viadosificacion";
    }
}
