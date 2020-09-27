package fernando.learn.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fernando.learn.app.model.Horario;

public interface IHorariosService {
	List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha);
	
	Page<Horario> bustarTodos(Pageable page);
	
	Horario buscarPorId(int idHorario);
	
	void guardar(Horario horario);
	
	void eliminar(int idHorario);
}
