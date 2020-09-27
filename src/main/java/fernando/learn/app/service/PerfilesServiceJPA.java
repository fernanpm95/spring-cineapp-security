package fernando.learn.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fernando.learn.app.model.Perfil;
import fernando.learn.app.repository.PerfilesRepository;

@Service
public class PerfilesServiceJPA implements IPerfilesService{

	@Autowired
	private PerfilesRepository perfilesRepo;
	
	@Override
	public void guardar(Perfil perfil) {
		// TODO Auto-generated method stub
		perfilesRepo.save(perfil);
	}

}
