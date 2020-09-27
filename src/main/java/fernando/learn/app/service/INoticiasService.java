package fernando.learn.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fernando.learn.app.model.Noticia;

public interface INoticiasService {
	
	void guardar(Noticia noticia);
	
	List<Noticia> getNoticiasRecientes();
	
	void eliminar(int idNoticia);
	
	Page<Noticia> buscarTodas(Pageable page);
	
	Noticia buscarPorId(int idNoticia);
}
