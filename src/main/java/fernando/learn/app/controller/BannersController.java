package fernando.learn.app.controller;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fernando.learn.app.model.Banner;
import fernando.learn.app.service.IBannersService;
import fernando.learn.app.util.Utils;

@Controller
@RequestMapping("/banners/")
public class BannersController {
	// Ejercicio: Inyectar instancia de la clase de servicio
	@Autowired
	IBannersService serviceBanner;
	
		/**
		 * Metodo para mostrar el listado de banners
		 * @param model
		 * @return
		 */
		@GetMapping("/index")
		public String mostrarIndex(Model model, Pageable page) {
			
			// Ejercicio: Implementar metodo
			Page<Banner> lista = serviceBanner.buscarTodos(page);
			model.addAttribute("banners", lista);
			
			// Ejercicio: Crear vista listBanners.jsp. Utilizar el archivo listBanners.html de la plantilla 
			return "banners/listBanners";
		}
		
		@GetMapping("/edit/{id}")
		public String editar(@PathVariable("id") int idBanner, Model model) {
			Banner banner = serviceBanner.buscarPorId(idBanner);
			model.addAttribute("banner", banner);
			return "banners/formBanner";
		}
		
		@GetMapping("delete/{id}")
		public String eliminar(@PathVariable("id") int idBanner, RedirectAttributes attributes) {
			serviceBanner.eliminar(idBanner);
			attributes.addFlashAttribute("mensaje", "Banner eliminado");
			return "redirect:/banners/index";
		}
		
		/**
		 * Metodo para mostrar el formulario para crear un nuevo Banner
		 * @return
		 */
		@GetMapping("/create")
		public String crear(@ModelAttribute Banner banner) {
			
			// Ejercicio: Crear vista formBanner.jsp. Utilizar el archivo formBanner.html de la plantilla 
			return "banners/formBanner";
			
		}
		
		/**
		 * Metodo para guardar el objeto de modelo de tipo Banner
		 * @return
		 */
		@PostMapping("/save")
		public String guardar(Banner banner, BindingResult result, RedirectAttributes attributes,
				@RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request ) {
			
			// Ejercicio: Implementar el metodo.
			if (result.hasErrors()) {
				System.out.println("Errores al guardar el banner");
				return "banners/formBanner";
			}
			if (!multipart.isEmpty()) {
				String nombreImagen = Utils.guardarImagen(multipart, request);
				banner.setArchivo(nombreImagen);
			}
			System.out.println("Recibiendo banner: " + banner);
			serviceBanner.insertar(banner);
			attributes.addFlashAttribute("mensaje", "Banner guardado correctamente");

			return "redirect:/banners/index";
		}	
	}
