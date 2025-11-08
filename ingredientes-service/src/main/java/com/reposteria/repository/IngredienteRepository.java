package com.reposteria.repository;

import com.reposteria.common.model.Ingrediente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

	public List<Ingrediente> findByUnidadMedida(int unid);
}