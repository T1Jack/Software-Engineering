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
@RequestMapping("/naturalezaquimica")
public class NaturalezaQuimicaController {

    @Autowired
    private NaturalezaQuimicaRepository naturalezaQuimicaRepository;

    @GetMapping
    public String listarNaturalezaQuimica(Model modelo) {
        List<NaturalezaQuimica> listaNaturalezaQuimica = naturalezaQuimicaRepository.findAll();
        modelo.addAttribute("listaNaturalezaQuimica", listaNaturalezaQuimica);
        return "medicamento/naturalezaquimica";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaNaturalezaQuimica(Model modelo) {
        modelo.addAttribute("naturalezaQuimica", new NaturalezaQuimica());
        return "medicamento/naturalezaQuimica_formulario";
    }

    @PostMapping("/guardar")
    public String guardarNaturalezaQuimica(NaturalezaQuimica naturalezaQuimica) {
        naturalezaQuimicaRepository.save(naturalezaQuimica);
        return "redirect:/naturalezaquimica";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeModificarNaturalezaQuimica(@PathVariable("id") Integer id, Model modelo) {
        NaturalezaQuimica naturalezaQuimica = naturalezaQuimicaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        modelo.addAttribute("naturalezaQuimica", naturalezaQuimica);
        return "medicamento/naturalezaQuimica_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarNaturalezaQuimica(@PathVariable("id") Integer id) {
        NaturalezaQuimica naturalezaQuimica = naturalezaQuimicaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        naturalezaQuimicaRepository.delete(naturalezaQuimica);
        return "redirect:/naturalezaquimica";
    }
}
