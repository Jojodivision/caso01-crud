package com.caso1.service;

import com.caso1.domain.Bike;
import java.util.List;

public interface BikeService {
    
    List<Bike> obtenerTodas();
    
    Bike obtenerPorId(Long id);
    
    void guardar(Bike bike);
    
    void eliminar(Long id);
}
