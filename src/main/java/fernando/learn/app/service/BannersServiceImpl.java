package fernando.learn.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fernando.learn.app.model.Banner;

//@Service
public class BannersServiceImpl implements IBannersService {

	private List<Banner> lista = null; 
	/**
	 * En el constructor creamos una lista enlazada con objetos de tipo Banner
	 */
	public BannersServiceImpl() {
		
		// Ejercicio: Crear una nueva lista enlazada
		lista = new LinkedList<>();
		
		// Ejercicio: Crear algunos objetos de tipo Banner (estaticos)
		Banner banner1 = new Banner();
		banner1.setId(1);
		banner1.setTitulo("Banner 1");
		banner1.setArchivo("slide1.jpg");
		Banner banner2 = new Banner();
		banner2.setId(2);
		banner2.setTitulo("Banner 2");
		banner2.setArchivo("slide2.jpg");
		Banner banner3 = new Banner();
		banner3.setId(3);
		banner3.setTitulo("Banner 3");
		banner3.setArchivo("slide3.jpg");
			
		// Ejercicio: Agregar los objetos Banner a la lista
		lista.add(banner1);
		lista.add(banner2);
		lista.add(banner3);
		
	}

	/**
	 * Insertamos un objeto de tipo Banner a la lista
	 */
	@Override
	public void insertar(Banner banner) {
		
		// Ejercicio: Implementar metodo
		lista.add(banner);
		
	}



	@Override
	public Page<Banner> buscarTodos(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int idBanner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Banner buscarPorId(int idBanner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banner> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
