package ar.edu.unju.escmi.dao;

import java.util.List;

import ar.edu.unju.escmi.entities.Cliente;
 
public interface IClienteDao {

	public void altaCliente(Cliente cliente);

	public void modificarCliente(Cliente cliente);
	
	public Cliente obtenerClienteId(Long idcliente);
	
	public List<Cliente> consultarClientes();

}
