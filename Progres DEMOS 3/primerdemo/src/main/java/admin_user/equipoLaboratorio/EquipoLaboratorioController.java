package admin_user.equipoLaboratorio;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import admin_user.marca.Marca;
import admin_user.marca.MarcaRepository;

@Controller
@RequestMapping("/equipolaboratorio")
public class EquipoLaboratorioController {

    @Autowired
    private EquipoLaboratorioRepository equipoLaboratorioRepository;

    @Autowired
    private TipoEquipoLabRepository tipoEquipoLabRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/equipos/nuevo")
    public String mostrarFormularioDeNuevoEquipoLab(Model modelo, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        modelo.addAttribute("user", userDetails);
        
        List<TipoEquipoLab> listaTiposEquipoLab = tipoEquipoLabRepository.findAll();
        List<Marca> listaMarcas = marcaRepository.findAll();
        modelo.addAttribute("equipoLaboratorio", new EquipoLaboratorio());
        modelo.addAttribute("listaTiposEquipoLab", listaTiposEquipoLab);
        modelo.addAttribute("listaMarcas", listaMarcas);
        return "equipolaboratorio/equipoLaboratorio_formulario";
    }

    @PostMapping("/equipos/guardar")
    public String guardarEquipoLaboratorio(EquipoLaboratorio equipoLaboratorio, Model modelo) {
        equipoLaboratorioRepository.save(equipoLaboratorio);
        return "redirect:/equipolaboratorio/equipos";
    }

    @GetMapping("/equipos")
    public String listarEquiposLaboratorio(Model modelo, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        modelo.addAttribute("user", userDetails);

        List<EquipoLaboratorio> listaEquiposLaboratorio = equipoLaboratorioRepository.findAll();
        modelo.addAttribute("listaEquiposLaboratorio", listaEquiposLaboratorio);
        return "equipolaboratorio/equipos";
    }

    @GetMapping("/equipos/editar/{id}")
    public String mostrarFormularioDeModificarEquipoLaboratorio(@PathVariable("id") Integer id, Model modelo, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        modelo.addAttribute("user", userDetails);
        
        EquipoLaboratorio equipoLaboratorio = equipoLaboratorioRepository.findById(id).get();
        modelo.addAttribute("equipoLaboratorio", equipoLaboratorio);

        List<TipoEquipoLab> listaTiposEquipoLab = tipoEquipoLabRepository.findAll();
        List<Marca> listaMarcas = marcaRepository.findAll();
        modelo.addAttribute("listaTiposEquipoLab", listaTiposEquipoLab);
        modelo.addAttribute("listaMarcas", listaMarcas);

        return "equipolaboratorio/equipoLaboratorio_formulario";
    }

    @GetMapping("/equipos/eliminar/{id}")
    public String eliminarEquipoLaboratorio(@PathVariable("id") Integer id) {
        equipoLaboratorioRepository.deleteById(id);
        return "redirect:/equipolaboratorio/equipos";
    }
}
