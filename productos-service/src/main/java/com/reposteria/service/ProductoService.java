package com.reposteria.service;

import java.util.List;

import com.reposteria.common.model.Producto;

public interface ProductoService {

	Producto obtener(int id);
	List<Producto> listar();
	List<Producto> listarXTipoProducto(int tipoProducto);
	Producto guardar(Producto obj);
	void eliminar(int id);
}