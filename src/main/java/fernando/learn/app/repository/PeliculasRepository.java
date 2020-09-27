package fernando.learn.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fernando.learn.app.model.Pelicula;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer> {
	
	List<Pelicula> findByEstatusAndFechaEstreno(String estatus, Date fecha);

}
