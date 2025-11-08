package com.reposteria.controller;

import com.reposteria.common.model.Producto;
import com.reposteria.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService service;

	// Define la ruta donde se guardarán tus imágenes
    private final String UPLOAD_DIR = "./uploads/images/";

    @PostMapping("/image")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Archivo vacío"));
        }

        try {
            // Asegúrate de que el directorio de subida exista
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Crea un nombre de archivo único (para evitar colisiones)
            String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
            String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;
            
            // Resuelve la ruta completa del archivo
            Path filePath = uploadPath.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Devuelve la RUTA PÚBLICA (no la ruta del disco)
            // Esto es lo que guardarás en la base de datos
            String fileUrl = "/images/" + uniqueFileName; 

            // Devuelve la URL en un JSON
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
    		productodb.setIdImagen(producto.getIdImagen());
    	}
        return service.guardar(productodb);
    }
    
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
		service.eliminar(id);
	}
}