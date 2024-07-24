package admin_user.mobiliario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mobiliario")
public class TipoMobiliarioController {

    @Autowired
    private TipoMobiliarioRepository tipoMobiliarioRepository;

    @GetMapping("/tipomobiliario")
    public String listarTipoMobiliario(Model modelo) {
        List<TipoMobiliario> listaTipoMobiliario = tipoMobiliarioRepository.findAll();
        modelo.addAttribute("listaTipoMobiliario", listaTipoMobiliario);
        return "mobiliario/tipomobiliario";
    }

    @GetMapping("/tipomobiliario/nuevo")
    public String mostrarFormularioDeNuevoTipoMobiliario(Model modelo) {
        modelo.addAttribute("tipoMobiliario", new TipoMobiliario());
        return "mobiliario/tipoMobiliario_formulario";
    }

    @PostMapping("/tipomobiliario/guardar")
    public String guardarTipoMobiliario(TipoMobiliario tipoMobiliario) {
        tipoMobiliarioRepository.save(tipoMobiliario);
        return "redirect:/mobiliario/tipomobiliario";
    }
}
