package com.reposteria.controller;

import com.reposteria.common.model.ValoresComunes;
import com.reposteria.service.ValoresComunesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ValoresComunesController {
	@Autowired
	private ValoresComunesService service;

	@GetMapping
	public List<ValoresComunes> listar() {
		return service.listar();
	}
	
    @GetMapping("/{id}")
    public ValoresComunes obtenerValorComun(@PathVariable int id) {
        return service.obtenerValoresComun(id);
    }

    @GetMapping("/codTabla/{tabla}")
    public List<ValoresComunes> listarComunXCodTabla(@PathVariable String tabla) {
        return service.listarComunXCodTabla(tabla);
    }

    @GetMapping("/clave1/{tabla}/{id}")
    public List<ValoresComunes> listarComunXClave1(@PathVariable String tabla,@PathVariable String id) {
        return service.listarComunXClave1(tabla,id);
    }

	@PostMapping
	public ValoresComunes crear(@RequestBody ValoresComunes o) {
		return service.guardar(o);
	}
    
    @PutMapping("{id}")
    public ValoresComunes editarValorComun(@RequestBody ValoresComunes comunes,@PathVariable int id) {
    	ValoresComunes valoresComunesdb = service.obtenerValoresComun(id);
    	if(valoresComunesdb != null) {
    		valoresComunesdb.setCodTabla(comunes.getCodTabla());
    		valoresComunesdb.setClave1(comunes.getClave1());
    		valoresComunesdb.setClave2(comunes.getClave2());
    		valoresComunesdb.setValor1(comunes.getValor1());
    		valoresComunesdb.setValor2(comunes.getValor2());
    	}
        return service.guardar(valoresComunesdb);
    }
    
    @DeleteMapping("{id}")
    public void eliminarValorComun(@PathVariable int id) {
    	ValoresComunes valoresComunesdb = service.obtenerValoresComun(id);
    	if(valoresComunesdb != null) {
    		service.eliminar(valoresComunesdb.getIdValoresComunes());
    	}
    }
}