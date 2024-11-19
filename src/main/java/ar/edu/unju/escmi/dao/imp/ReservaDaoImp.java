package ar.edu.unju.escmi.dao.imp;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ar.edu.unju.escmi.conf.EmfSingleton;
import ar.edu.unju.escmi.dao.IReservaDao;
import ar.edu.unju.escmi.entities.Reserva;

public class ReservaDaoImp implements IReservaDao {
	private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public void realizarReserva(Reserva reserva) {
		try {
			manager.getTransaction().begin();
			manager.persist(reserva);
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
	public List<Reserva> consultarReservas() {
		TypedQuery<Reserva> query = manager.createQuery("Select l from Reserva l", Reserva.class);
		List<Reserva> reservas = query.getResultList();
		return reservas;
	}

	@Override
	public Reserva consultarReservaId(Long idcliente) {
		return manager.find(Reserva.class, idcliente);
	}

}
