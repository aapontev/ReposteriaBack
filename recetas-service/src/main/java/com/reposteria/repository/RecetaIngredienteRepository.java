package com.reposteria.repository;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reposteria.common.model.RecetaIngrediente;

@Repository
public interface RecetaIngredienteRepository extends JpaRepository<RecetaIngrediente, Integer>  {
    //List<RecetaIngrediente> findByIdReceta(Integer recetaId);

}
