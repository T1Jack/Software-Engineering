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
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private NaturalezaQuimicaRepository naturalezaQuimicaRepository;

    @Autowired
    private FormaFarmaceuticaRepository formaFarmaceuticaRepository;

    @Autowired
    private ViaDosificacionRepository viaDosificacionRepository;

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoMedicamento(Model modelo) {
        List<NaturalezaQuimica> listaNaturalezaQuimica = naturalezaQuimicaRepository.findAll();
        List<FormaFarmaceutica> listaFormaFarmaceutica = formaFarmaceuticaRepository.findAll();
        List<ViaDosificacion> listaViaDosificacion = viaDosificacionRepository.findAll();

        modelo.addAttribute("medicamento", new Medicamento());
        modelo.addAttribute("listaNaturalezaQuimica", listaNaturalezaQuimica);
        modelo.addAttribute("listaFormaFarmaceutica", listaFormaFarmaceutica);
        modelo.addAttribute("listaViaDosificacion", listaViaDosificacion);
        return "medicamento/medicamento_formulario";
    }

    @PostMapping("/guardar")
    public String guardarMedicamento(Medicamento medicamento) {
        medicamentoRepository.save(medicamento);
        return "redirect:/medicamento";
    }

    @GetMapping
    public String listarMedicamentos(Model modelo) {
        List<Medicamento> listaMedicamentos = medicamentoRepository.findAll();
        modelo.addAttribute("listaMedicamentos", listaMedicamentos);
        return "medicamento/medicamento";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeModificarMedicamento(@PathVariable("id") Long id, Model modelo) {
        Medicamento medicamento = medicamentoRepository.findById(id).get();

        List<NaturalezaQuimica> listaNaturalezaQuimica = naturalezaQuimicaRepository.findAll();
        List<FormaFarmaceutica> listaFormaFarmaceutica = formaFarmaceuticaRepository.findAll();
        List<ViaDosificacion> listaViaDosificacion = viaDosificacionRepository.findAll();

        modelo.addAttribute("medicamento", medicamento);
        modelo.addAttribute("listaNaturalezaQuimica", listaNaturalezaQuimica);
        modelo.addAttribute("listaFormaFarmaceutica", listaFormaFarmaceutica);
        modelo.addAttribute("listaViaDosificacion", listaViaDosificacion);

        return "medicamento/medicamento_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMedicamento(@PathVariable("id") Long id) {
        medicamentoRepository.deleteById(id);
        return "redirect:/medicamento";
    }
}
