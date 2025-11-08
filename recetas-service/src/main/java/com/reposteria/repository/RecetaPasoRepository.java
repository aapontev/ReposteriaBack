package com.reposteria.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reposteria.common.model.RecetaPaso;

@Repository
public interface RecetaPasoRepository extends JpaRepository<RecetaPaso, Integer> {
    //List<RecetaPaso> findByReceta(Integer recetaId);

}
