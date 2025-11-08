package com.reposteria.service;

import com.reposteria.common.model.Receta;
//import com.reposteria.common.model.RecetaIngrediente;
//import com.reposteria.common.model.RecetaPaso;
import java.util.List;

public interface RecetaService {
    List<Receta> listarRecetas();
    Receta obtenerPorId(int id);
    Receta crearReceta(Receta receta);
    Receta actualizarReceta(int id, Receta receta);
    void eliminarReceta(int id);

    // Métodos secundarios
  //  List<RecetaPaso> listarPasos(int recetaId);
    //List<RecetaIngrediente> listarIngredientes(int recetaId);
}