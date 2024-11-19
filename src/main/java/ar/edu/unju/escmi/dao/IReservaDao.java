package ar.edu.unju.escmi.dao;

import java.util.List;

import ar.edu.unju.escmi.entities.Reserva;
 
public interface IReservaDao {
	public void realizarReserva(Reserva reserva);

	public List<Reserva> consultarReservas();
	
	public Reserva consultarReservaId(Long idcliente);
}
