package com.reposteria.controller;

import com.reposteria.common.model.Venta;
import com.reposteria.service.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class VentaController {
	
	@Autowired
	private VentaService service;


	@GetMapping("{id}")
	public Venta obtener(@PathVariable int id) {
		return service.obtener(id);
	}
	
	@GetMapping
	public List<Venta> listar() {
		return service.listar();
	}

	@PostMapping
	public Venta crear(@RequestBody Venta o) {
		return service.guardar(o);
	}

	@DeleteMapping("{id}")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
	@PutMapping("/{id}")
	public Venta actualizarCompleta(@PathVariable int id, @RequestBody Venta venta) {
	    return service.actualizarVentaCompleta(id, venta);
	}

	@PatchMapping("/{id}")
	public Venta actualizarParcial(@PathVariable int id, @RequestBody Venta venta) {
	    return service.actualizarParcialVenta(id, venta);
	}
	@DeleteMapping("/{idVenta}/detalles/{idDetalle}")
	public void eliminarDetalle(@PathVariable int idVenta, @PathVariable int idDetalle) {
	    service.eliminarDetalleDeVenta(idVenta, idDetalle);
	}
}