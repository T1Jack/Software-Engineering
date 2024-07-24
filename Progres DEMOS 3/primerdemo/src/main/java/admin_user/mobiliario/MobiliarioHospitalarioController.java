package admin_user.mobiliario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mobiliario")
public class MobiliarioHospitalarioController {

    @Autowired
    private MobiliarioHospitalarioRepository mobiliarioHospitalarioRepository;

    @Autowired
    private TipoMobiliarioRepository tipoMobiliarioRepository;

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoMobiliario(Model modelo) {
        List<TipoMobiliario> listaTiposMobiliario = tipoMobiliarioRepository.findAll();
        modelo.addAttribute("mobiliarioHospitalario", new MobiliarioHospitalario());
        modelo.addAttribute("listaTiposMobiliario", listaTiposMobiliario);
        return "mobiliario/mobiliario_formulario";
    }

    @PostMapping("/guardar")
    public String guardarMobiliarioHospitalario(MobiliarioHospitalario mobiliarioHospitalario) {
        mobiliarioHospitalarioRepository.save(mobiliarioHospitalario);
        return "redirect:/mobiliario";
    }

    @GetMapping
    public String listarMobiliario(Model modelo) {
        List<MobiliarioHospitalario> listaMobiliarioHospitalario = mobiliarioHospitalarioRepository.findAll();
        modelo.addAttribute("listaMobiliarioHospitalario", listaMobiliarioHospitalario);
        return "mobiliario/mobiliario";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeModificarMobiliario(@PathVariable("id") Integer id, Model modelo) {
        MobiliarioHospitalario mobiliarioHospitalario = mobiliarioHospitalarioRepository.findById(id).get();
        modelo.addAttribute("mobiliarioHospitalario", mobiliarioHospitalario);

        List<TipoMobiliario> listaTiposMobiliario = tipoMobiliarioRepository.findAll();
        modelo.addAttribute("listaTiposMobiliario", listaTiposMobiliario);

        return "mobiliario/mobiliario_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMobiliarioHospitalario(@PathVariable("id") Integer id) {
        mobiliarioHospitalarioRepository.deleteById(id);
        return "redirect:/mobiliario";
    }
}
