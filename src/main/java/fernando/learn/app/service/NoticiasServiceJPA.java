package fernando.learn.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fernando.learn.app.model.Noticia;
import fernando.learn.app.repository.NoticiasRepository;

@Service
public class NoticiasServiceJPA implements INoticiasService {

	@Autowired
	private NoticiasRepository noticiasRepo;
	
	@Override
	public void guardar(Noticia noticia) {
		noticiasRepo.save(noticia);
		
	}

	@Override
	public List<Noticia> getNoticiasRecientes() {
		return noticiasRepo.findTop3ByEstatusOrderByFechaDesc("Activa");
	}

	@Override
	public void eliminar(int idNoticia) {
		noticiasRepo.deleteById(idNoticia);
		
	}

	@Override
	public Page<Noticia> buscarTodas(Pageable page) {
		Page<Noticia> noticias = noticiasRepo.findAll(page);
		return noticias;
	}

	@Override
	public Noticia buscarPorId(int idNoticia) {
		Optional<Noticia> optional = noticiasRepo.findById(idNoticia);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
