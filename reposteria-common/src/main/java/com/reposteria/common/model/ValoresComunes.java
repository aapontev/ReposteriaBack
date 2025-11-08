package com.reposteria.common.model;

import jakarta.persistence.*;

@Entity
@Table(name = "valores_comunes")
public class ValoresComunes {
	@Id
	@Column(name = "id_valores_comunes")
	private Integer idValoresComunes;
	@Column(name = "cod_tabla")
	private String codTabla;
	private String clave1;
	private String clave2;
	private String valor1;
	private String valor2;

	public Integer getIdValoresComunes() {
		return idValoresComunes;
	}

	public void setIdValoresComunes(Integer v) {
		this.idValoresComunes = v;
	}

	public String getCodTabla() {
		return codTabla;
	}

	public void setCodTabla(String v) {
		this.codTabla = v;
	}

	public String getClave1() {
		return clave1;
	}

	public void setClave1(String v) {
		this.clave1 = v;
	}

	public String getClave2() {
		return clave2;
	}

	public void setClave2(String v) {
		this.clave2 = v;
	}

	public String getValor1() {
		return valor1;
	}

	public void setValor1(String v) {
		this.valor1 = v;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String v) {
		this.valor2 = v;
	}
}