package com.reposteria.service;

import com.reposteria.common.model.Ingrediente;
import java.util.List;

public interface IngredienteService {
	
	Ingrediente obtenerIngrediente(int id);
	List<Ingrediente> listar();
	Ingrediente guardar(Ingrediente obj);
	void eliminar(int id);
	List<Ingrediente> listarXUnidadMedida(int unidadMedida);
}