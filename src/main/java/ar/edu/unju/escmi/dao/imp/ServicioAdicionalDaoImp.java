package ar.edu.unju.escmi.dao.imp;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ar.edu.unju.escmi.conf.EmfSingleton;
import ar.edu.unju.escmi.dao.IServicioAdicionalDao;
import ar.edu.unju.escmi.entities.ServiciosAdicionales;

public class ServicioAdicionalDaoImp implements IServicioAdicionalDao {
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public void guardarServicioAdicional(ServiciosAdicionales servicioAdicional) {
		try {
			manager.getTransaction().begin();
			manager.persist(servicioAdicional);
			manager.getTransaction().commit();
		} catch (Exception e) {
			if (manager.getTransaction() != null) {
				manager.getTransaction().rollback();
			}
			System.out.println("No se pudo guardar el objeto ServicioAdicional");
		} finally {
			// manager.close();
		}

	}

	@Override
	public List<ServiciosAdicionales> consultarServicioAdicional() {
		TypedQuery<ServiciosAdicionales> query = manager.createQuery("Select l from ServiciosAdicionales l", ServiciosAdicionales.class);
		List<ServiciosAdicionales> serviciosAdicionales = query.getResultList();
		return serviciosAdicionales;
	}

	@Override
	public ServiciosAdicionales consultarServicioAdicionalId(Long idcliente) {
		return manager.find(ServiciosAdicionales.class, idcliente);
	}

}
