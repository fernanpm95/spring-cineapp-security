package fernando.learn.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fernando.learn.app.model.Banner;
import fernando.learn.app.model.Horario;
import fernando.learn.app.model.Noticia;
import fernando.learn.app.model.Pelicula;
import fernando.learn.app.service.IBannersService;
import fernando.learn.app.service.IHorariosService;
import fernando.learn.app.service.INoticiasService;
import fernando.learn.app.service.IPeliculasService;
import fernando.learn.app.util.Utils;

@Controller
public class HomeController {
	
	// Ejercicio: Inyectar clase de servicio de Banners
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IBannersService serviceBanners;
	
	@Autowired
	private IHorariosService serviceHorarios;
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		
		System.out.println("Buscando películas para la fecha: " + fecha);
		
		List<String> listaFechas = Utils.getNextDays(4);
		System.out.println(listaFechas);
		
		List<Pelicula> peliculas = null;
		try {
			Date f = dateFormat.parse(fecha);
			peliculas = servicePeliculas.buscarDisponibles(f);
			List<Banner> banners = serviceBanners.buscarTodos();
			
			List<Noticia> noticiasRecientes = serviceNoticias.getNoticiasRecientes();
			
			model.addAttribute("fechas", listaFechas);
			model.addAttribute("fechaBusqueda", fecha);
			model.addAttribute("peliculas", peliculas);
			model.addAttribute("noticiasRecientes", noticiasRecientes);
			
			// Ejercicio: agregar al modelo el listado de Banners para desplegarlo
			model.addAttribute("banners", banners);
		} catch (ParseException e) {
			System.out.println("Error: HomeController.mostrarPrincipal" + e.getMessage());
		}
		
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model){
		
		try {
			Date f = dateFormat.parse(dateFormat.format(new Date()));
			List<String> listaFechas = Utils.getNextDays(4);
			System.out.println(listaFechas);
			
			List<Pelicula> peliculas = servicePeliculas.buscarDisponibles(f);
			
			List<Banner> banners = serviceBanners.buscarTodos();
			
			List<Noticia> noticiasRecientes = serviceNoticias.getNoticiasRecientes();
			
			model.addAttribute("fechas", listaFechas);
			model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
			model.addAttribute("peliculas", peliculas);
			model.addAttribute("noticiasRecientes", noticiasRecientes);
			model.addAttribute("banners", banners);
		} catch (ParseException e) {
			System.out.println("Error: HomeController.mostrarPrincipal" + e.getMessage());
		}
		
		
		
//		peliculas.add("Fast and Furious");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens");
		
		
		// Ejercicio: agregar al modelo el listado de Banners para desplegarlo
		
		
		return "home";
	}
	
	//URL dinamicas con Pathvariable sobre todo en peticiones GET y webs restful, @Requestparam para forms con POST
	
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
//	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") Date fecha) {
//	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
		System.out.println("Buscando horarios para la película: " + idPelicula);
		System.out.println("En la fecha: " + fecha);
		
		List<Horario> horarios = serviceHorarios.buscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		// TO DO -- Buscar en la base de datos los horarios
		
//		String tituloPelicula = "Fast and Furious";
//		int duracion = 136;
//		double precioEntrada = 6;
//		
//		model.addAttribute("titulo", tituloPelicula);
//		model.addAttribute("duracion", duracion);
//		model.addAttribute("precio", precioEntrada);
		return "detalle";
	}
	
	@RequestMapping(value="/acerca", method = RequestMethod.GET)
	public String mostrarAcerca() {
		return "acerca";
	}
	
	@RequestMapping(value="/formLogin", method=RequestMethod.GET)
	public String mostrarLogin() {
		return "formLogin";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
