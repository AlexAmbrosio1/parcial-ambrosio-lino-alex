package com.example.demo.controllers;

import com.example.demo.config.RouteConstants;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(RouteConstants.API_BASE)
public class Controller {

    private final UsuarioService service;

    public Controller(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "CONECTADO - USUARIOS";
    }

    @Operation(summary = "Lista todos los usuarios")
    @GetMapping("/usuarios")
    public List<UsuarioDTO> getUsuarios() {
        return service.listar();
    }

    @Operation(summary = "Registrar un nuevo usuario")
    @PostMapping("/registrar")
    public UsuarioDTO registrar(@RequestBody UsuarioDTO dto) {
        return service.registrar(dto);
    }

    @Operation(summary = "Actualiza solo la clave de un usuario")
    @PatchMapping("/actualizarclave/{id}/clave")
    public String updateClave(@PathVariable String id, @RequestParam String clave) {
        return service.actualizarClave(id, clave);
    }
}
