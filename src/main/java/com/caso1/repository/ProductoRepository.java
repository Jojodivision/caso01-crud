package com.caso1.repository;

import com.caso1.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    // Con JPA repository ya tenemos el CRUD básico 
    //Spring Boot puede crear consultas complejas solo leyendo el nombre del método.
   
}
