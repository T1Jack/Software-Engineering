package admin_user.equipomedico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ubicacion")
public class UbicacionController {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @GetMapping
    public String listarUbicaciones(Model modelo) {
        List<Ubicacion> listaUbicaciones = ubicacionRepository.findAll();
        modelo.addAttribute("listaUbicaciones", listaUbicaciones);
        return "equipoMedico/ubicacion";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaUbicacion(Model modelo) {
        modelo.addAttribute("ubicacion", new Ubicacion());
        return "equipoMedico/ubicacion_formulario";
    }

    @PostMapping("/guardar")
    public String guardarUbicacion(Ubicacion ubicacion) {
        ubicacionRepository.save(ubicacion);
        return "redirect:/ubicacion";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeModificarUbicacion(@PathVariable("id") Integer id, Model modelo) {
        Ubicacion ubicacion = ubicacionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        modelo.addAttribute("ubicacion", ubicacion);
        return "equipoMedico/ubicacion_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUbicacion(@PathVariable("id") Integer id) {
        Ubicacion ubicacion = ubicacionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        ubicacionRepository.delete(ubicacion);
        return "redirect:/ubicacion";
    }
}
