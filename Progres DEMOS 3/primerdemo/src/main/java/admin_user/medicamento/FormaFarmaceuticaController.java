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
@RequestMapping("/formafarmaceutica")
public class FormaFarmaceuticaController {

    @Autowired
    private FormaFarmaceuticaRepository formaFarmaceuticaRepository;

    @GetMapping
    public String listarFormaFarmaceutica(Model modelo) {
        List<FormaFarmaceutica> listaFormaFarmaceutica = formaFarmaceuticaRepository.findAll();
        modelo.addAttribute("listaFormaFarmaceutica", listaFormaFarmaceutica);
        return "medicamento/formafarmaceutica";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaFormaFarmaceutica(Model modelo) {
        modelo.addAttribute("formaFarmaceutica", new FormaFarmaceutica());
        return "medicamento/formaFarmaceutica_formulario";
    }

    @PostMapping("/guardar")
    public String guardarFormaFarmaceutica(FormaFarmaceutica formaFarmaceutica) {
        formaFarmaceuticaRepository.save(formaFarmaceutica);
        return "redirect:/formafarmaceutica";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeModificarFormaFarmaceutica(@PathVariable("id") Integer id, Model modelo) {
        FormaFarmaceutica formaFarmaceutica = formaFarmaceuticaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        modelo.addAttribute("formaFarmaceutica", formaFarmaceutica);
        return "medicamento/formaFarmaceutica_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFormaFarmaceutica(@PathVariable("id") Integer id) {
        FormaFarmaceutica formaFarmaceutica = formaFarmaceuticaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        formaFarmaceuticaRepository.delete(formaFarmaceutica);
        return "redirect:/formafarmaceutica";
    }
}
