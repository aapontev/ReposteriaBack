package com.reposteria.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "receta_pasos")
public class RecetaPaso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_receta_pasos")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_receta")
	@JsonIgnore
	private Receta receta;
	@Column(name = "nro_paso")
	private Integer nroPaso;
	@Column(name = "detalle_paso")
	private String detallePaso;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Receta getReceta() {
		return receta;
	}
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	public Integer getNroPaso() {
		return nroPaso;
	}
	public void setNroPaso(Integer nroPaso) {
		this.nroPaso = nroPaso;
	}
	public String getDetallePaso() {
		return detallePaso;
	}
	public void setDetallePaso(String detallePaso) {
		this.detallePaso = detallePaso;
	}
	
	
}
