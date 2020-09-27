package pruebasjparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fernando.learn.app.model.Noticia;
import fernando.learn.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
// Obtener todas las entidades
		List<Noticia> lista = repo.findAll();
		for (Noticia n : lista) {
			System.out.println(n);
		}
		
		context.close();
	}

}
