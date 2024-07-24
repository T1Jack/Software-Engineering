package admin_user.equipomedico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoriaequipo")
public class CategoriaEquipoController {

    @Autowired
    private CategoriaEquipoRepository categoriaEquipoRepository;

    @GetMapping
    public String listarCategoriasEquipo(Model modelo) {
        List<CategoriaEquipo> listaCategoriasEquipo = categoriaEquipoRepository.findAll();
        modelo.addAttribute("listaCategoriasEquipo", listaCategoriasEquipo);
        return "equipoMedico/categoria";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevaCategoriaEquipo(Model modelo) {
        modelo.addAttribute("categoriaEquipo", new CategoriaEquipo());
        return "equipoMedico/categoria_formularioEqMed";
    }

    @PostMapping("/guardar")
    public String guardarCategoriaEquipo(CategoriaEquipo categoriaEquipo) {
        categoriaEquipoRepository.save(categoriaEquipo);
        return "redirect:/categoriaequipo";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeModificarCategoriaEquipo(@PathVariable("id") Integer id, Model modelo) {
        CategoriaEquipo categoriaEquipo = categoriaEquipoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        modelo.addAttribute("categoriaEquipo", categoriaEquipo);
        return "equipoMedico/categoria_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoriaEquipo(@PathVariable("id") Integer id) {
        CategoriaEquipo categoriaEquipo = categoriaEquipoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        categoriaEquipoRepository.delete(categoriaEquipo);
        return "redirect:/categoriaequipo";
    }
}
