package com.reposteria.service;

import com.reposteria.common.model.Venta;
import java.util.List;

public interface VentaService {
	List<Venta> listar();
	
	Venta obtener(int id);

	Venta guardar(Venta obj);

	void eliminar(int id);
	Venta actualizarParcialVenta(int id, Venta datosParciales);
	Venta actualizarVentaCompleta(int id, Venta ventaActualizada);
	void eliminarDetalleDeVenta(int idVenta, int idDetalle);
}