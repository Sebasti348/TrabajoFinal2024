package ar.edu.unju.escmi.dao;

import java.util.List;

import ar.edu.unju.escmi.entities.Salon;
 
public interface ISalonDao {
	public void guardarSalon(Salon salon);

	public List<Salon> consultarSalones();

	public Salon obtenerSalonId(Long idcliente);

}
