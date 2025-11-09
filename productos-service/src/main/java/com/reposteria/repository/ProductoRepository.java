package com.reposteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reposteria.common.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	public List<Producto> findByTipoProducto(int tipoProducto);
}