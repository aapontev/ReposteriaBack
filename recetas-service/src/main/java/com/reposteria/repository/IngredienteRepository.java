package com.reposteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reposteria.common.model.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    // Puedes agregar búsquedas personalizadas si deseas, por ejemplo:
    boolean existsByNombre(String nombre);
}
