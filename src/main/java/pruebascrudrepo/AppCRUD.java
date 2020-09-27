package pruebascrudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fernando.learn.app.model.Noticia;
import fernando.learn.app.repository.NoticiasRepository;

//Aplicación para persistir (crear) en la tabla Noticias un objeto de tipo Noticia 
public class AppCRUD {

	public static void main(String[] args) {

//		Noticia noticia = new Noticia();
//		noticia.setTitulo("Título de la segunda noticia");
//		noticia.setDetalle("Detalles específicos para explicar la segunda noticia creada");
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Recuperar varios registros por Id
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(2);
		ids.add(5);
		ids.add(8);
		
		Iterable<Noticia> it = repo.findAllById(ids);
		for(Noticia n : it) {
			System.out.println(n);
		}
		
		
//		// Borrar todos los registros (deleteAll). Es peligroso
//		repo.deleteAll();
		
		
//		//Recuperar todos los registros
//		Iterable<Noticia> it = repo.findAll();
//		for(Noticia n : it) {
//			System.out.println(n);
//		}
		
//		// Contar registros de una tabla (count())
//		long num = repo.count();
//		System.out.println("Se encontraron " + num + " registros");
		
		
//		//CRUD - Delete
//		int idNoticia = 342;
//		if(repo.existsById(idNoticia)) {
//			repo.deleteById(idNoticia);
//		}
		
		
//		// Método para verificar si una entidad existe en la BD (existsById)
//		int idNoticia = 1;
//		System.out.println(repo.existsById(idNoticia));
		
		
//		// CRUD - Update
//		//1-Buscar entidad a modificar
//		Optional<Noticia> optional = repo.findById(1);
//		
//		//2-Modificar y guardar entidad
//		if(optional.isPresent()) {
//			Noticia noticia = optional.get();
//			noticia.setEstatus("Inactiva");
//			//Si Spring detecta que el valor del id!=0 realiza un Update, si es =0 realiza un insert
//			repo.save(noticia);
//		}
		
		
//		// CRUD - Read
//		//Optional: si no se encuentra el registro, evita la excepción null
//		Optional<Noticia> noticia = repo.findById(1);
//		//Con get se recupera el objeto de tipo Noticia en lugar de recuperarlo tipo Optional
//		System.out.println(noticia.get());
		
//		// CRUD - Save
//		repo.save(noticia);
		
		context.close();
	}

}
