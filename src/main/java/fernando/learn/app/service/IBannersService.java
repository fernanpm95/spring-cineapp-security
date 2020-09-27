package fernando.learn.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fernando.learn.app.model.Banner;

public interface IBannersService {

	void insertar(Banner banner); 
	Page<Banner> buscarTodos(Pageable page);
	void eliminar(int idBanner);
	Banner buscarPorId(int idBanner);
	List<Banner> buscarTodos();
}