package com.example.demo.service;

import com.example.demo.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {

    List<ProductoDTO> listar();
    ProductoDTO registrar(ProductoDTO dto);
    String actualizarPrecio(Long id, Double precio);
}
