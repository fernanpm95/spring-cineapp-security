package fernando.learn.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fernando.learn.app.model.Noticia;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {

	//Para pruebas
	List<Noticia> findByEstatus(String estatus);
	
	List<Noticia> findByFecha(Date fecha);
	
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);
	
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);

	List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);
	
	//Para web final
	List<Noticia> findTop3ByEstatusOrderByFechaDesc(String estatus);
	
}
