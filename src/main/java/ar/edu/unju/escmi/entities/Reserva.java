package ar.edu.unju.escmi.entities;
 
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reservas")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "salon_id", nullable = false)
	private Salon salon;
	@Column(nullable = false)
	private LocalDate fecha;
	@Column(nullable = false)
	private LocalTime hs_inicio;
	@Column(nullable = false)
	private LocalTime hs_fin;
	@Column(nullable = false)
	private double monto_pagado;
    @ManyToMany
    @JoinTable(
        name = "Reserva_ServiciosAdicionales",
        joinColumns = @JoinColumn(name = "reserva_id"), 
        inverseJoinColumns = @JoinColumn(name = "servicio_id") 
    )
    private List<ServiciosAdicionales> serviciosAdicionales;
	@Column(nullable = false)
	private double pago_adelantado;
	@Column(nullable = false)
	private boolean cancelado;
	@Column(nullable = false)
	private boolean estado;

	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	

	public Reserva(Cliente cliente, Salon salon, LocalDate fecha, LocalTime hs_inicio, LocalTime hs_fin,
			double monto_pagado, List<ServiciosAdicionales> serviciosAdicionales, double pago_adelantado,
			boolean cancelado, boolean estado) {
		super();
		this.cliente = cliente;
		this.salon = salon;
		this.fecha = fecha;
		this.hs_inicio = hs_inicio;
		this.hs_fin = hs_fin;
		this.monto_pagado = monto_pagado;
		this.serviciosAdicionales = serviciosAdicionales;
		this.pago_adelantado = pago_adelantado;
		this.cancelado = cancelado;
		this.estado = estado;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHs_inicio() {
		return hs_inicio;
	}

	public void setHs_inicio(LocalTime hs_inicio) {
		this.hs_inicio = hs_inicio;
	}

	public LocalTime getHs_fin() {
		return hs_fin;
	}

	public void setHs_fin(LocalTime hs_fin) {
		this.hs_fin = hs_fin;
	}

	public double getMonto_pagado() {
		return monto_pagado;
	}

	public void setMonto_pagado(double monto_pagado) {
		this.monto_pagado = monto_pagado;
	}

	

	public List<ServiciosAdicionales> getServiciosAdicionales() {
		return serviciosAdicionales;
	}



	public void setServiciosAdicionales(List<ServiciosAdicionales> serviciosAdicionales) {
		this.serviciosAdicionales = serviciosAdicionales;
	}



	public double getPago_adelantado() {
		return pago_adelantado;
	}

	public void setPago_adelantado(double pago_adelantado) {
		this.pago_adelantado = pago_adelantado;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public double calcularCostoHorarioExtendido() {
	    Duration duracionExtra = Duration.between(hs_inicio, hs_fin);
	    long horasExtras = duracionExtra.toHours() - 4; 
	    return horasExtras * 10000;
	}

	public double calcularMontoTotal() {
		double total = 0;
		for (ServiciosAdicionales servicioAdicional : this.serviciosAdicionales) {
			total = total + servicioAdicional.getPrecio();
		}
		return total + calcularCostoHorarioExtendido() + this.salon.getPrecio();
	}

	public double calcularPagoPendiente() {
		return calcularMontoTotal() - this.monto_pagado - this.pago_adelantado;
	}

	public void mostrarDatos() {
		System.out.println("ID: " + this.id);		
		System.out.println("Cliente: " + this.cliente.getNombre());
		System.out.println("Salón: " + this.salon.getNombre());
		System.out.println("Fecha: " + this.fecha);
		System.out.println("Hora de Inicio: " + this.hs_inicio);
		System.out.println("Hora de Fin: " + this.hs_fin);
		System.out.println("Servicios Adicionales: " );
		for(ServiciosAdicionales serviciosAdicionales : this.serviciosAdicionales) {
			System.out.println(serviciosAdicionales.getDescripcion());
		}
		System.out.println("Cancelado: " + (cancelado ? "CANCELADO" : "PAGO PENDIENTE"));
		System.out.println("Estado: " + this.estado);
		System.out.println("Monto Pagado: " + this.monto_pagado);
		System.out.println("Pago Adelantado: " + this.pago_adelantado);
	}

}
