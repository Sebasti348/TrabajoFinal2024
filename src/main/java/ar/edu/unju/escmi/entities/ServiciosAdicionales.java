package ar.edu.unju.escmi.entities;

import java.util.List; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ServiciosAdicionales")
public class ServiciosAdicionales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 250)
	private String descripcion;
	@Column(nullable = false)
	private double precio;
	@Column(nullable = false)
	private boolean estado;
    @ManyToMany(mappedBy = "serviciosAdicionales") 
    private List<Reserva> reservas;
	public ServiciosAdicionales() {
		// TODO Auto-generated constructor stub
	}

	public ServiciosAdicionales(String descripcion, double precio, boolean estado) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void mostrarDatos() {
		System.out.println("Id: " + this.id);
		System.out.println("Descripcion: " + this.descripcion);
		System.out.println("Precio: " + this.precio);
		System.out.println("Estado: " + (estado ? "Disponible" : "No disponible"));
		System.out.println("════════════════════════════════╝");
	}

}
