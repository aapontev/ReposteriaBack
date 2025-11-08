package com.reposteria.repository;

import com.reposteria.common.model.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	public List<Producto> findByTipoProducto(int tipoProducto);
}