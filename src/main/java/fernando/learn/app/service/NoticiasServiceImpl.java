package fernando.learn.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fernando.learn.app.model.Noticia;

//@Service
public class NoticiasServiceImpl implements INoticiasService {

	public NoticiasServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void guardar(Noticia noticia) {
		System.out.println("Guardando noticia..." + noticia);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Noticia> getNoticiasRecientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int noticia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Noticia> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Noticia buscarPorId(int idNoticia) {
		// TODO Auto-generated method stub
		return null;
	}

}
