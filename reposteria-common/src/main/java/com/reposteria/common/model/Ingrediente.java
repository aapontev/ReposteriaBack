package com.reposteria.common.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingrediente")
	private Integer idIngrediente;
	
	private String nombre;
	
	@Column(name = "unidad_medida")
	private Integer unidadMedida;
	
	private Double stock;
	
	@Column(name = "costo_unitario")
	private Double costoUnitario;
	
	public Integer getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(Integer unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public Double getStock() {
		return stock;
	}
	public void setStock(Double stock) {
		this.stock = stock;
	}
	public Double getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(Double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	
}