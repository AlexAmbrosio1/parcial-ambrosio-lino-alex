package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.mapper.ProductoMapper;
import com.example.demo.models.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repo;
    private static final Logger logger = LoggerFactory.getLogger(ProductoServiceImpl.class);

    public ProductoServiceImpl(ProductoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ProductoDTO> listar() {
        logger.info("Listando productos");
        return repo.findAll().stream()
                .map(ProductoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO registrar(ProductoDTO dto) {
        logger.info("Registrando producto {}", dto.getNombre());
        Producto p = ProductoMapper.toEntity(dto);
        Producto saved = repo.save(p);
        return ProductoMapper.toDTO(saved);
    }

    @Override
    public String actualizarPrecio(Long id, Double precio) {
        logger.warn("Actualizando precio del producto {}", id);

        return repo.findById(id)
                .map(p -> {
                    p.setPrecio(precio);
                    repo.save(p);
                    return "Precio actualizado";
                })
                .orElse("Producto no encontrado");
    }
}
