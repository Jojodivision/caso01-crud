package com.caso1.service;

import com.caso1.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    // Definimos los que  CRUD debe hacer
    List<Producto> obtenerTodos();
    
    Producto obtenerPorId(Long id);
    
    void guardar(Producto producto);
    
    void eliminar(Long id);
}
