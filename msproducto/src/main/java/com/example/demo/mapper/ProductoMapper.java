package com.example.demo.mapper;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.models.Producto;

public class ProductoMapper {

    public static ProductoDTO toDTO(Producto p) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(p.getIdProducto());
        dto.setNombre(p.getNombre());
        dto.setPrecio(p.getPrecio());
        return dto;
    }

    public static Producto toEntity(ProductoDTO dto) {
        Producto p = new Producto();
        p.setIdProducto(dto.getId());
        p.setNombre(dto.getNombre());
        p.setPrecio(dto.getPrecio());
        return p;
    }
}
