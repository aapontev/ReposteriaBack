package com.reposteria.common.model;

//import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer idProducto;
	
	private String nombre;
	
	private Double precio;
	
	@Column(name = "tipo_producto")
	private Integer tipoProducto;
	
	private String descripcion;
	
	@Column(name = "imagen_url")
	private String imagenUrl;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer id) {
		this.idProducto = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String n) {
		this.nombre = n;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double p) {
		this.precio = p;
	}

	public Integer getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(Integer tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}	
	
}