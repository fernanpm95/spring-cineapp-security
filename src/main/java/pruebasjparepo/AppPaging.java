package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import fernando.learn.app.model.Noticia;
import fernando.learn.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

//		//Obtener las entidades por paginaci�n
//		Page<Noticia> page = repo.findAll(PageRequest.of(0, 5));
		
		//Obtener las entidades por paginaci�n
		Page<Noticia> page = repo.findAll(PageRequest.of(0, 10, Sort.by("titulo")));
		
		for(Noticia n : page) {
			System.out.println(n);
		}
		
		context.close();
	}

}