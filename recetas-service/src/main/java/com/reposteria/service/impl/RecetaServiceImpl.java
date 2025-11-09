package com.reposteria.service.impl;

import com.reposteria.common.model.Ingrediente;
import com.reposteria.common.model.Producto;
import com.reposteria.common.model.Receta;
import com.reposteria.common.model.RecetaIngrediente;
import com.reposteria.common.model.RecetaPaso;
import com.reposteria.repository.RecetaRepository;
import com.reposteria.service.IngredienteFeingClient;
import com.reposteria.service.ProductoFeignClient;
import com.reposteria.service.RecetaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecetaServiceImpl implements RecetaService {
	@Autowired
	private RecetaRepository recetaRepository;
	
	@Autowired
	private IngredienteFeingClient ingredienteFeingClient;
	
	@Autowired
    private ProductoFeignClient productoFeignClient;

	@Override
    public List<Receta> listarRecetas() {
        return recetaRepository.findAll();
    }

    @Override
    public Receta obtenerPorId(int id) {
        return recetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada con id " + id));
    }

    @Transactional
    @Override
    public Receta crearReceta(Receta receta) {
        // Verificar producto asociado
        if (receta.getProducto() != null && receta.getProducto().getIdProducto() != null) {
            Producto producto = productoFeignClient.obtenerProductoPorId(receta.getProducto().getIdProducto());
            receta.setProducto(producto);
        }

        // Vincular relaciones
        if (receta.getPasos() != null) {
            receta.getPasos().forEach(p -> p.setReceta(receta));
        }
        if (receta.getIngredientes() != null) {
            receta.getIngredientes().forEach(ri -> {
                ri.setReceta(receta);
                if (ri.getIngrediente() != null && ri.getIngrediente().getIdIngrediente() != null) {
                    Ingrediente ing = ingredienteFeingClient.obtenerIngredientePorId(ri.getIngrediente().getIdIngrediente());
                    ri.setIngrediente(ing);
                }
            });
        }

        return recetaRepository.save(receta);
    }

    @Transactional
    @Override
    public Receta actualizarReceta(int id, Receta datos) {
        // 1. Obtener la entidad manejada
        Receta existente = obtenerPorId(id);

        // 2. Actualizar campos simples
        existente.setNombre(datos.getNombre());
        existente.setDescripcion(datos.getDescripcion());
        existente.setTiempoPrep(datos.getTiempoPrep());

        // 3. Actualizar la relación @ManyToOne (Producto)
        if (datos.getProducto() != null && datos.getProducto().getIdProducto() != null) {
            Producto productoManaged = productoFeignClient.obtenerProductoPorId(datos.getProducto().getIdProducto());
            existente.setProducto(productoManaged);
        } else {
            existente.setProducto(null);
        }

        // --- 4. Actualizar colección de Pasos ---
        // (Esta lógica de 'clear' y 'add' es correcta para orphanRemoval)
        if (datos.getPasos() != null) {
            existente.getPasos().clear();
            for (RecetaPaso p : datos.getPasos()) {
                p.setReceta(existente); 
                existente.getPasos().add(p);
            }
        } else {
            existente.getPasos().clear();
        }

        // --- 5. Actualizar colección de Ingredientes (CORREGIDO) ---
        if (datos.getIngredientes() != null) {
            existente.getIngredientes().clear();

            for (RecetaIngrediente ri : datos.getIngredientes()) {
                ri.setReceta(existente); // Relación bidireccional

                // --- ESTA ES LA CORRECCIÓN ---
                // Ahora tratamos 'ri.getIngrediente()' como un solo objeto
                if (ri.getIngrediente() != null && ri.getIngrediente().getIdIngrediente() != null) {
                    Ingrediente ingManaged = ingredienteFeingClient.obtenerIngredientePorId(ri.getIngrediente().getIdIngrediente());
                    
                    // Simplemente seteamos el ingrediente manejado (no una lista)
                    ri.setIngrediente(ingManaged);
                }
                // --- FIN DE LA CORRECCIÓN ---

                existente.getIngredientes().add(ri);
            }
        } else {
            existente.getIngredientes().clear();
        }

        return recetaRepository.save(existente);
    }

    @Transactional
    @Override
    public void eliminarReceta(int id) {
        Receta receta = obtenerPorId(id);
        //pasoRepository.deleteAll(pasoRepository.findByReceta(id));
        //recetaIngredienteRepository.deleteAll(recetaIngredienteRepository.findByIdReceta(id));
        recetaRepository.delete(receta);
    }
    /*
    @Override
    public List<RecetaPaso> listarPasos(int recetaId) {
        return pasoRepository.findByReceta(recetaId);
    }

    @Override
    public List<RecetaIngrediente> listarIngredientes(int recetaId) {
        return recetaIngredienteRepository.findByIdReceta(recetaId);
    }*/
}