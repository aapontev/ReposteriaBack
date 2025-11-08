package com.reposteria.common.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle")
	private Integer idDetalle;
	@ManyToOne
	@JoinColumn(name = "id_venta")
	private Venta venta;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	private Integer cantidad;
	private Double subtotal;

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer v) {
		this.idDetalle = v;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta v) {
		this.venta = v;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto p) {
		this.producto = p;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer v) {
		this.cantidad = v;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double v) {
		this.subtotal = v;
	}
}