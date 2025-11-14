package com.example.demo.controllers;

import com.example.demo.config.RouteConstants;
import com.example.demo.dto.ProductoDTO;
import com.example.demo.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(RouteConstants.API_BASE)
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "CONECTADO - PRODUCTOS";
    }

    @Operation(summary = "Lista todos los productos")
    @GetMapping("/productos")
    public List<ProductoDTO> getProductos() {
        return service.listar();
    }

    @Operation(summary = "Registrar un nuevo producto")
    @PostMapping("/registrar")
    public ProductoDTO registrar(@RequestBody ProductoDTO dto) {
        return service.registrar(dto);
    }

    @Operation(summary = "Actualiza solo el precio de un producto")
    @PatchMapping("/actualizarprecio/{id}/precio")
    public String updatePrecio(@PathVariable Long id, @RequestParam Double precio) {
        return service.actualizarPrecio(id, precio);
    }
}
