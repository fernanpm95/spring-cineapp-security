package fernando.learn.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fernando.learn.app.model.Horario;
import fernando.learn.app.model.Pelicula;
import fernando.learn.app.repository.HorariosRepository;
import fernando.learn.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService {

	@Autowired
	private PeliculasRepository peliculasRepo;
	
	@Autowired
	private HorariosRepository horariosRepo;
	
	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
		
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return peliculasRepo.findAll();
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		Optional<Pelicula> optional = peliculasRepo.findById(idPelicula);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<String> buscarGeneros() {
		List<String> generos = new LinkedList<>();
		generos.add("Acción");
		generos.add("Aventura");
		generos.add("Clásicas");
		generos.add("Comedia Romántica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Acción y aventura");
		generos.add("Romántica");
		generos.add("Ciencia Ficción");
		return generos;
	}

	@Override
	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);
		
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		
		return peliculasRepo.findAll(page);
	}

	@Override
	public List<Pelicula> buscarDisponibles(Date fecha) {
		List <Pelicula> listaPeliculas = new LinkedList<>();
		List <Horario> listaHorarios = horariosRepo.findByFecha(fecha);
		for ( Horario h : listaHorarios) {
			listaPeliculas.add(h.getPelicula());
		}
		return listaPeliculas;
	}

}
