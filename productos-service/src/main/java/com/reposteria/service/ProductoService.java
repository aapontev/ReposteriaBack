package com.reposteria.service;

import com.reposteria.common.model.Producto;
import java.util.List;

public interface ProductoService {
	
	Producto obtener(int id);
	List<Producto> listar();
	List<Producto> listarXTipoProducto(int tipoProducto);
	Producto guardar(Producto obj);
	void eliminar(int id);
}