package com.caso1.service;

import com.caso1.domain.Producto;
import com.caso1.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    // Inyectamos el repositorio creado
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto obtenerPorId(Long id) {
        // Si no lo encuentra, devuelve null 
        return productoRepository.findById(id).orElse(null); 
    }

    @Override
    @Transactional
    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
