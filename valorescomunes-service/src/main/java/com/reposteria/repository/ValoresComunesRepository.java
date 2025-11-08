package com.reposteria.repository;

import com.reposteria.common.model.ValoresComunes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoresComunesRepository extends JpaRepository<ValoresComunes, Integer> {
	
	public List<ValoresComunes> findByCodTabla(String codTabla);
	public List<ValoresComunes> findByCodTablaAndClave1(String codTabla, String Clave1);
}