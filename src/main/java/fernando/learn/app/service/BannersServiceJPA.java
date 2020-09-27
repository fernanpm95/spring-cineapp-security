package fernando.learn.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fernando.learn.app.model.Banner;
import fernando.learn.app.repository.BannersRepository;

@Service
public class BannersServiceJPA implements IBannersService {

	@Autowired
	BannersRepository bannersRepo;
	
	@Override
	public void insertar(Banner banner) {
		bannersRepo.save(banner);
		
	}

	@Override
	public Page<Banner> buscarTodos(Pageable page) {
		return bannersRepo.findAll(page);
	}

	@Override
	public void eliminar(int idBanner) {
		bannersRepo.deleteById(idBanner);
		
	}

	@Override
	public Banner buscarPorId(int idBanner) {
		Optional<Banner> optional = bannersRepo.findById(idBanner);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Banner> buscarTodos() {
		return bannersRepo.findAll();
	}

}
