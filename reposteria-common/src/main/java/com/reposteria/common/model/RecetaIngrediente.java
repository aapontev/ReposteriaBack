package com.reposteria.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "receta_ingrediente")
public class RecetaIngrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_receta_ingrediente")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_receta")
	@JsonIgnore
	private Receta receta;
	@ManyToOne
	@JoinColumn(name = "id_ingrediente")
	private Ingrediente ingrediente;
	private Double cantidad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer v) {
		this.id = v;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta r) {
		this.receta = r;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente i) {
		this.ingrediente = i;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double v) {
		this.cantidad = v;
	}
}