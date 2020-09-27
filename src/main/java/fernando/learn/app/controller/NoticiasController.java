package fernando.learn.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fernando.learn.app.model.Noticia;
import fernando.learn.app.service.INoticiasService;

@Controller
@RequestMapping( value="/noticias")
public class NoticiasController {
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	@GetMapping(value = "/index")
	public String mostrarTodas(Model model, Pageable page) {
		Page<Noticia> lista = serviceNoticias.buscarTodas(page);
		model.addAttribute("noticias", lista);
		return "noticias/listNoticias";
	}
	
	@PostMapping(value="/save")
	public String guardar(@ModelAttribute Noticia noticia, BindingResult result, RedirectAttributes attributes) {
		
		serviceNoticias.guardar(noticia);
		
		attributes.addFlashAttribute("mensaje", "Noticia guardada correctamente");
		return "redirect:/noticias/index";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Noticia noticia) {
		return "noticias/formNoticia";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idNoticia, Model model) {
		Noticia noticia = serviceNoticias.buscarPorId(idNoticia);
		model.addAttribute("noticia", noticia);
		return "noticias/formNoticia";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idNoticia, RedirectAttributes attributes) {
		serviceNoticias.eliminar(idNoticia);
		attributes.addFlashAttribute("mensaje", "Noticia eliminada");
		return "redirect:/noticias/index";
	}
}
