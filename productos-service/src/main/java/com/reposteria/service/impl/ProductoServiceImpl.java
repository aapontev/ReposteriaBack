package com.reposteria.service.impl;

import com.reposteria.common.model.Producto;
import com.reposteria.repository.ProductoRepository;
import com.reposteria.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repo;

	@Override
	public List<Producto> listar() {
		return repo.findAll();
	}

	@Override
	public Producto guardar(Producto o) {
		return repo.save(o);
	}

	@Override
	public void eliminar(int id) {
		repo.deleteById(id);
	}

	@Override
	public Producto obtener(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Producto> listarXTipoProducto(int tipoProducto) {
		return repo.findByTipoProducto(tipoProducto);
	}
}