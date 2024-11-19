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

import ar.edu.unju.escmi.dao.imp.SalonDaoImp;

@Entity
@Table(name = "Salones")
public class Salon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 50,unique = true)
	private String nombre;
	@Column(length = 3)
	private int capacidad;
	@Column(nullable = false)
	private boolean pileta;
	@Column(nullable = false)
	private double precio;
	@OneToMany(mappedBy = "salon", cascade = CascadeType.ALL)
	private List<Reserva> reservas;

	public Salon() {
		// TODO Auto-generated constructor stub
	}

	public Salon(String nombre, int capacidad, boolean pileta, double precio) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.pileta = pileta;
		this.precio = precio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isPileta() {
		return pileta;
	}

	public void setPileta(boolean pileta) {
		this.pileta = pileta;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void mostrarDatos() {

		System.out.println("Id: " + this.id);
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Capacidad: " + this.capacidad);
		System.out.println("Con pileta: " + (this.pileta ? "SI" : "NO"));
		System.out.println("Precio: " + this.precio);
		System.out.println("════════════════════════════════╝");

	}
	
}
