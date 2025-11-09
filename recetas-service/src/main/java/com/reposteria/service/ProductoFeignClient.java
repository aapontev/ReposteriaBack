package com.reposteria.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.reposteria.common.model.Producto;

@FeignClient(name = "productos") // "productos-service" es el nombre en Eureka
public interface ProductoFeignClient {
	
    @GetMapping("/api/productos/{id}")
    Producto obtenerProductoPorId(@PathVariable int id);
}