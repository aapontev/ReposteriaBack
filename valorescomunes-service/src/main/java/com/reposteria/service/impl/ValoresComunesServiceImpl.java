package com.reposteria.service.impl;

import com.reposteria.common.model.ValoresComunes;
import com.reposteria.repository.ValoresComunesRepository;
import com.reposteria.service.ValoresComunesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValoresComunesServiceImpl implements ValoresComunesService {
	@Autowired
	private ValoresComunesRepository repo;

	public List<ValoresComunes> listar() {
		return repo.findAll();
	}

    public ValoresComunes obtenerValoresComun(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Valor Comun no encontrada"));
    }

	public ValoresComunes guardar(ValoresComunes o) {
		return repo.save(o);
	}

	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

    public List<ValoresComunes> listarComunXCodTabla(String codTabla) {
        return repo.findByCodTabla(codTabla);
    }

    public List<ValoresComunes> listarComunXClave1(String codTabla, String clave1) {
        return repo.findByCodTablaAndClave1(codTabla,clave1);
    }

}