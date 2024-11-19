package ar.edu.unju.escmi.dao.imp;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ar.edu.unju.escmi.conf.EmfSingleton;
import ar.edu.unju.escmi.dao.ISalonDao;
import ar.edu.unju.escmi.entities.Salon;

public class SalonDaoImp implements ISalonDao {
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public void guardarSalon(Salon salon) {
		
		try {
			manager.getTransaction().begin();
			manager.persist(salon);
			manager.getTransaction().commit();
		} catch (Exception e) {
			if (manager.getTransaction() != null) {
				manager.getTransaction().rollback();
			}
			System.out.println("No se pudo guardar el objeto Salon");
		} finally {
			// manager.close();
		}

	}

	@Override
	public List<Salon> consultarSalones() {
		TypedQuery<Salon> query = manager.createQuery("Select l from Salon l", Salon.class);
		List<Salon> salones = query.getResultList();
		return salones;
	}

	@Override
	public Salon obtenerSalonId(Long idcliente) {
		return manager.find(Salon.class, idcliente);
	}
	
	
	

}
