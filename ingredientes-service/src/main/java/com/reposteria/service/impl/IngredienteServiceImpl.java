package com.reposteria.service.impl;

import com.reposteria.common.model.Ingrediente;
import com.reposteria.repository.IngredienteRepository;
import com.reposteria.service.IngredienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredienteServiceImpl implements IngredienteService {
	
	@Autowired
	private IngredienteRepository repo;

	public List<Ingrediente> listar() {
		return repo.findAll();
	}

	public Ingrediente obtenerIngrediente(int id) {
		return repo.findById(id).get();
	}

	public Ingrediente guardar(Ingrediente o) {
		return repo.save(o);
	}

	public void eliminar(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<Ingrediente> listarXUnidadMedida(int unidadMedida) {
		return repo.findByUnidadMedida(unidadMedida);
	}

}