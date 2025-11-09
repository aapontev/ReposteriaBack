package com.reposteria.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.reposteria.common.model.Producto;
import com.reposteria.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService service;

	// Define la ruta donde se guardarán tus imágenes
	private final String UPLOAD_DIR = "D:/reposteria-uploads/images/";

	@PostMapping("/image")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Archivo vacío"));
        }

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
            String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;

            Path filePath = uploadPath.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // La URL pública sigue siendo la misma (esto está bien)
            String fileUrl = "/api/productos/images/" + uniqueFileName;

            return ResponseEntity.ok(Map.of("url", fileUrl));

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("error", "No se pudo guardar el archivo"));
        }
    }

	@GetMapping("/{id}")
	public Producto obtener(@PathVariable int id) {
		return service.obtener(id);
	}

	@GetMapping
	public List<Producto> listar() {
		return service.listar();
	}

	@GetMapping("/tipoProducto/{tipoProducto}")
	public List<Producto> listarXTipoProducto(@PathVariable int tipoProducto) {
		return service.listarXTipoProducto(tipoProducto);
	}

	@PostMapping
	public Producto crear(@RequestBody Producto o) {
		return service.guardar(o);
	}

    @PutMapping("/{id}")
    public Producto editarProducto(@RequestBody Producto producto,@PathVariable int id) {
    	Producto productodb = service.obtener(id);
    	if(productodb != null) {
    		productodb.setNombre(producto.getNombre());
    		productodb.setPrecio(producto.getPrecio());
    		productodb.setTipoProducto(producto.getTipoProducto());
    		productodb.setDescripcion(producto.getDescripcion());
    		productodb.setImagenUrl(producto.getImagenUrl());
    	}
        return service.guardar(productodb);
    }

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
}