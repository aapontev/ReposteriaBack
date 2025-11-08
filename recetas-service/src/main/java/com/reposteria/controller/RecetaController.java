package com.reposteria.controller;

import com.reposteria.common.model.Receta;
import com.reposteria.service.RecetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RecetaController {
	@Autowired
	private RecetaService recetaService;

    @GetMapping
    public ResponseEntity<List<Receta>> listar() {
        return ResponseEntity.ok(recetaService.listarRecetas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receta> obtener(@PathVariable int id) {
        return ResponseEntity.ok(recetaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Receta> crear(@RequestBody Receta receta) {
        return ResponseEntity.ok(recetaService.crearReceta(receta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receta> actualizar(@PathVariable int id, @RequestBody Receta receta) {
        return ResponseEntity.ok(recetaService.actualizarReceta(id, receta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        recetaService.eliminarReceta(id);
        return ResponseEntity.ok("Receta eliminada correctamente.");
    }
}