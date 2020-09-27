package pruebasjparepo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import fernando.learn.app.repository.NoticiasRepository;

public class AppDeleteAllInBatch {
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// M�todo deleteAllInBatch de JpaRepository es m�s eficiente
		// Ejecuta "delete from Noticias" en vez de "delete from Noticias where id=?" varias veces (deleteAll)
		// Pocos registros da igual, para muchos s� es mejor
		
		repo.deleteAllInBatch();

		context.close();
	}

}
