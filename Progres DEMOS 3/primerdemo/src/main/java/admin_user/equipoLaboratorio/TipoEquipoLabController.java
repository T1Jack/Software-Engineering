package admin_user.equipoLaboratorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipolaboratorio")
public class TipoEquipoLabController {

    @Autowired
    private TipoEquipoLabRepository tipoEquipoLabRepository;

    @GetMapping("/tipoequipo")
    public String listarTipoEquiposLab(Model modelo) {
        List<TipoEquipoLab> listaTipoEquiposLab = tipoEquipoLabRepository.findAll();
        modelo.addAttribute("listaTipoEquiposLab", listaTipoEquiposLab);
        return "equipolaboratorio/tipoequipo";
    }

    @GetMapping("/tipoequipo/nuevo")
    public String mostrarFormularioDeNuevoTipoEquipoLab(Model modelo) {
        modelo.addAttribute("tipoEquipoLab", new TipoEquipoLab());
        return "equipolaboratorio/tipoEquipoLab_formulario";
    }

    @PostMapping("/tipoequipo/guardar")
    public String guardarTipoEquipoLab(TipoEquipoLab tipoEquipoLab) {
        tipoEquipoLabRepository.save(tipoEquipoLab);
        return "redirect:/equipolaboratorio/tipoequipo";
    }
}
