package com.caso1.service;

import com.caso1.domain.Bike;
import com.caso1.repository.BikeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Bike> obtenerTodas() {
        return bikeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Bike obtenerPorId(Long id) {
        return bikeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Bike bike) {
        bikeRepository.save(bike);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        bikeRepository.deleteById(id);
    }
}
