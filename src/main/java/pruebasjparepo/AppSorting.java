package pruebasjparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import fernando.learn.app.model.Noticia;
import fernando.learn.app.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

//		//Obtener entidades ordenadas por un campo
//		List<Noticia> lista = repo.findAll(Sort.by("titulo").descending());
		
		//Obtener entidades ordenadas por dos campos
		List<Noticia> lista = repo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo")));
		
		for (Noticia n : lista) {
			System.out.println(n);
		}
		
		context.close();
	}

}
