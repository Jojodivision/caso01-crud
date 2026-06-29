package com.caso1.controller;

import com.caso1.domain.Producto;
import com.caso1.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Tabla con todos los registros 
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Cargando la página de inicio con la lista de productos");
        var productos = productoService.obtenerTodos();
        model.addAttribute("productos", productos);
        return "index"; // Esto buscará un archivo index.html en los templates
    }

    // Pantalla para agregar un producto 
    @GetMapping("/nuevo")
    public String nuevoProducto(Producto producto) {
        log.info("Cargando formulario para nuevo producto");
        return "modificar"; //un solo archivo html
    }

    //Guardar en la base de datos
    @PostMapping("/guardar")
    public String guardar(Producto producto) {
        log.info("Guardando el producto: {}", producto.getNombre());
        productoService.guardar(producto);
        return "redirect:/"; // Después de guardar, recarga la página de inicio
    }

    //Mostrar la pantalla con los datos cargados- Actualizar
    @GetMapping("/modificar/{idProducto}")
    public String modificar(Producto producto, Model model) {
        log.info("Buscando producto para modificar");
        producto = productoService.obtenerPorId(producto.getIdProducto());
        model.addAttribute("producto", producto);
        return "modificar";
    }

    //Eliminar un registro (Delete)
    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto producto) {
        log.info("Eliminando el producto");
        productoService.eliminar(producto.getIdProducto());
        return "redirect:/";
    }
}
