package com.reposteria.service.impl;

import com.reposteria.common.model.DetalleVenta;
import com.reposteria.common.model.Producto;
import com.reposteria.common.model.Venta;
import com.reposteria.repository.VentaRepository;
import com.reposteria.service.VentaService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {
	
	@Autowired
	private VentaRepository repo;

	public List<Venta> listar() {
		return repo.findAll();
	}

	@Transactional
	public Venta guardar(Venta o) {
		double total = 0.0;
		o.setFecha(new Date());

        if (o.getDetalles() != null) {
            for (DetalleVenta detalle : o.getDetalles()) {
                detalle.setVenta(o);

                Producto producto = detalle.getProducto();
                if (producto != null && producto.getPrecio() != null && detalle.getCantidad() != null) {
                    double subtotal = producto.getPrecio() * detalle.getCantidad();
                    detalle.setSubtotal(subtotal);
                    total += subtotal;
                }
            }
            o.setTotal(total);
        }
		return repo.save(o);
	}

	public void eliminar(int id) {
		repo.deleteById(id);
	}

	@Override
	public Venta obtener(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	
	// 🟡 ACTUALIZAR COMPLETA: reemplaza toda la venta y sus detalles
    @Transactional
    public Venta actualizarVentaCompleta(int id, Venta ventaActualizada) {
        Venta ventaExistente = repo.findById(id).get();

        // Actualiza datos básicos
        ventaExistente.setFecha(ventaActualizada.getFecha());

        // Limpiar los detalles anteriores
        ventaExistente.getDetalles().clear();

        double total = 0.0;
        List<DetalleVenta> nuevosDetalles = new ArrayList<>();

        if (ventaActualizada.getDetalles() != null) {
            for (DetalleVenta detalle : ventaActualizada.getDetalles()) {
                detalle.setVenta(ventaExistente);
                Producto producto = detalle.getProducto();

                if (producto != null && producto.getPrecio() != null && detalle.getCantidad() != null) {
                    double subtotal = producto.getPrecio() * detalle.getCantidad();
                    detalle.setSubtotal(subtotal);
                    total += subtotal;
                }

                nuevosDetalles.add(detalle);
            }
        }

        ventaExistente.setDetalles(nuevosDetalles);
        ventaExistente.setTotal(total);

        return repo.save(ventaExistente);
    }

    // 🟠 ACTUALIZAR PARCIAL: modifica solo campos o detalles sin borrar todo
    @Transactional
    public Venta actualizarParcialVenta(int id, Venta datosParciales) {
        Venta ventaExistente = repo.findById(id).get();

        if (datosParciales.getFecha() != null)
            ventaExistente.setFecha(datosParciales.getFecha());

        double total = 0.0;

        // Si vienen nuevos detalles, los agregamos sin borrar los anteriores
        if (datosParciales.getDetalles() != null && !datosParciales.getDetalles().isEmpty()) {
            for (DetalleVenta detalle : datosParciales.getDetalles()) {
                detalle.setVenta(ventaExistente);

                Producto producto = detalle.getProducto();
                if (producto != null && producto.getPrecio() != null && detalle.getCantidad() != null) {
                    double subtotal = producto.getPrecio() * detalle.getCantidad();
                    detalle.setSubtotal(subtotal);
                    total += subtotal;
                }

                ventaExistente.getDetalles().add(detalle);
            }
        } else {
            // Si no se envían nuevos detalles, mantener el total actual
            total = ventaExistente.getDetalles().stream()
                    .mapToDouble(d -> d.getSubtotal() != null ? d.getSubtotal() : 0.0)
                    .sum();
        }

        ventaExistente.setTotal(total);

        return repo.save(ventaExistente);
    }
    
    @Transactional
    public void eliminarDetalleDeVenta(int idVenta, int idDetalle) {
        Venta venta = repo.findById(idVenta).get();

        venta.getDetalles().removeIf(detalle -> detalle.getIdDetalle().equals(idDetalle));

        // Recalcular total después de eliminar el detalle
        double nuevoTotal = venta.getDetalles().stream()
                .mapToDouble(d -> d.getSubtotal() != null ? d.getSubtotal() : 0.0)
                .sum();

        venta.setTotal(nuevoTotal);

        repo.save(venta);
    }
}