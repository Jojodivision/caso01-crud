package com.caso1.controller;

import com.caso1.domain.Bike;
import com.caso1.service.BikeService;
import com.caso1.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/listado")
    public String listado(Model model) {
        // Se usa el método obtenerTodas en BikeService
        var bikes = bikeService.obtenerTodas(); 
        model.addAttribute("bikes", bikes);
        model.addAttribute("totalBikes", bikes.size());
        return "bike/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Bike bike, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            // Se usa el método guardaR BikeService
            bikeService.guardar(bike); 
            
            // Se sube la imagen a Firebase usando la carpeta bik y el ID generado
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "bike", bike.getIdBike());
            
            
            bike.setImagenBike(rutaImagen); 
        }
        bikeService.guardar(bike);
        return "redirect:/bike/listado";
    }
}
