package main.java.com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Producto;
import com.example.demo.repository.ProductoRepository;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository repo;

    @GetMapping("/")
    public String index() {
        return "PRODUCTO CONECTADO";
    }

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return repo.findAll();
    }

    @PostMapping("/registrar")
    public String post(@RequestBody Producto producto) {
        repo.save(producto);
        return "Registrado";
    }
}
