package com.example.demo.controllers;

import com.example.demo.config.RouteConstants;
import com.example.demo.dto.OperacionDTO;
import com.example.demo.service.OperacionService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(RouteConstants.API_BASE)
public class Controller {

    private final OperacionService service;

    public Controller(OperacionService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "CONECTADO - OPERACIONES";
    }

    @Operation(summary = "Lista todas las operaciones")
    @GetMapping("/operaciones")
    public List<OperacionDTO> getOperaciones() {
        return service.listar();
    }

    @Operation(summary = "Registrar una nueva operación")
    @PostMapping("/registrar")
    public OperacionDTO registrar(@RequestBody OperacionDTO dto) {
        return service.registrar(dto);
    }

    @Operation(summary = "Actualiza solo el total de una operación")
    @PatchMapping("/actualizartotal/{id}/total")
    public String updateTotal(@PathVariable Long id, @RequestParam Double total) {
        return service.actualizarTotal(id, total);
    }
}