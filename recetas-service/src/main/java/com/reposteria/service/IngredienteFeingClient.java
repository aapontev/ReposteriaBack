package com.reposteria.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.reposteria.common.model.Ingrediente;

@FeignClient(name = "ingredientes")
public interface IngredienteFeingClient {

    @GetMapping("/api/ingredientes/{id}")
    Ingrediente obtenerIngredientePorId(@PathVariable int id);
}
