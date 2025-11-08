package com.reposteria.service;

import com.reposteria.common.model.ValoresComunes;
import java.util.List;

public interface ValoresComunesService {
	
	List<ValoresComunes> listar();
	ValoresComunes obtenerValoresComun(int id);
	ValoresComunes guardar(ValoresComunes obj);
	void eliminar(Integer id);
	List<ValoresComunes> listarComunXCodTabla(String codTabla);
	List<ValoresComunes> listarComunXClave1(String codTabla, String clave1);
}