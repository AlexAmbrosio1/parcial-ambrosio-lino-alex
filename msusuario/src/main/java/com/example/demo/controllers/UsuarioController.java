package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @GetMapping("/")
    public String index() {
        return "MS USUARIO OK";
    }

    @GetMapping("/listar")
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody Usuario usuario) {
        repo.save(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Usuario registrado");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario credenciales) {

        Optional<Usuario> opt = repo.findByNombre(credenciales.getNombre());

        if (opt.isPresent() &&
            opt.get().getClave() != null &&
            opt.get().getClave().equals(credenciales.getClave())) {

            return ResponseEntity.ok("Login exitoso");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Credenciales inválidas");
    }
}
