package fernando.learn.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
// import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fernando.learn.app.model.Pelicula;
import fernando.learn.app.service.IDetallesService;
import fernando.learn.app.service.IPeliculasService;
import fernando.learn.app.util.Utils;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IDetallesService serviceDetalles;
	
	@Autowired
	private IPeliculasService servicePeliculas;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}

	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		return "peliculas/formPelicula";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
		if (result.hasErrors()) {
			System.out.println("Errores al guardar la película");
			return "peliculas/formPelicula";
		}

//		for (ObjectError error : result.getAllErrors()) {
//			System.out.println(error.getDefaultMessage());
//		}
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utils.guardarImagen(multiPart, request);
			pelicula.setImagen(nombreImagen);
		}

		serviceDetalles.insertar(pelicula.getDetalle());
		servicePeliculas.insertar(pelicula);

		attributes.addFlashAttribute("mensaje", "Película guardada correctamente");

		// return "peliculas/formPelicula";
		return "redirect:/peliculas/indexPaginate";

	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula, Model model) {
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
		
		model.addAttribute("pelicula", pelicula);
		
		return "peliculas/formPelicula";
	}
	
	//También se puede optimizar trayendo con get el id del detalle
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idPelicula, RedirectAttributes attributes) {
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
		//Primero eliminar la película
		servicePeliculas.eliminar(idPelicula);
		//Luego se eliminan los detalles
		serviceDetalles.eliminar(pelicula.getDetalle().getId());
		attributes.addFlashAttribute("mensaje", "Película eliminada");
		return "redirect:/peliculas/indexPaginate";
	}
	
	@ModelAttribute("generos")
	public List<String> getGeneros() {
		return servicePeliculas.buscarGeneros();
	}
	
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pelicula> lista = servicePeliculas.buscarTodas(page);
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
