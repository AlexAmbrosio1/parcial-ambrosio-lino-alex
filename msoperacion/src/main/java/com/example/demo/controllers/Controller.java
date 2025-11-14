package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Operacion;
import com.example.demo.repository.Repository;

@RestController
@RequestMapping("/api/auth")   // 👈 ESTA ES LA RUTA BASE
public class Controller {

    @Autowired 
    private Repository repo;

    @GetMapping("/")
    public String index() {
        return "CONECTADO";
    }

    @GetMapping("/operaciones")   // 👈 Queda: /api/auth/operaciones
    public List<Operacion> getOperaciones() {
        return repo.findAll();
    }   

    @PostMapping("/registrar")       // 👈 Queda: /api/auth/registrar
    public String post(@RequestBody Operacion operacion) {
        repo.save(operacion);
        return "Registrado";
    }
}
