package ar.edu.unju.escmi.entities;
 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique = true, length = 20)
	private String dni;
	@Column(nullable = false, length = 50)
	private String nombre;
	@Column(nullable = false, length = 50)
	private String apellido;
	@Column(length = 100)
	private String domicilio;
	@Column(length = 15)
	private String telefono;
	@Column(nullable = false)
	private boolean estado;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Reserva> reservas;
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String dni, String nombre, String apellido, String domicilio, String telefono, boolean estado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void mostrarDatos() {
		System.out.println("Id: " + this.id + "				║");
		System.out.println("Nombre: " + this.nombre + "			║");
		System.out.println("Apellido: " + this.apellido + "		║");
		System.out.println("DNI: " + this.dni + "			║");
		System.out.println("Domicilio: " + this.domicilio + "	║");
		System.out.println("Teléfono: " + this.telefono+"		║");
		System.out.println("Estado: " + (this.estado ? "Activo" : "Inactivo")+"			║");
		System.out.println("════════════════════════════════╝");
	}

}
