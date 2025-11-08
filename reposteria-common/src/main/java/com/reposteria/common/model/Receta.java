package com.reposteria.common.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "recetas")
public class Receta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_receta")
	private Integer idReceta;

	private String nombre;

	private String descripcion;

	@Column(name = "tiempo_prep")
	private Integer tiempoPrep;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;

	@OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RecetaPaso> pasos;

	@OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RecetaIngrediente> ingredientes;

	public Integer getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(Integer v) {
		this.idReceta = v;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String v) {
		this.nombre = v;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String v) {
		this.descripcion = v;
	}

	public Integer getTiempoPrep() {
		return tiempoPrep;
	}

	public void setTiempoPrep(Integer v) {
		this.tiempoPrep = v;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<RecetaPaso> getPasos() {
		return pasos;
	}

	public void setPasos(List<RecetaPaso> pasos) {
		this.pasos = pasos;
	}

	public List<RecetaIngrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<RecetaIngrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

}