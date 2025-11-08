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
	
	//@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Receta> recetas;

	@Column(name = "imagen_url")
	private String imagenUrl;
	
	public String getIdImagen() {
		return imagenUrl;
	}

	public void setIdImagen(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

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
	
}