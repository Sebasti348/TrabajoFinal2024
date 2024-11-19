package ar.edu.unju.escmi.dao;

import java.util.List;

import ar.edu.unju.escmi.entities.ServiciosAdicionales;
 
public interface IServicioAdicionalDao {
	public void guardarServicioAdicional(ServiciosAdicionales servicioAdicional);

	public List<ServiciosAdicionales> consultarServicioAdicional();
	
	public ServiciosAdicionales consultarServicioAdicionalId(Long idcliente);
}
