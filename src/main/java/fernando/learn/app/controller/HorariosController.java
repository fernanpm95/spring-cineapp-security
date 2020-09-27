package fernando.learn.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fernando.learn.app.model.Horario;
import fernando.learn.app.model.Pelicula;
import fernando.learn.app.service.IHorariosService;
import fernando.learn.app.service.IPeliculasService;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IHorariosService serviceHorarios;
	
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model, Pageable page) {
		Page<Horario> listaHorarios = serviceHorarios.bustarTodos(page);
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}
		
	/**
	 * Metodo para mostrar el formulario para crear un nuevo horario
	 * @return
	 */
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario horario, Model model) {
		
		// Ejercicio: Recuperar lista de peliculas para poblar <select>
		List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
				
		// Ejercicio: agregar al modelo listado de peliculas
		model.addAttribute("peliculas", listaPeliculas);
		
		// Ejercicio: crear archivo formHorario.jsp y configurar el diseño utilizando el codigo HTML
		// del archivo formHorario.html de la plantilla (utilizar Form Tag Library)
		
		return "horarios/formHorario";
	}
		
	/**
	 * Metodo para guardar el registro del Horario
	 * @param horario
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario, Model model, BindingResult result, RedirectAttributes attributes) {				
		
		// Ejercicio: Verificar si hay errores en el Data Binding
		if (result.hasErrors()) {
			List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}
		
		// Ejercicio: En caso de no haber errores, imprimir en consola el objeto de model Horario 
		// que ya debera de tener los datos del formulario
		//System.out.println("Horario recibido: " + horario);
		serviceHorarios.guardar(horario);
		
		attributes.addFlashAttribute("mensaje", "Horario guardado correctamente");
				
		// De momento, hacemos un redirect al mismo formulario 
		return "redirect:/horarios/index";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idHorario, Model model) {
		Horario horario = serviceHorarios.buscarPorId(idHorario);
		model.addAttribute("horario", horario);
		
		return "horarios/formHorario";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idHorario, RedirectAttributes attributes) {
		serviceHorarios.eliminar(idHorario);
		
		attributes.addFlashAttribute("mensaje", "Horario eliminado");
		
		return "redirect:/horarios/index";
	}
	
	@ModelAttribute("peliculas")
	public List<Pelicula> buscarPeliculas(){
		List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
		return listaPeliculas;
	}
	
	// Ejercicio: Crear metodo para personalizar el Data Binding para las todas las propiedades de tipo Date
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
	}
}
	