package com.example.demo.service;

import com.example.demo.dto.OperacionDTO;
import java.util.List;

public interface OperacionService {

    List<OperacionDTO> listar();
    OperacionDTO registrar(OperacionDTO dto);
    String actualizarTotal(Long id, Double total);
}
