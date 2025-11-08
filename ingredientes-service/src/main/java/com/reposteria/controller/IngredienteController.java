package com.reposteria.controller;

import com.reposteria.common.model.Ingrediente;
import com.reposteria.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class IngredienteController {
	
	@Autowired
	private IngredienteService service;

	@GetMapping
	public List<Ingrediente> listar() {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Ingrediente obtener(@PathVariable int id) {
		return service.obtenerIngrediente(id);
	}
	
	@GetMapping("/unidadMedida/{unidad}")
	public List<Ingrediente> listarXUnidadMedida(@PathVariable int unidad) {
		return service.listarXUnidadMedida(unidad);
	}

	@PostMapping
	public Ingrediente crear(@RequestBody Ingrediente o) {
		return service.guardar(o);
	}
	

    @PutMapping("/{id}")
    public Ingrediente editarIngrediente(@RequestBody Ingrediente ingrediente,@PathVariable int id) {
    	Ingrediente ingredientedb = service.obtenerIngrediente(id);
    	if(ingredientedb != null) {
    		ingredientedb.setNombre(ingrediente.getNombre());
    		ingredientedb.setUnidadMedida(ingrediente.getUnidadMedida());
    		ingredientedb.setStock(ingrediente.getStock());
    		ingredientedb.setCostoUnitario(ingrediente.getCostoUnitario());
    	}
        return service.guardar(ingredientedb);
    }

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
}