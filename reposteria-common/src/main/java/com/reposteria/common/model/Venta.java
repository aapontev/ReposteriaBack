package com.reposteria.common.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venta")
	private Integer idVenta;
	
	private Date fecha;
	
	private Double total;
	
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleVenta> detalles;

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer v) {
		this.idVenta = v;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date v) {
		this.fecha = v;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double v) {
		this.total = v;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}
	
	
}